package mvc.view;

import mvc.controller.DisciplinesController;

import mvc.controller.Controller;
import entreprise.Disciplines;
import mvc.controller.ControllerSpecialDisciplines;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static Utilitaire.Utilitaire.*;



public class DisciplineViewConsole extends AbstractView<Disciplines> {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(controller.getAll());
        List options = Arrays.asList("ajouter", "retirer", "rechercher", "modifier", "fin");
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



    private void retirer() {
        int nl = choixElt(la) - 1;
        Disciplines d = la.get(nl);
        boolean ok = controller.remove(d);
        if (ok) affMsg("Discipline effacée");
        else affMsg("Discipline non effacée");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    public void rechercher() {
        try {
            System.out.println("nom : ");
            String nom = sc.nextLine();
            Disciplines rech = new Disciplines(0, nom, null);
            Disciplines d = controller.search(rech);
            if (d == null) affMsg("Discipline inconnue");
            else {
                affMsg(d.toString());
                special(d);
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }

    public void modifier() {
        int choix = choixElt(la);
        Disciplines d = la.get(choix - 1);
        do {
            try {
                String nom = modifyIfNotBlank("nom", d.getNom());
                String description = modifyIfNotBlank("description", d.getDescription());
                d.setNom(nom);
                d.setDescription(description);
                break;
            } catch (Exception e) {
                System.out.println("Erreur : " + e);
            }
        } while (true);
        controller.update(d);
    }

    public void ajouter() {
        Disciplines d;
        do {
            try {
                System.out.println("nom : ");
                String nom = sc.nextLine();
                System.out.println("description : ");
                String description = sc.nextLine();
                d = new Disciplines(0, nom, description);
                break;
            } catch (Exception e) {
                System.out.println("Une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        controller.add(d);
    }

    public void special(Disciplines d) {
        List options = Arrays.asList("lister employés", "fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    listerEmployes(d);
                    break;
                case 2:
                    return;
            }
        } while (true);
    }

    public void listerEmployes(Disciplines d) {
        affListe(new ArrayList<>(d.getEmployes()));
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }

    public void setController(DisciplinesController disciplinesController) {

    }
}

