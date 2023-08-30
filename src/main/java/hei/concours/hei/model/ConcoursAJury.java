package hei.concours.hei.model;

import java.util.Objects;

public class ConcoursAJury {
    private int id;
    private int idConcours;
    private int idJury;

    public ConcoursAJury(){}

    public ConcoursAJury(int idConcours, int idJury) {
        this.idConcours = idConcours;
        this.idJury = idJury;
    }

    public ConcoursAJury(int id, int idConcours, int idJury) {
        this.id = id;
        this.idConcours = idConcours;
        this.idJury = idJury;
    }

    public int getId() {
        return id;
    }

    public int getIdConcours() {
        return idConcours;
    }

    public int getIdJury() {
        return idJury;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConcoursAJury that = (ConcoursAJury) o;
        return id == that.id && idConcours == that.idConcours && idJury == that.idJury;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idConcours, idJury);
    }

    @Override
    public String toString() {
        return "ConcoursAJury{" +
                "id=" + id +
                ", idConcours=" + idConcours +
                ", idJury=" + idJury +
                '}';
    }
}
