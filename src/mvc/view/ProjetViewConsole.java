package mvc.view;

import entreprise.Disciplines;
import entreprise.Investissement;
import entreprise.Projet;
import mvc.controller.ControllerSpecialProjet;

import java.text.DecimalFormat;
import java.time.LocalDate;
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
        Projet p = la.get(nl);
        boolean ok = controller.remove(p);
        if (ok) affMsg("Projet retiré");
        else affMsg("Impossible de retirer le projet");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    public void rechercher() {
        try {
            System.out.println("ID du projet : ");
            int id = Integer.parseInt(sc.nextLine());
            Projet rech = new Projet(id, null, null, null, null); // Dummy project for searching by id
            rech.setIdProjet(id);
            Projet p = controller.search(rech);
            if (p == null) affMsg("Projet introuvable");
            else {
                affMsg(p.toString());
                special(p);
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }

    public void modifier() {
        int choix = choixElt(la);
        Projet p = la.get(choix - 1);
        do {
            try {
                String nom = modifyIfNotBlank("nom", p.getNom());
                LocalDate datedebut = LocalDate.parse(modifyIfNotBlank("date de début (AAAA-MM-JJ)", p.getDatedebut().toString()));
                LocalDate datefin = LocalDate.parse(modifyIfNotBlank("date de fin (AAAA-MM-JJ)", p.getDatefin().toString()));
                DecimalFormat cout = p.getCout(); // You may want to allow modifying the cost too
                p.setNom(nom);
                p.setDatedebut(datedebut);
                p.setDatefin(datefin);
                break;
            } catch (Exception e) {
                System.out.println("Erreur : " + e);
            }
        } while (true);
        controller.update(p);
    }

    public void ajouter() {
        Projet p;
        do {
            try {
                System.out.println("Nom du projet : ");
                String nom = sc.nextLine();
                System.out.println("Date de début (AAAA-MM-JJ) : ");
                LocalDate datedebut = LocalDate.parse(sc.nextLine());
                System.out.println("Date de fin (AAAA-MM-JJ) : ");
                LocalDate datefin = LocalDate.parse(sc.nextLine());
                // Dummy cost for now, you may want to implement cost management too
                DecimalFormat cout = new DecimalFormat("#.##");
                p = new Projet(0, nom, datedebut, datefin, cout);
                break;
            } catch (Exception e) {
                System.out.println("Une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        controller.add(p);
    }

    public void special(Projet p) {
        List<String> options = Arrays.asList("afficher investissements", "ajouter discipline", "modifier discipline", "supprimer discipline", "fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    afficherInvestissements(p);
                    break;
                case 2:
                    ajouterDiscipline(p);
                    break;
                case 3:
                    modifierDiscipline(p);
                    break;
                case 4:
                    supprimerDiscipline(p);
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    public void afficherInvestissements(Projet p) {
        List<Investissement> investissements = p.getInvestissements();
        if (investissements.isEmpty()) {
            System.out.println("Aucun investissement pour ce projet.");
        } else {
            System.out.println("Investissements pour le projet '" + p.getNom() + "' :");
            for (Investissement i : investissements) {
                System.out.println("Discipline : " + i.getSpecialite().getNom() + ", Investissement : " + i.getQuantiteJH());
            }
        }
    }

    public void ajouterDiscipline(Projet p) {
        System.out.println("Nom de la discipline : ");
        String nomDiscipline = sc.nextLine();
        System.out.println("Quantité en JH : ");
        int quantiteJH = Integer.parseInt(sc.nextLine());
        Disciplines discipline = new Disciplines(0, nomDiscipline, null); // Dummy discipline for now
        p.addDisciplines(discipline, quantiteJH);
    }

    public void modifierDiscipline(Projet p) {
        System.out.println("Nom de la discipline à modifier : ");
        String nomDiscipline = sc.nextLine();
        System.out.println("Nouvelle quantité en JH : ");
        int nouvelleQuantite = Integer.parseInt(sc.nextLine());
        Disciplines discipline = new Disciplines(0, nomDiscipline, null); // Dummy discipline for now
        p.modifDisciplines(discipline, nouvelleQuantite);
    }

    public void supprimerDiscipline(Projet p) {
        System.out.println("Nom de la discipline à supprimer : ");
        String nomDiscipline = sc.nextLine();
        Disciplines discipline = new Disciplines(0, nomDiscipline, null); // Dummy discipline for now
        p.suppDisciplines(discipline);
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }
}
