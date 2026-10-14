import java.util.*;

abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getType();
    public abstract double calculatePay();

    @Override
    public String toString() {
        return "Payslip[name=" + name + ", type=" + getType() + ", pay=" + (long)calculatePay() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double salary;

    public FullTimeEmployee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override public String getType() { return "FullTime"; }
    @Override public double calculatePay() { return salary; }
}

class PartTimeEmployee extends Employee {
    private double hours;
    private double rate;

    public PartTimeEmployee(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override public String getType() { return "PartTime"; }
    @Override public double calculatePay() { return hours * rate; }
}

class InternEmployee extends Employee {
    private double stipend;

    public InternEmployee(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override public String getType() { return "Intern"; }
    @Override public double calculatePay() { return stipend; }
}

public class PayrollRegisterSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> staff = new ArrayList<>();

        while (sc.hasNext()) {
            String type = sc.next();
            if (type.equalsIgnoreCase("FullTime")) {
                String name = sc.next();
                double sal = sc.nextDouble();
                staff.add(new FullTimeEmployee(name, sal));
            } else if (type.equalsIgnoreCase("PartTime")) {
                String name = sc.next();
                double hours = sc.nextDouble();
                double rate = sc.nextDouble();
                staff.add(new PartTimeEmployee(name, hours, rate));
            } else if (type.equalsIgnoreCase("Intern")) {
                String name = sc.next();
                double stipend = sc.nextDouble();
                staff.add(new InternEmployee(name, stipend));
            }
        }
        sc.close();

        double totalPay = 0;
        double maxPay = -1;
        String topEarner = "";

        for (Employee emp : staff) {
            System.out.println(emp);
            double pay = emp.calculatePay();
            totalPay += pay;
            if (pay > maxPay) {
                maxPay = pay;
                topEarner = emp.getName();
            }
        }

        System.out.println("Total " + (long)totalPay);
        System.out.println("top earner " + topEarner);
    }
}
