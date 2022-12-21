import ru.netology.loremIpsum.Text;
import ru.netology.loremIpsum.WordsChecker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //Переводим текст статьи в набор символов
        char[] kitSymbols = Text.Statya.toLowerCase(Locale.ROOT).toCharArray();

        //Завели мапу
        Map<Character, Integer> symbols = new HashMap<>();
        for (char symbol : kitSymbols) {
            if (Character.isLetter(symbol)) {
                Integer integer = symbols.get(symbol);
                if (integer == null) {
                    symbols.put(symbol, 1);
                } else symbols.put(symbol, ++integer);
            }
        }
        //Максимальное число повторения символа
        Map.Entry<Character, Integer> maxEntry = null;
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;

            }
        }
        System.out.println("===============================================================");
        System.out.println("задача 1");
        System.out.println("Максимальное значение у " + maxEntry);

        //Минимальное число повторения символа
        Map.Entry<Character, Integer> minEntry = null;
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            if (minEntry == null || entry.getValue() < minEntry.getValue()) {
                minEntry = entry;

            }
        }
        System.out.println("Минимальное значение у " + minEntry);
        //System.out.println(symbols);


        //Поиск слов в тексте
        WordsChecker wordsChecker= new WordsChecker(Text.Statya);
        boolean r = wordsChecker.hasWord("copy");
        System.out.println();
        System.out.println("===============================================================");
        System.out.println("задача 2");
        System.out.println(r);

    }

}
