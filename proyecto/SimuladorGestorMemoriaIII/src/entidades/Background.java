package entidades;

import java.awt.Color;
import javax.swing.JPanel;

public class Background extends JPanel {
  
    /***
     * Se sobreescribe el método setBackground el cual
     * permite colorear el fondo de un componente
     * especificamente el componente heredado {JPanel}
     * @param bg {Class.Color}
     */
    @Override
    public void setBackground(Color bg) {
        Color color = new Color(255,255,204);
        this.setOpaque(true);
        super.setBackground(color); 
    }

}
