import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodeSumTest {

    @Test
    void sum() {
        assertEquals(0, HelloWorld.sum());          //  erwartete ausgabe 0 , ergebnis der methode sum() werden verglichen
        assertEquals(1, HelloWorld.sum(1));
        assertEquals(2, HelloWorld.sum(2));
        assertEquals(3, HelloWorld.sum(2, 1));
        assertEquals(4, HelloWorld.sum(1, 3));
        assertEquals(5, HelloWorld.sum(2, 3));
        //assertEquals(6, HelloWorld.sum(2, 3));

        //assertInstanceOf(sum());
    }
}