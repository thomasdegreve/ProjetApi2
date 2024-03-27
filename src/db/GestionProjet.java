package db;

import myconnections.DBConnection;
import myconnections.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class GestionProjet {


    private Scanner sc = new Scanner(System.in);
    private Connection dbConnect;

    public void gestion() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        do {
            System.out.println("1.ajout\n2.recherche\n3.modification\n4.suppression\n5.Afficher tout\n6.fin");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    ajoutProjet();
                    break;
                case 2:
                    rechercheProjet();
                    break;
                case 3:
                    modificationProjet();
                    break;
                case 4:
                    suppressionProjet();
                    break;
                case 5:
                    tous();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);

    }


    public void ajoutProjet() {
        try {
            String query = "INSERT INTO API2PROJET(NOM, DATEDEBUT, DATEFIN, COUT) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = dbConnect.prepareStatement(query);

            System.out.println("Entrez nom: ");
            String nom = sc.nextLine();
            pstmt.setString(1, nom);

            System.out.println("Entrez date de debut: ");
            String date_debut = sc.nextLine();
            pstmt.setString(2, date_debut);

            System.out.println("Entrez date de fin: ");
            String  date_fin = sc.nextLine();
            pstmt.setString(3, date_fin);

            System.out.println("cout : ");
            int couts = sc.nextInt();
            sc.nextLine();
            pstmt.setInt(4, couts);

            pstmt.executeUpdate();

            System.out.println("Projet ajoutée avec succès");

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void rechercheProjet() {
        try {
            String query = "SELECT * FROM API2PROJET WHERE IDPROJET = ?";

            PreparedStatement pstmt = dbConnect.prepareStatement(query);

            System.out.println("Entrez l'ID du Projet: ");
            int id = sc.nextInt();
            sc.nextLine();

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("NOM");
                String date_debut = rs.getString("DATEDEBUT");
                String date_fin = rs.getString("DATEFIN");
                int couts = rs.getInt("COUT");

                System.out.println("ID: " + id);
                System.out.println("nom : " + nom);
                System.out.println("date de debut : " + date_debut);
                System.out.println("date de fin : " + date_fin);
                System.out.println("cout : " + couts);
            } else {
                System.out.println("Aucun projet trouvée avec l'ID " + id);
            }

        } catch (SQLException e) {
            e.getMessage();
        }
    }


    public void modificationProjet() {
        try {
            String query = "UPDATE API2Projet SET NOM = ?, DATEDEBUT = ?, DATEFIN = ?, COUT = ? WHERE IDPROJET = ?";

            PreparedStatement pstmt = dbConnect.prepareStatement(query);

            System.out.println("Entrez l'ID DU PROJET: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Entrez nom: ");
            String nom = sc.nextLine();

            System.out.println("Entrez date de debut : ");
            String  date_debut = sc.nextLine();
            sc.nextLine();

            System.out.println("Entrez date de fin: ");
            String date_fin = sc.nextLine();

            System.out.println("Entrez cout: ");
            int couts = sc.nextInt();
            sc.nextLine();

            pstmt.setString(1, nom);
            pstmt.setString(2, date_debut);
            pstmt.setString(3, date_fin);
            pstmt.setInt(4, couts);
            pstmt.setInt(5, id);

            pstmt.executeUpdate();

            System.out.println("projet modifié avec succès");

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void suppressionProjet() {
        try {
            String query = "DELETE FROM API2PROJET WHERE IDPROJET = ?";

            PreparedStatement pstmt = dbConnect.prepareStatement(query);

            System.out.println("Entrez l'ID du projet: ");
            int id = sc.nextInt();
            sc.nextLine();

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            System.out.println("Projet supprimé avec succès");

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private void tous() {
        String query = "SELECT * FROM API2PROJET";
        try (Statement stmt = dbConnect.createStatement();
             ResultSet rs = stmt.executeQuery(query);) {

            while (rs.next()) {
                int id = rs.getInt("IDPROJET");
                String nom = rs.getString("NOM");
                String date_debut = rs.getString("DATEDEBUT");
                String date_fin = rs.getString("DATEFIN");
                int couts = rs.getInt("cout");

                System.out.println("------------------------------------------------");
                System.out.println("ID: " + id);
                System.out.println("nom: " + nom);
                System.out.println("date de debut : " + date_debut);
                System.out.println("date de fin: " + date_fin);
                System.out.println("cout : " + couts);
            }
        } catch (SQLException e) {
            System.out.println("erreur SQL " + e);
        }


    }


    public static void main(String[] args) {

        db.GestionProjet g = new db.GestionProjet();
        g.gestion();
    }

}


