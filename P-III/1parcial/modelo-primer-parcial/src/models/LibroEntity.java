package models;

public class LibroEntity{

    private Integer id;
    private String titulo;
    private String autor;
    private Integer anioPublicacion;
    private Integer stock;

    public LibroEntity(){
    }

    public LibroEntity(Integer id,
                       String titulo,
                       String autor,
                       Integer anioPublicacion,
                       Integer stock){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.stock = stock;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public Integer getAnioPublicacion(){
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion){
        this.anioPublicacion = anioPublicacion;
    }

    public Integer getStock(){
        return stock;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }

    @Override
    public String toString(){
        return "LibroEntity{" + "id=" + id + ", titulo='" + titulo + '\'' + ", autor='" + autor + '\'' + ", anioPublicacion=" + anioPublicacion + ", stock=" + stock + '}';
    }
}
