package hei.concours.hei.repository;

import hei.concours.hei.connection.DatabaseConnection;
import hei.concours.hei.model.Concours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ConcoursRepository implements ConcoursDAO{
    private DatabaseConnection connection;
    @Autowired
    public ConcoursRepository(DatabaseConnection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Concours concours) {
        String sql = "INSERT INTO concours(annee,date_concours,description,frais)" +
                "VALUES(?,?,?,?)";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
            PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setInt(1,concours.getAnnee());
            statement.setDate(2, Date.valueOf(concours.getDateConcours()));
            statement.setString(3,concours.getDescription());
            statement.setDouble(4,concours.getFrais());
            statement.executeUpdate();
            } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Concours> findAllConcours() {
        List<Concours> concoursList = new ArrayList<>();
        String sql = "SELECT * FROM concours";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        Statement statement = connection1.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                concoursList.add(new Concours(
                        resultSet.getInt("id"),
                        resultSet.getInt("annee"),
                        resultSet.getDate("date_concours").toLocalDate(),
                        resultSet.getString("description"),
                        resultSet.getDouble("frais")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return concoursList;
    }

    @Override
    public List<Concours> findConcoursById(int id) {
        List<Concours> concoursList = new ArrayList<>(1);
        String sql = "SELECT * FROM concours WHERE id=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                concoursList.add(new Concours(
                        resultSet.getInt("annee"),
                        resultSet.getDate("date_concours").toLocalDate(),
                        resultSet.getString("description"),
                        resultSet.getDouble("frais")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return concoursList;
    }

    @Override
    public List<Concours> findConcoursByDate(LocalDate date) {
        List<Concours> concoursList = new ArrayList<>();
        String sql = "SELECT * FROM concours WHERE date_concours=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setDate(1,Date.valueOf(date));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                concoursList.add(new Concours(
                        resultSet.getInt("id"),
                        resultSet.getInt("annee"),
                        resultSet.getDate("date_concours").toLocalDate(),
                        resultSet.getString("description"),
                        resultSet.getDouble("frais")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return concoursList;
    }

    @Override
    public void updateDateConcoursByDate(LocalDate date, LocalDate newDate) {
        String sql = "UPDATE concours SET date_concours=? WHERE date_concours=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setDate(1,Date.valueOf(newDate));
            statement.setDate(2,Date.valueOf(date));
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteConcoursById(int id) {
        String sql = "DELETE FROM concours WHERE id=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteConcoursByDate(LocalDate date) {
        String sql = "DELETE FROM concours WHERE date_concours=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setDate(1,Date.valueOf(date));
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
