import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

public class JbuttonAmeliore extends JButton {


    private int cooX;
    private int cooY;
    private Cellule cellule;

    public JbuttonAmeliore(int cooX, int cooY, Cellule cellule) {
        this.cooX = cooX;
        this.cooY = cooY;
        this.cellule = cellule;
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
        super.paintComponent(g);
        if (cellule.estAllumee()==true) {
            setText("1");
        }
        else {
            setText("0");
        }
    }
    
}
