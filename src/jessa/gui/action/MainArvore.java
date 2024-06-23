package jessa.gui.action;

import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import jessa.object.Categoria;
import jessa.object.MapCategoria;

/**
 *
 * @author victo
 */
public class MainArvore {

    private DefaultMutableTreeNode mainNo;
    private final JTree mainArvore;
    private MapCategoria categoriaMapa;

    public MainArvore(JTree mainArvore) {
        this.mainArvore = mainArvore;
        this.categoriaMapa = new MapCategoria();
        init();
    }

    public void init() {
        mainNo = new DefaultMutableTreeNode("Categoria");
        mainArvore.setModel(new DefaultTreeModel(mainNo));
    }

    public void adicionaCategoria(String titulo) {
        categoriaMapa.adicionaCategoria(Categoria.nova(titulo));
        reset();
    }

    private void recarregaArvore() {
        mainNo = new DefaultMutableTreeNode("Categoria");
        RecarregaArvore recarga = new RecarregaArvore(mainNo);
        categoriaMapa.percorreMapaCategoria(recarga);
    }

    public void reset() {
        recarregaArvore();
        mainArvore.setModel(new DefaultTreeModel(mainNo));
    }

    public MapCategoria acessoCategoriaMapa() {
        return categoriaMapa;
    }

    public void salvar() {
        SalvarArvore save = new SalvarArvore();
        save.noArquivo(categoriaMapa.geraListaCategoriaComLink());
    }

    public void carregar() {
        CaregarArvore load = new CaregarArvore();
        List<Categoria> lista = load.noArquivo();
        for (Categoria categoria : lista) {
            categoriaMapa.adicionaCategoria(categoria);
        }

    }

}
