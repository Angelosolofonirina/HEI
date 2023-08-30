package hei.concours.hei.repository;

import hei.concours.hei.connection.DatabaseConnection;
import hei.concours.hei.model.Jury;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class JuryRepository implements JuryDAO{
    private DatabaseConnection connection;
    @Autowired
    public JuryRepository(DatabaseConnection connection){
        this.connection = connection;
    }
    @Override
    public void insert(Jury jury) {
        String sql = "INSERT INTO jury(prenom,nom,numero_telephone,adresse_email)" +
                "VALUES(?,?,?,?)";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
            PreparedStatement statement = connection1.prepareStatement(sql)) {
            statement.setString(1,jury.getPrenom());
            statement.setString(2,jury.getNom());
            statement.setString(3,jury.getNumeroTelephone());
            statement.setString(4,jury.getAdresseEmail());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Jury> findAllJury() {
        List<Jury> juries = new ArrayList<>();
        String sql = "SELECT * FROM jury";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection1.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                juries.add(new Jury(
                        resultSet.getInt("id"),
                        resultSet.getString("prenom"),
                        resultSet.getString("nom"),
                        resultSet.getString("numero_telephone"),
                        resultSet.getString("adresse_email")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return juries;
    }

    @Override
    public List<Jury> findJuryById(int id) {
        List<Jury> juryList = new ArrayList<>(1);
        String sql = "SELECT * FROM jury WHERE id=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                juryList.add(new Jury(
                   resultSet.getString("prenom"),
                   resultSet.getString("nom"),
                   resultSet.getString("numero_telephone"),
                   resultSet.getString("adresse_email")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return juryList;
    }

    @Override
    public void updateAdresseEmailById(int id,String nouvelleAdresse) {
        String sql = "UPDATE FROM jury SET adresse_email=? WHERE id=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setString(1,nouvelleAdresse);
            statement.setInt(2,id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteJuryById(int id) {
        String sql = "DELETE FROM jury WHERE id=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
