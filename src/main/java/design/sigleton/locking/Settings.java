package design.sigleton.locking;

import java.io.Serializable;

public class Settings implements Serializable {

    /**
     * double checked locking JAVA 1.5 이하 이므로 volatile 제거
     *
     *     private static volatile Settings  INSTANCE;
     *
     *
     *     public static Settings getInstance() {
     *         if(INSTANCE == null) {
     *             synchronized(Settings.class) {
     *                 if(INSTANCE == null) {
     *                     INSTANCE = new Settings();
     *                 }
     *             }
     *         }
     *         return INSTANCE;
     *     }
     */

    /**
     *  static  inner 사용
     *
     * 외부 클래스 Settings가 로딩됩니다.
     * 내부 클래스 SettingsHolder는 이 시점에서 로딩되거나 초기화되지 않습니다.
     * getInstance()가 처음 호출될 때, 내부 클래스의 초기화가 시작됩니다.
     * 내부 클래스의 정적 필드 (INSTANCE)가 Settings의 새로운 인스턴스로 초기화됩니다.
     * 자바에서 클래스 로딩과 초기화는 원자적이고 스레드 안전한 것이 보장되므로, 이 방식은 Settings의 하나의 인스턴스만 생성됨을 보장합니다.
     * 이 메커니즘은 명시적인 동기화가 필요하지 않게 하며, 효율적이고 스레드 안전한 싱글톤 생성을 보장합니다.
     *
     * 요약하면, 자바의 정적 내부 클래스는 내부 클래스의 게으른 로딩과 초기화 동작을 활용하여 싱글톤 패턴을 깨끗하고 스레드 안전한 방법으로 구현하는 데 사용됩니다.
     *  */

    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance(); //이방법으로 직렬화, 역직렬화를 이용한 싱글톤 꺠는 방법 해결가능
    }

}
