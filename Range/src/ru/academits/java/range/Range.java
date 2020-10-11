package ru.academits.java.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return (number >= from && number <= to);
    }

    public Range getCrossing(Range range) {
        if (this.to <= range.from || range.to <= this.from) { //нет пересечения
            return null;
        }

        return new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));
    }

    public Range[] getUnion(Range range) {
        Range[] rangesUnion;

        if (this.to <= range.from || range.to <= this.from) { //нет пересечения
            rangesUnion = new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        } else {
            rangesUnion = new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
        }

        return rangesUnion;
    }

    public Range[] getSubtraction(Range range) {
        Range[] rangeSubtraction;
        Range cross = new Range(Math.max(this.from, range.from), Math.min(this.to, range.to)); //находим пересечение в случае, если отрезки пересекаются

        if (this.from == range.from && this.to == range.to) {
            rangeSubtraction = new Range[0];
        } else if (this.to <= range.from || range.to <= this.from) { //нет пересечения
            rangeSubtraction = new Range[]{new Range(this.from, this.to)};
        } else if (this.from < cross.from && this.to > cross.to) {
            double from1 = this.from;
            double to1 = cross.from;

            double from2 = cross.to;
            double to2 = this.to;

            rangeSubtraction = new Range[]{new Range(from1, to1), new Range(from2, to2)};
        } else {
            rangeSubtraction = new Range[1];

            double resultFrom;
            double resultTo;

            if (this.from < cross.from) {
                resultFrom = this.from;
                resultTo = cross.from;
            } else {
                resultFrom = cross.to;
                resultTo = this.to;
            }

            rangeSubtraction[0] = new Range(resultFrom, resultTo);
        }

        return rangeSubtraction;
    }
}
