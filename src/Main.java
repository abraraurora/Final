import java.util.InputMismatchException;
import java.util.Scanner;
 
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    boolean mainChecker = true;
    Scanner mainScan = new Scanner(System.in);
    while(mainChecker){
            try{
                throw new myExcept();
            }
            catch(myExcept e){

            }
        }
    }
}
class MyException extends Throwable {

}
abstract class Menus<T> {
   abstract public T menuPromptAndSelect();

  abstract public void menuSelectCheck();
}

class MainMenu extends Menus<Integer> {
    StudentManagement studentManagementMenu = new StudentManagement();
    CourseManagement courseManagementMenu = new CourseManagement();
    boolean whileToggle = true;
    @Override
    public void menuSelectCheck() {
        int userSelection  = -1;
        userSelection = menuPromptAndSelect();
        switch (userSelection){
            case 0->{ System.out.println("Goodbye!");
            System.exit(0);}
            case 1->{studentManagementMenu.menuSelectCheck();}
            case 2->{courseManagementMenu.menuSelectCheck();}
            default -> {System.out.println("fatal error! program will shutdown");System.exit(1);}
        }

    }
    @Override
    public Integer menuPromptAndSelect() {
        boolean toggle = true;
        int mainSelection = 0;
        while (toggle) {
            try {
                Scanner mainScan = new Scanner(System.in);
                System.out.println("-------------------------------------------\nMain Menu\n\n1 : Student Management\n2 : Course Management\n0 : Exit");
                mainSelection = mainScan.nextInt();
                mainScan.close();
                if(mainSelection>2 || mainSelection<0){
                    throw new myExcept();
                }
            }
            catch (myExcept | Exception e) {
                System.out.println("invalid input!");
            }
            finally {
                if(mainSelection>=0 && mainSelection<= 2){
                    toggle = false;
                }
            }
        }
        return mainSelection;

    }

}
class StudentManagement extends Menus<Character> {
    //student management initial prompt code
    @Override
    public Character menuPromptAndSelect() {
        boolean toggle = true;
        char studentSelection = ' ';
        while (toggle) {
            try {
                Scanner studentScan = new Scanner(System.in);
                System.out.println("a. add a student\nb. search for a student by id\nc. delete a student\nd. print the fee invoice of a student by id.\ne. Print all students"); // will change
                studentSelection = studentScan.next().charAt(0);
                studentScan.close();
                if(studentSelection != ('a'|'b'|'c'|'d'|'e')){ // will change
                    throw new myExcept();
                }
            }
            catch (myExcept | Exception e) {
                System.out.println("invalid input!");
            }
            finally {
                if(studentSelection ==('a'|'b'|'c'|'d'|'e') ) { // will change
                    toggle = false;
                }
            }
        }
        return studentSelection;

    }

    @Override
    public void menuSelectCheck() {

    }
}

class CourseManagement extends Menus {
    @Override
    public int menuPromptAndSelect() {
        return 0;
    }

    @Override
    public void menuSelectCheck() {

    }
}

// delete these comments later
// All students: name and ID
// Undergrad: undergrad courses taken, gpa, resident or not

// MS: grad courses taken[], 
// PHD: labs supervised (discount), advisor, research subject
// separate research fee of 700 for PHD students 

abstract class Student {

    // Data
    private String name;
    private String id; 

    // Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Constructor 
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return id.toUpperCase() + "-" + name.toUpperCase();
    }

abstract public void printInvoice();
}

class UndergraduateStudent extends Student{

    // Data
    private int[] undergradCrnsTaken;
    private double gpa;
    private boolean resident;

    // Setters and getters
    public int[] getUndergradCrnsTaken() {
        return undergradCrnsTaken;
    }

    public void setUndergradCrnsTaken(int[] undergradCrnsTaken) {
        this.undergradCrnsTaken = undergradCrnsTaken;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public boolean isResident() {
        return resident;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }

    // Constructor
    public UndergraduateStudent(String name, String id, int[] undergradCrnsTaken, double gpa, boolean resident) {
        super (name, id);
        this.undergradCrnsTaken = undergradCrnsTaken.clone();
        this.gpa = gpa;
        this.resident= resident;
    }

    // Function to get cost for credit hours depending on if OOS resident or not
    // ...
    
    @Override
    public void printInvoice() {
        /// ...
    }
}

abstract class GraduateStudent extends Student {

    public GraduateStudent (String name, String id) {
        super(name, id);    
}

class PHDStudent extends GraduateStudent {

    // Data
    private int[] labsSupervised;
    private String advisor;
    private String researchSubject;

    // Setters and Getters
    public int[] getlabsSupervised() {
        return labsSupervised;
    }
    
    public void setLabsSupervised(int[] labsSupervised) {
        this.labsSupervised = labsSupervised;
    }
    
    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public String getResearchSubject() {
        return researchSubject;
    }

    public void setResearchSubject(String researchSubject) {
        this.researchSubject = researchSubject;
    }

    // Constructor
    public PHDStudent(String name, String id, int[] labsSupervised, String advisor, String researchSubject) {
        super(name, id);
        this.labsSupervised = labsSupervised.clone();
        this.advisor = advisor;
        this.researchSubject = researchSubject; 
    }

    // Function to get total cost for a PHD student
    // ... 

    @Override
    public void printInvoice() {
        // ...
    }
}
class  MSStudent extends GraduateStudent {

    // Data
    private int[] gradCrnsTaken;

    // Setter and getter
    public int[] getGradCrnsTaken() {
        return gradCrnsTaken;
    }

    public void setGradCrnsTaken(int[] gradCrnsTaken) {
        this.gradCrnsTaken = gradCrnsTaken;
    }

    // Constructor
    public MSStudent(String name, String id, int[] gradCrnsTaken) {
        super(name, id);
        this.gradCrnsTaken = gradCrnsTaken.clone();

    @Override
    public void printInvoice() {
        // ...
    }
}
