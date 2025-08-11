package study.cs.hw_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniformIntegersTest {

    private UniformIntegers uniformIntegers;

    @BeforeEach
    void setup() {
        uniformIntegers = new UniformIntegers();
    }

    @Test
    void shouldCountUniformIntegers() {
        assertEquals(5, uniformIntegers.count(75, 300));
        assertEquals(9, uniformIntegers.count(1, 9));
        assertEquals(1, uniformIntegers.count(999999999999L, 999999999999L));
    }

    @Test
    @Timeout(1)
    void shouldCountLongRangeInTime() {
        assertEquals(108, uniformIntegers.count(1, 1_000_000_000_000L));
    }

}
