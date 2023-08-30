package hei.concours.hei.controller;

import hei.concours.hei.model.Sujet;
import hei.concours.hei.service.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sujet")
public class SujetController {
    private SujetService sujetService;
    @Autowired
    public SujetController(SujetService sujetService){
        this.sujetService = sujetService;
    }
    @PostMapping("/")
    public String addSujet(@RequestBody Sujet sujet){
        return sujetService.insertSujet(sujet);
    }
    @GetMapping("/")
    public List<Sujet> getAllSujet(){
        return sujetService.findAll();
    }
    @PatchMapping("/{id}")
    public String updateMathsById(@PathVariable int id,@RequestParam("nouveauSujet") String nouveauSujet){
        return sujetService.updateSujetMathsById(id,nouveauSujet);
    }
    @DeleteMapping
    public String deleteSujetById(@RequestParam("id") int id){
        return sujetService.deleteById(id);
    }
}
