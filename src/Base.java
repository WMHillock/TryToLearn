//import java.sql.Array;
//import java.text.MessageFormat;
//import java.util.*;
//import javax.swing.JOptionPane;
//public class Base {
//        String name;
//        int age;
//        String food;
//
//        name = JOptionPane.showInputDialog("Введите имя:");
//        age = Integer.parseInt(JOptionPane.showInputDialog("Введите возраст:"));
//
//        JOptionPane.showMessageDialog(null,"Hello " + name + ", you are " + age);
//
//        String dayOfWeek;
//        dayOfWeek = JOptionPane.showInputDialog("Enter the day of week:");
//
//        switch (dayOfWeek) {
//            case "Sunday":
//                JOptionPane.showMessageDialog(null,"Its Sunday mate!");
//                break;
//            case "Monday":
//                JOptionPane.showMessageDialog(null,"Its Monday mate!");
//                break;
//            case "Tuesday":
//                JOptionPane.showMessageDialog(null,"Its Tuesday mate!");
//                break;
//            case "Wednesday":
//                JOptionPane.showMessageDialog(null,"Its Wednesday mate!");
//                break;
//            case "Thursday":
//                JOptionPane.showMessageDialog(null,"Its Thursday mate!");
//                break;
//            case "Friday":
//                JOptionPane.showMessageDialog(null,"Its Friday mate!");
//                break;
//            case "Saturday":
//                JOptionPane.showMessageDialog(null,"Its Saturday mate!");
//                break;
//            default:
//                JOptionPane.showMessageDialog(null,"Enter the correct day!");
//
//        }
//    int temp = Integer.parseInt(JOptionPane.showInputDialog(null, "WHat is weather out today?"));
//
//    if(temp >= 25) {
//        JOptionPane.showMessageDialog(null, "Today is hot outside!");
//    } else if (temp <=25 && temp >=15) {
//        JOptionPane.showMessageDialog(null, "Today is warm outside!");
//    } else {
//        JOptionPane.showMessageDialog(null, "Today is cold outside!");
//    }
//
//        String response = JOptionPane.showInputDialog(null, "Do you wanna play the game?");
//
//        if(response.toLowerCase(Locale.ENGLISH).equals("yes")) {
//            JOptionPane.showMessageDialog(null, "Lets play, Bro!");
//        } else if (response.toLowerCase(Locale.ENGLISH).equals("no")) {
//            JOptionPane.showMessageDialog(null, "Thats sad, Bro!");
//        } else {
//            JOptionPane.showMessageDialog(null, "WTF!?!? bro?");
//        }
//
//    String value = "";
//    int loopCounter = 0;
//
//    while(value.isBlank() && loopCounter <= 100) {
//    loopCounter++;
//    JOptionPane.showMessageDialog(null, "We are going " + loopCounter + " cycle");
//    if(loopCounter == 10) {
//    value = "Stop this shit";
//    JOptionPane.showMessageDialog(null, value);
//     }
//     }
//        String value = "third";
//        System.out.println(switch (value){
//            case "first" ,"third" ->  "Its first or Third";
//            case "second" -> "Its second";
//            default -> "other";
//        });
//
//        int[] intArr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
//
//        for(int boxArr : intArr) {
//            System.out.println(boxArr);
//        }
//    //Это метка, Тагир говорит что нахер метки
//        OUTER:
//        for(int boxArr : intArr) {
//            if (boxArr == 8){
//                break OUTER;
//            }
//            System.out.println(boxArr);
//        }
//
//    class Point {
//        int x, y;
//
//        void shift(int dx, int dy) {
//            y+=dx;
//            x+=dy;
//            System.out.println(y + "\n" + x);
//        }
//        //Перегрузка метода с разными вариантами возврата значения
//        int shift(int dx) {
//            return x+=dx;
//        }
//        //Перегрузка со сменой типа входящих значений
//        void shift(String str) {
//            System.out.println(str + x + " раз");
//        }
//    }
//
//    Point newPoint = new Point();
//        newPoint.shift(3,5);
//
//    //Лайфхак от Тагира
//
//    record Point2(int x, int y){}
//        System.out.println(new Point2(6, 8));
//
//        /*Если создать вложенный клас то он будет иметь доступ к полям
//        класса в который он вложен
//        * */
//}
