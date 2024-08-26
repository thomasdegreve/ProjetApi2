package designpattern.Builder;

import entreprise.Disciplines;

import java.util.Objects;

public class Employe {
    /**
     * matricule unique de l'employé
     */
    private final String matricule;

    /**
     * nom de l'employé
     */
    private final String nom;

    /**
     * prenom de l'employé
     */
    private final String prenom;

    /**
     * tel de l'employé
     */
    private String tel;

    /**
     * mail de l'employé
     */
    private String mail;

    /**
     * specialite de l'employé
     */
    private Disciplines specialite;

    /**
     * Private constructor for the Builder
     */
    private Employe(Builder builder) {
        this.matricule = builder.matricule;
        this.nom = builder.nom;
        this.prenom = builder.prenom;
        this.tel = builder.tel;
        this.mail = builder.mail;
        this.specialite = builder.specialite;
    }

    // Getters
    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public Disciplines getSpecialite() {
        return specialite;
    }


    public static class Builder {
        private final String matricule;
        private final String nom;
        private final String prenom;
        private String tel;
        private String mail;
        private Disciplines specialite;

        public Builder(String matricule, String nom, String prenom) {
            if (matricule == null || nom == null || prenom == null) {
                throw new IllegalArgumentException("Matricule, nom, and prenom ne peuvent pas etre nuls");
            }
            this.matricule = matricule;
            this.nom = nom;
            this.prenom = prenom;
        }

        public Builder tel(String tel) {
            this.tel = tel;
            return this;
        }

        public Builder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public Builder specialite(Disciplines specialite) {
            this.specialite = specialite;
            return this;
        }

        public Employe build() {
            return new Employe(this);
        }
    }

    @Override
    public String toString() {
        return "Employe{" +
                "matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", specialite=" + specialite +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(matricule, employe.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }
}
