package kataTeniss;

import java.util.ArrayList;
import java.util.List;

public class ScoreParser {

    private static boolean isNumeric(String str) {
        if(str.isEmpty()) return false;
        for (Character c: str.toCharArray()) {
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static List<Integer> parse(String score) {
        List<Integer> points = new ArrayList<>();
        String[] scoreParts = score.split("-");
        int points1 = Integer.parseInt(scoreParts[0]);
        int points2 = Integer.parseInt(scoreParts[1]);

        if (scoreParts.length != 2 || !isNumeric(scoreParts[0]) || !isNumeric(scoreParts[1])) {
            throw new IllegalArgumentException("Invalid score format");
        }
        if (Math.max(points1, points2) != 3) {
            if ((points1 >= 4 || points2 >= 4) && Math.abs(points1 - points2) > 2) {
                throw new IllegalArgumentException("Illogical difference");
            }
        }

        points.add(points1);
        points.add(points2);
        return points;
    }

}
