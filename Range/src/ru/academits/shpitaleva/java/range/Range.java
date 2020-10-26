package ru.academits.shpitaleva.java.range;

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
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        if (to <= range.from || range.to <= from) { //нет пересечения
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (to < range.from || range.to < from) { //нет пересечения
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        } else {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }
    }

    public Range[] getDifference(Range range) {
        //находим пересечение в случае, если отрезки пересекаются:
        double lowIntersectionBound = Math.min(to, range.to);
        double highIntersectionBound = Math.max(from, range.from);

        if (from == range.from && to == range.to) {
            return new Range[0];
        } else if (to <= range.from || range.to <= from) { //нет пересечения
            return new Range[]{new Range(from, to)};
        } else if (from < highIntersectionBound && to > lowIntersectionBound) {
            double from1 = from;
            double to1 = lowIntersectionBound;

            double from2 = highIntersectionBound;
            double to2 = to;

            return new Range[]{new Range(from1, to1), new Range(from2, to2)};
        } else {
            double resultFrom;
            double resultTo;

            if (from < lowIntersectionBound) {
                resultFrom = from;
                resultTo = lowIntersectionBound;
            } else {
                resultFrom = highIntersectionBound;
                resultTo = to;
            }

            return new Range[]{new Range(resultFrom, resultTo)};
        }
    }

    @Override
    public String toString() {
        return "(" + from + "; " + to + ")";
    }
}
