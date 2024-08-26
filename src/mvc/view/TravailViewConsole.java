package mvc.view;

import entreprise.Employe;
import entreprise.Travail;
import mvc.controller.ControllerSpecialTravail;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Utilitaire.Utilitaire.*;

public class TravailViewConsole extends AbstractView<Travail> {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(controller.getAll());
        List<String> options = Arrays.asList("Ajouter", "Retirer", "Rechercher", "Modifier", "Rechercher par employé", "Fin");
        while (true) {
            int choice = choixListe(options);

            switch (choice) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    rechEmploye();
                    break;
                case 6:
                    return;
            }
        }
    }

    private void rechEmploye() {
        System.out.print("Nom de l'employé : ");
        String nom = sc.nextLine();
        List<Travail> travaux = ((ControllerSpecialTravail) controller).filtrerTravaux(t -> t.getEmployes().getNom().startsWith(nom));
        if (travaux.isEmpty()) {
            System.out.println("Aucun résultat trouvé.");
            return;
        }
        int choice = choixListe(travaux);
        if (choice != 0) special(travaux.get(choice - 1));
    }

    private void retirer() {
        int choice = choixElt(la) - 1;
        Travail travail = la.get(choice);
        boolean ok = controller.remove(travail);
        affMsg(ok ? "Travail effacé." : "Erreur lors de l'effacement du travail.");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    private void rechercher() {
        System.out.print("Nom de l'employé : ");
        String nomEmploye = sc.nextLine();
        Employe employe = new Employe(0, "", nomEmploye, "", "", "", null);
        Travail recherche = new Travail(0, null, employe);
        Travail travail = controller.search(recherche);
        if (travail == null) {
            affMsg("Travail inconnu.");
        } else {
            affMsg(travail.toString());
            special(travail);
        }
    }

    private void modifier() {
        int choice = choixElt(la) - 1;
        Travail travail = la.get(choice);
        while (true) {
            try {
                String empNom = modifyIfNotBlank("Nom de l'employé", travail.getEmployes().getNom());

                if (!empNom.isEmpty()) {
                    Employe employe = new Employe(travail.getEmployes().getIdEmploye(), travail.getEmployes().getMatricule(), empNom, travail.getEmployes().getPrenom(), travail.getEmployes().getTel(), travail.getEmployes().getMail(), travail.getEmployes().getDisciplines());
                    travail.setEmployes(employe);
                }

                controller.update(travail);
                affMsg("Travail modifié !");
                break;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }

    private void ajouter() {
        while (true) {
            try {
                System.out.print("Nom de l'employé : ");
                String empNom = sc.nextLine();
                System.out.print("Prénom de l'employé : ");
                String empPrenom = sc.nextLine();
                System.out.print("Téléphone de l'employé : ");
                String empTel = sc.nextLine();
                System.out.print("Email de l'employé : ");
                String empMail = sc.nextLine();

                Employe employe = new Employe(0, "", empNom, empPrenom, empTel, empMail, null);  // Simplification de l'ajout
                Travail travail = new Travail(0, null, employe);

                controller.add(travail);
                affMsg("Travail ajouté !");
                break;
            } catch (Exception e) {
                System.out.println("Une erreur est survenue : " + e.getMessage());
            }
        }
    }

    private void special(Travail travail) {
        List<String> options = Arrays.asList("Afficher les détails de l'employé", "Fin");
        while (true) {
            int choice = choixListe(options);

            switch (choice) {
                case 1:
                    affMsg("Employé : " + travail.getEmployes().toString());
                    break;
                case 2:
                    return;
            }
        }
    }

    @Override
    public void affList(List la) {
        affListe(la);

    }
}
