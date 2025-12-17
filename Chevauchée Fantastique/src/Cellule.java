/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**paint component
 *
 * @author paulh
 */
public class Cellule {
private boolean allumee;
private boolean chevalPresent;

public Cellule(){
    this.allumee=true;
    this.chevalPresent= false;
}

 public boolean entrer() {
        if (!allumee) {
            return false;
        }
        allumee = false;      
        chevalPresent = true;
        return true;
    }
  public void sortir() {
        chevalPresent = false;
    }

    public boolean estAllumee() {
        return allumee;
    }

    public boolean aCheval() {
        return chevalPresent;
    }
}
