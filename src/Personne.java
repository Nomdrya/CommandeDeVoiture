/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 * @author Raymond
 */
public class Personne {
    private String nomComplet;
    protected ArrayList<Vehicule> vehicules;
    private double budget;

    public Personne(String nomComplet, double budget) {
        this.nomComplet = nomComplet;
        this.budget = budget;
        this.vehicules = new ArrayList<Vehicule>();
    }

    public ArrayList<Vehicule> getVehicules() {
        return vehicules;
    }

    public void acheterVehicule(Vehicule vehicule) throws Exception {

        if (budget < vehicule.getPrix())
            throw new Exception(this + ", budget insuffisant, " + vehicule);

        if (vehicule.getProprietaire() == null) {
            vehicules.add(vehicule);
            budget = budget - vehicule.getPrix();
            vehicule.setProprietaire(this);
        } else
            throw new Exception(vehicule + " a un propriétaire: " + vehicule.getProprietaire().nomComplet);
    }

    public void vendreVehicule(int indice ) throws Exception {
        Vehicule vehicule = vehicules.get(indice);
        if (vehicules.contains(vehicule)) {
            vehicule.setProprietaire(null);

            vehicules.remove(vehicule);
            budget = budget + vehicule.getPrix();
        } else
        throw new Exception(this + ", pas proprietaire, " + vehicule);

    }


    @Override
    public String toString() {
        return "Personne{" +
                "nomComplet='" + nomComplet + '\'' +
                ", budget=" + budget +
                '}';
    }

    public void afficherVehicules() {
        System.out.println(nomComplet + " a les vehicules: ");
        for (int i = 0; i < vehicules.size(); i++) {
            System.out.println("- " + vehicules.get(i));
        }
    }

}

