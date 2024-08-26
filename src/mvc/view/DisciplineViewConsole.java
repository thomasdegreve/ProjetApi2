package mvc.view;

import entreprise.Disciplines;
import mvc.controller.ControllerSpecialDiscipline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Utilitaire.Utilitaire.*;

public class DisciplineViewConsole extends AbstractView<Disciplines> {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(controller.getAll());
        List<String> options = Arrays.asList("ajouter", "retirer", "rechercher", "modifier", "rechercher par nom", "fin");
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
                    return;
            }
        } while (true);
    }

    @Override
    public void affList(List la) {

    }

    private void rechNom() {
        System.out.println("Nom recherché :");
        String nomRecherche = sc.nextLine();
        List<Disciplines> ld = ((ControllerSpecialDiscipline)controller).filtrerDisciplines(d -> d.getNom().startsWith(nomRecherche));
        if (ld.isEmpty()) {
            System.out.println("Aucun résultat trouvé.");
            return;
        }
        int ch = choixListe(ld);
        if (ch != 0) special(ld.get(ch - 1));
    }

    private void retirer() {
        int nl = choixElt(la) - 1;
        Disciplines d = la.get(nl);
        boolean ok = controller.remove(d);
        affMsg(ok ? "Discipline effacée." : "Discipline non effacée.");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    public void rechercher() {
        try {
            System.out.println("ID :");
            int id = Integer.parseInt(sc.nextLine().trim());


            Disciplines rech = new Disciplines(id, "", "");


            Disciplines d = controller.search(rech);

            if (d == null) {
                affMsg("Discipline inconnue.");
            } else {
                affMsg(d.toString());
                special(d);
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur : ID invalide. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void modifier() {
        int choix = choixElt(la);
        Disciplines d = la.get(choix - 1);
        do {
            try {
                String nom = modifyIfNotBlank("Nom", d.getNom());
                d.setNom(nom);
                String description = modifyIfNotBlank("Description", d.getDescription());
                d.setDescription(description);
                break;
            } catch (Exception ex) {
                System.out.println("Erreur : " + ex);
            }
        } while (true);
        controller.update(d);
    }

    public void ajouter() {
        Disciplines d;
        do {
            try {
                System.out.println("ID :");
                int id = Integer.parseInt(sc.nextLine());
                System.out.println("Nom :");
                String nom = sc.nextLine();
                System.out.println("Description :");
                String description = sc.nextLine();
                d = new Disciplines(id, nom, description);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Erreur : ID invalide. " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Une erreur est survenue : " + ex.getMessage());
            }
        } while (true);
        controller.add(d);
    }

    public void special(Disciplines d) {
        List<String> options = Arrays.asList("Lister employés", "Lister projets", "Fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    listerEmployes(d);
                    break;
                case 2:
                    listerProjets(d);
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    public void listerEmployes(Disciplines d) {
        affList(new ArrayList<>(((ControllerSpecialDiscipline)controller).listerEmployes(d)));
    }

    public void listerProjets(Disciplines d) {
        affList(new ArrayList<>(((ControllerSpecialDiscipline)controller).listerProjets(d)));
    }
}
