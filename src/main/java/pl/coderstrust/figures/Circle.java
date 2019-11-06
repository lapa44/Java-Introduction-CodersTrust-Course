package pl.coderstrust.figures;

public class Circle implements Figure {

    private double r;

    Circle(double r) {
        if (r <= 0) {
            throw new IllegalArgumentException("Circle radius cannot be lower than or equal to zero.");
        }
        this.r = r;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(r, 2);
    }
}
