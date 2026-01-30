package chapter8;

abstract public class Person {
    protected String name;
    protected String id;
    protected String addr;
    protected String email;

    protected Person(String name, String id, String addr, String email) {
        this.name = name;
        this.id = id;
        this.addr = addr;
        this.email = email;
    }

    abstract public String getType();

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAddr() {
        return addr;
    }

    public String getEmail() {
        return email;
    }


    
}
