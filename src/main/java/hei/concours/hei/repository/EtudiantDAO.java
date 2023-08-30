package hei.concours.hei.repository;
import hei.concours.hei.model.Etudiant;

import java.util.List;

public interface EtudiantDAO {
    public abstract void insert(Etudiant etudiant);
    public abstract List<Etudiant> findAllEtudiant();
    public abstract List<Etudiant> findEtudiantById(int id);
    public abstract List<Etudiant> findEtudiantByConcoursId(int concoursId);
    public abstract void updateAdresseEmailById(int id,String adresseEmail);
    public abstract void deleteEtudiantById(int id);
}
