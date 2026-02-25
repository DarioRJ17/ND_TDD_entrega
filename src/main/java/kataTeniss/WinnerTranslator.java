package kataTeniss;

public class WinnerTranslator implements IScoreTranslator {
    @Override
    public boolean applies(int points1, int points2) {
        return (points1 >= 4 || points2 >= 4) && Math.abs(points1-points2) == 2; // alguno debe ganar
    }

    @Override
    public String translate(String score) {
        String[] points = score.split("-");
        int points1 = Integer.parseInt(points[0]);
        int points2 = Integer.parseInt(points[1]);

        if (!applies(points1, points2)) {
            throw new IllegalArgumentException("Illogical score for deciding winner"); // ninguno ha ganado
        }

        if (points1 > points2) {
            return "Player 1 wins";
        } else {
            return "Player 2 wins";
        }
    }
}
