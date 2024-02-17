package entreprise;

import java.util.List;

public class Investissement {
    /**
     * auto incrémentation
     */
    private static int nextId = 1;
    /**
     * id unique de l'investissement
     */
    protected int idInvest;

    /**
     * quantite en JH
     */
    protected int quantiteJH;

    /**
     * spécialité de type discipline
     */
    protected Disciplines specialite;

    /**
     * constructeur paramétré
     * @param quantiteJH quantite en jh
     * @param specialite specialité pour l'investissement
     * constructeur paramétré
     */
    public Investissement(int quantiteJH,Disciplines specialite){
        this.idInvest=nextId++; // aide de chat gpt pour auto incrementation
        this.quantiteJH=quantiteJH;
        this.specialite=specialite;
    }

    /**
     * getter idInvest
     * return l'id de l'investissement
     */
    public int getIdInvest() {
        return idInvest;
    }

    /**
     *setter idInvest
     * @param idInvest id numerique de l'investissement
     */
    public void setIdInvest(int idInvest) {
        this.idInvest = idInvest;
    }

    /**
     * getter QuantiteJH
     * return la quantite en JH
     */
    public int getQuantiteJH() {
        return quantiteJH;
    }

    /**
     * setter quantiteJH
     * @param quantiteJH la quantite en jh
     */
    public void setQuantiteJH(int quantiteJH) {
        this.quantiteJH = quantiteJH;
    }

    /**
     * getter Specialite
     * return la specialité
     */
    public Disciplines getSpecialite() {
        return specialite;
    }

    /**
     * setter specialite
     * @param specialite la specialite pour l'investissement
     */
    public void setSpecialite(Disciplines specialite) {
        this.specialite = specialite;
    }
}
