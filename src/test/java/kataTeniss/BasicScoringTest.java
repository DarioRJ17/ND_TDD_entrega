package kataTeniss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicScoringTest {
    @Test
    void shouldReturnLoveLove_OnStart() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("0-0");
        assertEquals("Love-Love", res);
    }

    @Test
    void testPlayerOneScoresOnce_ShouldBeFifteenLove() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("1-0");
        assertEquals("Fifteen-Love", res);
    }

    @Test
    void testPlayerTwoScoresOnce_ShouldBeLoveFifteen() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("0-1");
        assertEquals("Love-Fifteen", res);
    }

    @Test
    void testBothPlayersScoreOnce_ShouldBeFifteenAll() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("1-1");
        assertEquals("Fifteen-All", res);
    }

    @Test
    void testPlayerOneScoresTwice_ShouldBeThirtyLove() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("2-0");
        assertEquals("Thirty-Love", res);
    }

    @Test
    void testPlayerTwoScoresTwice_ShouldBeLoveThirty() {
        PointsTranslator translator = new PointsTranslator();
        String res = translator.translate("0-2");
        assertEquals("Love-Thirty", res);
    }

    // Negative cases

    @Test
    void testNegativeScoreP1_ShouldThrowException() {
        PointsTranslator translator = new PointsTranslator();
        assertThrows(IllegalArgumentException.class,
                () -> translator.translate("-1-0"));
    }

    @Test
    void testNegativeScoreP2_ShouldThrowException() {
        PointsTranslator translator = new PointsTranslator();
        assertThrows(IllegalArgumentException.class,
                () -> translator.translate("0--1"));
    }

    @Test
    void testInvalidFormat_ShouldThrowException() {
        PointsTranslator translator = new PointsTranslator();
        assertThrows(IllegalArgumentException.class,
                () -> translator.translate("1:0"));
    }

    @Test
    void testNonNumericInput_ShouldThrowException() {
        PointsTranslator translator = new PointsTranslator();
        assertThrows(IllegalArgumentException.class,
                () -> translator.translate("A-B"));
    }
}
