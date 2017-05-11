/**
 * Created by raymo on 4/24/2017.
 */
public class Particulier
        extends Personne {
    public Particulier(String nomComplet, double budget) {
        super(nomComplet, budget);
    }

    @Override
    public String toString() {
        return "Particulier{" + super.toString() + "}";
    }

    @Override
    public String toShortString() {
        return "Particulier," + super.toShortString();
//        return "Particulier," + nomComplet + ","+ budget;
    }
}