package study.cs.hw_1;

class TimeComplexity {

    private static final double GAMMA = 0.5772156649015328606;

    int assignmentA(int n) {
        return (n - 2) / 10;
    }

    int assignmentB(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    int assignmentC(int n) {
        return (int) Math.sqrt(n - 1) + 1;
    }

    int assignmentD(int n) {
        return 100 * n;
    }

    int assignmentE(int n) {
        return n * n * (n * n + 1) / 2;
    }

    int assignmentF(int n) {
        int sum = 0;
        for (int k = 1; k < n; k++) {
            sum += (int) (Math.log(k) / Math.log(2));
        }
        return sum + (n - 1);
    }

    int assignmentG(int n) {
        return n * (n + 1) * (n + 2) / 6;
    }

    int assignmentH(int n) {
        return getHarmonicSum(n) + n * (n + 1) / 2;
    }

    private int getHarmonicSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (int) Math.ceil((double) n / i);
        }
        return sum;
    }

    int assignmentI(int n) {
        return 2 * n - Integer.bitCount(n);
    }

    int assignmentJ(int n) {
        return n * (int) (Math.log(n) / Math.log(2)) + n;
    }
}
