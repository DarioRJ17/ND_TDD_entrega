package kataTeniss;

public class FortyTranslator implements IPointsTranslator {
    @Override
    public boolean applies(int number) {
        return number == 3;
    }

    @Override
    public String translate(int number) {
        if (!applies(number)) throw new IllegalArgumentException("Number must be 3");
        return "Forty";
    }
}
