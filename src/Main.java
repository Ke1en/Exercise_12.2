/*
Задача: Анализ текста
        Напишите программу, которая анализирует текст и выводит статистику по словам в тексте.
        Условия задачи

1. Программа должна прочитать текст из переменной например String text;
2. Нужно подсчитать, сколько раз встречается каждое слово в тексте.
3. После подсчета, выведите:
        Список всех уникальных слов, отсортированный по алфавиту.
        Количество уникальных слов.
4. Игнорируйте регистр слов (например, слова Java и java считаются одинаковыми).
5. Игнорируйте знаки препинания, такие как точки, запятые и другие символы, чтобы не учитывать их как часть слов.

Подсказки
Используйте Map<String, Integer> для хранения слов и их количества.
Чтобы упростить подсчет, можно использовать HashMap.
Для сортировки уникальных слов используйте TreeSet или отсортируйте ключи HashMap.
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been" +
                " the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of" +
                " type and scrambled it to make a type specimen book. It has survived not only five centuries, but" +
                " also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in" +
                " the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently" +
                " with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        text = text.replaceAll("\\p{Punct}", "").toLowerCase();

        List<String> list = new ArrayList<>(Arrays.asList(text.split(" ")));

        System.out.println("Выводим весь списочек: \n" + list);

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : list) {
            wordCount.compute(word, (_, count) -> (count == null) ? 1 : count + 1);
        }

        System.out.println("\nСписочек сколько раз встречается каждое слово в тексте: \n" + wordCount);

        Map<String, Integer> treeSort = new TreeMap<>(wordCount);

        int count = 0;

        System.out.println("\nСписочек слов в алфавитном порядке:");
        for (String key : treeSort.keySet()) {
            count++;
            System.out.println(key);
        }

        System.out.println("Всего уникальных слов: " + count);
    }
}