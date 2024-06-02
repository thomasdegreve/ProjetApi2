package mvc.model;

import entreprise.Disciplines;
import entreprise.Employe;
import mvc.observer.Observer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static myconnections.DBConnection.dbConnect;

public class ModelDisciplines extends DAO<Disciplines> implements DAOSpecialDisciplines {

    private List<Disciplines> ldatas = new ArrayList<>();

    @Override
    public Disciplines add(Disciplines elt) {
        boolean present = ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    public void notifyObservers(){
        List<Observer> myObservers = new ArrayList<>();
        List l =getNotification();
        for(Observer o : myObservers) o.update(l);
    }
    @Override
    public boolean remove(Disciplines elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }
   /* CREATE VIEW EmployesParDiscipline AS
    SELECT e.*, d.nom
    FROM api2employee e
    JOIN api2disciplines d ON e.iddisciplines = d.iddisciplines
    WHERE d.discipline = '&nomDisicpline';

*/


        public List<Employe> EmployesParDiscipline(Disciplines discipline) {
            List<Employe> employes = new ArrayList<>();
            String query = "SELECT * FROM EmployesParDiscipline WHERE id_discipline=?";
            try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setInt(1, discipline.getId());
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String matricule = rs.getString("matricule");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String tel = rs.getString("tel");
                    String mail = rs.getString("mail");


                    employes.add(new Employe(id, matricule, nom, prenom, tel, mail, null));
                }
            } catch (SQLException e) {
                System.err.println("Erreur SQL : " + e);
            }
            return employes;
        }


    @Override
    public Disciplines update(Disciplines elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Disciplines read(Disciplines rech) {
        int p = ldatas.indexOf(rech);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Disciplines> getAll() {
        return ldatas;
    }

    @Override
    public List<Employe> listerEmployes(Disciplines discipline) {
        return null;
    }

    @Override
    public List<Disciplines> getDiscipline() {
        return null;
    }

    @Override
    public Disciplines addDiscipline(Disciplines discipline) {
        return null;
    }

    @Override
    public boolean removeDiscipline(Disciplines discipline) {
        return false;
    }

    @Override
    public Disciplines updateDiscipline(Disciplines discipline) {
        return null;
    }

    @Override
    public Disciplines readDiscipline(int idDiscipline) {
        return null;
    }
}
