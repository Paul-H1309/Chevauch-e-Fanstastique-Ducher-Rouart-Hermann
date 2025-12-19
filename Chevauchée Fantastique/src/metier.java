public class metier {

    int TAILLE = 5;

    private int chevalX;
    private int chevalY;

    Cellule[][] grille = new Cellule[TAILLE][TAILLE];

    public metier() {

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
        grille[0][0].allumer();
    }

    public Cellule[][] getGrille() {
        return grille;
    }
}
