package entreprise;

import java.text.DecimalFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Création d'une instance de projet
        Projet projet = new Projet(
                1,
                "Projet1",
                new Date(),
                new Date(),
                new DecimalFormat("#0.00")
        );

        // Création de disciplines
        Disciplines discipline1 = new Disciplines(1, "Discipline1", "Description1");
        Disciplines discipline2 = new Disciplines(2, "Discipline2", "Description2");

        // Ajout de disciplines au projet
        projet.addDisciplines(discipline1, 100);
        projet.addDisciplines(discipline2, 200);

        // Affichage des disciplines et investissements
        projet.ListeDisciplinesEtInvestissement();

        // Modification de la quantité d'une discipline
        projet.modifDisciplines(discipline1,200);
        // Affichage des disciplines et investissements après modification
        System.out.println("MODIF : ");
        projet.ListeDisciplinesEtInvestissement();

        // Suppression d'une discipline du projet
        projet.suppDisciplines(discipline2);
        System.out.println("suppression : ");
        // Affichage des disciplines et investissements après suppression
        projet.ListeDisciplinesEtInvestissement();

        System.out.println("Liste des spécialités : " + projet.listeSpecialite());
    }
}
