package hei.concours.hei.service;

import hei.concours.hei.connection.DatabaseConnection;
import hei.concours.hei.model.Etudiant;
import hei.concours.hei.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    private DatabaseConnection connection;
    private EtudiantRepository etudiantRepository;
    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository){
        this.etudiantRepository = etudiantRepository;
    }
    public String insertEtudiant(Etudiant etudiant){
        etudiantRepository.insert(etudiant);
        return "Etudiant inseré avec succès";
    }
    public List<Etudiant> findAll(){
        return etudiantRepository.findAllEtudiant();
    }
    public List<Etudiant> findById(int id){
        return etudiantRepository.findEtudiantById(id);
    }
    public List<Etudiant> findByConcoursId(int concoursId) {
        return etudiantRepository.findEtudiantByConcoursId(concoursId);
    }
    public String updateEmailById(int id,String adresseEmail){
        etudiantRepository.updateAdresseEmailById(id,adresseEmail);
        return "Mise à jour avec succès";
    }
    public String deleteById(int id){
        etudiantRepository.deleteEtudiantById(id);
        return "Etudiant id:"+id+" supprimé";
    }
}
