/**
 * Created by Raymond on 10.04.17.
 */
public class Moto extends Vehicule {

    private int cylindree;



    public Moto(int cylindree,String fabricant, int chevaux, int annee, int km, double prix, boolean neuf){
        super(fabricant,chevaux,annee,km,prix,neuf);
        this.cylindree=cylindree;

    }

    @Override
    public String toString() {
        return "Moto{" +
                "cylindree=" + cylindree + ", " +
                super.toString() +
                '}';
    }
}
