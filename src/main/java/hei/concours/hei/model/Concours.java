package hei.concours.hei.model;

import java.time.LocalDate;
import java.util.Objects;

public class Concours {
    private int id;
    private int annee;
    private LocalDate dateConcours;
    private String description;
    private Double frais;

    public Concours(int id, int annee, LocalDate dateConcours, String description, Double frais) {
        this.id = id;
        this.annee = annee;
        this.dateConcours = dateConcours;
        this.description = description;
        this.frais = frais;
    }

    public Concours(int annee, LocalDate dateConcours, String description, Double frais) {
        this.annee = annee;
        this.dateConcours = dateConcours;
        this.description = description;
        this.frais = frais;
    }
    public Concours(){}

    public int getId() {
        return id;
    }

    public int getAnnee() {
        return annee;
    }

    public LocalDate getDateConcours() {
        return dateConcours;
    }

    public String getDescription() {
        return description;
    }

    public Double getFrais() {
        return frais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concours concours = (Concours) o;
        return id == concours.id && annee == concours.annee && Objects.equals(dateConcours, concours.dateConcours) && Objects.equals(description, concours.description) && Objects.equals(frais, concours.frais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, annee, dateConcours, description, frais);
    }

    @Override
    public String toString() {
        return "Concours{" +
                "id=" + id +
                ", annee=" + annee +
                ", dateConcours=" + dateConcours +
                ", description='" + description + '\'' +
                ", frais=" + frais +
                '}';
    }
}
