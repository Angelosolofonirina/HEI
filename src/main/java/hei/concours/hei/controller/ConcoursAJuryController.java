package hei.concours.hei.controller;

import hei.concours.hei.model.ConcoursAJury;
import hei.concours.hei.model.Jury;
import hei.concours.hei.service.ConcoursAJuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concours/jury")
public class ConcoursAJuryController {
    private ConcoursAJuryService concoursAJuryService;
    @Autowired
    public ConcoursAJuryController(ConcoursAJuryService concoursAJuryService){
        this.concoursAJuryService = concoursAJuryService;
    }
    @PostMapping("/")
    public String addConcoursAJury(@RequestBody ConcoursAJury concoursAJury){
        return concoursAJuryService.insert(concoursAJury);
    }
    @GetMapping("/")
    public List<Jury> getAllJuryByConcoursId(@RequestParam("concoursId") int concoursId){
        return concoursAJuryService.findAllJuryByConcoursId(concoursId);
    }
}
