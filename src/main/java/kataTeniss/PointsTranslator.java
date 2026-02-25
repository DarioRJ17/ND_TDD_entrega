package kataTeniss;

import java.util.List;

public class PointsTranslator {

    private final IPointsTranslator[] pointsTranslators;
    private final IScoreTranslator[] scoreTranslators;

    public PointsTranslator() {
        pointsTranslators = new IPointsTranslator[] {
                new LoveTranslator(),
                new FifteenTranslator(),
                new ThirtyTranslator(),
                new FortyTranslator()
        };
        scoreTranslators = new IScoreTranslator[] {
                new AdvantageTranslator(),
                new EqualsTranslator(),
                new WinnerTranslator()
        };
    }

    public String translate(String score) {
        List<Integer> intPoints = ScoreParser.parse(score);

        int points1 = intPoints.get(0);
        int points2 = intPoints.get(1);

        if (points1 + points2 >= 6 || points1 == points2) {
            for (IScoreTranslator translator : scoreTranslators) {
                if (translator.applies(points1, points2)) {
                    return translator.translate(score);
                }
            }
            throw new IllegalStateException("There isn't any translation for score: " + points1 + "-" + points2);
        }

        return scoreFormatter(points1, points2);
    }

    private String playerPointsFormatter (int playerPoints){
        for (IPointsTranslator translator : pointsTranslators) {
            if (translator.applies(playerPoints)) {
                return translator.translate(playerPoints);
            }
        }
        throw new IllegalStateException("There isn't any translation for player points: " + playerPoints);
    }

    private String scoreFormatter (int points1, int points2){
        return playerPointsFormatter(points1) + "-" + playerPointsFormatter(points2);
    }

}
