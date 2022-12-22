import java.lang.reflect.*;
import java.util.List;

public class DarkSideReflections {
    /* В общем рефлексия кода это для реверс инжиниринга,
    срочной, временной корректировки косяков. С её помощью
    можно творить дикую дич, получать доступ к приватным
    полям, изменять приватные поля без сеттера... Короче
    режим разработчика в режиме разработчика. С помощью кода
    ниже мы можем узнать структуру класса
     */
    void test(List<? extends Number> list) {
        try {
            Method test = getClass().getDeclaredMethod("test", List.class);
            Type type = test.getGenericParameterTypes()[0];
            if(type instanceof ParameterizedType){
                System.out.println("TypeName " + ((ParameterizedType) type).getRawType().getTypeName());
                Type[] args = ((ParameterizedType)type).getActualTypeArguments();
                for (Type arg : args) {
                    if (arg instanceof WildcardType) {
                        Type[] bounds = ((WildcardType)arg).getUpperBounds();
                        System.out.println("Bound " + bounds[0]);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
