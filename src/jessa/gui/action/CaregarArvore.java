package jessa.gui.action;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jessa.file.FileProcess;
import jessa.object.CarregaDadosLink;
import jessa.object.Categoria;
import jessa.object.Link;

/**
 *
 * @author victo
 */
public class CaregarArvore {

    private List<Categoria> lista;

    public CaregarArvore() {
        lista = new ArrayList<>();
    }

 

    List<Categoria> noArquivo() {

        File n = new File("lista.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(n))) {
           
            String line = br.readLine();
            Categoria categoria = null;
            while (line != null) {
                if(line.contains(FileProcess.SEPARATOR_CATEGORIA)){
                    categoria = new Categoria();
                    categoria.setTitulo(line.replace(FileProcess.SEPARATOR_CATEGORIA,""));
                    lista.add(categoria);
                }
                if(line.contains(FileProcess.SEPARATOR_LINK)){
                    String[] split = line.replace(FileProcess.SEPARATOR_LINK, "").split(FileProcess.DIVIDE_LINK);
                    Link link = new Link(split[0], split[1]);
                    categoria.inserirLink(link);
                }
                line = br.readLine();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
       
    }

}
