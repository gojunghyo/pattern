package design.factoryV2.after;

public class App {

    public static void main(String[] args) {
        Ship whiteShip = new WhiteShipFactory().orderShip("gojgho", " gojgho@naver.com");
        Ship blackShip = new BlackShipFactory().orderShip("gojgho", "gojgho@naver.com");

        System.out.println(whiteShip);
        System.out.println(blackShip);
    }
}
