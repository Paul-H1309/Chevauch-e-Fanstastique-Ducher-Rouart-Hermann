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
    
    int totalAllume = 15; 
    int totalEteint = 10;
    int tailleGrille = TAILLE * TAILLE;

    if (totalAllume + totalEteint > tailleGrille) {
        throw new IllegalArgumentException("Le nombre total de cellules dépasse la taille de la grille");
    }

  
    boolean[] etatCellules = new boolean[tailleGrille];


    for (int i = 0; i < totalAllume; i++) {
        etatCellules[i] = true;
    }

    for (int i = tailleGrille - 1; i > 0; i--) {
        int j = (int)(Math.random() * (i + 1));
        boolean temp = etatCellules[i];
        etatCellules[i] = etatCellules[j];
        etatCellules[j] = temp;
    }


    for (int i = 0; i < TAILLE; i++) {
        for (int j = 0; j < TAILLE; j++) {
            int index = i * TAILLE + j;
            if (etatCellules[index]) {
                grille[i][j].allumer();
            } else {
                grille[i][j].eteindre(); 
            }
        }
    }
    }

    public Cellule[][] getGrille() {
        return grille;
    }
}
