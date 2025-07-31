package study.cs.hw_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeComplexityTest {

    private Random random;

    private TimeComplexity timeComplexity;

    @BeforeEach
    void setUp() {
        this.random = new Random();
        this.timeComplexity = new TimeComplexity();
    }

    @Test
    void assignmentAShouldCalculateCounterCorrectly() {
        random.ints(0, 10_000)
                .limit(1000)
                .forEach(n -> assertEquals(assignmentAVerifier(n), timeComplexity.assignmentA(n)));
    }

    private int assignmentAVerifier(int n) {
        int counter = 0;
        for (int i = 5; i < n / 2; i += 5) {
            counter++;
        }
        return counter;
    }

    @Test
    void assignmentBShouldCalculateCounterCorrectly() {
        random.ints(1, 10_000)
                .limit(1000)
                .forEach(n -> assertEquals(assignmentBVerifier(n), timeComplexity.assignmentB(n)));
    }

    private int assignmentBVerifier(int n) {
        int counter = 0;
        for (int i = n; i > 1; i /= 2) {
            counter++;
        }
        return counter;
    }

    @Test
    void assignmentCShouldCalculateCounterCorrectly() {
        random.ints(1, 10_000)
                .limit(1000)
                .forEach(n -> assertEquals(assignmentCVerifier(n), timeComplexity.assignmentC(n)));
    }

    private int assignmentCVerifier(int n) {
        int counter = 0;
        for (int i = 0; i * i < n; i++) {
            counter++;
        }
        return counter;
    }

    @Test
    void assignmentDShouldCalculateCounterCorrectly() {
        random.ints(0, 10_000)
                .limit(1000)
                .forEach(n -> assertEquals(assignmentDVerifier(n), timeComplexity.assignmentD(n)));
    }

    private int assignmentDVerifier(int n) {
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 100; j++) {
                counter++;
            }
        }
        return counter;
    }

    @Test
    void assignmentEShouldCalculateCounterCorrectly() {
        random.ints(0, 100)
                .limit(10)
                .forEach(n -> assertEquals(assignmentEVerifier(n), timeComplexity.assignmentE(n)));
    }

    private int assignmentEVerifier(int n) {
        int counter = 0;
        for (int i = 1; i <= n * n; i++) {
            for (int j = 1; j <= i; j++) {
                counter++;
            }
        }
        return counter;
    }

    @Test
    void assignmentFShouldCalculateCounterCorrectly() {
        random.ints(1, 100)
                .limit(100)
                .forEach(n -> assertEquals(assignmentFVerifier(n), timeComplexity.assignmentF(n)));
    }

    private int assignmentFVerifier(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j *= 2) {
                counter++;
            }
        }
        return counter;
    }

    @Test
    void assignmentGShouldCalculateCounterCorrectly() {
        random.ints(0, 100)
                .limit(100)
                .forEach(n -> assertEquals(assignmentGVerifier(n), timeComplexity.assignmentG(n)));
    }

    private int assignmentGVerifier(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = 1; k <= j; k++) {
                    counter++;
                }
            }
        }
        return counter;
    }

    @Test
    void assignmentHShouldCalculateCounterCorrectly() {
        random.ints(0, 1000)
                .limit(100)
                .forEach(n -> assertEquals(assignmentHVerifier(n), timeComplexity.assignmentH(n)));
    }

    private int assignmentHVerifier(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j += i) {
                counter++;
            }
            for (int j = 1; j <= i; j++) {
                counter++;
            }
        }
        return counter;
    }


    @Test
    void assignmentIShouldCalculateCounterCorrectly() {
        random.ints(0, 10)
                .limit(100)
                .forEach(n -> {
                    final AtomicInteger iCounter = new AtomicInteger();
                    assignmentIVerifier(n, iCounter);
                    assertEquals(iCounter.get(), timeComplexity.assignmentI(n));
                });
    }


    private void assignmentIVerifier(int n, AtomicInteger iCounter) {
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            iCounter.incrementAndGet();
        }
        assignmentIVerifier(n / 2, iCounter);
    }

    @Test
    void assignmentJShouldCalculateCounterCorrectly() {
        random.ints(0, 10)
                .limit(100)
                .map(n -> (int) Math.pow(2, n))
                .forEach(n -> {
                    final AtomicInteger jCounter = new AtomicInteger();
                    assignmentJVerifier(n, jCounter);
                    assertEquals(jCounter.get(), timeComplexity.assignmentJ(n));
                });
    }

    private void assignmentJVerifier(int n, AtomicInteger jCounter) {
        if (n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            jCounter.incrementAndGet();
        }

        assignmentJVerifier(n/2, jCounter);
        assignmentJVerifier(n/2, jCounter);
    }

}
