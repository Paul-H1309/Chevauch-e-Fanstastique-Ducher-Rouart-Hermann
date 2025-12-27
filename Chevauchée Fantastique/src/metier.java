
public class metier {

    int TAILLE = 5;
    private int chevalX;
    private int chevalY;
    Cellule[][] grille = new Cellule[TAILLE][TAILLE];
    
    private int[][][] tours = {
        {
            {0,0},{2,1},{4,0},{3,2},{4,4},
            {2,3},{0,4},{1,2},{0,0},{1,4},
            {3,3},{4,1},{2,0},{0,1},{1,3},
            {3,4},{4,2},{3,0},{1,1},{0,2},
            {2,2},{4,3},{3,1},{1,0},{2,4}
        },
        {
            {2,2},{0,1},{1,3},{0,4},{2,3},
            {4,4},{3,2},{4,0},{2,1},{0,0},
            {1,2},{0,4},{1,0},{3,1},{4,3},
            {2,4},{0,3},{1,1},{3,0},{4,2},
            {3,4},{1,3},{0,2},{2,0},{4,1}
        }
        
    };

   
    public metier(int niveau) {
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                grille[i][j] = new Cellule();
            }
        }
        initialisation(niveau);
    }

private void initialisation(int level) {

    int[][] tour = choisirTourAleatoire();

   
    for (int i = 0; i < TAILLE; i++) {
        for (int j = 0; j < TAILLE; j++) {
            grille[i][j].allumer();
        }
    }

    
    int nbEteintes;
    switch(level) {
        case 1: nbEteintes = 20; break;  // Facile
        case 2: nbEteintes = 14; break;  // Moyen
        case 3: nbEteintes = 7; break;   // Difficile
        default: nbEteintes = 14;
    }

    
    if (nbEteintes > tour.length) {
        nbEteintes = tour.length;
    }

    
    int[] indices = new int[tour.length];
    for (int i = 0; i < tour.length; i++) {
        indices[i] = i;
    }

   
    for (int i = tour.length - 1; i > 0; i--) {
        int j = (int)(Math.random() * (i + 1));
        int tmp = indices[i];
        indices[i] = indices[j];
        indices[j] = tmp;
    }

    
    for (int k = 0; k < nbEteintes; k++) {
        int index = indices[k];
        int x = tour[index][0];
        int y = tour[index][1];
        grille[x][y].eteindre();
    }

  
    int lastIndex = tour.length - 1;
    chevalX = tour[lastIndex][0];
    chevalY = tour[lastIndex][1];
    grille[chevalX][chevalY].placerCheval();
}


    public boolean deplacerCheval(int xDest, int yDest) {

        if (xDest < 0 || xDest >= TAILLE || yDest < 0 || yDest >= TAILLE) {
            return false;
        }

        int dx = Math.abs(xDest - chevalX);
        int dy = Math.abs(yDest - chevalY);

      
        if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) {
            return false;
        }

         if (!grille[xDest][yDest].estAllumee()) {
        return false;
    }
    grille[chevalX][chevalY].retirerCheval();

    chevalX = xDest;
    chevalY = yDest;
    grille[chevalX][chevalY].placerCheval();
    grille[chevalX][chevalY].basculerLumiere();

    return true;     
    }


    public int[][] choisirTourAleatoire() {
        int index = (int)(Math.random() * tours.length);
        return tours[index];
    }
    
    public boolean estVictoire() {
    for (int i = 0; i < TAILLE; i++) {
        for (int j = 0; j < TAILLE; j++) {
            if (grille[i][j].estAllumee()) {
                return false;
            }
        }
    }
    return true;
}
    public boolean estDefaite() {
    int[][] coups = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
    for (int[] c : coups) {
        int xDest = chevalX + c[0];
        int yDest = chevalY + c[1];
        if (xDest >= 0 && xDest < TAILLE && yDest >= 0 && yDest < TAILLE) {
            if (grille[xDest][yDest].estAllumee()) {
                return false; // coup possible
            }
        }
    }
    return true; // aucun coup possible
}
}
