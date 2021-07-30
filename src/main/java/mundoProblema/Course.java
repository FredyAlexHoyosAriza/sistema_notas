package mundoProblema;
// composicion: los objetos Score solo existen dentro de la clase Course
// Asociacion: un objeto de la clase Student sigue existiendo independientemente de si
// se elimina la clase Course (En este paquete falta crear la clase Student), Student
// existiria en la aplicacion
// Agregacion: Se da, si en la clase Course existiera un arreglo de objetos tipo Student;
// asociacion multiple es agregacion
import java.util.ArrayList;

// En python se tiene que el tipado para los argumentos de las funciones es dinamico,
// en tanto que aqui en java el tipado es estatico, por ello, en los metodos no se
// usan argumentos con valores por omision. El costo de la flexibilidad en python es
// un mayor costo computacional que lo hace un poco mas lento que java

public class Course {

    // Attributes
    private String courseName;
    private int courseStudentCode;
    private double adjustedAverage;
    private ArrayList<Score> scoresCollection = new ArrayList<Score>();
    private Score worstScore;
    private Student student;
    // private int[] a = new int[10];
    // private Score bestScore;

    // Methods: the signature of a method is established by its input parameters; type, quantity and order

    // Constructors
    // Coruse(): publico en el mundo del paquete
    // public Course(): publico externamente fuera del paquete
    public Course()  {
        courseName = "Not assigned";
        courseStudentCode = 0000;
        adjustedAverage = 0.0;
        for(Score score : scoresCollection) {
            score = new Score();
        }
        worstScore = new Score(); // worstScore = new Score(100);
        student =  new Student();
        // bestScore;

    }
    public Course(String _courseName, int _courseStudentCode, int n1, int n2, int n3, int n4, int n5) { // publico externamente
        // Se pudo haber recibido un arreglo de enteros y cargar un numero variable de enteros en ScoresCollection

        // Por convencion los objetos llevan nobmres que empiezan en minuscula y
        // clases llevan nombres que empiezan en mayusculas
        courseName = _courseName;
        courseStudentCode = _courseStudentCode;
        // scoresCollection = new ArrayList<Score>();
        scoresCollection.add(new Score(n1));
        scoresCollection.add(new Score(n2));
        scoresCollection.add(new Score(n3));
        scoresCollection.add(new Score(n4));
        scoresCollection.add(new Score(n5));
        worstScore = new Score();
        // bestScore = new Score(0);
        adjustedAverage = 0;
        // Por coherencia, los objetos tipo Score no deberian existir fuera de la clase Course (fuera del contexto Course)
    }

    public Course(Student _student, String _courseName, int n1, int n2, int n3, int n4, int n5) { // publico externamente
        // Se pudo haber recibido un arreglo de enteros y cargar un numero variable de enteros en ScoresCollection

        // Por convencion los objetos llevan nobmres que empiezan en minuscula y
        // clases llevan nombres que empiezan en mayusculas
        student = _student;
        courseName = _courseName;
        courseStudentCode = student.getCode();
        // scoresCollection = new ArrayList<Score>();
        scoresCollection.add(new Score(n1));
        scoresCollection.add(new Score(n2));
        scoresCollection.add(new Score(n3));
        scoresCollection.add(new Score(n4));
        scoresCollection.add(new Score(n5));
        worstScore = new Score();
        // bestScore = new Score(0);
        adjustedAverage = 0;
        // Por coherencia, los objetos tipo Score no deberian existir fuera de la clase Course (fuera del contexto Course)
    }

    // Methods
    
    // Get the worst Score
    public void getWorstScore() {
        // int[] a = new int[10];
        int aux = 0, worstScore100 = scoresCollection.get(0).getScale100();
        for (int i = 1; i < scoresCollection.size(); i++) {
            aux = scoresCollection.get(i).getScale100();
            if(aux < worstScore100) {
                worstScore100 = aux;
            }
        }
        worstScore.setScale100(worstScore100);
        /*
        for(Score score : scoresCollection) {
            if(score.getScale100() < worstScore.getScale100()){
                worstScore = score;
            }
        }
        */
    }

    //
    public void getAdjustedAverage(){
        this.getWorstScore();
        // Recorrer scoresCollection para obtener el promedio ajustado
        adjustedAverage = 0;
        for (Score score : scoresCollection){
            adjustedAverage += score.getScale5();
        }
        adjustedAverage = (adjustedAverage - worstScore.getScale5())/(scoresCollection.size()-1);
    }

    // Show the student code with his respective adjusted average
    public void showAdjustedAverage() {
        this.getAdjustedAverage();
        // System.out.printf("Adjusted average of " + this.courseStudentCode + ": %.2f \n" , this.adjustedAverage);
        System.out.printf("Adjusted average of " + student.getCode() + ": %.2f \n" , this.adjustedAverage);
    }

    // Show course
    public void showCourse() {
        System.out.println("**** Course: " + this.courseName + " ****");
        System.out.println();
        for(Score score : scoresCollection) {
            score.showScore();
        }
        System.out.printf("Adjusted average of " + student.getCode() + ": %.2f \n" , this.adjustedAverage);
        System.out.println("Worst score: ");
        this.worstScore.showScore();
    }

    public void setNameAndScores(String _courseName, int n1, int n2, int n3, int n4, int n5) { // publico externamente
        // Se pudo haber recibido un arreglo de enteros y cargar un numero variable de enteros en ScoresCollection

        // Por convencion los objetos llevan nobmres que empiezan en minuscula y
        // clases llevan nombres que empiezan en mayusculas
        courseName = _courseName;
        // scoresCollection = new ArrayList<Score>();
        scoresCollection.add(new Score(n1));
        scoresCollection.add(new Score(n2));
        scoresCollection.add(new Score(n3));
        scoresCollection.add(new Score(n4));
        scoresCollection.add(new Score(n5));
        this.getAdjustedAverage();
    }

    // El polimorfismo se da cuando para un mismo metodo existen diferentes inplementaciones independientemente
    // de si hacen o no lo mismo; el sistema diferencia entre estos metodos a partir de sus firmas, es decir,
    // el tipo, cantidad y orden de sus arguementos de entrada pero no de su retorno.

    // Add a new course score
    // En este caso se trataria de un polimorfismo en tiempo de compilacion
    public void addCourseScore(int Score100) {
        scoresCollection.add(new Score(Score100));
        this.getAdjustedAverage();
    }

    public void addCourseScore(String scoreName, int Score100) {
        scoresCollection.add(new Score(scoreName, Score100));
        this.getAdjustedAverage();
    }

    // Getters    
    public String getCourseName() {
        return courseName;
    }

    public int getCourseStudentCode() {
        return courseStudentCode;
    }

    // Setters
    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
