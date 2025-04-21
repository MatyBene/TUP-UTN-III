package models;

public class UsuarioEntity{

    private Integer id;
    private String nombre;
    private String email;

    public UsuarioEntity(){
    }

    public UsuarioEntity(Integer id,
                         String nombre,
                         String email){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public UsuarioEntity(String nombre,
                         String email){
        this.nombre = nombre;
        this.email = email;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioEntity:\n" +
               "  ID: " + id + "\n" +
               "  Nombre: " + nombre + "\n" +
               "  Email: " + email + "\n";
    }
}
