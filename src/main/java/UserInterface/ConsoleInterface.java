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
        sc.nextLine();
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
        // Se instancia el objeto atributo student con la informacion recogida; student se carga en userInterface
        student = new Student(code, names, surnames);
        course.setStudent(student);
    }

    public void setCourse() {
        System.out.print("\n***** Entering course information *****\n");
        System.out.print("Please enter the course name: ");
        Scanner sc = new Scanner(System.in);
        String courseName = sc.nextLine();
        System.out.print("Please enter, in scale100, the score 1: ");
        int score1 = sc.nextInt();
        // Manejar el movimiento de carro que no es interpretado por nextInt; el enter, luego de ingresar el int
        sc.nextLine();
        System.out.print("Please enter, in scale100, the score 2: ");
        int score2 = sc.nextInt();
        // Manejar el movimiento de carro que no es interpretado por nextInt; el enter, luego de ingresar el int
        sc.nextLine();
        System.out.print("Please enter, in scale100, the score 3: ");
        int score3 = sc.nextInt();
        sc.nextLine();
        System.out.print("Please enter, in scale100, the score 4: ");
        int score4 = sc.nextInt();
        sc.nextLine();
        System.out.print("Please enter, in scale100, the score 5: ");
        int score5 = sc.nextInt();
        this.course.setNameAndScores(courseName, score1, score2, score3, score4, score5);
    }

    public void addNewScore() {
        // User interaction form
        System.out.print("\n***** Entering a new score *****\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the evaluated concept: ");
        String scoreName = sc.nextLine();
        System.out.print("Please enter, in scale100, the new score: ");
        int newScore = sc.nextInt();
        sc.nextLine();

        // consumption of the logic of the problem world
        this.course.addCourseScore(scoreName, newScore);

    }

    // Main loop
    public void executeMainLoop(){
        // Ciclo indeterminado; funcionara cuantos veces desee o inponga el usuario
        boolean follow = true;

        while(follow) {

            // Aloja la ejecucion de la aplicacion
            int option = mainMenu();
            // System.out.println();
            if(option == 1) {
                // Student register call
                this.setStudent(); // solicita los campos para establecer un estudnte, pero no retorna nada

            } else if(option == 2) {
                // Course register call
                this.setCourse();

            // Los metodos para mostrar informacion, como buena practica de programacion, deberian ser parte de la interaccion,
            // en este caso hacen parte de las clases Student y Course, puesto que fueron inplementados en estas previamente.
            // Por lo cual se puede decir que el mundo del problema cuenta con algo de interaccion con metodos que permiten
            // salida de informacion en consola. Es resposabilidad del programador tomar estas desiciones, pero como buena
            // practica se espera que se haga uso de muy poca logica del mundo del problema en la interaccion; cuanto mucho un
            // metodo por caso y solo en algunos casos

            } else if(option == 3) { // case: option = 3
                // Show course information call
                this.course.showCourse(); // Aqui solo se llama una funcion del mundo del problema
                
            } else if(option == 4) { // case: option = 4
                // Show student information
                this.student.showStudentInfo(); // Aqui solo se llama una funcion del mundo del problema
                
            } else if(option == 5) {
                // showAdjustedAverage call
                this.course.showAdjustedAverage(); // Aqui solo se llama una funcion del mundo del problema

            } else if(option == 6) {
                // AddNewScore call
                addNewScore();

                
            } else if(option == 7) {
                // Exit call
                follow = false;
                System.out.println("Successful exit\n");                
            } else {
                System.out.println("** Please enter a valid option **");
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
