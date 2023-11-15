package design.factory.after;


public class Client {
    public static void main(String[] args) {

        Ship whiteship = new WhiteShipFactory().orderShip("gojgho", "gojgho@naver.com");
        System.out.println(whiteship);
        Ship blackShip = new BlackShipFactory().orderShip("gojgho", "gojgho@naver.com");
        System.out.println(blackShip);
    }
}
