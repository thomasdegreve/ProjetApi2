package entreprise;

import java.util.List;

public class Investissement {
    private static int nextId = 1;
    protected int idInvest;
    protected int quantiteJH;

    protected Disciplines specialite;

    public Investissement(int quantiteJH,Disciplines specialite){
        this.idInvest=nextId++; // aide de chat gpt pour auto incrementation
        this.quantiteJH=quantiteJH;
        this.specialite=specialite;
    }

    public int getIdInvest() {
        return idInvest;
    }

    public void setIdInvest(int idInvest) {
        this.idInvest = idInvest;
    }

    public int getQuantiteJH() {
        return quantiteJH;
    }

    public void setQuantiteJH(int quantiteJH) {
        this.quantiteJH = quantiteJH;
    }

    public Disciplines getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Disciplines specialite) {
        this.specialite = specialite;
    }
}
