package hei.concours.hei.repository;

import hei.concours.hei.model.Sujet;

import java.util.List;

public interface SujetDAO {
    public abstract void insert(Sujet sujet);
    public abstract List<Sujet> findAllSujet();
    public abstract void updateSujetMathsById(int id,String nouveauSujet);
    public abstract void deleteSujetById(int id);
}
