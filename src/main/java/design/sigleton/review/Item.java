package design.sigleton.review;

import java.io.Serializable;

public class Item implements Serializable {
    /**
     * double checkd locking singleton pattern review
     */

//    private static volatile Item INSTANCE;
//
//
//
//    public synchronized Item getItem() {
//        if(INSTANCE == null) {
//            synchronized (Item.class) {
//                if(INSTANCE == null) {
//                    return new Item();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//
    /**
     * static inner class singleton pattern
     */

    static class ItemHolder {
        private static final Item INSTANCE = new Item();
    }

    public static Item getInstance() {
        //가능한이유는 내부 정적 클래스의 지연로딩 때문에 가능하며 내부 이너 클래스생성시 지연되어 하나만 생성되도록 보장받기 때문이다.
        return ItemHolder.INSTANCE;
    }

    public Object readResolve(){
        return getInstance();
    }
}
