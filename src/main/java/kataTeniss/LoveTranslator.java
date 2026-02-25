package kataTeniss;

public class LoveTranslator implements  IPointsTranslator {
    @Override
    public boolean applies(int number) {
        return number == 0;
    }

    @Override
    public String translate(int number) {
        if (!applies(number)) throw new IllegalArgumentException("Number must be 0");
        return "Love";
    }
}
