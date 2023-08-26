/**
 * 
 * @author Juan Goyes 
 * clase Estudiante
 * En esta clase estan los atributos y constructores con metodos getters y setters
 */
public class Estudiante {

    private  String cedula;
    private String nombre;
    private String apellido;
    private int semestre;
    private String correo;
    private String celular;

    public Estudiante() {
    }

    public Estudiante(String cedula, String nombre, String apellido, int semestre, String correo, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
        this.correo = correo;
        this.celular = celular;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
    
  
}

