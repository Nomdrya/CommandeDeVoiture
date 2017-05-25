import java.util.ArrayList;

/**
 * Created by henrik on 5/22/17.
 */
public class CommandeDeVoiturePersistant {
    ArrayList<Voiture> voitures = new ArrayList<>();
    ArrayList<Camion> camions = new ArrayList<>();
    ArrayList<Moto> motos = new ArrayList<>();
    ArrayList<Particulier> particuliers;
    ArrayList<Garage> garages;

    public CommandeDeVoiturePersistant(ArrayList<Particulier> particuliers, ArrayList<Garage> garages, ArrayList<Vehicule> vehicules) {
        this.particuliers = particuliers;
        this.garages = garages;
        for(Vehicule v: vehicules) {
            if(v instanceof Moto) {
                motos.add((Moto) v);
            } else if (v instanceof Voiture) {
                voitures.add((Voiture) v);
            } else if (v instanceof Camion) {
                camions.add((Camion) v);
            }
        }
    }
}
