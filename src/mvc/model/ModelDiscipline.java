/*package mvc.model;

import entreprise.*;
import myconnections.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class ModelDiscipline implements DAOSpecialDisciplines {
    protected Connection dbConnect;

    public ModelDiscipline() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("Erreur de connexion");
            System.exit(1);
        }


    @Override
    public Disciplines addDiscipline(Disciplines discipline) {
        String addProcedure = "{ call APIADD_DISCIPLINE(?,?) }";
        try (CallableStatement cstm = dbConnect.prepareCall(addProcedure)) {
            cstm.setString(1, discipline.getNom());
            cstm.setString(2, discipline.getDescription());
            cstm.executeUpdate();
            notifyObservers();  // Notify observers after successful addition
            return discipline;
        } catch (SQLException e) {
            System.err.println("Erreur SQL lors de l'ajout de la discipline :" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean removeDiscipline(Disciplines discipline) {
        String removeProcedure = "{ call APIREMOVE_DISCIPLINE(?) }";
        try (CallableStatement cstm = dbConnect.prepareCall(removeProcedure)) {
            cstm.setInt(1, discipline.getId());
            int n = cstm.executeUpdate();
            if (n == 0) {
                System.err.println("La discipline à supprimer n'a pas été trouvée");
                return false;
            }
            notifyObservers();  // Notify observers after successful removal
            return true;
        } catch (SQLException e) {
            System.err.println("Erreur SQL lors de la suppression de la discipline :" + e.getMessage());
            return false;
        }
    }

    @Override
    public Disciplines updateDiscipline(Disciplines discipline) {
        String updateProcedure = "{ call APIUPDATE_DISCIPLINE(?,?,?) }";
        try (CallableStatement cstm = dbConnect.prepareCall(updateProcedure)) {
            cstm.setInt(1, discipline.getId());
            cstm.setString(2, discipline.getNom());
            cstm.setString(3, discipline.getDescription());
            cstm.executeUpdate();
            notifyObservers();  // Notify observers after successful update
            return readDiscipline(discipline.getId());
        } catch (SQLException e) {
            System.err.println("Erreur SQL lors de la mise à jour de la discipline :" + e.getMessage());
            return null;
        }
    }

    @Override
    public Disciplines readDiscipline(int id_d) {
        String query = "SELECT * FROM API2DISCIPLINES WHERE id_d = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, id_d);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                return new Disciplines(id_d, name, description);
            } else {
                System.err.println("La discipline avec l'ID " + id_d + " est introuvable");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL lors de la lecture de la discipline :" + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Disciplines> getDisciplines() {
        List<Disciplines> ld = new ArrayList<>();
        String query = "SELECT * FROM API2DISCIPLINES";
        try (Statement stmt = dbConnect.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id_d");
                String name = rs.getString("name");
                String description = rs.getString("description");
                ld.add(new Disciplines(id, name, description));
            }
            return ld;
        } catch (SQLException e) {
            System.err.println("Erreur SQL lors de la récupération des disciplines :" + e.getMessage());
            return null;
        }
    }


    private void notifyObservers() {

    }

    @Override
    public Set<Employe> listerEmployes(Disciplines discipline) {

        return null;
    }

    @Override
    public Set<Projet> listerProjets(Disciplines d) {

        return null;
    }

    @Override
    public List<Projet> listerProjets(Disciplines d, double minBudget, double maxBudget) {

        return null;
    }

    @Override
    public List<Disciplines> filtrerDisciplines(Predicate<Disciplines> pr) {

        return null;
    }

    @Override
    public List getNotification() {
        return getDisciplines();
    }
}
*/package mvc.model;

import entreprise.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ModelDiscipline extends DAO<Disciplines> implements DAOSpecialDisciplines {

    private List<Disciplines> disciplinesList = new ArrayList<>();

    public ModelDiscipline() {
        // Initialisation avec quelques données pour tester
        // Cela peut être remplacé par une vraie initialisation si nécessaire
        disciplinesList.add(new Disciplines(1, "Discipline A", "Description A"));
        disciplinesList.add(new Disciplines(2, "Discipline B", "Description B"));
    }


    public Disciplines addDiscipline(Disciplines discipline) {
        disciplinesList.add(discipline);
        notifyObservers();
        return discipline;
    }


    public boolean removeDiscipline(Disciplines discipline) {
        boolean removed = disciplinesList.removeIf(d -> d.getId() == discipline.getId());
        if (removed) {
            notifyObservers();
        }
        return removed;
    }


    public Disciplines updateDiscipline(Disciplines discipline) {
        for (int i = 0; i < disciplinesList.size(); i++) {
            Disciplines d = disciplinesList.get(i);
            if (d.getId() == discipline.getId()) {
                disciplinesList.set(i, discipline);
                notifyObservers();
                return discipline;
            }
        }
        System.err.println("La discipline avec l'ID " + discipline.getId() + " est introuvable");
        return null;
    }


    public Disciplines readDiscipline(int id_d) {
        return disciplinesList.stream()
                .filter(d -> d.getId() == id_d)
                .findFirst()
                .orElse(null);
    }


    public List<Disciplines> getDisciplines() {
        return new ArrayList<>(disciplinesList);
    }



    @Override
    public Set<Employe> listerEmployes(Disciplines discipline) {

        return null;
    }

    @Override
    public Set<Projet> listerProjets(Disciplines d) {

        return null;
    }

    @Override
    public List<Projet> listerProjets(Disciplines d, double minBudget, double maxBudget) {

        return null;
    }

    @Override
    public List<Disciplines> filtrerDisciplines(Predicate<Disciplines> pr) {
        return disciplinesList.stream()
                .filter(pr)
                .collect(Collectors.toList());
    }


    @Override
    public Disciplines add(Disciplines elt) {
        return null;
    }

    @Override
    public boolean remove(Disciplines elt) {
        return false;
    }

    @Override
    public Disciplines update(Disciplines elt) {
        return null;
    }

    @Override
    public Disciplines read(Disciplines rech) {
        return null;
    }

    @Override
    public List<Disciplines> getAll() {
        return null;
    }

    public List<Disciplines> getNotification() {
        return getDisciplines();
    }
}
