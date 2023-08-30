package hei.concours.hei.repository;

import hei.concours.hei.model.Concours;

import java.time.LocalDate;
import java.util.List;

public interface ConcoursDAO {
    public abstract void insert(Concours concours);
    public abstract List<Concours> findAllConcours();
    public abstract List<Concours> findConcoursById(int id);
    public abstract List<Concours> findConcoursByDate(LocalDate date);
    public abstract void updateDateConcoursByDate(LocalDate date,LocalDate newDate);
    public abstract void deleteConcoursById(int id);
    public abstract void deleteConcoursByDate(LocalDate date);
}
