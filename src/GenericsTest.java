import java.util.NoSuchElementException;
import java.util.Objects;

public class GenericsTest<T> {
    T value;
    public GenericsTest(T value) {this.value = value;}

    public T getValue() {
        if(value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    public void setValue(T newValue) {
        value = newValue;
    }

    public T orElse(T other) {
        return value == null ? other : value;
    }

    public boolean isPresent() {
        return value != null;
    }

    /* Для создания допустим модуля принимающего все Number
    Мы должны сделать цикл действий, создать наш генерик тип
    в обобщенном виде, экстенднуть его в наш класс принимающий
    намберсы, а потом отдельно сделать класс принимающий инты
    звучит как хрень, но посмотрим. КОроче он сказал что это норм
    что мы не сможем менять объект если это уклаывается в нашу
    логику проекта ... сложно конечно... Еще кроме extends есть
    ключевое слово Object<? super T> это когда мы берем свойства
    подтипа для нашего типа, расширяем через движение обобщения
    вниз прим.(Object -> String).
    А extends соответственно расширяет вверх
    прим. (String -> Object)
    При парамеризации методов мы так же можем указать тип видом
    static <T> myMethod (GenX<? super T> genX, T value)
     */

//    GenericsTest<String> newString =
//            new GenericsTest<>("My String");
//        System.out.println(newString.isPresent());
//        System.out.println(newString.getValue());
//        System.out.println(newString.orElse("New String"));
//    //Создание переменной через wildcard(?) и var
//    var present = new GenericsTest<String>(null);
//    GenericsTest<?> backYard = new GenericsTest<>("Yo!");
//    Object value = backYard.getValue();
//    /*Но с рандом (?) не будет возможности изменять
//     переменную через set потому что не определен тип */
//    GenericsTest<Object> myObject =
//            new GenericsTest<>("info");
//    //Здесь через сет можно внести в переменную любой Obj
//
//    GenericsTest<? extends Number> number =
//            new GenericsTest<>(123);
//        /*Но ту тоже жопа нельзя будет бахнуть новое значение
//        потому что Java удет думать что может быть и double*/

    //Если сложности недостаточно то держите:
    @SafeVarargs //Мы говорим что мы адекватны компилятору ...
    static <T> boolean isOneOf (T value, T... arrArgs){
    for(T option : arrArgs) {
        if(Objects.equals(value, arrArgs)) return true;
    }
    return false;
    }
    /* Здесь у нас дженерик тип с переменным количеством options
    что даже на первый взгляд смотрится страшновато
     */
}

