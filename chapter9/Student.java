package chapter9;

public class Student implements Comparable<Student> {

    private String name;

    public Student(String name) {
        this.name = name;
    }
    
    @Override
    public int compareTo(Student o) {
        String part1[] = name.split(" ");
        String part2[] = o.name.split(" ");
        return part1[1].compareTo(part2[1]);
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Student students[] = new Student[] {
            new Student("John Smith"),
            new Student("Adam Sandler"),
            new Student( "Zack Thomas")
        };
        System.out.println("Before");
        System.out.println(java.util.Arrays.toString(students));
        System.out.println("After");
        java.util.Arrays.sort(students);
        System.out.println(java.util.Arrays.toString(students));
    }
}
