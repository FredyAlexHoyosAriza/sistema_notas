package mundoProblema;

public class Student {
        //Atributos
        private int code;
        private String names;
        private String surnames;
    
        //Constructores
        public Student(){
            this.code = 0;
            this.names = "No names assigned";
            this.surnames = "No surnames assigned";
        }
    
        public Student(int _code, String _names, String _surnames){
            this.code = _code;
            this.names = _names;
            this.surnames = _surnames;
        }
    
        //Métodos -> No hemos colocado lógica, pero está posibilidad
        public void showStudentInfo(){
            System.out.println("&&&&&& Sudent Info &&&");
            System.out.println("Code -> "+this.code);
            System.out.println("Names -> "+this.names);
            System.out.println("Surnames -> "+this.surnames);
        }
    
        //Getters
        public int getCode() {
            return code;
        }

        public String getNames() {
            return names;
        }

        public String getSurnames() {
            return surnames;
        }

        //Setters
        public void setCode(int code) {
            this.code = code;
        }

        public void setNames(String names) {
            this.names = names;
        }

        public void setSurnames(String surnames) {
            this.surnames = surnames;
        }
}
