package jessa.gui.action;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.tree.DefaultMutableTreeNode;
import jessa.object.Link;

/**
 *
 * @author victo
 */
public class AbrirLink {
private DefaultMutableTreeNode link;
    public static AbrirLink instance(Object p) {
        return new AbrirLink((DefaultMutableTreeNode)p);
    }

    private AbrirLink(DefaultMutableTreeNode link) {
        this.link = link;
    }

    public void system(){
        Link tab = ((Link)link.getUserObject());
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
            try {
                Desktop.getDesktop().browse(new URI(tab.getLink()));
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
