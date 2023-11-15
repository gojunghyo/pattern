package design.factory.after;

public interface ShipFactory {

    default Ship orderShip(String name, String email) {
        validation(name, email);
        prepareFor(name);

        Ship ship = createShip();

        sendEmailTo(ship);
        return ship;
    }

    Ship createShip();

    private void sendEmailTo(Ship ship) {
        System.out.println(ship.getName() + "다 만들었습니다.");
    };

    private void prepareFor(String name) {
        System.out.println(name + " 만들 준비 중");
    };

    private void validation(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 지어주세요.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("연락처를 남겨주세요.");
        }
    };
}
