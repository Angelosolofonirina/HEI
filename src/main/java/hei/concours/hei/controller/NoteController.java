package hei.concours.hei.controller;

import hei.concours.hei.model.Note;
import hei.concours.hei.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;
    @Autowired
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }
    @PostMapping("/")
    public String addNote(@RequestBody Note note){
        return noteService.insertNote(note);
    }
    @GetMapping("/")
    public List<Note> getAllNoteDesc(){
        return noteService.findAll();
    }
    @GetMapping("/{etudiantId}")
    public List<Note> getNoteByEtudiantId(@PathVariable int etudiantId){
        return noteService.findByEtudiantId(etudiantId);
    }
    @PatchMapping
    public String updateNoteMathsByEtudiantId(@RequestParam("id") int etudiantId,@RequestParam("nouveauNote") Double nouveauNote){
        return noteService.updateMathsByEtudiantId(etudiantId,nouveauNote);
    }
    @DeleteMapping("/{id}")
    public String deleteNoteById(@PathVariable int id){
        return noteService.deleteById(id);
    }
}
