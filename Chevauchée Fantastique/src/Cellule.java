public class Cellule {

    private boolean allumee;
    private boolean chevalPresent;

    public Cellule() {
        allumee = false;
        chevalPresent = false;
    }

    public void allumer() {
        allumee = true;
    }

    public void eteindre() {
        allumee = false;
    }

    public void basculerLumiere() {
        allumee = !allumee;
    }

    public boolean estAllumee() {
        return allumee;
    }

    public void placerCheval() {
        chevalPresent = true;
    }

    public void retirerCheval() {
        chevalPresent = false;
    }

    public boolean aCheval() {
        return chevalPresent;
    }

}
