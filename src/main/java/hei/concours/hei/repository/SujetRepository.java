package hei.concours.hei.repository;

import hei.concours.hei.connection.DatabaseConnection;
import hei.concours.hei.model.Sujet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SujetRepository implements SujetDAO{
    private DatabaseConnection connection;
    @Autowired
    public SujetRepository(DatabaseConnection connection){
        this.connection = connection;
    }
    @Override
    public void insert(Sujet sujet) {
        String sql = "INSERT INTO sujet(url_sujet_maths,url_sujet_français,id_concours)" +
                "VALUES(?,?,?)";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
            PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setString(1,sujet.getUrlSujetMaths());
            statement.setString(2,sujet.getUrlSujetFrançais());
            statement.setInt(3,sujet.getIdConcours());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Sujet> findAllSujet() {
        List<Sujet> sujets = new ArrayList<>();
        String sql = "SELECT * FROM sujet";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection1.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                sujets.add(new Sujet(
                        resultSet.getInt("id"),
                        resultSet.getString("url_sujet_maths"),
                        resultSet.getString("url_sujet_français"),
                        resultSet.getInt("id_concours")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return sujets;
    }

    @Override
    public void updateSujetMathsById(int id, String nouveauSujet) {
        String sql = "UPDATE sujet SET url_sujet_maths=? WHERE id=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setString(1,nouveauSujet);
            statement.setInt(2,id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteSujetById(int id) {
       String sql = "DELETE FROM sujet WHERE id=?";
       try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
       PreparedStatement statement = connection1.prepareStatement(sql)){
           statement.setInt(1,id);
           statement.executeUpdate();
       }catch (SQLException e){
           System.out.println(e.getMessage());
       }
    }
}
