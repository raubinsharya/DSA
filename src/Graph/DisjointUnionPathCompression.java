package Graph;

public class DisjointUnionPathCompression {
    int rank[] = new int[101];

    int find(int Parent[], int X) {
        if (Parent[X] == X) return X;
        return Parent[X] = find(Parent, Parent[X]);
    }

    void unionSet(int Parent[], int X, int Z) {
        X = find(Parent, X);
        Z = find(Parent, Z);
        if (rank[X] < rank[Z]) {
            Parent[X] = Z;
        } else if (rank[Z] < rank[X]) {
            Parent[Z] = X;
        } else {
            Parent[Z] = X;
            rank[X]++;
        }
    }
}
