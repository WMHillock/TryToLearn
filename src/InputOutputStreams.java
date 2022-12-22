import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class InputOutputStreams {
    public InputOutputStreams() throws IOException {
    }

    /* InputStream - читать байты
    OutputStream - писать байты
    Reader - читать символы
    Writer - писать символы
    Файлы на диске читать ПОЧТИ ВСЕГДА В БАЙТАХ!
    XML вероятно может самостоятельно декодироваться, не точно
    int read, int read(byte[]b), int read(byte[] b, int offset,
    int length) - такая херня при чтении (варианты)
    long skip(long n) - пропуск кол-ва байт
    int available() - доступно байт
    void mark(int readlimit)
    void reset() - Отмотка в байтах
    boolean markSupported() - маркировка, потом ресет мотает нас к этой точке

     */

    static void readFully(InputStream is, byte[] b)
            throws IOException {
        int offset = 0;
        while(offset < b.length) {
            int count = is.read(b, offset, b.length - offset);
            if(count == -1) {
                throw new IOException("Stream has less then + " +
                        b.length + " bytes");
            }
            offset += count;
        }
    }

    public static void main(String[] args) throws IOException {
//        byte[] b = new byte[100];
//        readFully(System.in, b);
//        System.out.println(Arrays.toString(b));

//        InputStream is = new URL("http://www.google.com").openStream();
//        System.out.println(new String(is.readAllBytes(), StandardCharsets.UTF_8));
        //Так с http Делать не надо это плохо, фу фу надо так:
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://www.google.com"))
//                .build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();
        //Пример try с ресурсами
        try (InputStream in = new FileInputStream("/etc/passwrd");
             OutputStream out = new FileOutputStream("/etc/passwd.bak")) {
            in.transferTo(out);
        }

    }
    /* Реализации InputStream
    FileInputStream - для работы с файлами по пути к ним
    ByteArrayImputStream - массив байт
    BufferedInputStream - обертка инпутстрима, крч хорош(капсулирует)
    DataInputStream - структурированные двоичные данные
    PipedInputStream - не нужно использовать
    ZipFile.getInputStream(ZipEntry) - файл из архива, без анпака
    Process.getInputStrem() - вывод процесса
    URL.openStream() - содержимое по URL
    Не забываем закрывать потоки когда закончили работу с ними,
    помним что есть try() {} Catch with resources когда мы в опции
    try(Прописываем наши открываемые потоки) чтоб они сами закрылись
    по окончанию работы
    Есть еще метод finalize - не надо его пользовать, он плохой
    если классу implements AutoClosable то можно его методы пихать
    в try  с ресурсами, лайфхак епта

    Реализация OutPutStream
    В целом аналогично инпут стриму
    void write, void flush, void close
    Реализации
    FileOutputStream
    ByteArrayOutputStream
    BufferedOutputStream
    PrintStream
    DataOutputStream
    URL ... короче как и во входящем потоке

    Reader реализация
    InputStreamReader(InputStream + charSet)
    FileReader(file, charset)
    StringReader
    BufferedReader (имеет String readLine и Stream<String> lines())


    Writer реализация
    OutputStreamWriter(OutputStream + charset)
    FileWriter (file, charset)
    StringWriter
    BufferedWriter

    java.io.File
    Представляет собой путь к файлу и сам файл
    МОжет быть абсолютным и относительным
    Относительный путь сложно поменять
    Короче устаревшая хрень,но иногда пользуема
    new File(parentDirectory + "/" + fileName);
    Хороший API
    java.nio.file.Path/Paths/Files

    Path (Comparable)
    getFileName()
    getParent()
    getRoot()
    resolve(Path/String) endWith(Path, String)
    getName(int), getNameCount(), iterator
    toString()/toFile()/toUri()
    register(WatchService, WatchEvent.Kind...)

    Files
    copy, move, delete, createFile, createDirectory...
    readAllBytes/readAllLines
    write(byte[], Iterable<String>)
    lines, list, walk -Stream
    walkFileTree
    exist, size, getAttribute, isDirectory, isRegularFile...
    newBufferedReader, newInputStream, newOutputStream, newByteChannel

     */

}
