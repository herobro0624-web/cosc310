package chapter8;

public class Employee extends Person {
    public Employee(String name, String id, String addr, String email) {
        super(name, id, addr, email);
    }

    @Override
    public String getType() {
        return "Employee";
    }
    
}
