import java.util.ArrayList;
import java.util.Date;

/**
 * Created by raymo on 4/24/2017.
 */
public class Garage extends Personne {

    private ArrayList<Location> locations=new ArrayList<>();

    public Garage(String nomComplet, double budget){
        super(nomComplet, budget);
    }

    class Location{
        double forfait;
        Date debut;
        Date fin;
        Vehicule vehicule;
        Client client;

        public Location(double forfait, Date debut, Date fin, Vehicule vehicule, Client client) {
            this.forfait = forfait;
            this.debut = debut;
            this.fin = fin;
            this.vehicule = vehicule;
            this.client = client;
        }
    }
    public void nouvelleLocation (double forfait,Date debut,Date fin, Vehicule vehicule, Client client){
        locations.add(new Location(forfait, debut, fin, vehicule, client));
    }
}
