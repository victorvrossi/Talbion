package jessa.gui.action;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
public class SalvarArvore {

    List<Categoria> lista;

    public SalvarArvore() {
        lista = new ArrayList<>();
    }
    FileOutputStream fos;

    private void write(String text) {
        try {
            fos.write(text.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(SalvarArvore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void close() {
        try {
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(SalvarArvore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private FileOutputStream newFile(File n) {
        try {
            return new FileOutputStream(n);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    void noArquivo(List<Categoria> lista) {
        File n = new File("lista.txt");
        fos = newFile(n);

        try {
            FileProcess ff = new FileProcess();
            write(ff.geraString(lista));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


//    public void s() {
//        String value = "Hello";
//        FileOutputStream fos = new FileOutputStream(fileName);
//        DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
//        outStream.writeBytes(value);
//        outStream.close();
//
//        // verify the results
//        String result;
//        FileInputStream fis = new FileInputStream(fileName);
//        DataInputStream reader = new DataInputStream(fis);
//        result = reader.readUTF();
//        reader.close();
//    }
}
