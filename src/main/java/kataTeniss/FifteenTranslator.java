package kataTeniss;

public class FifteenTranslator implements  IPointsTranslator {
    @Override
    public boolean applies(int number) {
        return number == 1;
    }

    @Override
    public String translate(int number) {
        if (!applies(number)) throw new IllegalArgumentException("Number must be 1");
        return "Fifteen";
    }
}
