/*
 * A faire pour jeudi:
 * - Creer classes Camion, Voiture
 * - Gerer les cas dans creerVehicule(type)
 * - Creer toString pour Camion et Voiture
 */

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Raymond
 */
public class CommandedeVehicule {

    private ArrayList<Personne> clients = new ArrayList<>();

    private ArrayList<Vehicule> vehicules = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);
    private boolean continuer = true;


    public static void main(String[] args) {
//        Vehicule berline = new Vehicule("VW", 250, 2016, 5000, 43000);
//        Vehicule coupe = new Vehicule("BMW", 350, 2015, 35000, 58000);
//        Vehicule van = new Vehicule("Fiat", 180, 2013);
//        van.setPrix(19000);
//
//
//        Personne monsieurX = new Personne("MrX", 80000);
//        Personne madameY = new Personne("MsY", 7000000);
//
//
//
//
//        try {
//            monsieurX.acheterVoiture(berline);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            madameY.acheterVoiture(van);
//            madameY.acheterVoiture(coupe);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        madameY.afficherVoitures();
//        System.out.println();
//        monsieurX.afficherVoitures();

        CommandedeVehicule commande = new CommandedeVehicule();

        while (commande.continuer) {
            commande.afficherMenu();
            int choix = commande.lireChoix();
            commande.gererChoix(choix);


        }
    }

    public void afficherMenu() {
        System.out.println("0: quitter le programme");
        System.out.println("1: creer un client");
        System.out.println("2: afficher les clients");
        System.out.println("3: créer vehicule");
        System.out.println("4: afficher vehicule");
    }

    public int lireChoix() {
        int choix = scanner.nextInt();
        scanner.nextLine();
        return choix;
    }

    public void gererChoix(int choix) {
        switch (choix) {
            case 0:
                continuer = false;
                break;
            case 1:
                creerClient();
                break;

            case 2:
                afficherClients();
                break;
            case 3:
                creerVehicule();
                break;
            case 4:
                afficherVehicule();
                break;
            case 5:
                try{
                    // appel à acheterVehicule
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
    }


    public void creerClient() {
        System.out.println("entrez le nom");
        String nom = scanner.nextLine();
        System.out.println("budget");
        double budget = scanner.nextDouble();
        clients.add(new Personne(nom, budget));
    }

    public void afficherClients() {
        System.out.println(clients);
    }


    private void creerVehicule() {
        int choix=0;
        boolean mauvaischoix=true;
        while(mauvaischoix) {


            System.out.println("entrez type de vehicule");
            System.out.println("0: moto");
            System.out.println("1: voiture");
            System.out.println("2: camion");
            choix = lireChoix();
            if (choix > 2 || choix < 0)
                System.out.println("corrigez le choix");
            else
                mauvaischoix=false;

        }
        creerVehicule(choix);
        // creerVehicule(lireChoix());

    }

    public void creerVehicule(int type) {

        System.out.println("entrez le fabricant");
        String fabricant = scanner.nextLine();

        System.out.println("chevaux");
        int chevaux = scanner.nextInt();

        System.out.println("année");
        int annee = scanner.nextInt();

        System.out.println("km");
        int km = scanner.nextInt();

        System.out.println("prix");
        double prix = scanner.nextDouble();

        System.out.println("neuf");
        boolean neuf = scanner.nextBoolean();

        switch (type) {
            case 0:
                System.out.println("cylindree");
                int cylindree = scanner.nextInt();

                vehicules.add(new Moto(cylindree, fabricant, chevaux, annee, km, prix, neuf));
                break;

            case 1:
                System.out.println("nombre de portes");
                int nombredeportes = scanner.nextInt();
                System.out.println("nombre de places");
                int nombredeplaces = scanner.nextInt();
                vehicules.add(new Voiture (nombredeportes,nombredeplaces,fabricant, chevaux, annee, km, prix, neuf));
                break;

        }

    }

    public void afficherVehicule() {
        for (int i=0;i<vehicules.size();i++){
            System.out.println(i+":" +vehicules.e);
        }
    }

    public void acheterVehicule(Personne client, Vehicule vehicule) throws Exception {
        client.acheterVehicule(vehicule);
    }
}


