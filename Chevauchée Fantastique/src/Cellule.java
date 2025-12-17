public class Cellule {

    private boolean allumee;
    private boolean chevalPresent;

    public Cellule() {
        this.allumee = false;
        this.chevalPresent = false;
    }
    
    public boolean estAllumee() {
        return allumee;
    }

    public boolean aCheval() {
        return chevalPresent;
    }

    public void allumer() {
        allumee=true;
    }    

    public void eteindre() {
        allumee = false;
    }

    
    public void placerCheval() {
        chevalPresent = true;
    }

    public void enleverCheval() {
        chevalPresent = false;
    }
}
