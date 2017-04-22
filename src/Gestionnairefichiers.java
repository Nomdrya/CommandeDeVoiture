import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by raymo on 4/22/2017.
 */
public class Gestionnairefichiers {
    public static ArrayList<Vehicule> lirevehicule() {


        ArrayList<Vehicule> vehicules = null;
        try {

            BufferedReader br = new BufferedReader(new FileReader("src/vehicules.txt"));
            vehicules = new ArrayList<>();
            String[] tab;
            String line;
            while ((line = br.readLine()) != null) {
                tab = line.split(",");
                switch (tab[0]) {
                    case "Moto":
                        vehicules.add(new Moto(
                                Integer.parseInt(tab[1]),
                                tab[2],
                                Integer.parseInt(tab[3]),
                                Integer.parseInt(tab[4]),
                                Integer.parseInt(tab[5]),
                                Double.parseDouble(tab[6]),
                                Boolean.parseBoolean(tab[7])

                        ));
                        break;
                    case "Camion":
                        vehicules.add(new Camion(
                                        Integer.parseInt(tab[1]),
                                        tab[2],
                                        Integer.parseInt(tab[3]),
                                        Integer.parseInt(tab[4]),
                                        Integer.parseInt(tab[5]),
                                        Double.parseDouble(tab[6]),
                                        Boolean.parseBoolean(tab[7])

                                )
                        );
                        break;
                    case "Voiture":
                        vehicules.add(new Voiture(
                                Integer.parseInt(tab[1]),
                                Integer.parseInt(tab[2]),
                                (tab[3]),
                                Integer.parseInt(tab[4]),
                                Integer.parseInt(tab[5]),
                                Integer.parseInt(tab[6]),
                                Double.parseDouble(tab[7]),
                                Boolean.parseBoolean(tab[8])
                        ));
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicules;
    }

    public static void ecrirevehicule(ArrayList<Vehicule> listedevehicules){
        BufferedWriter bw= new BufferedWriter(new FileWriter("src/vehicules.txt"));

    }
}
