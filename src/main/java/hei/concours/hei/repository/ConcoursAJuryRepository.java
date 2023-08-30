package hei.concours.hei.repository;

import hei.concours.hei.connection.DatabaseConnection;
import hei.concours.hei.model.ConcoursAJury;
import hei.concours.hei.model.Jury;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ConcoursAJuryRepository implements ConcoursAJuryDAO{
    @Override
    public void insertConcoursAJury(ConcoursAJury concoursAJury) {
        String sql = "INSERT INTO concours_a_jury(id_concours,id_jury) VALUES" +
                "(?,?)";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
            PreparedStatement statement = connection1.prepareStatement(sql)){
               statement.setInt(1,concoursAJury.getIdConcours());
               statement.setInt(2,concoursAJury.getIdJury());
               statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<ConcoursAJury> findAllConcoursAJury() {
        List<ConcoursAJury> concoursAJuries = new ArrayList<>();
        String sql = "SELECT * FROM concours_a_jury";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                concoursAJuries.add(new ConcoursAJury(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_concours"),
                        resultSet.getInt("id_jury")
                        )
                );
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return concoursAJuries;
    }

    @Override
    public List<Jury> findAllJuryByConcoursId(int concoursId) {
        List<Jury> juries = new ArrayList<>();
        String sql = "SELECT jury.prenom,jury.nom FROM jury " +
                "INNER JOIN concours_a_jury ON " +
                "jury.id = concours_a_jury.id_jury INNER JOIN " +
                "concours ON concours_a_jury.id_concours = concours.id " +
                "WHERE concours.id=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setInt(1,concoursId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                juries.add(new Jury(
                        resultSet.getString("prenom"),
                        resultSet.getString("nom")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return juries;
    }
}
