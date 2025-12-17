/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rouart Antoine
 */
public class metier {
Cellule[][] grille;
   public metier() {
    grille = new Cellule[5][5];
    for (int i = 0; i < 10; i++) {
        for (int j=0 ; j<10 ; j++){
            grille[i][j]=new Cellule();  
        }
    }
    initalisation();
   }

private void initalisation(){
    grille[2][2].allumer();  
}

}