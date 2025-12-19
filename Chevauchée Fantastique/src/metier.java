
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

   
    public metier() {


        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                grille[i][j] = new Cellule();
            }
        }

        initialisation();
    }

    private void initialisation() {

        int[][] tour = choisirTourAleatoire();

        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                grille[i][j].allumer();
            }
        }


        int nbEteintes = 7; 
        for (int k = 0; k < nbEteintes; k++) {
            int index = (int)(Math.random() * (TAILLE * TAILLE / 2));
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

        
        grille[chevalX][chevalY].retirerCheval();

    
        chevalX = xDest;
        chevalY = yDest;

       
        grille[chevalX][chevalY].placerCheval();

       
        grille[chevalX][chevalY].basculerLumiere();

        return true;
    }

    public Cellule[][] getGrille() {
        return grille;
    }

    public int[][] choisirTourAleatoire() {
        int index = (int)(Math.random() * tours.length);
        return tours[index];
    }

}