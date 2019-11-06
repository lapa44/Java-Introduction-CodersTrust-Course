package pl.coderstrust.figures;

public class Triangle implements Figure {

    double a, h;

    Triangle(double a, double h) {
        if (a <= 0) {
            throw new IllegalArgumentException("Triangle side cannot be be lower than or equal to zero.");
        }
        if (h <= 0) {
            throw new IllegalArgumentException("Triangle height cannot be lower than or equal to zero.");
        }
        this.a = a;
        this.h = h;
    }

    @Override
    public double calculateArea() {
        return (a * h) / 2;
    }
}
