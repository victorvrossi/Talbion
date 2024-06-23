package jessa.object;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author victo
 */
public class Categoria {

    public static Categoria nova(String titulo) {
        Categoria nova = new Categoria();
        nova.setTitulo(titulo);
        return nova;
    }

    private String titulo;
    
    private Map<Integer,Link> listaLinks;

    public Categoria() {    
        listaLinks = new HashMap<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public Categoria setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }
    
    public void inserirLink(Link link){
        if(listaLinks.containsKey(link.hashCode())){
            LinkException.jaExisteLink(link);
        }
        listaLinks.put(link.hashCode(), link);        
    }
    
    public void removerLink(Link link){
        if(!listaLinks.containsKey(link.hashCode())){
            LinkException.naoExisteLink(link);
        }        
        listaLinks.remove(link.hashCode());        
    }

    @Override
    public int hashCode() {
        return titulo.hashCode();
    }

    @Override
    public String toString() {
        return titulo;
    }
    

   public void percorrerMapaLinks(CarregaDadosLink clink) {
       if(listaLinks == null || listaLinks.size()<1){
           return;
       }
        listaLinks.entrySet().forEach(mapLink->{
            Link link = mapLink.getValue();
            clink.dadosLink(link);
        });
    }

    public boolean temLink() {
        return !listaLinks.isEmpty();
    }


    
}
