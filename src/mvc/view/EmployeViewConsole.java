package mvc.view;

import entreprise.Employe;
import entreprise.Disciplines;
import mvc.controller.ControllerSpecialEmploye;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Utilitaire.Utilitaire.*;

public class EmployeViewConsole extends AbstractView<Employe> {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(controller.getAll());
        List<String> options = Arrays.asList(
                "Ajouter",
                "Retirer",
                "Rechercher",
                "Modifier",
                "Rechercher par nom",
                "Afficher",
                "Fin"
        );
        do {
            int ch = choixListe(options);

            switch (ch) {
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
                    rechNom();
                    break;
                case 6:
                    afficher();
                    break;
                case 7:
                    return;
            }
        } while (true);
    }

    private void rechNom() {
        System.out.println("Nom recherché :");
        String nomRecherche = sc.nextLine();
        List<Employe> le = ((ControllerSpecialEmploye)controller).filtrerEmployes(e -> e.getNom().startsWith(nomRecherche));
        if (le.isEmpty()) {
            System.out.println("Aucun résultat trouvé.");
            return;
        }
        int ch = choixListe(le);
        if (ch != 0) special(le.get(ch - 1));
    }

    private void retirer() {
        int nl = choixElt(la) - 1;
        Employe e = la.get(nl);
        boolean ok = controller.remove(e);
        affMsg(ok ? "Employé effacé." : "Employé non effacé.");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    public void rechercher() {
        try {
            System.out.println("Matricule :");
            String matricule = sc.nextLine().trim();
            Employe rech = new Employe(0, matricule, "", "", "", "", null);
            Employe e = controller.search(rech);

            if (e == null) {
                affMsg("Employé inconnu.");
            } else {
                affMsg(e.toString());
                special(e);
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void modifier() {
        int choix = choixElt(la);
        Employe e = la.get(choix - 1);
        do {
            try {
                String matricule = modifyIfNotBlank("Matricule", e.getMatricule());
                String nom = modifyIfNotBlank("Nom", e.getNom());
                String prenom = modifyIfNotBlank("Prénom", e.getPrenom());
                String tel = modifyIfNotBlank("Téléphone", e.getTel());
                String mail = modifyIfNotBlank("Mail", e.getMail());
                String specialiteNom = modifyIfNotBlank("Spécialité", e.getDisciplines() != null ? e.getDisciplines().getNom() : "");

                Disciplines specialite = new Disciplines(0, specialiteNom, ""); // Placeholder for specialite

                e.setMatricule(matricule);
                e.setNom(nom);
                e.setPrenom(prenom);
                e.setTel(tel);
                e.setMail(mail);
                e.setDisciplines(specialite);

                break;
            } catch (Exception ex) {
                System.out.println("Erreur : " + ex);
            }
        } while (true);
        controller.update(e);
    }

    public void ajouter() {
        Employe e;
        do {
            try {
                System.out.println("Matricule :");
                String matricule = sc.nextLine();
                System.out.println("Nom :");
                String nom = sc.nextLine();
                System.out.println("Prénom :");
                String prenom = sc.nextLine();
                System.out.println("Téléphone :");
                String tel = sc.nextLine();
                System.out.println("Mail :");
                String mail = sc.nextLine();
                System.out.println("Spécialité (Nom) :");
                String specialiteNom = sc.nextLine();

                Disciplines specialite = new Disciplines(0, specialiteNom, "");

                e = new Employe(0, matricule, nom, prenom, tel, mail, specialite);
                break;
            } catch (Exception ex) {
                System.out.println("Une erreur est survenue : " + ex.getMessage());
            }
        } while (true);
        controller.add(e);
    }

    public void special(Employe e) {
        List<String> options = Arrays.asList("Lister travaux", "Fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    listerTravaux(e);
                    break;
                case 2:
                    return;
            }
        } while (true);
    }

    public void listerTravaux(Employe e) {
        affList(new ArrayList<>(((ControllerSpecialEmploye)controller).listerTravaux(e)));
    }

    private void afficher() {
        int choix = choixElt(la);
        if (choix > 0 && choix <= la.size()) {
            Employe e = la.get(choix - 1);
            affMsg(e.toString());
        } else {
            affMsg("Choix invalide.");
        }
    }


    public void affList(List la) {
        if (la.isEmpty()) {
            System.out.println("Aucun employé à afficher.");
            return;
        }
        for (int i = 0; i < la.size(); i++) {
            System.out.println((i + 1) + ". " + la.get(i).toString());
        }
    }

}
