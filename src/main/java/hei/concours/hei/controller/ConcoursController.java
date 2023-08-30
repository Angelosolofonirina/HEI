package hei.concours.hei.controller;

import hei.concours.hei.model.Concours;
import hei.concours.hei.service.ConcoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/concours")
public class ConcoursController {
    private ConcoursService concoursService;
    @Autowired
    public ConcoursController(ConcoursService concoursService){
        this.concoursService = concoursService;
    }
    @PostMapping("/")
    public String addConcours(@RequestBody Concours concours){
        return concoursService.insertConcours(concours);
    }
    @GetMapping("/")
    public List<Concours> getAllConcours(){
        return concoursService.findAll();
    }
    @GetMapping("/{id}")
    public List<Concours> getConcoursById(@PathVariable int id){
        return concoursService.findById(id);
    }
    @GetMapping
    public List<Concours> getConcoursByDate(@RequestParam("date") LocalDate date){
        return concoursService.findByDate(date);
    }
    @PatchMapping
    public String updateDateConcoursByDate(@RequestParam("date") LocalDate date,@RequestParam("newDate") LocalDate newDate){
        return concoursService.updateDateByDate(date,newDate);
    }
    @DeleteMapping("/{id}")
    public String deleteConcoursById(@PathVariable int id){
        return concoursService.deleteById(id);
    }
    @DeleteMapping
    public String deleteConcoursByDate(@RequestParam("date") LocalDate date){
        return concoursService.deleteByDate(date);
    }
}
