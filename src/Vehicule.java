/**
 *
 * @author Raymond
 */
public class Vehicule {
    private String fabricant;
    private int chevaux,km,annee;
    private double prix;
    private Personne proprietaire;
    private boolean neuf;

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Vehicule(String fabricant, int chevaux, int annee, int km, double prix, boolean neuf){
        this.fabricant=fabricant;
        this.chevaux=chevaux;
        this.annee=annee;
        this.km=km;
        this.prix=prix;
        this.neuf=neuf;

    }
    public double getPrix(){
        return prix;
    }

    public void setPrix(double nouveauPrix){
        this.prix=nouveauPrix;
    }

    @Override
    public String toString() {
        return
                "fabricant='" + fabricant + "'" +
                ", chevaux=" + chevaux +
                ", km=" + km +
                ", annee=" + annee +
                ", prix=" + prix +
                ", neuf=" + neuf;
    }
}

