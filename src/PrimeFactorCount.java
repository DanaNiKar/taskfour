import java.util.HashSet;
import java.util.Set;

//Класс для подсчета количества различных простых множителей числа
public class PrimeFactorCount implements Count {
    @Override
    public int count(int number) {
        Set<Integer> primeFactors = new HashSet<>(); // Используем множество для уникальных простых множителей
        int num = Math.abs(number); // Работаем с абсолютным значением

        // Цикл для нахождения простых множителей
        for (int i = 2; i <= Math.sqrt(num); i++) {
            while (num % i == 0) {
                primeFactors.add(i); // Добавляем множитель в множество
                num /= i; // Делим число на множитель
            }
        }

        // Если осталось число больше 1, оно простое
        if (num > 1) {
            primeFactors.add(num);
        }

        // Возвращаем количество различных простых множителей
        return primeFactors.size();
    }
}
