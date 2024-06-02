package mvc.view;

import entreprise.Disciplines;
import entreprise.Investissement;
import mvc.controller.ControllerSpecialInvestissement;
import mvc.controller.InvestissementController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static Utilitaire.Utilitaire.*;



public class InvestissementViewConsole extends AbstractView<Investissement> {
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

    private void retirer() {
        int nl = choixElt(la) - 1;
        Investissement i = la.get(nl);
        boolean ok = controller.remove(i);
        if (ok) affMsg("Investissement effacé");
        else affMsg("Investissement non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    public void rechercher() {
        try {
            System.out.println("ID de l'investissement : ");
            int id = Integer.parseInt(sc.nextLine());
            Investissement rech = new Investissement(0, null); // Dummy investment for searching by id
            rech.setIdInvest(id);
            Investissement i = controller.search(rech);
            if (i == null) affMsg("Investissement inconnu");
            else {
                affMsg(i.toString());
                special(i);
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }

    public void modifier() {
        int choix = choixElt(la);
        Investissement i = la.get(choix - 1);
        do {
            try {
                int quantiteJH = Integer.parseInt(modifyIfNotBlank("quantité en JH", String.valueOf(i.getQuantiteJH())));
                String specialiteNom = modifyIfNotBlank("spécialité (nom)", i.getSpecialite().getNom());
                Disciplines specialite = new Disciplines(0, specialiteNom, null); // Creating a dummy discipline for now
                i.setQuantiteJH(Integer.parseInt(String.valueOf(quantiteJH)));
                i.setSpecialite(specialite);
                break;
            } catch (Exception e) {
                System.out.println("Erreur : " + e);
            }
        } while (true);
        controller.update(i);
    }

    public void ajouter() {
        Investissement i;
        do {
            try {
                System.out.println("Quantité en JH : ");
                int quantiteJH = Integer.parseInt(sc.nextLine());
                System.out.println("Spécialité (nom) : ");
                String specialiteNom = sc.nextLine();
                Disciplines specialite = new Disciplines(0, specialiteNom, null); // Creating a dummy discipline for now
                i = new Investissement(quantiteJH, specialite);
                break;
            } catch (Exception e) {
                System.out.println("Une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        controller.add(i);
    }

    public void special(Investissement i) {
        List<String> options = Arrays.asList("afficher spécialité", "fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    afficherSpecialite(i);
                    break;
                case 2:
                    return;
            }
        } while (true);
    }

    public void afficherSpecialite(Investissement i) {
        affMsg(i.getSpecialite().toString());
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }


}
