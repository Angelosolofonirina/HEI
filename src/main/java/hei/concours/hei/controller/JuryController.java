package hei.concours.hei.controller;

import hei.concours.hei.model.Jury;
import hei.concours.hei.service.JuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jury")
public class JuryController {
    private JuryService juryService;
    @Autowired
    public JuryController(JuryService juryService){
        this.juryService = juryService;
    }
    @PostMapping("/")
    public String addJury(@RequestBody Jury jury){
        return juryService.insert(jury);
    }
    @GetMapping("/")
    public List<Jury> getAllJury(){
        return juryService.findAll();
    }
    @GetMapping("/{id}")
    public List<Jury> getJuryById(@PathVariable int id){
        return juryService.findById(id);
    }
    @PatchMapping
    public String updateMailById(@PathVariable int id,@RequestParam("nouvelleAdresse") String nouvelleAdresseEmail) {
        return juryService.updateEmailById(id,nouvelleAdresseEmail);
    }
    @DeleteMapping
    public String deleteJuryById(@RequestParam("id") int id){
        return juryService.deleteById(id);
    }
}
