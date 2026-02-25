package kataTeniss;

public interface IPointsTranslator {
    boolean applies(int number);

    String translate(int number);
}
