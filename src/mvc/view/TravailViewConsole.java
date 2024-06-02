package mvc.view;

import entreprise.Employe;
import entreprise.Travail;
import mvc.controller.ControllerSpecialTravail;
import mvc.controller.TravailController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static Utilitaire.Utilitaire.*;



public class TravailViewConsole extends AbstractView<Travail> {
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
        Travail t = la.get(nl);
        boolean ok = controller.remove(t);
        if (ok) affMsg("Travail retiré");
        else affMsg("Impossible de retirer le travail");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    public void rechercher() {
        try {
            System.out.println("ID du travail : ");
            int id = Integer.parseInt(sc.nextLine());
            Travail rech = new Travail(0, null, null); // Dummy project for searching by id
            rech.setIdTravail(id);
            Travail t = controller.search(rech);
            if (t == null) affMsg("Travail introuvable");
            else affMsg(t.toString());
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }

    public void modifier() {
        int choix = choixElt(la);
        Travail t = la.get(choix - 1);
        do {
            try {
                int pourcentage = Integer.parseInt(modifyIfNotBlank("pourcentage", Integer.toString(t.getPourcentage())));
                LocalDate dateEngag = LocalDate.parse(modifyIfNotBlank("date d'engagement (AAAA-MM-JJ)", t.getDateEngag().toString()));
                // You may want to modify the employee too, but that depends on your requirements
                t.setPourcentage(pourcentage);
                t.setDateEngag(dateEngag);
                break;
            } catch (Exception e) {
                System.out.println("Erreur : " + e);
            }
        } while (true);
        controller.update(t);
    }

    public void ajouter() {
        Travail t;
        do {
            try {
                System.out.println("Pourcentage de prise en charge : ");
                int pourcentage = Integer.parseInt(sc.nextLine());
                System.out.println("Date d'engagement (AAAA-MM-JJ) : ");
                LocalDate dateEngag = LocalDate.parse(sc.nextLine());
                // Dummy employee for now
                Employe employe = new Employe(0, null, null, null, null,null,null);
                t = new Travail(pourcentage, dateEngag, employe);
                break;
            } catch (Exception e) {
                System.out.println("Une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        controller.add(t);
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }

    public void setController(TravailController travailController) {
    }
}
