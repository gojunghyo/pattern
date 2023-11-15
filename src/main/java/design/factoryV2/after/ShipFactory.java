package design.factoryV2.after;

public interface ShipFactory {

    default Ship orderShip(String name, String email){
        validationNameAndEmail(name, email);
        prepareFor(name);
        Ship ship = createShip();

        // notify
        sendEmailTo(email, ship);
        return ship;
    }

    Ship createShip();

    private void validationNameAndEmail(String name, String email) {
        // validate
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 지어주세요.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("연락처를 남겨주세요.");
        }
    }


    private static void prepareFor(String name) {
        System.out.println(name + " 만들 준비 중");
    }

    private static void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었습니다.");
    }


}
