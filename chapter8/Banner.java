package chapter8;

public class Banner {

    public static void main(String[] args) {
        Person persons[] = new Person[15000];
        persons[0] = new Student("John Smith", "900000001", "123 Main St, ", "jsmith@samford.edu");
        persons[1] = new Faculty("Jane Doe", "900000002", "456 Oak St, ", "jdoe@samford.edu");
        persons[2] = new Student("Jim Brown", "900000003", "789 Pine St, ", "jbrown@samford.edu");
        persons[3] = new Faculty("Sara White", "900000004", "321 Maple St, ", "swhite@samford.edu");
        persons[4] = new Staff("Tom Green", "900000005", "654 Cedar St, ", "tgreen@samford.edu");
        for (Person person : persons) {
            if (person != null) {
                System.out.println("Name: " + person.getName());
                System.out.println("Type: " + person.getType());
            }
        }

        
    }
    
}
