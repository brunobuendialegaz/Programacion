package agente;

public class Contacto {
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private int telefono;

    public Contacto(){}
    public Contacto (String nombre, String apellido, String dni, String email, int telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String toString(){
        return "Nombre: "+nombre+" Apellido: "+apellido+" Teléfono: "+telefono+" Email: "+email;
    }
}
