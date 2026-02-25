package kataTeniss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeuceAndAdvantageTest {
    @Test
    void testScoreIsFortyAll_ShouldBeDeuce() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("3-3");
        assertEquals("Deuce", res);
    }

    @Test
    void testPlayerOneAdvantageAfterDeuce_ShouldBeAdvantagePlayerOne() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("4-3");
        assertEquals("Advantage Player 1", res);
    }

    @Test
    void testPlayerTwoAdvantageAfterDeuce_ShouldBeAdvantagePlayerTwo() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("3-4");
        assertEquals("Advantage Player 2", res);
    }

    @Test
    void testAdvantageLost_BackToDeuce() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("4-4");
        assertEquals("Deuce", res);
    }

    // Negative cases

    @Test
    void testImpossibleScoreDifference_ShouldThrowException() {
        PointsTranslator translator = new PointsTranslator();
        assertThrows(IllegalArgumentException.class,
                () -> translator.translate("6-1")); // diferencia ilógica
    }

    @Test
    void testEmptyInput_ShouldThrowException() {
        PointsTranslator translator = new PointsTranslator();
        assertThrows(IllegalArgumentException.class,
                () -> translator.translate(""));
    }
}
