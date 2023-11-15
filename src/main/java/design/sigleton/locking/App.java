package design.sigleton.locking;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
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

        /**
         * enum 클래스를 사용한 싱글톤
         * 장점:  간단하게 싱글톤으로 만들수있으며 리플렉션과 직렬화 역직렬화를 통한 싱글톤패턴깨는것을 방지할수있다.
         * 단점: 미리 만들어진다. enum은 상속이 불가능하다
         */

        SettingsEnum settingsEnum = SettingsEnum.INSTANCE;
        SettingsEnum settingsEnum1 = null;

        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("enum.obj"))) {
            out.writeObject(settingsEnum);
        }
        //try with resource 는 close 를 명시적으로해주지 않아도 된다.
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("enum.obj"))) {
            settingsEnum1 = (SettingsEnum) in.readObject();
        }
        System.out.println(settingsEnum == settingsEnum1);

    }
}
