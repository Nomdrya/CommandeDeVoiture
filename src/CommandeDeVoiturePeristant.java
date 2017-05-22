import java.util.ArrayList;

/**
 * Created by henrik on 5/22/17.
 */
public class CommandeDeVoiturePeristant {
    ArrayList<Voiture> voitures = new ArrayList<>();
    ArrayList<Camion> camions = new ArrayList<>();
    ArrayList<Moto> motos = new ArrayList<>();
    ArrayList<Particulier> particuliers;
    ArrayList<Garage> garages;

    public CommandeDeVoiturePeristant(ArrayList<Particulier> particuliers, ArrayList<Garage> garages, ArrayList<Vehicule> vehicules) {
        this.particuliers = particuliers;
        this.garages = garages;
        for (Vehicule v : vehicules) {
            if (v instanceof Moto) {
                motos.add((Moto) v);
            } else if (v instanceof Voiture) {
                voitures.add((Voiture) v);
            } else if (v instanceof Camion) {
                camions.add((Camion) v);
            }
        }
    }

    @Override
    public String toString() {
        return "CommandeDeVoiturePeristant{" +
                "voitures=" + voitures +
                ", camions=" + camions +
                ", motos=" + motos +
                ", particuliers=" + particuliers +
                ", garages=" + garages +
                '}';
    }
}
