package mvc.view;

import entreprise.Employe;
import mvc.controller.ControllerSpecialEmploye;
import mvc.controller.EmployeController;
import mvc.view.AbstractView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static Utilitaire.Utilitaire.*;

public class EmployeViewConsole extends AbstractView<Employe> {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(controller.getAll());
        List<String> options = Arrays.asList("ajouter", "retirer", "rechercher", "modifier", "fin");
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
                    return;
            }
        } while (true);
    }

    @Override
    public void affList(List la) {

    }


    private void retirer() {
        int nl = choixElt(la) - 1;
        Employe e = la.get(nl);
        boolean ok = controller.remove(e);
        if (ok) affMsg("employé retiré");
        else affMsg("employé non retiré");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    public void rechercher() {
        try {
            System.out.println("Nom : ");
            String nom = sc.nextLine();
            System.out.println("Matricule : ");
            String matricule = sc.nextLine();
            // Vous pouvez ajuster la création de l'objet Employe selon vos besoins
            Employe rech = new Employe(0, matricule, nom, "", "", "", null);
            Employe e = controller.search(rech);
            if (e == null) affMsg("Employé non trouvé");
            else {
                affMsg(e.toString());
                special(e);
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }

    public void modifier() {
        int choix = choixElt(la);
        Employe e = la.get(choix - 1);
        // Implémentez la logique de modification ici
        controller.update(e);
    }

    public void ajouter() {
        Employe e;
        do {
            try {
                // Saisie des informations pour créer un nouvel employé
                System.out.println("Nom : ");
                String nom = sc.nextLine();
                System.out.println("Matricule : ");
                String matricule = sc.nextLine();
                // Vous pouvez ajuster la création de l'objet Employe selon vos besoins
                e = new Employe(0, matricule, nom, "", "", "", null);
                break;
            } catch (Exception ex) {
                System.out.println("Une erreur est survenue : " + ex.getMessage());
            }
        } while (true);
        controller.add(e);
    }

    public void special(Employe e) {

    }





}
