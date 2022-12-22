import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class ExceptionTest {
    static class MyException extends Exception{
        /* Основной класс исключений - Throwable
        * у него есть 2 наследника Error и Exception*/
        public MyException(String message, Throwable cause) {
            super(message, cause);
        }
    }

//    static void myExTest(String str) throws MyException {
//        throw new MyException(str);
//    }
    /*Суть в пробрасывании исключения с нашим текстом +
     реальная ошибка */
    void readFile() throws MyException {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(
                    "/etc/passwd"));
            System.out.println(Arrays.toString(bytes));
        }
        catch (IOException e) {
            throw new MyException("Unable to read file", e);
        }
        finally {
            System.out.println("Операция завершена");
        }


        //Потоками лучше не управлять исключениями
        for(int i = 0; i < 10; i++) {
            try {
                if (i == 5) continue;
                if (i == 7) break;
                System.out.println("More Interation!");
            } finally {
                System.out.println("I = " + i);
            }
        }

    }

}
