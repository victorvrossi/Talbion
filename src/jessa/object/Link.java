package jessa.object;

/**
 *
 * @author victo
 */
public class Link {
    
    private String titulo;
    private String link;

    public Link(String titulo, String link) {
        this.titulo = titulo;
        this.link = link;
    }
    
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return titulo;
    }
    

    @Override
    public int hashCode() {
        return (""+titulo+link).toLowerCase().replace(" ", "").hashCode();
    }
    
    
    
    

}
