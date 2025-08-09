package study.cs.hw_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

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
        random.ints(0, 10_000)
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
        random.ints(0, 10_000)
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
        random.ints(0, 100)
            .limit(10)
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
            .limit(10)
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

}
