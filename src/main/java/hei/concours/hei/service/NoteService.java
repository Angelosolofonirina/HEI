package hei.concours.hei.service;

import hei.concours.hei.connection.DatabaseConnection;
import hei.concours.hei.model.Note;
import hei.concours.hei.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private DatabaseConnection connection;
    private NoteRepository noteRepository;
    @Autowired
    public NoteService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }
    public String insertNote(Note note){
        noteRepository.insert(note);
        return "Note ajouté avec succès";
    }
    public List<Note> findAll(){
        return noteRepository.findAllNoteDesc();
    }
    public List<Note> findByEtudiantId(int etudiantId){
        return noteRepository.findNoteByEtudiantId(etudiantId);
    }
    public String updateMathsByEtudiantId(int etudiantId,Double note){
        noteRepository.updateNoteMathsByEtudiantId(etudiantId,note);
        return "Mise à jour avec succès";
    }
    public String deleteById(int id){
        noteRepository.deleteNoteById(id);
        return "note supprimé";
    }
}
