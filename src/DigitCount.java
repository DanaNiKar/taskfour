public class DigitCount implements Count {
    @Override
    public int count(int number) {
        // Преобразуем число в строку и считаем длину
        return String.valueOf(Math.abs(number)).length(); // Используем Math.abs для учета отрицательных чисел
    }
}