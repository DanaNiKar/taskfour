//Класс для подсчета количества символов в десятичной записи числа
public class DigitCount implements ICount {
    private ICount digitCounter = (int num) -> String.valueOf(Math.abs(num)).length();

    @Override
    public int count(int number) {
        return digitCounter.count(number);
    }
}