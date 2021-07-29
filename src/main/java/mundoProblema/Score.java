package mundoProblema;
// Las clases en un paquete deben tener una relacion, un factor comun
// En tanto que los paquetes suelen tener una relacion de dependencia;
// Un paquete suele depender de otro u otros

public class Score {
    
    // Atributos -> variables del paradigma anterior en contexto -> entidad representada

    // Las constantes se declaran en mayuscula (buena practica de programacion)
    public static final int APROVED_SCALE100 = 59;// final implica que la variable es constante
    public static final double APROVED_SCALE5 = 2.95;
    private String evaluatedConcept;
    private int scale100;
    private double scale5;
    private String cualitative;
    
    // Metodos -> son las operaciones -> describen el comportamiento del objeto
    
    // Tipos de metodos:

    // Metodos constructores: logica (algoritmo) de construccion de un objeto de la clase
    // El tener varios constructores se conoce somo sobrecarga de constructores
    public Score() {
        // En este constructor no se requiere el puntero this (opcional)
        this.evaluatedConcept = "Concepto sin asignar";
        this.cualitative = "Sin aginar";
        scale100 = 0;
        scale5 = 0.0;
    }

    public Score(int ScoreEsc100) {
        // En este constructor no se requiere el puntero this (opcional)
        this.evaluatedConcept = "Concepto sin asignar";
        this.cualitative = "Sin asignar";
        scale100 = ScoreEsc100;
        scale5 = ((double)scale100)/20; // Puesto que scale100 es int, para evitar perdida de informacion hacemos un casting

        if(scale100 >= Score.APROVED_SCALE100) {
            this.cualitative = "Approved";

        } else {
            this.cualitative = "Not approved";
        }
    }

    public Score(double ScoreEsc5) {
        // En este constructor no se requiere el puntero this (opcional)
        this.evaluatedConcept = "Concepto sin asignar";
        this.cualitative = "Sin asignar";
        //long test = Math.round(ScoreEsc5);
        //int test = (int)ScoreEsc5; // se descarta por completo la parte decimal (truncado)
        scale5 = ScoreEsc5;
        scale100 = (int)(20*scale5); // Puesto que scale100 es int, para evitar perdida de informacion hacemos un casting

        if(scale5 >= APROVED_SCALE5) { // Score.APROVED_SCALE5: Scorecion para acceder este atributo desde fuera de la clase
            this.cualitative = "Approved";

        } else {
            this.cualitative = "Reprobated";
        }
    }

    // Metodos que definen el comportamiento
    public void showScore() {
        System.out.println("--Score Info--");
        System.out.println("Evaluated concept: " + evaluatedConcept);
        System.out.println("100 scale: " + scale100);
        System.out.println("5 scale: " + scale5);
        System.out.println("Cualitative: " + cualitative);

    }

    // Metdosos Getters y Setters: metodos para obtener y establecer atributos que son privados
    // Se podrian usar un getter y un setter para cada atributo, pero esto no es una buena
    // practica de programacion. Se deben usar solos los getters y los setters que sean necesarios,
    // usualmente se usan para los atributos privados
    
    // Getters: permiten la consulta de artibutos (los getters deben ser publicos)
    public int getScale100() {
        return scale100;
    }

    public double getScale5() {
        return scale5;
    }

    public String getCualitative() {
        return cualitative;
    }

    public String getEvaluatedConcept() {
        return evaluatedConcept;
    }

    // Setters
    // Se deben usar setters solo cuando se desee cambiar el valor de atributos privados de manera externa
    public void setEvaluatedConcept(String evaluatedConcept) {
        this.evaluatedConcept = evaluatedConcept;
    }
}
