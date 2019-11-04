package pl.coderstrust.figures;

public class Circle implements Figure {

    private double r;

    Circle(double r) {
        if (r <= 0) {
            throw new IllegalArgumentException("Circle's radius cannot be negative.");
        }
        this.r = r;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(r, 2);
    }
}
