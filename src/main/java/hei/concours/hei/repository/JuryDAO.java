package hei.concours.hei.repository;

import hei.concours.hei.model.Jury;

import java.util.List;

public interface JuryDAO {
    public abstract void insert(Jury jury);
    public abstract List<Jury> findAllJury();
    public abstract List<Jury> findJuryById(int id);
    public abstract void updateAdresseEmailById(int id,String nouvelleAdresse);
    public abstract void deleteJuryById(int id);
}
