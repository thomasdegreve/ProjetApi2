package designpattern.composite;

public class Main {
    public static void main(String[] args) {

        Projet projet1 = new Projet("Projet A", 1000.0);
        Projet projet2 = new Projet("Projet B", 2000.0);


        GroupeProjet groupe1 = new GroupeProjet(1, "Groupe 1");
        groupe1.ajouterComposant(projet1);
        groupe1.ajouterComposant(projet2);

        GroupeProjet groupe2 = new GroupeProjet(2, "Groupe 2");
        groupe2.ajouterComposant(groupe1);


        System.out.println(groupe1);
        System.out.println(groupe2);
    }
}
