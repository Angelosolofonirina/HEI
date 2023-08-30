package hei.concours.hei.repository;

import hei.concours.hei.model.Note;

import java.util.List;

public interface NoteDAO {
    public abstract void insert(Note note);
    public abstract List<Note> findAllNoteDesc();
    public abstract List<Note> findNoteByEtudiantId(int etudiantId);
    public abstract void updateNoteMathsByEtudiantId(int etudiantId,Double nouveauNote);
    public abstract void deleteNoteById(int id);
}
