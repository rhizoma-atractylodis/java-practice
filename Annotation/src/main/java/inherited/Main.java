package inherited;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        Class<Son> sonClass = Son.class;
        Annotation[] annotations = sonClass.getAnnotations();
        Annotation[] declaredAnnotations = sonClass.getDeclaredAnnotations();
        for (Annotation annotation : declaredAnnotations) {
            System.out.println(annotation);
        }
    }
}
