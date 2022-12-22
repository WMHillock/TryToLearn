import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        Map<Object, List<String>> crazyMap = new HashMap<>();
        crazyMap.put(1, new ArrayList<>());

        System.out.println(combinations(12, 4));

    }
    static BigInteger factorial(int i) {
        BigInteger res = BigInteger.ONE;
        while (i > 0) {
            res = res.multiply(BigInteger.valueOf(i));
            i--;
        }
        return res;
    }

    static BigInteger combinations(int n, int k) {
        CompletableFuture<BigInteger> factN = CompletableFuture.supplyAsync(() -> factorial(n));
        CompletableFuture<BigInteger> factK = CompletableFuture.supplyAsync(() -> factorial(k));
        CompletableFuture<BigInteger> factNminusK = CompletableFuture.supplyAsync(() -> factorial(n - k));
        return factN.thenCombine(factK, BigInteger::divide)
                .thenCombine(factNminusK, BigInteger::divide).join();
    }


    /*Переменное число аргументов имеет синтаксис
     Object ... objects */
//    static void printAll(Object... objects) {
//        for (Object object : objects) {
//            System.out.println(object);
//        }
//
//    }
//
//    FFace operation = (x, y) -> x + y;

}

