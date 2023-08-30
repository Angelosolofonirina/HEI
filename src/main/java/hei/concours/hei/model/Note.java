package hei.concours.hei.model;

import java.util.Objects;

public class Note {
    private int id;
    private int idEtudiant;
    private int idConcours;
    private Double français;
    private Double mathematique;

    public Note(int idEtudiant, int idConcours, Double français, Double mathematique) {
        this.idEtudiant = idEtudiant;
        this.idConcours = idConcours;
        this.français = français;
        this.mathematique = mathematique;
    }

    public Note(int id, int idEtudiant, int idConcours, Double français, Double mathematique) {
        this.id = id;
        this.idEtudiant = idEtudiant;
        this.idConcours = idConcours;
        this.français = français;
        this.mathematique = mathematique;
    }

    public Note(int idEtudiant, Double français, Double mathematique) {
        this.idEtudiant = idEtudiant;
        this.français = français;
        this.mathematique = mathematique;
    }
    public Note(){}
    public int getId() {
        return id;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public int getIdConcours() {
        return idConcours;
    }

    public Double getFrançais() {
        return français;
    }

    public Double getMathematique() {
        return mathematique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id && idEtudiant == note.idEtudiant && idConcours == note.idConcours && Objects.equals(français, note.français) && Objects.equals(mathematique, note.mathematique);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idEtudiant, idConcours, français, mathematique);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", idEtudiant=" + idEtudiant +
                ", idConcours=" + idConcours +
                ", français=" + français +
                ", mathematique=" + mathematique +
                '}';
    }
}
