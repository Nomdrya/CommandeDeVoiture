/**
 *
 * @author Raymond
 */
public class Voiture {
    private String fabricant;
    private int chevaux,km,annee;
    private double prix;
    private Personne proprietaire;

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Voiture (String fabricant,int chevaux, int annee){
        this.fabricant=fabricant;
        this.chevaux=chevaux;
        this.annee=annee;

    }
    public Voiture (String fabricant,int chevaux, int annee,int km,double prix){
        this.fabricant=fabricant;
        this.chevaux=chevaux;
        this.annee=annee;
        this.km=km;
        this.prix=prix;

    }
    public double getPrix(){
        return prix;
    }

    public void setPrix(double nouveauPrix){
        this.prix=nouveauPrix;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "fabricant='" + fabricant + "'" +
                ", chevaux=" + chevaux +
                ", km=" + km +
                ", annee=" + annee +
                ", prix=" + prix +
                '}';
    }
}

