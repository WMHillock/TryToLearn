import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiTest {
    public static void main(String[] args) {


    /* Есть 4 типа стрима:
        java.util.stream.Stream
        java.util.stream.IntStream
        java.util.stream.LongStream
        java.util.stream.DoubleStream
     У каждого есть свои доп методы
     */
    List<Integer> myList = new ArrayList<>();
    myList.add(10);
    myList.add(25);
    myList.add(49);
    int x = 5;


    Stream.empty();
    Stream.of(myList);
    Stream.ofNullable(x);


    Stream.of("foo", "bar", "fiz-buz")
            .map(String::length)//Тут идет боксинг, заменим
            .forEach(System.out::println);


        Stream.of("foo", "bar", "fiz-buz")
                .mapToInt(String::length)
            .forEach(System.out::println);


    /*Варианты проежуточных операций:
    map (mapToInt, mapToLong, mapToDouble, mapToObj) -
    отображает каждый элемент стрима
    filter - это фильтр XD
    flatMap(flatMapToInt, flatMapToLong, flatMapToDouble) -
    позволяет 1 элемент срима превратить во много, стрим в чары
    distinct - убирает повторы
    sorted - сортировка по условиям
    limit - ограничит количество элементов
    skip - пропускает определенные элементы (пропускает спереди)
    peek -
    takeWhile
    dropWhile
    boxed/asLongStream/asDoubleStream (примитивы)
     */

    Stream.of("foo", "bar", "fiz-buz")
            .flatMapToInt(String::chars)
            .forEach(a -> System.out.println((char) a));

        List<Integer> list =  IntStream.range(1, 50)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(list);
                list.forEach(System.out::println);

                IntStream.iterate(1, z -> z * 2)
                        .limit(10)
                        .sorted() //Не короткозамкнутся операция
                        .forEach(System.out::println);

        /* Терминальные операции:
                count - считает кол-во элементов в стриме
                findFirst\findAny -> Optional
                anyMatch\nonMatch\allMatch - совпадения
                forEach\forEachOrder
                min\max - Optional
                reduce
                collect
                toArray
                sum\average\summaryStatistics
         */

        /* Collectors:
        toList()
        toSet()
        toCollection(supplier)
        toMap(keyMapper, valueMapper[, merger[,mapSupplier]])
        joining([separator [, prefix, suffix]])
        groupingBy(classifier[[, mapSupplier], downstream])
        partitioningBy(predicate[,downstream])
        reducing\counting, mapping, minBy, maxBy
        averagingInt, averagingLong, averagingDouble
        summingInt, summingLong, summingDouble
         */

        String[] strings = {"Hello", "Java", "Course", "Java"};
        Map<String, Integer> lengths = Arrays.stream(strings)
                .collect(Collectors.toMap(v -> v, String::length,
                        (a, b) -> a, LinkedHashMap::new));
        //разобрались с повторами, залили в мапку, ЛХмапку
        System.out.println(lengths);

    }
    public List<String> processList(List<String> list) {
        return list.stream()
                .map(String::trim)
                .filter(s -> !((String) s).isEmpty())
                .collect(Collectors.toList());
    }
}


