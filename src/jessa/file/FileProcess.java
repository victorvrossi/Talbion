package jessa.file;

import java.util.List;
import jessa.object.CarregaDadosLink;
import jessa.object.Categoria;
import jessa.object.Link;

/**
 *
 * @author victo
 */
public class FileProcess {

    private final String newLine = System.getProperty("line.separator");
    private StringBuilder sFile;
    
    public static final String SEPARATOR_CATEGORIA = "[C]";
    public static final String SEPARATOR_LINK = "[l]";
    public static final String DIVIDE_LINK = "<s>";

    public String geraString(List<Categoria> lista) {

        sFile = new StringBuilder();
        lista.forEach(categoria -> {
            sFile.append(SEPARATOR_CATEGORIA);
            sFile.append(categoria.getTitulo());
            sFile.append(newLine);
            categoria.percorrerMapaLinks(new CarregaDadosLink() {
                @Override
                public void dadosLink(Link link) {
                    sFile.append(SEPARATOR_LINK);
                    sFile.append(link.getTitulo());
                    sFile.append(DIVIDE_LINK);
                    sFile.append(link.getLink());
                    sFile.append(newLine);
                }
            });
        });
        return sFile.toString();

    }

}
