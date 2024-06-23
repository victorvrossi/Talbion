package jessa.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jessa.gui.action.CategoriaRecuperadaDoMapa;

/**
 *
 * @author victo
 */
public class MapCategoria {

    private Map<Integer, Categoria> mapCategoria;

    public MapCategoria() {
        mapCategoria = new HashMap<>();
    }

    public void adicionaCategoria(Categoria categoria) {
        if (mapCategoria.containsKey(categoria.hashCode())) {
            LinkException.jaExisteCategoria(categoria);
        }
        mapCategoria.put(categoria.hashCode(), categoria);

    }

    public Categoria[] getArray() {
        if(mapCategoria.size()<1)return  new Categoria[0];
        return  mapCategoria.values().toArray(new Categoria[mapCategoria.size()]);
    }

    public void percorreMapaCategoria(CategoriaRecuperadaDoMapa recuperaCategoria) {
        mapCategoria.entrySet().forEach(categoria -> {
            Categoria c = categoria.getValue();
            recuperaCategoria.recuperaTituloCategoria(c.getTitulo());
            c.percorrerMapaLinks(new CarregaDadosLink() {
                @Override
               public void dadosLink(Link link) {
                    recuperaCategoria.recuperaLink(link);
                }
            });
            recuperaCategoria.getNo(c);
        });
    }
    
    
    public List<Categoria> geraListaCategoriaComLink() {
        List<Categoria> listaCategoria = new ArrayList<>();
        mapCategoria.entrySet().forEach(categoria -> {
            Categoria c = categoria.getValue();
            listaCategoria.add(c);
        });
        return listaCategoria;
    }

    public void remover(Categoria categoria) {
        if (!mapCategoria.containsKey(categoria.hashCode())) {
            LinkException.jaExisteCategoria(categoria);
        }
        mapCategoria.remove(categoria.hashCode());
    }
    
     public void remover(Categoria categoria,Link link) {
        if (!mapCategoria.containsKey(categoria.hashCode())) {
            LinkException.jaExisteCategoria(categoria);
        }
        Categoria cat = mapCategoria.get(categoria.hashCode());
        cat.removerLink(link);
    }

    public void editar(Categoria categoria,String titulo) {
         if (!mapCategoria.containsKey(categoria.hashCode())) {
            LinkException.jaExisteCategoria(categoria);
        }
         if(titulo == null || titulo.isBlank()) LinkException.informeUmTitulo();
         mapCategoria.get(categoria.hashCode()).setTitulo(titulo);
    }


}
