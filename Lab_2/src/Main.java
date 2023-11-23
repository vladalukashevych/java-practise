import com.education.ztu.*;
import com.education.ztu.enums.Gender;
import com.education.ztu.enums.Location;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Teachers
        Teacher teacher1 = new Teacher("Mathematics", "University X", new Car("Toyota", "Corolla"), "John", "Doe", 35, Gender.MALE, Location.ZHYTOMYR);
        teacher1.setSubject("English");
        teacher1.setUniversity("University U");
        System.out.printf(teacher1.getFullInfo());

        Teacher teacher2 = new Teacher("Physics", "University Y", new Car("Honda", "Civic"), "Jane", "Smith", 40, Gender.FEMALE, Location.VINNYTSYA);
        teacher2.setAge(99);
        teacher2.setFirstname("Ivan");
        System.out.printf(teacher2.getFullInfo());

        teacher2.TeachLesson();
        System.out.printf(teacher2.getOccupation() + "\n");
        System.out.printf((teacher2 instanceof Human) + "\n");
        Teacher.showCounter();

        // Students
        Student student1 = new Student("University A", "Computer Science", 2, "Alice", "Smith", 20, Gender.FEMALE, Location.VINNYTSYA);
        student1.setUniversity("University U");
        System.out.printf(student1.getFullInfo());

        Student student2 = new Student("University B", "Business Administration", 3, "Bob", "Johnson", 22, Gender.MALE, Location.RIVNE);

        System.out.printf(student2.getFullInfo());

        Student student3 = new Student("University C", "Electrical Engineering", 1, "Charlie", "Brown", 19, Gender.MALE, Location.ZHYTOMYR);

        System.out.printf(student3.getFullInfo());

        student3.Study();
        System.out.printf(student3.getOccupation() + "\n");
        System.out.printf((student3 instanceof Human) + "\n");
        Student.showCounter();

        // Employees
        Employee employee1 = new Employee("ABC Corp", "Software Engineer", new Car("Toyota", "Camry"), "John", "Doe", 28, Gender.MALE, Location.KIEV);

        System.out.printf(employee1.getFullInfo());

        Employee employee2 = new Employee("XYZ Ltd", "Marketing Specialist", new Car("Honda", "Accord"), "Jane", "Smith", 35, Gender.FEMALE, Location.RIVNE);

        System.out.printf(employee2.getFullInfo());

        employee2.Work();
        System.out.printf(employee2.getOccupation() + "\n");
        System.out.printf((employee2 instanceof Human) + "\n");
        Employee.showCounter();
    }
}