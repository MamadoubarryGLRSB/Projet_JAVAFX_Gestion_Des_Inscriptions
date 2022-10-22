package ism.inscriptions.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ism.inscriptions.core.MysqlDb;
import ism.inscriptions.entities.Inscription;
import ism.inscriptions.repositories.IInscriptionRepository;

public class InscriptionRepository extends MysqlDb implements IInscriptionRepository {
    private final String SQL_INSERT="INSERT INTO `inscription` ( `date_inscription`, `annee`, `etu_id`) VALUES ( ?,?,?);";
    private final String SQL_SELECT_ALL="SELECT * FROM `inscription`";
    @Override
    public Inscription insert(Inscription insc) {
        this.ouvrirConnexionBd();
        try {
            //recuperez le dernier id qui a ete inserer
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1,insc.getDateInscription());
            ps.setString(2,insc.getAnnee());
            ps.setInt(3,insc.getEtu().getId());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){

                insc.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBd();
        return insc;
    }
    @Override
    public List<Inscription> findAll() {
        List<Inscription> inscriptions=new ArrayList<>();
        this.ouvrirConnexionBd();
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=    stm.executeQuery(SQL_SELECT_ALL);
            while(rs.next()){
                Inscription cl =new Inscription(
                         rs.getInt("id"),
                         rs.getString("dateInscription"),
                         rs.getString("annee"));
                    
                
              inscriptions.add(cl);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBd();
        return inscriptions;
        
    }
    
}
