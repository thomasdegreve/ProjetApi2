package mvc.view;

import entreprise.Disciplines;
import entreprise.Investissement;
import mvc.controller.ControllerSpecialInvestissement;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Utilitaire.Utilitaire.*;

public class InvestissementViewConsole extends AbstractView<Investissement> {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(controller.getAll());
        List<String> options = Arrays.asList(
                "ajouter",
                "retirer",
                "rechercher",
                "modifier",

                "rechercher par spécialité",
                "fin"
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
                    rechSpecialite();
                    break;
                case 6:
                    return;
            }
        } while (true);
    }



    private void rechSpecialite() {
        System.out.println("Nom spécialité :");
        String specialiteNom = sc.nextLine();
        List<Investissement> li = ((ControllerSpecialInvestissement)controller).filtrerInvestissements(i -> i.getSpecialite().getNom().startsWith(specialiteNom));
        if (li.isEmpty()) {
            System.out.println("Aucun résultat trouvé");
            return;
        }
        int ch = choixListe(li);
        if (ch != 0) special(li.get(ch - 1));
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
            System.out.println("Quantité JH :");
            int quantiteJH = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.println("Nom spécialité :");
            String specialiteNom = sc.nextLine();
            Disciplines specialite = new Disciplines(0, specialiteNom, ""); // Placeholder for Disciplines

            Investissement rech = new Investissement(quantiteJH, specialite);
            Investissement i = controller.search(rech);

            if (i == null) affMsg("Investissement inconnu");
            else {
                affMsg(i.toString());
                special(i);
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void modifier() {
        int choix = choixElt(la);
        Investissement i = la.get(choix - 1);
        do {
            try {
                String quantiteJH = modifyIfNotBlank("Quantité JH", i.getQuantiteJH());
                String specialiteNom = modifyIfNotBlank("Nom spécialité", i.getSpecialite().getNom());
                Disciplines specialite = new Disciplines(0, specialiteNom, "");

                i.setQuantiteJH(quantiteJH);
                i.setSpecialite(specialite);
                break;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        } while (true);
        controller.update(i);
    }



    public void ajouter() {
        Investissement i;
        do {
            try {
                System.out.println("Quantité JH :");
                int quantiteJH = sc.nextInt();
                sc.nextLine();
                System.out.println("Nom spécialité :");
                String specialiteNom = sc.nextLine();
                Disciplines specialite = new Disciplines(0, specialiteNom, "");

                i = new Investissement(quantiteJH, specialite);
                break;
            } catch (Exception e) {
                System.out.println("Une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        controller.add(i);
    }

    public void special(Investissement i) {
        List<String> options = Arrays.asList("Afficher détails spécialité", "Fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    affMsg("Spécialité: " + i.getSpecialite().toString());
                    break;
                case 2:
                    return;
            }
        } while (true);
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }
}
