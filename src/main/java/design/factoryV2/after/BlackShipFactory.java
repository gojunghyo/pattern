package design.factoryV2.after;

public class BlackShipFactory implements ShipFactory{

    @Override
    public Ship orderShip(String name, String email) {
        return ShipFactory.super.orderShip(name, email);
    }

    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
