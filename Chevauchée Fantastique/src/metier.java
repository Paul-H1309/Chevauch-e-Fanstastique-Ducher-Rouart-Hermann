public class metier {

    int TAILLE = 5;

    private int chevalX;
    private int chevalY;

    private Cellule[][] grille;

    public metier() {
        grille = new Cellule[TAILLE][TAILLE];

        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                grille[i][j] = new Cellule();
            }
        }

        initialisation();

        chevalX = 2;
        chevalY = 2;
        grille[chevalX][chevalY].placerCheval();
    }

  
  /*
    public boolean deplacerCheval(int xDest, int yDest) {

        if (xDest < 0 || xDest >= TAILLE || yDest < 0 || yDest >= TAILLE) {
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

       
        grille[chevalX][chevalY].basculerLumiere();

        return true;
    }
/*/
   
    private void initialisation() {
        grille[2][2].allumer();
        grille[1][3].allumer();
        grille[3][1].allumer();
    }

    public Cellule[][] getGrille() {
        return grille;
    }
}
