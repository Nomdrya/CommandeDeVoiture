import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by raymo on 4/24/2017.
 */
public class Garage extends Personne {

    private ArrayList<Location> locations = new ArrayList<>();

    public Garage(String nomComplet, double budget) {
        super(nomComplet, budget);
    }

    class Location {
        double forfait;
        GregorianCalendar debut;
        GregorianCalendar fin;
        Vehicule vehicule;
        Particulier client;

        public Location(double forfait, GregorianCalendar debut, GregorianCalendar fin, Vehicule vehicule, Particulier client) {
            this.forfait = forfait;
            this.debut = debut;
            this.fin = fin;
            this.vehicule = vehicule;
            this.client = client;
        }
    }

    public void nouvelleLocation(double forfait, GregorianCalendar debut, GregorianCalendar fin, Vehicule vehicule, Particulier client) throws Exception {
        if (vehicules.contains(vehicule)) {
            for (Location l : locations) {
                if (l.vehicule == vehicule) {
                    if (!(debut.after(l.fin) || fin.before(debut))) {
                        throw new Exception("pas disponible");
                    }
                }
            }
            locations.add(new Location(forfait, debut, fin, vehicule, client));
        } else throw new Exception("ce vehicule n'appartient pas au garage");
    }
}
