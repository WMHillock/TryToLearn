import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class DemoTypesExceptions {

    /*Ебический пример, где мы типизируем ошибку которую мы будем
    Выкидывать, мама дорогая, это умно. Мы тут типом указываем
    интерфейсы ... типа Iterable условно мы сюда можем пихнуть
    все что можно крутить итератором... воу, обалдеть а второй
    интерфейс это наш самописный ThrowableConsumer в котором
    мы указали ограничение для выкидываемых исключениях ...
    Тагир - Батя =) Ага и при этом мы можем имплементить тип
    Iterable например для наших собственных классов... все я аут
    мне пришло озарение глубины типов в java я преисполнился XD
    * */
    void closeAll(List<Closeable> list) throws IOException {
        forEach(list, Closeable::close);
    }

    static <T, X extends Throwable> void forEach(
            Iterable<T> iterable, ThrowableConsumer<T, X> consumer)
            throws X {
        for(T t : iterable) {
            consumer.accept(t);
        }
    }

    @FunctionalInterface
    interface ThrowableConsumer<T, X extends Throwable> {
        void accept(T t) throws X;
    }
}
