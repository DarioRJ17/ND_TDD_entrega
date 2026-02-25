package kataTeniss;

public class ThirtyTranslator implements IPointsTranslator {
    @Override
    public boolean applies(int number) {
        return number == 2;
    }

    @Override
    public String translate(int number) {
        if (!applies(number)) throw new IllegalArgumentException("Number must be 2");
        return "Thirty";
    }
}
