import java.util.*;

public class CollectionsTest {
    /*Основа коллекций Iterable<> и Itertor<>,
    от них все наследуется
    ниже устаревшее написание
    Это старая но рабочая версия если нужен доступ к
     переменным
     */
    void printAllOld(Iterable<?> iterable) {
        Iterator<?> iterator = iterable.iterator();
        while (iterator.hasNext()) {
//           Пример доступа к внутренним данным
//            if(iterator.hasNext().isEmpty()) {
//                iterator.remove();
//            }
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    //Эти конструкции равны по дейтсвию, но ниже новый вариант
    void printAllNew(Iterable<?> iterable) {
        for (Object obj : iterable) {
            System.out.println(obj);
        }
    }

    //Это наш итератор, самописный, считает копии value
    static <T> Iterable<T> nCopies(T value, int count) {
        if (count < 0)
            throw new IllegalArgumentException("Negative count "
                    + count);
        return () -> new Iterator<T>() { //Лямбда однако ...
            int rest = count;

            @Override
            public boolean hasNext() {
                return rest < 0;
            }

            @Override
            public T next() {
                if (rest == 0)
                    throw new NoSuchElementException();
                rest--;
                return value;
            }
        };
    }
    //Коллекции Collection<E> extends Iterable<E>
    /*
    Set<e> extends Collection<E> не отличается по методам
    отличсется тем что содержит не более 1 экземпляра
    любого объекта. Два сета можно сравнить через equals
     */

    static Set<Integer> rangeSet(int fromInclusive, int toExclusive) {
        return new AbstractSet<Integer>() {
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    int next = fromInclusive;

                    public boolean hasNext() {
                        return next != toExclusive;
                    }

                    public Integer next() {
                        if(next == toExclusive) {
                            throw new NoSuchElementException();
                        }
                        return next++;
                    }
                };
            }
                public int size() {
                return toExclusive - fromInclusive;
                }
        };
    }
    /*
    sout(rangeSet(10, 20).contains(10));
    true
    sout(rangeSet(10, 20).contains(20));
    false максимальное значение не включается
    sout(rangeSet(10, 20));
    [10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
    sout(rangeSet(0, Integer.MAX_VALUE).contains(-1))
    Из-за специфики итератора будет обойден весь объем данных
    и только посре сравнения всех значений нам дадут ответ
    Можно переписать итератор
            @Override
        public boolean contains(Object o) {
            return o instanceof Integer &&
                    ((Integer) o) >= fromInclusive &&
                    ((Integer) o) < toExclusive;
        }
     */

    /* List<E> extends Collection<E>
    Коллекция с индексами, "расширяемый массив"
    Есть свой итератор listIterator
    Можно вырезать кусочек списка sublist еще есть методы
    итераций - hasPrecious(), previous(), nextIndex(),
    previousIndex(), set(), add()
     */

    static  List<Integer> rangeList(int fromInclusive,
                                    int toExclusive){
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                if(index < 0 || index >= size()){
                    throw new IndexOutOfBoundsException(index);
                }
                return fromInclusive + index;
            }
            @Override
            public int size() {
                return toExclusive - fromInclusive;
            }
        };

    }
    /* Такое дело, для быстрых итераций нужно бахать
    имплементацию implements RandomAccess она дает ускорение
    производитеьлности в поиске. Лучше делать её приватной ...
     Для этого создадим еще один класс см ниже*/

//    private static class RangeList extends AbstractList<Integer>
//            implements RandomAccess {
//        @Override
//        public boolean contains(Object o) {
//            return o instanceof Integer &&
//                    (Integer) o >= fromInclusive &&
//                    (Integer) o < toExclusive;
//        }
//    }
    // Нельзя имплементить одну коллекцию другой кста.

    /* Плохие коллекции - замена
    Enumeration - ArrayList
    Vector - ArrayList
    Stack - ArrayDeque
    Dictionary - Map
    HashTable - HashMap
    LinkedList - ArrayList / ArrayDeque
     */

    //Map ассоциативный массив оптимизированный поиск по ключу
    /*Interface Entry<Key, Value> имеет доп методы - getKey(),
    getValue(), setValue();
     */

    /* Есть проблема, нельзя исзменять список во время его обхода
    циклом или Stream или других обходах, за исключением использования
    итератора, там можно удалять, но и все.
     */

    }



