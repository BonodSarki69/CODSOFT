import java.util.*;

class Course {
    String code, title, description, schedule;
    int capacity, enrolled;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolled = 0;
    }

    public boolean hasSlot() {
        return enrolled < capacity;
    }

    public void enroll() {
        if (hasSlot()) enrolled++;
    }

    public void drop() {
        if (enrolled > 0) enrolled--;
    }

    public void display() {
        System.out.printf("%s - %s (%s)\nDescription: %s\nCapacity: %d/%d\n\n", 
                code, title, schedule, description, enrolled, capacity);
    }
}

class Student {
    String id, name;
    List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (course.hasSlot()) {
            registeredCourses.add(course);
            course.enroll();
            System.out.println("✅ Successfully registered for " + course.title);
        } else {
            System.out.println("⚠️ Course full! Cannot register.");
        }
    }

    public void dropCourse(String courseCode) {
        for (Course course : registeredCourses) {
            if (course.code.equalsIgnoreCase(courseCode)) {
                registeredCourses.remove(course);
                course.drop();
                System.out.println("❌ Successfully dropped " + course.title);
                return;
            }
        }
        System.out.println("⚠️ You are not registered in this course.");
    }

    public void displayRegisteredCourses() {
        System.out.println("\n📚 Registered Courses for " + name + " (" + id + "):");
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            for (Course course : registeredCourses) {
                System.out.println("- " + course.title + " (" + course.code + ")");
            }
        }
    }
}

public class Task5 {
    static Map<String, Course> courses = new HashMap<>();
    static Map<String, Student> students = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadCourses();
        while (true) {
            System.out.println("\n📌 MENU:\n1️⃣ Register Student\n2️⃣ List Courses\n3️⃣ Register for Course\n4️⃣ Drop Course\n5️⃣ View Registered Courses\n6️⃣ Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1 -> registerStudent();
                case 2 -> listCourses();
                case 3 -> registerForCourse();
                case 4 -> dropCourse();
                case 5 -> viewStudentCourses();
                case 6 -> {
                    System.out.println("🔚 Exiting system. Goodbye!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }

    static void loadCourses() {
        courses.put("CS101", new Course("CS101", "Intro to Programming", "Learn Java basics", 2, "MWF 10:00AM"));
        courses.put("MATH201", new Course("MATH201", "Calculus I", "Study of differentiation and integration", 3, "TTH 9:00AM"));
        courses.put("PHYS301", new Course("PHYS301", "Physics I", "Fundamentals of mechanics", 2, "MWF 11:00AM"));
    }

    static void registerStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        if (students.containsKey(id)) {
            System.out.println("⚠️ Student already registered!");
            return;
        }
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        students.put(id, new Student(id, name));
        System.out.println("✅ Student registered successfully!");
    }

    static void listCourses() {
        System.out.println("\n📋 Available Courses:");
        for (Course course : courses.values()) {
            course.display();
        }
    }

    static void registerForCourse() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        Student student = students.get(id);
        if (student == null) {
            System.out.println("⚠️ Student not found! Register first.");
            return;
        }
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine().toUpperCase();
        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("⚠️ Invalid course code.");
            return;
        }
        student.registerCourse(course);
    }

    static void dropCourse() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        Student student = students.get(id);
        if (student == null) {
            System.out.println("⚠️ Student not found! Register first.");
            return;
        }
        System.out.print("Enter course code to drop: ");
        String courseCode = scanner.nextLine().toUpperCase();
        student.dropCourse(courseCode);
    }

    static void viewStudentCourses() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        Student student = students.get(id);
        if (student == null) {
            System.out.println("⚠️ Student not found! Register first.");
            return;
        }
        student.displayRegisteredCourses();
    }
}
