import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JbuttonAmeliore extends JButton {

private Image imageCheval;
    public int cooX;
    public int cooY;
    private Cellule cellule;

    public JbuttonAmeliore(int cooX, int cooY, Cellule cellule) {
        this.cooX = cooX;
        this.cooY = cooY;
        this.cellule = cellule;
         try {
            ImageIcon icon = new ImageIcon(
    getClass().getResource("/images/st_small_507x507-pad_600x600_f8f8f8-removebg-preview.png")
);
imageCheval = icon.getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCooX() {
        return cooX;
    }

    public int getCooY() {
        return cooY;
    }

    public Cellule getCellule() {
        return cellule;
    }

@Override
protected void paintComponent(Graphics g) {
    // fond selon état
    if (cellule.aCheval()) {
        g.setColor(new java.awt.Color(102, 102, 102)); // gris pour le cheval
    } else if (cellule.estAllumee()) {
        g.setColor(new java.awt.Color(255, 255, 102)); // jaune
    } else {
        g.setColor(new java.awt.Color(102, 102, 102)); // gris éteint
    }
    g.fillRect(0, 0, getWidth(), getHeight());

    // image du cheval
    if (cellule.aCheval() && imageCheval != null) {
        g.drawImage(imageCheval, 0, 0, getWidth(), getHeight(), this);
    }

    // bordure
    g.setColor(java.awt.Color.BLACK);
    g.drawRect(0, 0, getWidth()-1, getHeight()-1);
}
}

    

