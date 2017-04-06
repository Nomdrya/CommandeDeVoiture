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
    private ArrayList<Voiture> voitures;
    private double budget;

    public Personne(String nomComplet, double budget) {
        this.nomComplet = nomComplet;
        this.budget = budget;
        this.voitures = new ArrayList<Voiture>();
    }

    public void acheterVoiture(Voiture voiture) throws Exception {

        if (budget < voiture.getPrix())
            throw new Exception(this + ", budget insuffisant, " + voiture);

        if (voiture.getProprietaire() == null) {
            voitures.add(voiture);
            budget = budget - voiture.getPrix();
            voiture.setProprietaire(this);
        } else
            throw new Exception(voiture + " a un propriétaire: " + voiture.getProprietaire().nomComplet);
    }

    public void vendreVoiture(Voiture voiture) throws Exception {
        if (voitures.contains(voiture)) {
            voiture.setProprietaire(null);

            voitures.remove(voiture);
            budget = budget + voiture.getPrix();
        } else
        throw new Exception(this + ", pas proprietaire, " + voiture);

    }


    @Override
    public String toString() {
        return "Personne{" +
                "nomComplet='" + nomComplet + '\'' +
                ", budget=" + budget +
                '}';
    }

    public void afficherVoitures() {
        System.out.println(nomComplet + " a les voitures: ");
        for (int i = 0; i < voitures.size(); i++) {
            System.out.println("- " + voitures.get(i));
        }
    }

}

