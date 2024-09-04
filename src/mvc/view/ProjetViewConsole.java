package mvc.view;

import entreprise.Projet;
import mvc.controller.ControllerSpecialProjet;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Utilitaire.Utilitaire.*;

public class ProjetViewConsole extends AbstractView<Projet> {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(controller.getAll());
        List<String> options = Arrays.asList("ajouter", "retirer", "rechercher", "modifier", "rechercher par nom",  "fin");
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
        String nrech = sc.nextLine();
        List<Projet> lp = ((ControllerSpecialProjet) controller).filtrerProjets(p -> p.getNom().startsWith(nrech));
        if (lp.isEmpty()) {
            System.out.println("Aucun résultat trouvé");
            return;
        }
        int ch = choixListe(lp);
        if (ch != 0) special(lp.get(ch - 1));
    }

    private void retirer() {
        int nl = choixElt(la) - 1;
        Projet p = la.get(nl);
        boolean ok = controller.remove(p);
        if (ok) affMsg("Projet effacé");
        else affMsg("Projet non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    public void rechercher() {
        try {
            System.out.println("Nom :");
            String nom = sc.nextLine();
            System.out.println("Type :");
            String type = sc.nextLine();

            Projet rech = new Projet(0, nom, LocalDate.now(), LocalDate.now(), 0.0);
            Projet p = controller.search(rech);
            if (p == null) affMsg("Projet inconnu");
            else {//TODO QUESTION 1
                affMsg(p.toString());
                int x = p.InvestissementTotal();

                System.out.println("L'investissement total de ce projet est est de " + x);



                special(p);
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }

    public void modifier() {
        int choix = choixElt(la);
        Projet p = la.get(choix - 1);

        while (true) {
            try {

                String nom = modifyIfNotBlank("Nom", p.getNom());



                String datedebutStr = modifyIfNotBlank("Date début (YYYY-MM-DD)", p.getDatedebut().toString());
                LocalDate datedebut = datedebutStr.isEmpty() ? p.getDatedebut() : LocalDate.parse(datedebutStr);

                String datefinStr = modifyIfNotBlank("Date fin (YYYY-MM-DD)", p.getDatefin().toString());
                LocalDate datefin = datefinStr.isEmpty() ? p.getDatefin() : LocalDate.parse(datefinStr);


                String coutStr = modifyIfNotBlank("Coût", String.valueOf(p.getCout()));
                double cout = coutStr.isEmpty() ? p.getCout() : Double.parseDouble(coutStr);


                p.setNom(nom);

                p.setDatedebut(datedebut);
                p.setDatefin(datefin);
                p.setCout(cout);

                controller.update(p);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Erreur de format de date : " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Erreur de format numérique : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }


    public void ajouter() {//TODO QUESTION 3
        Projet p;
        do {
            try {
                String nom;
                String type;
                do {
                    System.out.println("Nom :");
                     nom = sc.nextLine();
                    System.out.println("Type :");
                     type = sc.nextLine();
                }while (nom.isEmpty() || type.isEmpty());

                LocalDate datefin;
                LocalDate datedebut;
                do {
                    System.out.println("Date début (YYYY-MM-DD) :");
                    datedebut = LocalDate.parse(sc.nextLine());
                    System.out.println("Date fin (YYYY-MM-DD) :");
                    datefin = LocalDate.parse(sc.nextLine());
                } while (datefin.isBefore(datedebut));


                double cout;
                do {
                    System.out.println("Coût :");
                    cout = sc.nextDouble();
                    sc.nextLine();
                } while (cout < 0 );


                p = new Projet(0, nom, datedebut, datefin, cout);
                break;
            } catch (Exception e) {
                System.out.println("Une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        controller.add(p);
    }

    public void special(Projet p) {
        List<String> options = Arrays.asList("Lister travaux", "Lister investissements", "Fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    listerTravaux(p);
                    break;
                case 2:
                    listerInvestissements(p);
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    public void listerTravaux(Projet p) {
        affList(new ArrayList<>(((ControllerSpecialProjet) controller).listerTravaux(p)));
    }

    public void listerInvestissements(Projet p) {
        affList(new ArrayList<>(((ControllerSpecialProjet) controller).listerInvestissements(p)));
    }
}
