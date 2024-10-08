import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;


//Основной класс
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Создаем сканер для ввода данных
        System.out.print("Введите число: ");

        int number = 0; //Инициализируем переменную для числа
        boolean validInput = false; //Флаг для проверки корректности ввода

        //Проверка на корректность ввода числа
        while (!validInput) {
            if (scanner.hasNextInt()) { //Проверяем, является ли ввод целым числом
                number = scanner.nextInt(); //Считываем число
                validInput = true; //Устанавливаем флаг в true, если ввод корректен
            } else {
                System.out.println("Пожалуйста, введите корректное целое число.");
                scanner.next(); //Пропускаем некорректный ввод
            }
        }

        // Создаем экземпляры классов
        Count digitCounter = new DigitCount();
        Count primeFactorCounter = new PrimeFactorCount();

        // Используем лямбда-выражение для переопределения метода count
        Count digitCountLambda = (num) -> String.valueOf(Math.abs(num)).length();
        Count primeFactorCountLambda = (num) -> {
            Set<Integer> primeFactors = new HashSet<>();
            int n = Math.abs(num); // Работаем с абсолютным значением

            // Цикл для нахождения простых множителей
            for (int i = 2; i <= Math.sqrt(n); i++) {
                while (n % i == 0) {
                    primeFactors.add(i); // Добавляем множитель в множество
                    n /= i; // Делим число на множитель
                }
            }

            // Если осталось число больше 1, оно простое
            if (n > 1) {
                primeFactors.add(n);
            }

            // Возвращаем количество различных простых множителей
            return primeFactors.size();
        };

        // Выводим результаты
        System.out.println("Количество символов в десятичной записи числа: " + digitCountLambda.count(number));
        System.out.println("Количество различных простых множителей числа: " + primeFactorCountLambda.count(number));
    }
}
