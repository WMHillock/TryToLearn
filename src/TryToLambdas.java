import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.*;

public class TryToLambdas {

    //Варианты работы со ссылками на методы
    IntBinaryOperator sum = Integer::sum;

    Function<String, String> trimer = String::trim;

    //Вот это интересный вариант
    Predicate<String> isFoo = "foo"::equals;

    Consumer<Objects> printer = System.out::println;

    Supplier<List<String>> listFactory = ArrayList::new;

    IntFunction<String[]> arrayFactory = String[]::new;

    //Way to stream API

    static Optional<String> getOne() {
        return Optional.empty();
    }
    static Optional<String> getTwo() {
        return Optional.of("foo");
    }

    public static void main(String[] args) {

        getOne()
                .or(() -> getTwo())
                .ifPresent(System.out::println);
    }


}
