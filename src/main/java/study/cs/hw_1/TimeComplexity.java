package study.cs.hw_1;

class TimeComplexity {

    int assignmentA(int n) {
        return (n - 2) / 10;
    }

    int assignmentB(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    int assignmentC(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt < n) {
            return sqrt + 1;
        }
        return sqrt;
    }

    int assignmentD(int n) {
        return 100 * n;
    }

    int assignmentE(int n) {
        return n * n * (n * n + 1) / 2;
    }

    int assignmentF(int n) {
        int m = (int) (Math.log(n - 1) / Math.log(2));
        return n * (m + 1) - (int) Math.pow(2, m + 1) + 1;
    }

    int assignmentG(int n) {
        return n * (n + 1) * (n + 2) / 6;
    }
}
