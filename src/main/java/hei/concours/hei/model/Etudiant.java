package hei.concours.hei.model;

import java.time.LocalDate;
import java.util.Objects;

public class Etudiant {
    private int id;
    private String prenom;
    private String nom;
    private String numeroTelephone;
    private String adresseEmail;
    private String photoIdentite;
    private String imageBulletinTerminale;
    private String serieBacc;
    private String photocopieNoteBaccCertifie;
    private String photocopieCinCertifie;
    private LocalDate dateInscription;
    private int concoursId;

    public Etudiant(String prenom, String nom, String numeroTelephone, String adresseEmail, String photoIdentite, String imageBulletinTerminale, String serieBacc, String photocopieNoteBaccCertifie, String photocopieCinCertifie, LocalDate dateInscription, int concoursId) {
        this.prenom = prenom;
        this.nom = nom;
        this.numeroTelephone = numeroTelephone;
        this.adresseEmail = adresseEmail;
        this.photoIdentite = photoIdentite;
        this.imageBulletinTerminale = imageBulletinTerminale;
        this.serieBacc = serieBacc;
        this.photocopieNoteBaccCertifie = photocopieNoteBaccCertifie;
        this.photocopieCinCertifie = photocopieCinCertifie;
        this.dateInscription = dateInscription;
        this.concoursId = concoursId;
    }

    public Etudiant(int id, String prenom, String nom, String numeroTelephone, String adresseEmail, String photoIdentite, String imageBulletinTerminale, String serieBacc, String photocopieNoteBaccCertifie, String photocopieCinCertifie, LocalDate dateInscription, int concoursId) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.numeroTelephone = numeroTelephone;
        this.adresseEmail = adresseEmail;
        this.photoIdentite = photoIdentite;
        this.imageBulletinTerminale = imageBulletinTerminale;
        this.serieBacc = serieBacc;
        this.photocopieNoteBaccCertifie = photocopieNoteBaccCertifie;
        this.photocopieCinCertifie = photocopieCinCertifie;
        this.dateInscription = dateInscription;
        this.concoursId = concoursId;
    }

    public Etudiant(String prenom, String nom, String serieBacc) {
        this.prenom = prenom;
        this.nom = nom;
        this.serieBacc = serieBacc;
    }
    public Etudiant(){}

    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public String getPhotoIdentite() {
        return photoIdentite;
    }

    public String getImageBulletinTerminale() {
        return imageBulletinTerminale;
    }

    public String getSerieBacc() {
        return serieBacc;
    }

    public String getPhotocopieNoteBaccCertifie() {
        return photocopieNoteBaccCertifie;
    }

    public String getPhotocopieCinCertifie() {
        return photocopieCinCertifie;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public int getConcoursId() {
        return concoursId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return id == etudiant.id && concoursId == etudiant.concoursId && Objects.equals(prenom, etudiant.prenom) && Objects.equals(nom, etudiant.nom) && Objects.equals(numeroTelephone, etudiant.numeroTelephone) && Objects.equals(adresseEmail, etudiant.adresseEmail) && Objects.equals(photoIdentite, etudiant.photoIdentite) && Objects.equals(imageBulletinTerminale, etudiant.imageBulletinTerminale) && Objects.equals(serieBacc, etudiant.serieBacc) && Objects.equals(photocopieNoteBaccCertifie, etudiant.photocopieNoteBaccCertifie) && Objects.equals(photocopieCinCertifie, etudiant.photocopieCinCertifie) && Objects.equals(dateInscription, etudiant.dateInscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prenom, nom, numeroTelephone, adresseEmail, photoIdentite, imageBulletinTerminale, serieBacc, photocopieNoteBaccCertifie, photocopieCinCertifie, dateInscription, concoursId);
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                ", adresseEmail='" + adresseEmail + '\'' +
                ", photoIdentite='" + photoIdentite + '\'' +
                ", imageBulletinTerminale='" + imageBulletinTerminale + '\'' +
                ", serieBacc='" + serieBacc + '\'' +
                ", photocopieNoteBaccCertifie='" + photocopieNoteBaccCertifie + '\'' +
                ", photocopieCinCertifie='" + photocopieCinCertifie + '\'' +
                ", dateInscription=" + dateInscription +
                ", concoursId=" + concoursId +
                '}';
    }
}
