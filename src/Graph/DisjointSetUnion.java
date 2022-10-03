package Graph;

// problem Link
// https://practice.geeksforgeeks.org/problems/disjoint-set-union-find/1
// note is only disjoint set not path compression problem

public class DisjointSetUnion {
    int find(int A[], int X) {
        if (A[X] == X) return X;
        return A[X] = find(A, A[X]);
    }

    void unionSet(int A[], int X, int Z) {
        X = find(A, X);
        Z = find(A, Z);
        A[X] = Z; // not path compression
    }
}
