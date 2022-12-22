import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.CompletableFuture.supplyAsync;

abstract class MultiThreadingTest extends Thread
        implements Runnable {
    /*Основой многопоточности является интерфейс Runnable
    и класс Thread
    Изначально программа состоит из одного потока который запускает
    метод main()
    В интерфейсе Runnable содержится единственный абстрактный
    метод run(), в котором реализуется логика выполнения нового потока.
    Функциональность каждого отдельного потока содержит класс Thread
    Для создания нового потока можно реализовать интерфейс Runnable
    Или унаследовать класс Thread
    Вообще клас Thread имплементит интерфейс так что он таки вторичен
    подстраиваясь под лямбды будет удобней пользовать Runnable

     */

    @Override //Или class Thread или интерфейс Runnable
    public void run(){
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {

        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        Container container = new Container();
        Runnable foo = () -> {
            for (int i = 0; i < 100_000; i++) {
                container.addEntry("foo");
            }
        };

        List<Thread> threads = new ArrayList<>();
        for (long count = 0; count < 10; count++) {
            Thread thread = new Thread(foo);
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(container.size());

    Thread thread = new Thread(() ->
            System.out.println("Run this shit"));
    thread.setPriority(7); // Выставление приоритета потоку
    thread.start(); //Запустить поток
    thread.interrupt(); //Поставить флаг отключения для потока

        /* Через наследование класса Thread делаем если нужно дополнить
    функционал самого класса Thread
    Интерфейс для реализации одновременности выполнения нескольких
    задач, когда нет нужды изменять механизм многопоточности
    Запускаем через .start() потому как .run() запустит тупо в
    Main Thread
    Запуском потоков занимается в JVM Планировщик потоков, который
    в автоматическом режиме решает какой поток должен выполняться в
    конкретный момент времени. Последовательность выполнения потоков
    контролировать нельзя?!
    Поток нельзя остановить, можно только указать что ему
    следует остановиться, через флаг .interrupt()
    По умолчанию основной поток имеет приоритет = 5, всего значение
    приоритета может быть от 0 до 10, в Thread есть 3 приоритет конст.
    Для каждого потока создается свой стек в памяти, в который помеща-
    ются все данные связанные с выполнением потока
     */
        Thread thread1 = new Thread(() ->
                System.out.println("thread1 is started"));
        Thread thread2 = new Thread(() ->
                System.out.println("thread2 is started"));
        Thread thread3 = new Thread(() ->
                System.out.println("thread3 is started"));

        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        thread3.start();

        /* Поток можно усыпить Thread.sleep(2000) - на 2 секунды
        Так же можно пропустить ход - Thread.yield()

        Daemon потоки - фоновые процессы, которые нужны для обслуживания
        основных потоков. JVM завершает работу как только все !Daemon
        потоки завершены
        методы Daemon:
        setDaemon()
        isDaemon()

        Ошибки потоков
        DeadLock - взаимная блокировка, несколько потоков находятся
        в ожидании ресурсов, занятых друг-другом
        Race Condition - ошибка проектирования при которой существует
        зависимость от порядка выполнения частей кода
        Не все RC производят DL, но все DL происходят в RC

         */
        ConcurrentHashMap<?,?> concurrentHashMap = new ConcurrentHashMap<>();
        CopyOnWriteArrayList<?> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        CopyOnWriteArraySet<?> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
//        ConcurrentNavigableMap, ConcurrentLinkedQueue, ConcurrentLinkedDeque,
//        ConcurrentSkipListMap, ConcurrentSkipListSet - еще такие есть
        /*Для синхронизации используется специальный пакет с методами
         и классами java.util.concurrent как пример выше Map для sync
         суть потокобезопасности что одновременно можно и читать и вносить
         изменения не вызывает исключение ConcurrentModificationException
         */

//        private final AtomicBoolean flag = new AtomicBoolean(false);
//        void doOnce() {
//            if(flag.compareAndSet(false, true)) {
//                action.run();
//            }
//        }
        Semaphore semaphore = new Semaphore(3);
        /*объект синхронизации, ограничивающий одновременный доступ к общему
        ресурсу нескольким потокам с помощью счетчика. */
        CountDownLatch count = new CountDownLatch(10);
        /*(«защелка с обратным отсчетом») — объект синхронизации
        потоков, блокирующий один или несколько потоков до тех пор,
        пока не будут выполнены определенные условия. Количество
        условий задается счетчиком. */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        /*Барьерная синхронизация останавливает участника
        (исполняемый поток) в определенном месте в ожидании
        прихода остальных потоков группы. */
        Exchanger<?> exchanger = new Exchanger<>();
        /*объект синхронизации, используемый для двустороннего
        обмена данными между двумя потоками. */
        Phaser phaser = new Phaser();
        /*объект синхронизации типа «Барьер», но, в отличие от
        CyclicBarrier, может иметь несколько барьеров (фаз), и
        количество участников на каждой фазе может быть разным. */


    }


    public class Test {
        public synchronized void test() {}
        /*ключ synchronized нужен для реализации последовательного
        доступа к ресурсам (чтоб без ошибок)
        синхронизировать можно метод или блок кода
        final поля видны всем потоками без синхронизации
        static методы синхронизируются по классу где метод объявлен
        Если у объекта есть sync статический и sync не статический
        метод они могут выполняться одновременно, так как для первого
        монитор блокировки класс а для второго объект
        недостаток sync - задержка других потоков в очереди к объекту
        или методу, которы sync - Это может стать узким местом в программе
        и снизить скорость работы
         */
    }

    /*Кроме прочего касаясь темы очередей мы знаем что есть блокирующие
    очереди BlockingQueue, BlockingDeque, TransferQueue, ArrayBlockingQueue
    LinkedBlockingQueue, LinkedBlockingDeque, SynchronousQueue, LinkedTransferQueue
    DelayQueue, PriorityBlockingQueue
    и не блокирующие очереди - ConcurrentLinkedQueue, ConcurrentLinkedDeque
    Разница между ними в том что не блокирующие очереди могут к херам
    переполнится и упасть с out of memory если не успевают с нужной скоростью
    обрабатывать данные из других потоков
    Для таких ситуаций нужна блокирующая очередь, в которой мы можем
    настроить её размер, при превышении которого другие потоки,
    передающие в неё данные будут останавливаться.
     */

    /*Пакет java.util.concurrent.locks

    Lock — базовый интерфейс, предоставляющий более гибкий подход при
    ограничении доступа к ресурсам

    Condition — интерфейсное условие в сочетании с блокировкой
    Lock позволяет заменить методы монитора/мьютекса (wait,
    notify и notifyAll) объектом, управляющим ожиданием событий
    Объект с условием чаще всего получается из блокировок с
    использованием метода lock.newCondition()

    ReadWriteLock — интерфейс создания read/write блокировок,
    который реализует один единственный класс
    ReentrantReadWriteLock.

     */

    /* Атомарность это когда невозможно наблюдать
    частичный вариант выполнения операции, всегда видно либо
    до или после операции
    Примеры - запись в поле boolean, byte, short, int, Object
    Запись в поле с модификатором volatile для (long и double)
     */

//    public static class Container {
//        private static volatile Container INSTANCE;
//        int x = 1;
//        /* Тут проверяем чтоб наш контейнер создался только
//        один раз для первого потока который начал с ним работу,
//        а уже второй и последующие не создавали новый, хороша
//        ли данная реализация такой идеи? Тагир сказал что нет XD
//        Singleton double checked locking fixed
//         */
//        static Container getInstance() {
//            if (INSTANCE == null) {
//                synchronized (Container.class) {
//                    if (INSTANCE == null) {
//                        INSTANCE = new Container();
//                    }
//                }
//            }
//            return INSTANCE;
//        }
//    }


    public static class Container {
        private final List<String> list = new ArrayList<>();
        synchronized void addEntry(String str) {
            list.add(str);
        }

        int size() {
            return list.size();
        }
        /* Singleton initialization on demand holder idiom
        JVM гарантирует что каждый класс будет инициализирован
        1 раз
        Тут мы сделали приватный класс Holder который как только
        будет инициализирован и создан контейнер, один раз
        Таким образом мы решим вопрос дублирования контейнера
        В общем неизменяемые объекты друзья многопотока
         */
        int x = 1;
        static Container getInstance() {
            return Holder.INSTANCE;
        }

        /*
        Способ поставить поток в ожидании условия, или
        окончании работы другого потока, два варианта реализации
         */
        volatile boolean content = false;

        public void waitForContent() {
            while(!content) {
                Thread.onSpinWait();
            }
            System.out.println("Content has been arrived");
        }

        public synchronized void deliverContent() {
            content = true;
            notifyAll();
        }
        boolean content2 = false;
        public synchronized void waitForContent2() {
            while (!content2) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
            System.out.println("Contetn has been arrived");
        }
    private static class Holder {
            static final Container INSTANCE = new Container();
    }
    }

    /* Есть еще live lock, это когда потоки меняют состояние
    но прогресс отсутствуют, короче цикличная блок\анблок
    борода
     */

    /* Ты куда? мы еще не закончили!
    CompletableFuture
    Используется для автоматического контроя за потоками
    Смотри пример XD :
     */

//    AtomicReference<?> doer = new AtomicReference<>();
//    AtomicInteger count = new AtomicInteger();
//    Runnable r = () -> doer.get().doOnce(count::incrementAndGet);
//    for(int i = 0; i < JUMPS; i++) {
//        count.set(0);
//        doer.set(new Doer());
//        CompletableFuture<?> future = CompletableFuture.allOf(
//                Stream.generate(() -> CompletableFuture.runAsync(r))
//                        .limit(THREADS).toArray(CompletableFuture[]::new));
//                future.join();
//                if (count.get() != 1) {
//                    System.out.println("oops");
//                }
//    }
    /* Понравилось? В принципе не слишком сложно, код украден
    Поэтоу переменные и классы частично отсутствуют, не стал
    их восстанавливать.
    В общем речи дет о классе CompetableFuture который сам может
    работать с потоками без ручного гемороя
    Еще пример ...
     */

    static BigInteger factorial(int i) {
        BigInteger res = BigInteger.ONE;
        while (i > 0) {
            res = res.multiply(BigInteger.valueOf(i));
            i--;
        }
        return res;
    }
    //Многопоточное вычисление факториалов с CompletableFuture
    static BigInteger combinations(int n, int k) {
        CompletableFuture<BigInteger> factN = supplyAsync(() -> factorial(n));
        CompletableFuture<BigInteger> factK = supplyAsync(() -> factorial(k));
        CompletableFuture<BigInteger> factNminusK = supplyAsync(() -> factorial(n - k));
        return factN.thenCombine(factK, BigInteger::divide)
                .thenCombine(factNminusK, BigInteger::divide).join();
    }
}
