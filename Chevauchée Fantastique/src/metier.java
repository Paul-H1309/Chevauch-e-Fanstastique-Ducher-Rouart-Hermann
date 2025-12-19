
import java.util.ArrayList;

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
    boolean[][] visite = new boolean[TAILLE][TAILLE];
    int[][] parcours = new int[TAILLE * TAILLE][2];

    int xFin = (int)(Math.random() * TAILLE);
    int yFin = (int)(Math.random() * TAILLE);

    parcours[0][0] = xFin;
    parcours[0][1] = yFin;
    visite[xFin][yFin] = true;

    for (int i = 1; i < TAILLE * TAILLE; i++) {
        int[] voisins = getVoisinsNonVisites(parcours[i-1][0], parcours[i-1][1], visite);
        if (voisins == null) {
            i = 0;
            visite = new boolean[TAILLE][TAILLE];
            parcours[0][0] = xFin;
            parcours[0][1] = yFin;
            visite[xFin][yFin] = true;
        } else {
            parcours[i][0] = voisins[0];
            parcours[i][1] = voisins[1];
            visite[voisins[0]][voisins[1]] = true;
        }
    }


    for (int i = 0; i < TAILLE; i++) {
        for (int j = 0; j < TAILLE; j++) {
            grille[i][j].allumer();
        }
    }
    chevalX = parcours[TAILLE*TAILLE - 1][0];
    chevalY = parcours[TAILLE*TAILLE - 1][1];
    grille[chevalX][chevalY].placerCheval();
}

private int[] getVoisinsNonVisites(int x, int y, boolean[][] visite) {
    int[][] moves = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
    ArrayList<int[]> candidats = new ArrayList<>();
    for (int[] m : moves) {
        int nx = x + m[0];
        int ny = y + m[1];
        if (nx >= 0 && nx < TAILLE && ny >= 0 && ny < TAILLE && !visite[nx][ny]) {
            candidats.add(new int[]{nx, ny});
        }
    }
    if (candidats.isEmpty()) return null;
    return candidats.get((int)(Math.random() * candidats.size()));
}

    public Cellule[][] getGrille() {
        return grille;
    }
}
