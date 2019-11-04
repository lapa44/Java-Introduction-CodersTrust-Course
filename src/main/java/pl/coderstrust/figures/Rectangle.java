package pl.coderstrust.figures;

public class Rectangle implements Figure {

    double a, b;

    Rectangle(double a, double b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Figures values cannot be negative cannot be negative");
        }
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculateArea() {
        return a * b;
    }
}
