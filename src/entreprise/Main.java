package entreprise;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
      // Création des disciplines
        Disciplines discipline1 = new Disciplines(1, "Discipline1", "Description1");
        Disciplines discipline2 = new Disciplines(2, "Discipline2", "Description2");

        // Création des employés avec leurs spécialités
        Employe employe1 = new Employe(1, "123456", "John", "Doe", "123456789", "john@example.com", discipline1);
        Employe employe2 = new Employe(2, "654321", "Jane", "Doe", "987654321", "jane@example.com", discipline2);
        Employe employe3 = new Employe(3, "987654", "Alice", "Smith", "456123789", "alice@example.com", discipline1);

        // Création d'une liste de travaux avec les employés
        Travail travail1 = new Travail(50, LocalDate.now(), employe1);
        Travail travail2 = new Travail(30, LocalDate.now(), employe2);
        Travail travail3 = new Travail(20, LocalDate.now(), employe3);

        // Création d'un projet
        Projet projet = new Projet(1, "Projet1", LocalDate.now(), LocalDate.now().plusMonths(1), 1.00);

        // Ajout des travaux au projet
        projet.getTravails().add(travail1);
        projet.getTravails().add(travail2);
        projet.getTravails().add(travail3);

        // Affichage des spécialités des employés travaillant sur le projet
        Set<Disciplines> specialites = projet.listeSpecialitesEmployes();
        System.out.println("Liste des spécialités des employés travaillant sur le projet :");
        for (Disciplines specialite : specialites) {
            System.out.println(specialite);
        }

        // Ajout de disciplines au projet
        projet.addDisciplines(discipline1, 100);
        projet.addDisciplines(discipline2, 200);

        // Affichage des disciplines et investissements
        System.out.println("Liste des disciplines et investissements :");
        projet.ListeDisciplinesEtInvestissement();

        // Modification de la quantité d'une discipline
        projet.modifDisciplines(discipline1, 200);
        // Affichage des disciplines et investissements après modification
        System.out.println("Liste des disciplines et investissements après modification :");
        projet.ListeDisciplinesEtInvestissement();

        // Suppression d'une discipline du projet
        projet.suppDisciplines(discipline2);
        // Affichage des disciplines et investissements après suppression
        System.out.println("Liste des disciplines et investissements après suppression :");
        projet.ListeDisciplinesEtInvestissement();

        // Affichage de l'investissement total
        System.out.println("Investissement total : " + projet.InvestissementTotal());

        // Ajout d'un employé dans un projet
        projet.addEmploye(employe1, 50, LocalDate.now());
        projet.addEmploye(employe2, 30, LocalDate.now());
        projet.addEmploye(employe3, 20, LocalDate.now());

        // Affichage de la liste des employés avec leur pourcentage et leur date d'engagement
        System.out.println("Liste des employés avec leur pourcentage et leur date d'engagement :");
        projet.ListeEmployeEtPourcentageEtDate();

        // Suppression d'un employé dans un projet
        projet.suppEmploye(employe2);
        // Affichage de la liste des employés après suppression
        System.out.println("Liste des employés après suppression :");
        projet.ListeEmployeEtPourcentageEtDate();

        // Modification d'un employé dans un projet
        projet.modifEmploye(employe1, 70);
        // Affichage de la liste des employés après modification
        System.out.println("Liste des employés après modification :");
        projet.ListeEmployeEtPourcentageEtDate();

        // Calcul du pourcentage total
        System.out.println("Pourcentage total : " + projet.totalPourcentage());
    }
}
