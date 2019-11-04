package pl.coderstrust.figures;

public class Trapezoid extends Rectangle implements Figure {

    private double h;

    Trapezoid(double a, double b, double h) {
        super(a, b);
        if (h <= 0) {
            throw new IllegalArgumentException("Trapezoid's height cannot be negative.");
        }
        this.h = h;
    }

    @Override
    public double calculateArea() {
        return 0.5d * (a + b) * h;
    }
}
