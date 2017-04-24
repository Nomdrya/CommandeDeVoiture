/**
 * Created by raymo on 4/18/2017.
 */
public class Camion extends Vehicule {

    private int tonnes;



    public Camion (int tonnes,
                   String fabricant, int chevaux, int annee, int km, double prix, boolean neuf){
        super(fabricant,chevaux,annee,km,prix,neuf);
        this.tonnes = tonnes;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "tonnes =" + tonnes + ", " +
                super.toString() +
                '}';
    }
    @Override
    public String toString2() {
        return "Camion," + tonnes + "," +
                super.toString2();}
}

