package hei.concours.hei.repository;

import hei.concours.hei.connection.DatabaseConnection;
import hei.concours.hei.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class EtudiantRepository implements EtudiantDAO{
    private DatabaseConnection connection;
    @Autowired
    public EtudiantRepository(DatabaseConnection connection){
        this.connection = connection;
    }
    @Override
    public void insert(Etudiant etudiant) {
        String sql = "INSERT INTO etudiant(prenom,nom,numero_telephone," +
                "adresse_email,photo_identite,image_bulletin_terminale," +
                "serie_bacc,photocopie_note_bacc_certifie,photocopie_cin_certifie," +
                "date_inscription,concour_id) VALUES(?,?,?,?,?)";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setString(1, etudiant.getPrenom());
            statement.setString(2, etudiant.getNom());
            statement.setString(3, etudiant.getNumeroTelephone());
            statement.setString(4, etudiant.getAdresseEmail());
            statement.setString(5, etudiant.getPhotoIdentite());
            statement.setString(6, etudiant.getImageBulletinTerminale());
            statement.setString(7, etudiant.getSerieBacc());
            statement.setString(8, etudiant.getPhotocopieNoteBaccCertifie());
            statement.setString(9, etudiant.getPhotocopieCinCertifie());
            statement.setDate(10,Date.valueOf(etudiant.getDateInscription()));
            statement.setInt(11, etudiant.getConcoursId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Etudiant> findAllEtudiant() {
        List<Etudiant> etudiantList = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection1.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                etudiantList.add(new Etudiant(
                        resultSet.getInt("id"),
                        resultSet.getString("prenom"),
                        resultSet.getString("nom"),
                        resultSet.getString("numero_telephone"),
                        resultSet.getString("adresse_email"),
                        resultSet.getString("photo_identite"),
                        resultSet.getString("image_bulletin_terminale"),
                        resultSet.getString("serie_bacc"),
                        resultSet.getString("photocopie_note_bacc_certifie"),
                        resultSet.getString("photocopie_cin_certifie"),
                        resultSet.getDate("date_inscription").toLocalDate(),
                        resultSet.getInt("concour_id")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return etudiantList;
    }
    @Override
    public List<Etudiant> findEtudiantById(int id) {
        List<Etudiant> etudiantList = new ArrayList<>(1);
        String sql = "SELECT * FROM etudiant WHERE id=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                etudiantList.add(new Etudiant(
                        resultSet.getInt("id"),
                        resultSet.getString("prenom"),
                        resultSet.getString("nom"),
                        resultSet.getString("numero_telephone"),
                        resultSet.getString("adresse_email"),
                        resultSet.getString("photo_identite"),
                        resultSet.getString("image_bulletin_terminale"),
                        resultSet.getString("serie_bacc"),
                        resultSet.getString("photocopie_note_bacc_certifie"),
                        resultSet.getString("photocopie_cin_certifie"),
                        resultSet.getDate("date_inscription").toLocalDate(),
                        resultSet.getInt("concour_id")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return etudiantList;
    }

    @Override
    public List<Etudiant> findEtudiantByConcoursId(int concoursId) {
        List<Etudiant> etudiantList = new ArrayList<>(1);
        String sql = "SELECT * FROM etudiant WHERE concour_id=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setInt(1,concoursId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                etudiantList.add(new Etudiant(
                        resultSet.getInt("id"),
                        resultSet.getString("prenom"),
                        resultSet.getString("nom"),
                        resultSet.getString("numero_telephone"),
                        resultSet.getString("adresse_email"),
                        resultSet.getString("photo_identite"),
                        resultSet.getString("image_bulletin_terminale"),
                        resultSet.getString("serie_bacc"),
                        resultSet.getString("photocopie_note_bacc_certifie"),
                        resultSet.getString("photocopie_cin_certifie"),
                        resultSet.getDate("date_inscription").toLocalDate(),
                        resultSet.getInt("concour_id")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return etudiantList;
    }

    @Override
    public void updateAdresseEmailById(int id,String adresseEmail) {
       String sql = "UPDATE FROM etudiant SET adresse_email=? WHERE id=?";
       try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
       PreparedStatement statement = connection1.prepareStatement(sql)){
          statement.setString(1,adresseEmail);
          statement.setInt(2,id);
          statement.executeUpdate();
       }catch (SQLException e){
           System.out.println(e.getMessage());
       }
    }

    @Override
    public void deleteEtudiantById(int id) {
        String sql = "DELETE FROM etudiant WHERE id=?";
        try(Connection connection1 = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = connection1.prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
