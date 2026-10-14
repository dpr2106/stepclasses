import java.util.*;

interface Chargeable {
    boolean bookChargingBay();
}

abstract class Vehicle {
    protected String passNumber;
    protected String ownerName;

    public Vehicle(String passNumber, String ownerName) {
        this.passNumber = passNumber;
        this.ownerName = ownerName;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public abstract String getTypeName();
    public abstract int getPassFee();
}

class Bike extends Vehicle {
    public Bike(String passNumber, String ownerName) {
        super(passNumber, ownerName);
    }
    @Override public String getTypeName() { return "Bike"; }
    @Override public int getPassFee() { return 300; }
}

class Car extends Vehicle {
    public Car(String passNumber, String ownerName) {
        super(passNumber, ownerName);
    }
    @Override public String getTypeName() { return "Car"; }
    @Override public int getPassFee() { return 1000; }
}

class EBike extends Vehicle implements Chargeable {
    public EBike(String passNumber, String ownerName) {
        super(passNumber, ownerName);
    }
    @Override public String getTypeName() { return "EBike"; }
    @Override public int getPassFee() { return 300; }
    @Override public boolean bookChargingBay() { return true; }
}

class ECar extends Vehicle implements Chargeable {
    public ECar(String passNumber, String ownerName) {
        super(passNumber, ownerName);
    }
    @Override public String getTypeName() { return "ECar"; }
    @Override public int getPassFee() { return 1000; }
    @Override public boolean bookChargingBay() { return true; }
}

public class CampusVehiclePassSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> registry = new HashMap<>();

        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equalsIgnoreCase("PASS")) {
                String type = sc.next();
                String passNo = sc.next();
                String owner = sc.next();

                Vehicle v;
                if (type.equalsIgnoreCase("Bike")) v = new Bike(passNo, owner);
                else if (type.equalsIgnoreCase("Car")) v = new Car(passNo, owner);
                else if (type.equalsIgnoreCase("EBike")) v = new EBike(passNo, owner);
                else v = new ECar(passNo, owner);

                registry.put(passNo, v);
                System.out.println(v.getPassNumber() + " (" + v.getTypeName() + ") pass fee " + v.getPassFee());
            } else if (command.equalsIgnoreCase("CHARGE")) {
                String passNo = sc.next();
                Vehicle v = registry.get(passNo);
                if (v instanceof Chargeable) {
                    System.out.println(passNo + " charging bay allotted");
                } else {
                    System.out.println(passNo + " rejected: charging unsupported");
                }
            }
        }
        sc.close();
    }
}
