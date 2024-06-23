package jessa.gui.action;

import jessa.object.Categoria;
import jessa.object.Link;

/**
 *
 * @author victo
 */
public abstract class CategoriaRecuperadaDoMapa {
    public abstract void recuperaTituloCategoria(String titulo);
    public abstract void recuperaLink(Link link);

    public abstract void getNo(Categoria c);
}
