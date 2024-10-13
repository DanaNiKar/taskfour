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
        ICount digitCounter = new DigitCount();
        ICount primeFactorCounter = new PrimeFactorCount();


        // Выводим результаты
        System.out.println("Количество символов в десятичной записи числа: " + digitCounter.count(number));
        System.out.println("Количество различных простых множителей числа: " + primeFactorCounter.count(number));
    }
}
