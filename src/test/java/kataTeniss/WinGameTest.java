package kataTeniss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinGameTest {
    @Test
    void testPlayerOneWinsAfterAdvantage_ShouldBeWinPlayerOne() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("5-3");
        assertEquals("Player 1 wins", res);
    }

    @Test
    void testPlayerTwoWinsAfterAdvantage_ShouldBeWinPlayerTwo() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("3-5");
        assertEquals("Player 2 wins", res);
    }

    @Test
    void testPlayerOneWinsByTwoPoints_ShouldBeWinPlayerOne() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("4-0");
        assertEquals("Player 1 wins", res);
    }

    @Test
    void testPlayerTwoWinsByTwoPoints_ShouldBeWinPlayerTwo() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("0-4");
        assertEquals("Player 2 wins", res);
    }

    // Negative cases

    @Test
    void testWinningWithoutTwoPointDifference_ShouldThrowException() {
        PointsTranslator translator = new PointsTranslator();
        assertThrows(IllegalArgumentException.class,
                () -> translator.translate("4-3"));  // sería ventaja
    }
}
