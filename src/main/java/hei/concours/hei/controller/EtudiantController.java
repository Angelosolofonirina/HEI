package hei.concours.hei.controller;

import hei.concours.hei.model.Etudiant;
import hei.concours.hei.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    private EtudiantService etudiantService;
    @Autowired
    public EtudiantController(EtudiantService etudiantService){
        this.etudiantService = etudiantService;
    }
    @PostMapping("/")
    public String addEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.insertEtudiant(etudiant);
    }
    @GetMapping("/")
    public List<Etudiant> getAllEtudiant(){
        return etudiantService.findAll();
    }
    @GetMapping("/{id}")
    public List<Etudiant> getEtudiantById(@PathVariable int id){
        return etudiantService.findById(id);
    }
    @GetMapping
    public List<Etudiant> getAllEtudiantByConcoursId(@RequestParam("concoursId") int concoursId){
        return etudiantService.findByConcoursId(concoursId);
    }
    @PatchMapping("/{id}")
    public String updateAdresseEmailById(@PathVariable int id,@RequestParam("nouveauEmail") String nouveauEmail){
        return etudiantService.updateEmailById(id,nouveauEmail);
    }
    @DeleteMapping
    public String deleteEtudiantById(@RequestParam("id") int id){
        return etudiantService.deleteById(id);
    }
}
