package hei.concours.hei.service;

import hei.concours.hei.connection.DatabaseConnection;
import hei.concours.hei.model.Jury;
import hei.concours.hei.repository.JuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuryService {
    private DatabaseConnection connection;
    private JuryRepository juryRepository;
    @Autowired
    public JuryService(JuryRepository juryRepository){
        this.juryRepository = juryRepository;
    }
    public String insert(Jury jury) {
        juryRepository.insert(jury);
        return "jury inseré avec succès";
    }
    public List<Jury> findAll(){
        return juryRepository.findAllJury();
    }
    public List<Jury> findById(int id){
        return juryRepository.findJuryById(id);
    }
    public String updateEmailById(int id,String adresseEmail) {
        juryRepository.updateAdresseEmailById(id,adresseEmail);
        return "Mise à jour avec succès";
    }
    public String deleteById(int id){
        juryRepository.deleteJuryById(id);
        return "Le jury id:"+id+" est supprimé";
    }
}
