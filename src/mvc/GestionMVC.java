package mvc;

import entreprise.*;
import mvc.controller.*;
import mvc.model.*;
import mvc.view.*;
import Utilitaire.Utilitaire;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;

public class GestionMVC {

    public static HashMap<Employe, Projet> ASSIGNMENTS = new HashMap<>();

    public static DAO<Employe> em;
    public static AbstractView<Employe> ev;
    public static Controller<Employe> ec;

    public static DAO<Projet> pm;
    public static AbstractView<Projet> pv;
    public static Controller<Projet> pc;

    public static DAO<Disciplines> dm;
    public static AbstractView<Disciplines> dv;
    public static Controller<Disciplines> dc;



    public void gestion() {

        em = new ModelEmploye();
        ev = new EmployeViewConsole();
        ec = new EmployeController(em, ev);
        em.addObserver(ev);

        pm = new ModelProjet();
        pv = new ProjetViewConsole();
        pc = new ProjetController(pm, pv);
        pm.addObserver(pv);

        dm = new ModelDiscipline();
        dv = new DisciplineViewConsole();
        dc = new DisciplinesController(dm, dv);
        dm.addObserver(dv);

        try {
            populate();
        } catch (Exception e) {
            System.out.println("Erreur lors du populate : " + e);
            System.exit(1);
        }

        List<String> loptions = Arrays.asList("employés", "projets", "disciplines", "sauvegarde des assignments", "restauration des assignments", "fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch) {
                case 1:
                    ev.menu();
                    break;
                case 2:
                    pv.menu();
                    break;
                case 3:
                    dv.menu();
                    break;
                case 4:
                    sauvegarde();
                    break;
                case 5:
                    restauration();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }

    private void restauration() {
        try (FileReader fr = new FileReader("c:/poo2/assignments.txt");
             Scanner sc = new Scanner(fr)) {
            while (sc.hasNext()) {
                String ligne = sc.nextLine();
                String[] infos = ligne.split("-");
                String empId = infos[0];
                String projId = infos[1];
                Employe emp = em.read(new Employe(1, "", "","", "", "",null));
                if (emp == null) {
                    System.out.println(empId + " : employé inconnu");
                    continue;
                }
                Projet proj = pm.read(new Projet(1, "",LocalDate.now(),LocalDate.now(),100.00));
                if (proj == null) {
                    System.out.println(projId + " : projet inconnu");
                    continue;
                }
                ASSIGNMENTS.put(emp, proj);
            }
            System.out.println("Restauration terminée");

        } catch (Exception e) {
            System.out.println("Erreur de fichier " + e);
        }
    }

    private void sauvegarde() {
        Set<Employe> setEmp = GestionMVC.ASSIGNMENTS.keySet();
        List<Employe> le = new ArrayList<>(setEmp);
        le.sort(Comparator.comparing(Employe::getIdEmploye));
        try (FileWriter fw = new FileWriter("c:/poo2/assignments.txt");
             PrintWriter pr = new PrintWriter(fw)) {
            for (Employe emp : le) {
                pr.println(emp.getIdEmploye() + "-" + GestionMVC.ASSIGNMENTS.get(emp).getIdProjet());
            }

        } catch (Exception e) {
            System.out.println("Erreur de fichier " + e);
        }
    }

    public void populate() {

        Disciplines d1 = new Disciplines(1,"Développement", "IT");
        dm.add(d1);

        Disciplines d2 = new Disciplines(2,"Marketing", "Commercial");
        dm.add(d2);

        Projet p1 = new Projet(1, "Développement d'une application", LocalDate.of(2024, 6, 30),LocalDate.of(2024,8,30),120.00);
        pm.add(p1);
      //  d1.addProjet(p1);

        Projet p2 = new Projet(2, "campagne marketing", LocalDate.of(2024, 6, 30),LocalDate.of(2024,8,30),120.00);
        pm.add(p2);
       // d2.addProjet(p2);

        Employe e1 = new Employe(1,"fefeefe" ,"Jean", "Dupont", "02555656", "rgrdg@gmzil.com",d1);
        em.add(e1);

        Employe e2 = new Employe(2, "fefef","Alice", "Martin", "26516165", "fe,kfs@mail",d2);
        em.add(e2);

        ASSIGNMENTS.put(e1, p1);
        ASSIGNMENTS.put(e2, p2);
    }

    public static void main(String[] args) {
        GestionMVC gb = new GestionMVC();
        gb.gestion();
    }
}
