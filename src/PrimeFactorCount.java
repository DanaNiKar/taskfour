import java.util.HashSet;
import java.util.Set;

//Класс для подсчета количества различных простых множителей числа
public class PrimeFactorCount implements ICount {
    private ICount primeFactorCounter = (int num) -> {
        Set<Integer> primeFactors = new HashSet<>(); // Используем множество для уникальных простых множителей
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

    @Override
    public int count(int number) {
        return primeFactorCounter.count(number);
    }
}
