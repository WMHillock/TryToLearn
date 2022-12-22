//import java.text.MessageFormat;
//import java.util.Locale;
//
//public class StringsHacks {
//
//
//    //TODO Strings
//    String helloWorld = "Hello world";
//    String worldHello = "hELLO wORLD";
//    //Метод стравнения без учета регистра
//        System.out.println(helloWorld.equalsIgnoreCase(worldHello));
//    //так правильно ловеркейсить с учетом локали
//        System.out.println(worldHello.toLowerCase(Locale.ROOT));
//    //Так тоже можно
//        System.out.println("*".repeat(10));
//    //Stringbuilder работает так
//
//    StringBuilder allWeekdays = new StringBuilder();
//        for (Weekday weekday : Weekday.values()) {
//        allWeekdays.append(weekday).append("\n");
//    }
//        System.out.println(allWeekdays);
//        /*
//        Говорит мой любимый String.format() медленней обычного
//        И рекомендует пользовать Locale с ним, во избежание ошибок
//        */
//        System.out.printf(Locale.ROOT,
//            "%s, %s \n",
//    helloWorld, worldHello );
//    //Говорит этот метод гибче и лучше ... реально!
//    String slogan = MessageFormat.format(
//            "{0} {1}",
//            helloWorld, worldHello);
//        System.out.println(slogan);
//
//}
