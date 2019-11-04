package pl.coderstrust.figures;

public class Triangle extends Rectangle implements Figure {

    Triangle(double a, double h) {
        super(a, h);
    }

    @Override
    public double calculateArea() {
        return super.calculateArea() / 2;
    }
}
