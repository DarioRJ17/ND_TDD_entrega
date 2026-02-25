package kataTeniss;

import java.util.List;

public class AdvantageTranslator implements IScoreTranslator {
    @Override
    public boolean applies(int points1, int points2) {
        return (points1 == 4 || points2 == 4) && Math.abs(points1-points2) == 1; // alguno debe tener ventaja
    }

    @Override
    public String translate(String score) {
        String[] points = score.split("-");
        int points1 = Integer.parseInt(points[0]);
        int points2 = Integer.parseInt(points[1]);

        if (!applies(points1, points2)) {
            throw new IllegalArgumentException("Illogical score for advantage"); // ninguno tiene ventaja
        }

        if (points1 > points2) {
            return "Advantage Player 1";
        } else {
            return "Advantage Player 2";
        }
    }
}
