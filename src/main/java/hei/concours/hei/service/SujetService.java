package hei.concours.hei.service;

import hei.concours.hei.model.Sujet;
import hei.concours.hei.repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SujetService {
    private SujetRepository sujetRepository;
    @Autowired
    public SujetService(SujetRepository sujetRepository){
        this.sujetRepository = sujetRepository;
    }
    public String insertSujet(Sujet sujet){
        sujetRepository.insert(sujet);
        return "sujet inseré avec succès";
    }
    public List<Sujet> findAll(){
        return sujetRepository.findAllSujet();
    }
    public String updateSujetMathsById(int id,String nouveauSujetMaths){
        sujetRepository.updateSujetMathsById(id,nouveauSujetMaths);
        return "Mise à jour avec succès";
    }
    public String deleteById(int id){
        sujetRepository.deleteSujetById(id);
        return "Sujet supprimé";
    }
}
