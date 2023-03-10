package Utils;

public class Pair<X, Y> {
    public X first;
    public Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first + ":" + second;
    }
}
