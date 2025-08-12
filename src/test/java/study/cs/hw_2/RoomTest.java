package study.cs.hw_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomTest {

    private Room room;

    @BeforeEach
    void setup() {
        room = new Room();
    }

    @Test
    void shouldCalculateChairs() {
        assertEquals("1 0 1 0 1 0", room.calc(3, 2, 2, 2));
        assertEquals("", room.calc(197, 195, 781, 90));
        assertEquals("", room.calc(471, 790, 109, 43));
        assertEquals("", room.calc(2, 4, 0, 0));
        assertEquals("5 0 2 0 8 0", room.calc(15, 7, 10, 13));
        assertEquals("1 1 0 0 0 0", room.calc(2, 2, 0, 1));
    }
}
