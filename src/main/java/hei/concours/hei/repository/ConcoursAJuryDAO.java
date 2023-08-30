package hei.concours.hei.repository;

import hei.concours.hei.model.Concours;
import hei.concours.hei.model.ConcoursAJury;
import hei.concours.hei.model.Jury;

import java.util.List;

public interface ConcoursAJuryDAO {
    public abstract void insertConcoursAJury(ConcoursAJury concoursAJury);
    public abstract List<ConcoursAJury> findAllConcoursAJury();
    public abstract List<Jury> findAllJuryByConcoursId(int concoursId);
}
