/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rouart Antoine
 */
public class metier {
    
private int chevalX;
private int chevalY;
Cellule[][] grille;
   public metier() {
    grille = new Cellule[5][5];
    for (int i = 0; i < 5; i++) {
        for (int j=0 ; j<5 ; j++){
            grille[i][j]=new Cellule();  
        }
    }
    initalisation();
    chevalX = 2;
    chevalY = 2;
    grille[chevalX][chevalY].placerCheval();
   }
 public boolean deplacerCheval(int xDest, int yDest) {
        if (xDest < 0 || xDest >= 5 || yDest < 0 || yDest >= 5) {
            return false;
        }


        int dx = Math.abs(xDest - chevalX);
        int dy = Math.abs(yDest - chevalY);
        if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) {
            return false;
        }

        grille[chevalX][chevalY].retirerCheval();
        chevalX = xDest;
        chevalY = yDest;
        grille[chevalX][chevalY].placerCheval();

        return true; // déplacement effectué
    }
private void initalisation(){
    grille[2][2].allumer();  
}

}