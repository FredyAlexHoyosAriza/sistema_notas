package UserInterface;
import mundoProblema.*;
import java.util.Scanner;
public class ConsoleInterface {
    // Attributes
    private Course course;
    private Student student;

    // Methods

    // Constructors
    ConsoleInterface() {
        course = new Course();
        student = new Student();
    }

    // Functionality; behavior
    public int mainMenu() {
        System.out.print("\n**** Main menu ****\n");
        System.out.println("1. Set student information");
        System.out.println("2. Set course information");
        System.out.println("3. Show course information");
        System.out.println("4. Show student information");
        System.out.println("5. Show adjusted average");
        System.out.println("6. Add course score");
        System.out.println("7. Exit");
        System.out.print("\nSelect a choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        // sc.close();
        // En un cilco indeterminado aparecen problemas al realizar multiples cierres, por ello aqui se evita el cierre
        // System.out.println();
        return choice;
    }

    public void setStudent() {
        System.out.print("\n***** Entering student information *****\n");
        System.out.print("Please enter the student's names: ");
        Scanner sc = new Scanner(System.in);
        String names = sc.nextLine();
        System.out.print("Please enter the student's surnames: ");
        String surnames = sc.nextLine();
        System.out.print("Please enter the student's code: ");
        int code = sc.nextInt();
        // sc.nextLine(); // Manejar el movimiento de carro que no es interpretado por nextInt; el enter, luego de ingresar el int
        // Se instancia el objeto atributo student con la informacion recogida; student se carga en userInterface
        student = new Student(code, names, surnames);
    }

    // Main loop
    public void executeMainLoop(){
        // Ciclo indeterminado; funcionara cuantos veces desee o inponga el usuario
        boolean follow = true;

        while(follow) {

            // Aloja la ejecucion de la aplicacion
            int option = mainMenu();
            System.out.println();
            if(option == 1) {
                // Student register call
                this.setStudent(); // solicita los campos para establecer un estudnte, pero no retorna nada

            } else if(option == 2) {
                // Course register call
                System.out.println("No built option");

            } else if(option == 3) {
                // Show course information call
                System.out.println("No built option");
                
            } else if(option == 4) {
                // Show student information
                this.student.showStudentInfo();
                
            } else if(option == 5) {
                System.out.println("No built option");

            } else if(option == 6) {
                System.out.println("No built option");
                
            } else if(option == 7) {
                follow = false;
                System.out.println("Successful exit\n");                
            }

        }

    }

    public static void main(String[] args) {

        // Create the application in console version
        ConsoleInterface interfaz = new ConsoleInterface(); // interface: es una palabra reservada
        
        // Start up the application
        interfaz.executeMainLoop();
    }
    
}
