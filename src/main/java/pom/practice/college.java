package pom.practice;

class Person {
    String name;
    String addr;
    int age;

    public Person(String name, String addr, int age) {
        this.name = name;
        this.addr = addr;
        this.age = age;
    }

    public void DisplayDetails() {
        System.out.println("Name: " + name + "\nAddress: " + addr + "\nAge: " + age);
    }
}

class students extends Person {
    int studentid;
    String course;

    public students(String name, String addr, int age, int studentid, String course) {
        super(name, addr, age);
        this.studentid = studentid;
        this.course = course;
    }

    public void DisplayStudent() {
        DisplayDetails();
        System.out.println("Student ID: " + studentid + "\nCourse: " + course);
    }

    public static void CollegeInfo() {
        System.out.println("Welcome to Suryadatta College");
    }
}

public class college {
    public static void main(String[] args) {
        students.CollegeInfo();
        students s1 = new students("A", "pune", 20, 101, "MCA");
        students s2 = new students("B", "pune", 20, 102, "MCA");
        students s3 = new students("C", "pune", 20, 103, "MCA");
        students s4 = new students("D", "pune", 20, 104, "MCA");

        s1.DisplayStudent();
        s2.DisplayStudent();
        s3.DisplayStudent();
        s4.DisplayStudent();
    }
}
