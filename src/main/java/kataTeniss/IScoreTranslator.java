package kataTeniss;

public interface IScoreTranslator {
    boolean applies(int points1, int points2);

    String translate(String score);
}
