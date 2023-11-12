package design.sigleton.locking;

public class Settings {

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
     *  static  inner 사용 */

    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }

}
