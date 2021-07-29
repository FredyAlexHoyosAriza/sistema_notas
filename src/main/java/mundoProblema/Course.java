package mundoProblema;
// composicion: los objetos Score solo existen dentro de la clase Course
// Asociacion: un objeto de la clase Student sigue existiendo independientemente de si
// se elimina la clase Course (En este paquete falta crear la clase Student), Student
// existiria en la aplicacion
// Agregacion: Se da, si en la clase Course existiera un arreglo de objetos tipo Student;
// asociacion multiple es agregacion
import java.util.ArrayList;

public class Course {

    // Attributes
    private String courseName;
    private String courseStudentCode;
    private double adjustedAverage;
    private ArrayList<Score> scoresCollection = new ArrayList<Score>();
    private Score worstScore;
    private Student student;
    // private Score bestScore;

    // Constructors
    // Coruse(): publico en el mundo del paquete
    // public Course(): publico externamente fuera del paquete
    public Course()  {
        courseName = "Not assigned";
        courseStudentCode = "0000";
        adjustedAverage = 0.0;
        for(Score score : scoresCollection) {
            score = new Score();
        }
        worstScore = new Score();
        student =  new Student();
        // bestScore;

    }
    public Course(String _courseName, String _courseStudentCode, int n1, int n2, int n3, int n4, int n5) { // publico externamente
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
        worstScore = new Score(100);
        // bestScore = new Score(0);
        adjustedAverage = 0;
        // Por coherencia, los objetos tipo Score no deberian existir fuera de la clase Course (fuera del contexto Course)
    }

    // Methods
    
    // Get the worst Score
    public void getWorstScore() {
        int[] a = new int[10];
        // int worstScore100 = 100;
        for(Score score : scoresCollection) {
            if(score.getScale100() < worstScore.getScale100()){
                worstScore = score;
            }

        }
    }

    //
    public void getAdjustedAverage(){
        this.getWorstScore();
        // Recorrer scoresCollection para obtener el promedio ajustado
        for (Score score : scoresCollection){
            adjustedAverage += score.getScale5();
        }
        adjustedAverage = (adjustedAverage - worstScore.getScale5())/(scoresCollection.size()-1);
    }

    // Show course
    public void showCourse() {
        System.out.println("**** Course: " + this.courseName + " ****");
        System.out.println();
        for(Score score : scoresCollection) {
            score.showScore();
        }
        System.out.printf("Adjusted average of " + this.courseStudentCode + ": %.2f \n" , this.adjustedAverage);
        System.out.println("Worst score: ");
        this.worstScore.showScore();
    }
    
    public String getCourseName() {
        return courseName;
    }

    public String getCourseStudentCode() {
        return courseStudentCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
