import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by raymo on 4/22/2017.
 */
public class GestionnaireFichiers {
//    public static ArrayList<Vehicule> lireVehicules() {
//        ArrayList<Vehicule> vehicules = null;
//        try {
//
//            BufferedReader br = new BufferedReader(new FileReader("src/vehicules.txt"));
//            vehicules = new ArrayList<>();
//            String[] tab;
//            String line;
//            while ((line = br.readLine()) != null) {
//                tab = line.split(",");
//                switch (tab[0]) {
//                    case "Moto":
//                        vehicules.add(new Moto(
//                                Integer.parseInt(tab[1]),
//                                tab[2],
//                                Integer.parseInt(tab[3]),
//                                Integer.parseInt(tab[4]),
//                                Integer.parseInt(tab[5]),
//                                Double.parseDouble(tab[6]),
//                                Boolean.parseBoolean(tab[7])
//
//                        ));
//                        break;
//                    case "Camion":
//                        vehicules.add(new Camion(
//                                        Integer.parseInt(tab[1]),
//                                        tab[2],
//                                        Integer.parseInt(tab[3]),
//                                        Integer.parseInt(tab[4]),
//                                        Integer.parseInt(tab[5]),
//                                        Double.parseDouble(tab[6]),
//                                        Boolean.parseBoolean(tab[7])
//
//                                )
//                        );
//                        break;
//                    case "Voiture":
//                        vehicules.add(new Voiture(
//                                Integer.parseInt(tab[1]),
//                                Integer.parseInt(tab[2]),
//                                (tab[3]),
//                                Integer.parseInt(tab[4]),
//                                Integer.parseInt(tab[5]),
//                                Integer.parseInt(tab[6]),
//                                Double.parseDouble(tab[7]),
//                                Boolean.parseBoolean(tab[8])
//                        ));
//                }
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return vehicules;
//    }
//
//    public static void ecrireVehicules(ArrayList<Vehicule> listedevehicules) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter("src/vehicules.txt"));
//        for (Vehicule v : listedevehicules) {
//            bw.write(v.toString2() + '\n');
//            bw.flush();
//        }
//        bw.close();
//    }
//
//    public static void ecrireClients(ArrayList<Personne> listedeclients) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter("src/clients.txt"));
//        for (Personne p : listedeclients) {
//            bw.write(p.toShortString() + '\n');
//            bw.flush();
//        }
//        bw.close();
//
//    }
//    public static ArrayList<Personne> lireClients() {
//        ArrayList<Personne> clients = null;
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("src/clients.txt"));
//            clients = new ArrayList<>();
//            String[] tab;
//            String line;
//            while ((line = br.readLine()) != null) {
//                tab = line.split(",");
//                String nom = tab[1];
//                double budget=Double.parseDouble(tab[2]);
//                if (tab[0].equals("Garage")){
//                    clients.add(new Garage(nom,budget));
//                } else {
//                    clients.add(new Particulier(nom, budget));
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return clients;
//    }

    public static void ecrireCommandeJson(CommandeDeVoiturePersistant commande) {
        Gson gson = new Gson();
        try {
            FileWriter fw = new FileWriter("commande.json");
            gson.toJson(commande, fw);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static CommandeDeVoiturePersistant lireCommandeJson ()
    {
        try {
            Gson gson = new Gson();
            FileReader fr = new FileReader("commande.json");
            return gson.fromJson(fr, CommandeDeVoiturePersistant.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

