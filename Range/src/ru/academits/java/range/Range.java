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

    public double getRangeLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return (number >= from && number <= to);
    }

    public Range getRangesCrossing(Range range2) {
        if (this.to < range2.from || range2.to < this.from) {
            return null;
        }

        double from;
        double to;

        from = Math.max(this.from, range2.from);

        to = Math.min(this.to, range2.to);

        return new Range(from, to);
    }

    public Range[] getRangesUnion(Range range2) {
        Range[] rangesUnion;

        if (this.getRangesCrossing(range2) == null) {
            rangesUnion = new Range[2];
            rangesUnion[0] = this;
            rangesUnion[1] = range2;
        } else {

            double from = Math.min(this.from, range2.from);

            double to = Math.max(this.to, range2.to);

            rangesUnion = new Range[1];
            rangesUnion[0] = new Range(from, to);
        }

        return rangesUnion;
    }

    public Range[] getRangesSubtraction(Range range) {
        Range[] rangeSubtraction;
        Range cross = this.getRangesCrossing(range);

        if (this.from == range.from && this.to == range.to) {
            rangeSubtraction = new Range[0];
        } else if (cross == null) {
            rangeSubtraction = new Range[1];
            rangeSubtraction[0] = new Range(this.from, this.to);
        } else if (this.from < cross.from && this.to > cross.to) {
            double from1 = this.from;
            double to1 = cross.from;

            double from2 = cross.to;
            double to2 = this.to;

            rangeSubtraction = new Range[2];

            rangeSubtraction[0] = new Range(from1, to1);
            rangeSubtraction[1] = new Range(from2, to2);
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
