package kataTeniss;

public class EqualsTranslator implements IScoreTranslator {

    private final IPointsTranslator[] equalsTranslators;

    public EqualsTranslator() {
        equalsTranslators = new IPointsTranslator[] {
                new FifteenTranslator(),
                new ThirtyTranslator()
        };
    }

    @Override
    public boolean applies(int points1, int points2) {
        return points1 == points2;
    }

    @Override
    public String translate(String score) {
        String[] points = score.split("-");
        int points1 = Integer.parseInt(points[0]);
        int points2 = Integer.parseInt(points[1]);

        if (!applies(points1, points2)) {
            throw new IllegalArgumentException("Players' points are not equal"); // no son iguales
        }

        if (points1 == 0 && points2 == 0) {
            return "Love-Love";
        } else if (points1 >= 3 && points2 >= 3) {
            return "Deuce";
        }

        for (IPointsTranslator translator : equalsTranslators) {
            if (translator.applies(points1)) {
                return translator.translate(points1) + "-All";
            }
        }

        throw new IllegalStateException("No translator found for equal score");
    }
}
