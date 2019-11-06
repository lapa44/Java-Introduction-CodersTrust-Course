package pl.coderstrust.figures;

public class Trapezoid implements Figure {

     double a, b, h;

    Trapezoid(double a, double b, double h) {
        if (a <= 0) {
            throw new IllegalArgumentException("Trapezoid side cannot be lower than or equal to zero.");
        }
        if (b <= 0) {
            throw new IllegalArgumentException("Trapezoid side cannot be lower than or equal to zero.");
        }
        if (h <= 0) {
            throw new IllegalArgumentException("Trapezoid height cannot be lower than or equal to zero");
        }
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    public double calculateArea() {
        return 0.5d * (a + b) * h;
    }
}
