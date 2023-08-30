package hei.concours.hei.service;

import hei.concours.hei.connection.DatabaseConnection;
import hei.concours.hei.model.ConcoursAJury;
import hei.concours.hei.model.Jury;
import hei.concours.hei.repository.ConcoursAJuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcoursAJuryService {
    private DatabaseConnection connection;
    private ConcoursAJuryRepository concoursAJuryRepository;
    @Autowired
    public ConcoursAJuryService(ConcoursAJuryRepository concoursAJuryRepository){
        this.concoursAJuryRepository = concoursAJuryRepository;
    }
    public String insert(ConcoursAJury concoursAJury){
        concoursAJuryRepository.insertConcoursAJury(concoursAJury);
        return "inseré avec succès";
    }
    public List<ConcoursAJury> findAll(){
        return concoursAJuryRepository.findAllConcoursAJury();
    }
    public List<Jury> findAllJuryByConcoursId(int concoursId){
        return concoursAJuryRepository.findAllJuryByConcoursId(concoursId);
    }
}
