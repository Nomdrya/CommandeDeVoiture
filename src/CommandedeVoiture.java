/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Raymond
 */
public class CommandedeVoiture {

    private ArrayList<Personne> clients = new ArrayList<>();

    private ArrayList<Voiture> voitures = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
//        Voiture berline = new Voiture("VW", 250, 2016, 5000, 43000);
//        Voiture coupe = new Voiture("BMW", 350, 2015, 35000, 58000);
//        Voiture van = new Voiture("Fiat", 180, 2013);
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

        CommandedeVoiture commande = new CommandedeVoiture();

        while(true) {
            commande.afficherMenu();
            int choix = commande.lireChoix();
            commande.gererChoix(choix);
        }
    }

    public void afficherMenu() {
        System.out.println("0: quitter le programme");
        System.out.println("1: creer un client");
        System.out.println("2: afficher les clients");
    }

    public int lireChoix() {
        int choix = scanner.nextInt();
        scanner.nextLine();
        return choix;

    }

    public void gererChoix(int choix) {
        switch (choix) {
            case 0:
                break;
            case 1:
                creerClient();
                break;

            case 2:
                afficherClients();
                break;
        }



    }

    public void creerClient(){
        System.out.println("entrez le nom");
        String nom = scanner.nextLine();
        System.out.println("budget");
        double budget = scanner.nextDouble();
        clients.add(new Personne(nom, budget));
    }

    public void afficherClients(){
        System.out.println(clients);
    }






}