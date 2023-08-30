package hei.concours.hei.service;

import hei.concours.hei.connection.DatabaseConnection;
import hei.concours.hei.model.Concours;
import hei.concours.hei.repository.ConcoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ConcoursService {
    private DatabaseConnection connection;
    private ConcoursRepository concoursRepository;
    @Autowired
    public ConcoursService(ConcoursRepository concoursRepository){
        this.concoursRepository = concoursRepository;
    }
    public String insertConcours(Concours concours){
        concoursRepository.insert(concours);
        return "Concours inseré avec succès";
    }
    public List<Concours> findAll(){
        return concoursRepository.findAllConcours();
    }
    public List<Concours> findById(int id){
        return concoursRepository.findConcoursById(id);
    }
    public List<Concours> findByDate(LocalDate date){
        return concoursRepository.findConcoursByDate(date);
    }
    public String updateDateByDate(LocalDate date,LocalDate newDate){
        concoursRepository.updateDateConcoursByDate(date,newDate);
        return "Mise à jour avec succès";
    }
    public String deleteById(int id){
        concoursRepository.deleteConcoursById(id);
        return "Concours supprimé";
    }
    public String deleteByDate(LocalDate date){
        concoursRepository.deleteConcoursByDate(date);
        return "Le concours est supprimé ";
    }
}
