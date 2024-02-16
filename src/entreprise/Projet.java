package entreprise;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projet {
    protected int idProjet;
    protected String nom;
    protected Date datedebut;
    protected Date datefin;
    protected DecimalFormat cout;

    protected List<Investissement> investissements=new ArrayList<>();
    protected  List<Travail> travails=new ArrayList<>();

    public Projet(int idProjet,String nom,Date datedebut,Date datefin,DecimalFormat cout){
        this.idProjet=idProjet;
        this.nom=nom;
        this.datedebut=datedebut;
        this.datefin=datefin;
        this.cout=cout;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public DecimalFormat getCout() {
        return cout;
    }

    public void setCout(DecimalFormat cout) {
        this.cout = cout;
    }

    public List<Investissement> getInvestissements() {
        return investissements;
    }

    public void setInvestissements(List<Investissement> investissements) {
        this.investissements = investissements;
    }

    public List<Travail> getTravails() {
        return travails;
    }

    public void setTravails(List<Travail> travails) {
        this.travails = travails;
    }

    public void ListeDisciplinesEtInvestissement(){
        for(Investissement inv : investissements){
            System.out.println("Disciplines : "+inv.specialite.getNom() +" Investissement : "+inv.quantiteJH );
        }
    }
    public void InvestissementTotal(){
        int invesTot = 0;
        for(Investissement inv : investissements){
            invesTot+=inv.quantiteJH;
        }

    }
    public void addDisciplines(Disciplines disciplines,int quantite){
        Investissement investissement = new Investissement(quantite, disciplines);
        investissements.add(investissement);
    }
    public void modifDisciplines(Disciplines disciplines,int quantite){
        for(Investissement inv : investissements){
            if(inv.getSpecialite().equals(disciplines)){
                inv.setQuantiteJH(quantite);
                return;
            }
        }
    }
    public void suppDisciplines(Disciplines disciplines){
        for(Investissement inv : investissements){
            if(inv.getSpecialite().equals(disciplines)){
                investissements.remove(inv);
                return;
            }
        }
    }

    public void ListeEmployeEtPourcentageEtDate(){
        for(Travail trv : travails){
            System.out.println("Employe : "+trv.getEmployes() +" Pourcentage : "+trv.getPourcentage() +"Date : "+trv.getDateEngag());
        }
    }
    public void addEmploye(Employe employe,int pourcentage,Date date){
        Travail travail1 = new Travail(pourcentage,date,employe);
        travails.add(travail1);
    }
    public void suppEmploye(Employe employe){
        travails.removeIf(travail -> travail.getEmployes() == employe);

    }
    public void modifEmploye(Employe employe,int pourcentage){
        for(Travail trv : travails){
            if(trv.getEmployes()==employe){
                trv.setPourcentage(pourcentage);
                return;
            }
        }
    }
    public int totalPourcentage(){
        int total = 0;
        for(Travail travail : travails){
            total += travail.getPourcentage();
        }
        return total;

    }
    public String listeSpecialite(){
        List<String> specialites = new ArrayList<>();
        for(Investissement inv : investissements){
            specialites.add(inv.getSpecialite().getNom());
        }
        return specialites.toString();
    }
}