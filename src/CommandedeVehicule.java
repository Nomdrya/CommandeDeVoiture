
import java.io.IOException;
import java.util.*;
/**
 * @author Raymond
 */
public class CommandedeVehicule {

    private ArrayList<Personne> clients = new ArrayList<>();
    private ArrayList<Particulier> particuliers = new ArrayList<>();
    private ArrayList<Garage> garages = new ArrayList<>();

    private ArrayList<Vehicule> vehicules = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private boolean continuer = true;


    public void setClients(ArrayList<Personne> clients) {
        this.clients = clients;
        for(Personne p: clients) {
            if(p instanceof Garage) {
                garages.add((Garage) p);
            } else {
                particuliers.add((Particulier) p);
            }
        }
    }

    public static void main(String[] args) {
        CommandedeVehicule commande = new CommandedeVehicule();
        commande.setVehicules(GestionnaireFichiers.lireVehicules());
        commande.setClients(GestionnaireFichiers.lireClients());
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
        System.out.println("5: acheter vehicule");
        System.out.println("6: vendre vehicule");
        System.out.println("7: louer vehicule");

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
                try {
                    creerClient();
                } catch (Exception e) {
                    System.out.println("interruption");
                }
                break;

            case 2:
                afficherClients();
                break;
            case 3:
                creerVehicule();
                break;
            case 4:
                afficherVehicule(this.vehicules);
                break;
            case 5:
                try {
                    afficherClients();
                    int numClients = scanner.nextInt();
                    afficherVehicule(this.vehicules);
                    int numVehicule = scanner.nextInt();
                    clients.get(numClients).acheterVehicule(vehicules.get(numVehicule));
                } catch (Exception e) {
                    System.out.println("Erreur, l'achat n'a pas pu être effectué");
                }
                break;
            case 6:
                try {
                    afficherClients();
                    int numClients = scanner.nextInt();
                    afficherVehicule(clients.get(numClients).getVehicules());
                    int numVehicule = scanner.nextInt();
                    clients.get(numClients).vendreVehicule(numVehicule);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            case 7:
                try {
                    afficherGarages();
                    int numGarage = scanner.nextInt();

                    afficherVehicule(garages.get(numGarage).getVehicules());
                    int numVehicule = scanner.nextInt();

                    afficherParticuliers();
                    int numParticuliers = scanner.nextInt();

                    // annee debut, mois debut, jour debut
                    System.out.println("entrez annee, mois, jour du debut de la location");

                    int annee = scanner.nextInt();
                    int mois = scanner.nextInt();
                    int jour = scanner.nextInt();
                    GregorianCalendar debut = new GregorianCalendar(annee, mois, jour);

                    // annee fin, mois fin, jour de fin
                    System.out.println("entrez annee, mois, jour de fin de la location");
                    annee = scanner.nextInt();
                    mois = scanner.nextInt();
                    jour = scanner.nextInt();
                    GregorianCalendar fin = new GregorianCalendar(annee, mois, jour);
                    double forfait;
                    System.out.println("Entrez forfait");
                    forfait = scanner.nextDouble();
                    garages.get(numGarage).nouvelleLocation(forfait, debut, fin, vehicules.get(numVehicule), particuliers.get(numParticuliers));

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
    }


    public void creerClient() throws Exception {
        System.out.println("entrez le nom");
        String nom = scanner.nextLine();
        System.out.println("budget");
        double budget = scanner.nextDouble();
        System.out.println("Garage (1) ou Particulier (2)");
        int choix = scanner.nextInt();
        if (choix == 1) {
            garages.add(new Garage(nom, budget));
            clients.add(garages.get(garages.size() - 1));
        } else if (choix == 2) {
            // Creer Client
            particuliers.add(new Particulier(nom, budget));
            clients.add(particuliers.get(particuliers.size() - 1));

        } else {
            throw new Exception("choix invalide");
        }
        GestionnaireFichiers.ecrireClients(clients);
    }

    public void afficherClients() {
        for (int i = 0; i < clients.size(); i++)
            System.out.println(i + ": " + clients.get(i));
    }

    public void afficherGarages() {
        for (int i = 0; i < garages.size(); i++)
            System.out.println(i + ": " + garages.get(i));
    }

    public void afficherParticuliers() {
        for (int i = 0; i < particuliers.size(); i++)
            System.out.println(i + ": " + particuliers.get(i));
    }

    private void creerVehicule() {
        int choix = 0;
        boolean mauvaischoix = true;
        while (mauvaischoix) {


            System.out.println("entrez type de vehicule");
            System.out.println("0: moto");
            System.out.println("1: voiture");
            System.out.println("2: camion");
            choix = lireChoix();
            if (choix > 2 || choix < 0)
                System.out.println("corrigez le choix");
            else
                mauvaischoix = false;

        }
        creerVehicule(choix);
        try {
            GestionnaireFichiers.ecrireVehicules(vehicules);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                vehicules.add(new Voiture(nombredeportes, nombredeplaces, fabricant, chevaux, annee, km, prix, neuf));
                break;
            case 2:
                System.out.println("tonnes");
                int tonnes = scanner.nextInt();
                Vehicule v = new Camion(tonnes, fabricant, chevaux, annee, km, prix, neuf);
                System.out.println(v);
                vehicules.add(v);
                break;
        }
    }

    public void afficherVehicule(ArrayList<Vehicule> vehicules) {
        for (int i = 0; i < vehicules.size(); i++) {
            System.out.println(i + ": " + vehicules.get(i));
        }
    }

    public void setVehicules(ArrayList<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }
}


