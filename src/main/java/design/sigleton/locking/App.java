package design.sigleton.locking;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /**
         * replection 을 이용한 비교 , 싱글톤을 꺠드리는 방법 1번
         */
//        Settings instance = Settings.getInstance();
//        Constructor<Settings> declaredConstructor = Settings.class.getDeclaredConstructor();
//        declaredConstructor.setAccessible(true);
//        Settings settings = declaredConstructor.newInstance();
//
//        System.out.println(instance == settings);

        /**
         * 직렬화 역직렬화를 이용한 싱글톤을 꺠뜨리는 방법 2번,
         * resolve
         */

//        Settings instance = Settings.getInstance();
//        Settings instance2 = null;
//
//        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
//            out.writeObject(instance);
//        }
//
//        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
//             instance2 = (Settings) in.readObject();
//        }
//        System.out.println(instance == instance2);



    }
}
