package hei.concours.hei.repository;

import hei.concours.hei.connection.DatabaseConnection;
import hei.concours.hei.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class NoteRepository implements NoteDAO{
    private DatabaseConnection connection;
    @Autowired
    public NoteRepository(DatabaseConnection connection){
        this.connection = connection;
    }
    @Override
    public void insert(Note note) {
    String sql = "INSERT INTO note(id_etudiant,id_concours,français,mathematique) VALUES(?,?,?,?)";
    try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
        statement.setInt(1,note.getIdEtudiant());
        statement.setInt(2,note.getIdConcours());
        statement.setDouble(3,note.getFrançais());
        statement.setDouble(4,note.getMathematique());
        statement.executeUpdate();
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
    }

    @Override
    public List<Note> findAllNoteDesc() {
        List<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM note ORDER BY (français+mathematique) DESC";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection1.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                notes.add(new Note(
                        resultSet.getInt("id_etudiant"),
                        resultSet.getInt("id_concours"),
                        resultSet.getDouble("français"),
                        resultSet.getDouble("mathematique")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return notes;
    }

    @Override
    public List<Note> findNoteByEtudiantId(int etudiantId) {
        List<Note> noteList = new ArrayList<>(1);
        String sql = "SELECT * FROM etudiant WHERE id_etudiant=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setInt(1,etudiantId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                noteList.add(new Note(
                        resultSet.getInt("id_etudiant"),
                        resultSet.getInt("id_concours"),
                        resultSet.getDouble("français"),
                        resultSet.getDouble("mathematique")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return noteList;
    }
    @Override
    public void updateNoteMathsByEtudiantId(int etudiantId, Double nouveauNote) {
        String sql = "UPDATE FROM note SET mathematique=? WHERE id=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setInt(1,etudiantId);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteNoteById(int id) {
        String sql = "DELETE FROM note WHERE id=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
