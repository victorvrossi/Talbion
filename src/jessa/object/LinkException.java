package jessa.object;

/**
 *
 * @author victo
 */
public class LinkException extends RuntimeException{

    static void jaExisteLink(Link link) {
        throw new LinkException("Já existe Link "+link.getTitulo()+" "+link.getLink());
    }
    
    static void jaExisteCategoria(Categoria cat) {
        throw new LinkException("Já existe Categoria "+cat.getTitulo()+" ");
    }
    static void naoExisteCategoria(Categoria cat) {
        throw new LinkException("Não existe Categoria "+cat.getTitulo()+" ");
    }
    
    static void naoExisteLink(Link link) {
        throw new LinkException("Não existe Link "+link.getTitulo()+" "+link.getLink());
    }

    static void informeUmTitulo() {
        throw new LinkException("Informe um titulo");
    }

    public LinkException(String text) {
        super(text);
    }
    

}
