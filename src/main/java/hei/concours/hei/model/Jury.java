package hei.concours.hei.model;

import java.util.Objects;

public class Jury {
    private int id;
    private String prenom;
    private String nom;
    private String numeroTelephone;
    private String adresseEmail;

    public Jury(String prenom, String nom, String numeroTelephone, String adresseEmail) {
        this.prenom = prenom;
        this.nom = nom;
        this.numeroTelephone = numeroTelephone;
        this.adresseEmail = adresseEmail;
    }

    public Jury(int id, String prenom, String nom, String numeroTelephone, String adresseEmail) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.numeroTelephone = numeroTelephone;
        this.adresseEmail = adresseEmail;
    }

    public Jury(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }
    public Jury(){}

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public int getId() {
        return id;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jury jury = (Jury) o;
        return id == jury.id && Objects.equals(prenom, jury.prenom) && Objects.equals(nom, jury.nom) && Objects.equals(numeroTelephone, jury.numeroTelephone) && Objects.equals(adresseEmail, jury.adresseEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prenom, nom, numeroTelephone, adresseEmail);
    }

    @Override
    public String toString() {
        return "Jury{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                ", adresseEmail='" + adresseEmail + '\'' +
                '}';
    }
}
