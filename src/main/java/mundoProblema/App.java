package mundoProblema;

/**
 * Aplicacion de Scores
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to the Score sysmte!" ); // Just for one course

        // Idealmente en el principal solo se deberia construir objetos Materia y Estudiante,
        // un objeto Score solo se deberia construir en la clase Materia

        // Probar la clase Score
        // Score nota1 = new Score();
        // nota1.showScore();
        // Score nota2 = new Score(77);
        // nota2.showScore();
        // Score nota3 = new Score(3.85);
        // nota3.showScore();

        Course course = new Course("Programacion Basica", 0010276, 40, 50, 39, 76, 96);
        course.getAdjustedAverage();
        course.showCourse();
    }
}
