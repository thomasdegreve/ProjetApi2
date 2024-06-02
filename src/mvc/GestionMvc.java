package mvc;




import entreprise.*;
import mvc.controller.*;
import mvc.model.*;
import mvc.view.*;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static Utilitaire.Utilitaire.*;
public class GestionMVC {

    public static DAO<Disciplines> dm;
    public static AbstractView<Disciplines> dv;
    public static Controller<Disciplines> dc;

    public static DAO<Employe> em;
    public static AbstractView<Employe> ev;
    public static Controller<Employe> ec;

    public static DAO<Investissement> im;
    public static AbstractView<Investissement> iv;
    public static Controller<Investissement> ic;

    public static DAO<Projet> pm;
    public static AbstractView<Projet> pv;
    public static Controller<Projet> pc;

    public static DAO<Travail> tm;
    public static AbstractView<Travail> tv;
    public static Controller<Travail> tc;

    public void gestion() {

        dm = new ModelDisciplines();
        dv = new DisciplineViewConsole();
        dc = new DisciplinesController(dm, dv);
        dm.addObserver(dv);

        em = new ModelEmploye();
        ev = new EmployeViewConsole();
        ec = new EmployeController(em, ev);
        em.addObserver(ev);

        im = new ModelInvestissement();
        iv = new InvestissementViewConsole();
        ic = new InvestissementController(im, iv);
        im.addObserver(iv);

        pm = new ModelProjet();
        pv = new ProjetViewConsole();
        pc = new ProjetController(pm, pv);
        pm.addObserver(pv);

        tm = new ModelTravail();
        tv = new TravailViewConsole();
        tc = new TravailController(tm, tv);
        tm.addObserver(tv);

        try {
            populate();
        } catch (Exception e) {
            System.out.println("erreur lors du populate : " + e);
            System.exit(1);
        }

        List<String> loptions = Arrays.asList("disciplines", "employes", "investissements", "projets", "travaux", "fin");
        do {
            int ch = choixListe(loptions);
            switch (ch) {
                case 1:
                    dv.menu();
                    break;
                case 2:
                    ev.menu();
                    break;
                case 3:
                    iv.menu();
                    break;
                case 4:
                    pv.menu();
                    break;
                case 5:
                    tv.menu();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }

    public void populate() {

        Disciplines d1 = new Disciplines(1,"programmation JAVA","code only java");
        dm.add(d1);
        Disciplines d2 = new Disciplines(2,"C++","code only c++");
        dm.add(d2);

        Employe e1 = new Employe(1, "15025","Smith", "John",  "0123456789","john.smith@mail.com",d1);
        em.add(e1);
        Employe e2 = new Employe(2, "154545", "Doe", "Jane", "9876543210","jane.doe@mail.com" ,d2);
        em.add(e2);

        Investissement i1 = new Investissement(15,d1);
        im.add(i1);

        Travail t1 = new Travail(15, LocalDate.of(2023,5,6), e1);
        tm.add(t1);

        Projet p1 = new Projet(1,"programme en c++", LocalDate.of(2024, 1, 1),LocalDate.of(2024,2,1),120.00 );
        pm.add(p1);


    }

    public static void main(String[] args) {
        GestionMVC gb = new GestionMVC();
        gb.gestion();
    }
}
