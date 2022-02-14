package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person> personClass = Person.class;
        Person person1 = personClass.newInstance();
        person1.setName("person-newInstance");
        person1.setAge(1);
        System.out.println(person1);
        System.out.println("----------------------");
        Constructor<Person> constructor = personClass.getConstructor(String.class, Integer.class);
        Person person2 = constructor.newInstance("person-fullParam", 2);
        System.out.println(person2);
        System.out.println("----------------------");
        Constructor<Person> dc = personClass.getDeclaredConstructor(String.class);
        dc.setAccessible(true);
        Person person3 = dc.newInstance("person-private");
        person3.setAge(3);
        System.out.println(person3);
        System.out.println("----------------------");
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            System.out.println("Constructor[" + declaredConstructor.toString() + "]");
            System.out.print("Parameter type:(");
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType.getName() + ",");
            }
            if (parameterTypes.length == 0) {
                System.out.println(")");
            } else {
                System.out.println("\b)");
            }
        }
    }
}
