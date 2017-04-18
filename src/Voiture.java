/**
 * Created by raymo on 4/13/2017.
 */
public class Voiture extends Vehicule {
    private int nombredeportes;
    private int nombredeplaces;

    public Voiture(int nombredeportes, int nombredeplaces,
                   String fabricant, int chevaux,
                   int annee, int km, double prix, boolean neuf) {

        super(fabricant, chevaux, annee, km, prix, neuf);
        this.nombredeportes = nombredeportes;
        this.nombredeplaces = nombredeplaces;
    }
    @Override
    public String toString() {
        return "Voiture{" +
                "nombre de portes=" +nombredeportes + ", " +
                "nombre de places=" +nombredeplaces + ", " +

                super.toString() +
                '}';
    }

}
