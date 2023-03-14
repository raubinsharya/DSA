package Utils;

public class Pairs<X, Y, Z> {
    public X first;
    public Y second;
    public Z third;

    public Pairs(X first, Y second, Z third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public String toString() {
        return "Pairs{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
