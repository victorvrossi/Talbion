/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jessa;

import java.awt.event.WindowEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import jessa.gui.DiaCategoria;
import jessa.gui.DiaLink;
import jessa.gui.action.AbrirLink;
import jessa.gui.action.DiaWindowListener;
import jessa.gui.action.MainArvore;

/**
 *
 * @author victo
 */
public class FrameMain extends javax.swing.JFrame {

    /**
     * Creates new form FrameMain
     */
    public FrameMain() {
        initComponents();
        arvore = new MainArvore(arvoreCategoria);
        arvore.reset();

        centraliza();
    }

    private void centraliza(){
        CentroTela c = new CentroTela(this);        
        setLocation(c.getX(), c.getY());
    }
    private MainArvore arvore;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        arvoreCategoria = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuArquivo = new javax.swing.JMenu();
        menuCarregarLista = new javax.swing.JMenuItem();
        MenuSalvarLista = new javax.swing.JMenuItem();
        MenuEdit = new javax.swing.JMenu();
        MenuEditCategoria = new javax.swing.JMenuItem();
        MenuEditLink = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        arvoreCategoria.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                arvoreCategoriaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(arvoreCategoria);

        MenuArquivo.setText("File");

        menuCarregarLista.setText("Carregar");
        menuCarregarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCarregarListaActionPerformed(evt);
            }
        });
        MenuArquivo.add(menuCarregarLista);

        MenuSalvarLista.setText("Salvar");
        MenuSalvarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSalvarListaActionPerformed(evt);
            }
        });
        MenuArquivo.add(MenuSalvarLista);

        jMenuBar1.add(MenuArquivo);

        MenuEdit.setText("Editar");

        MenuEditCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        MenuEditCategoria.setText("Categoria");
        MenuEditCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEditCategoriaActionPerformed(evt);
            }
        });
        MenuEdit.add(MenuEditCategoria);

        MenuEditLink.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        MenuEditLink.setText("Link");
        MenuEditLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEditLinkActionPerformed(evt);
            }
        });
        MenuEdit.add(MenuEditLink);

        jMenuBar1.add(MenuEdit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuEditCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEditCategoriaActionPerformed
        DiaCategoria diaCategoria = new DiaCategoria(this, true);
        diaCategoria.map(arvore.acessoCategoriaMapa());
        diaCategoria.refresh();
        diaCategoria.setVisible(true);
        diaCategoria.addWindowListener(new DiaWindowListener() {
            @Override
            public void windowClosed(WindowEvent e) {
                arvore.reset();
            }
        });
    }//GEN-LAST:event_MenuEditCategoriaActionPerformed

    DefaultMutableTreeNode categoriaSelecionada = null;
    private void arvoreCategoriaValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_arvoreCategoriaValueChanged
        TreePath path = evt.getPath();
        switch (path.getPathCount()) {
            case 1 ->
                categoriaSelecionada = null;
            case 2 ->
                categoriaSelecionada = (DefaultMutableTreeNode) path.getPath()[1];
            case 3 ->
                AbrirLink.instance(path.getPath()[2]).system();
        }
    }//GEN-LAST:event_arvoreCategoriaValueChanged

    private void MenuEditLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEditLinkActionPerformed
        DiaLink diaLink = new DiaLink(this, true);
        diaLink.map(arvore.acessoCategoriaMapa());
        diaLink.refresh();
        diaLink.setVisible(true);
        diaLink.addWindowListener(new DiaWindowListener() {
            @Override
            public void windowClosed(WindowEvent e) {
                arvore.reset();
            }
        });
    }//GEN-LAST:event_MenuEditLinkActionPerformed

    private void MenuSalvarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalvarListaActionPerformed
        arvore.salvar();
    }//GEN-LAST:event_MenuSalvarListaActionPerformed

    private void menuCarregarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCarregarListaActionPerformed
        arvore.carregar();
        arvore.reset();
    }//GEN-LAST:event_menuCarregarListaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuArquivo;
    private javax.swing.JMenu MenuEdit;
    private javax.swing.JMenuItem MenuEditCategoria;
    private javax.swing.JMenuItem MenuEditLink;
    private javax.swing.JMenuItem MenuSalvarLista;
    private javax.swing.JTree arvoreCategoria;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuCarregarLista;
    // End of variables declaration//GEN-END:variables
}