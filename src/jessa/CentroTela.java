package jessa;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

/**
 *
 * @author victo
 */
public class CentroTela {
private Window frame;

    public CentroTela(Window frame) {
        this.frame = frame;
    }
    

    public int getX() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) ((dimension.getWidth() - frame.getWidth()) / 2);
    }

    public int getY() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) ((dimension.getHeight() - frame.getHeight()) / 2);
    }
}
