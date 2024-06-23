package jessa.gui.action;

import javax.swing.tree.DefaultMutableTreeNode;
import jessa.object.Categoria;
import jessa.object.Link;

/**
 *
 * @author victo
 */
public class RecarregaArvore extends CategoriaRecuperadaDoMapa {

    private DefaultMutableTreeNode mainNo;
    public RecarregaArvore(DefaultMutableTreeNode mainNo) {
        this.mainNo=mainNo;
    }

    private DefaultMutableTreeNode categoria;

    @Override
    public void recuperaTituloCategoria(String titulo) {
        categoria = new DefaultMutableTreeNode(titulo);
    }

    @Override
    public void recuperaLink(Link link) {
        DefaultMutableTreeNode linkTree = new DefaultMutableTreeNode(link.getTitulo());
        linkTree.setUserObject(link);
        categoria.add(linkTree);
    }


    @Override
    public void getNo(Categoria c) {
        mainNo.add(categoria);
    }
    

}
