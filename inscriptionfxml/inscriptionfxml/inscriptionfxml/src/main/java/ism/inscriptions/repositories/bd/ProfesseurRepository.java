package ism.inscriptions.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import ism.inscriptions.core.MysqlDb;
import ism.inscriptions.entities.Professeur;
import ism.inscriptions.repositories.IProfesseurRepository;

public class ProfesseurRepository extends MysqlDb implements IProfesseurRepository {
    private final String SQL_INSERT="INSERT INTO `user` (`nom_complet`,`nci`, `grade`,`role`) VALUES (?,?, ?,?)";
    private final String SQL_SELECT_ALL="select * from user where role like 'ROLE_PROFESSEUR' ";
    private final String SQL_SELECT_BY_ID="select * from user where role like 'ROLE_PROFESSEUR' and id_user=? ";
    private final String SQL_SELECT_BY_NCI="select * from user where role like 'ROLE_PROFESSEUR' and nci like ? ";
    AffectationRepository affDao=new AffectationRepository();
    @Override
    public Professeur insert(Professeur prof) {
        this.ouvrirConnexionBd();
        try {
            //recuperez le dernier id qui a ete inserer
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,prof.getNom_complet());
            ps.setString(2,prof.getNci());
            ps.setString(3,prof.getGrade());
            ps.setString(4,prof.getRole());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                prof.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBd();
        return prof;
    }

    @Override
    public Professeur findById(int id) {
        Professeur prof=null;
        this.ouvrirConnexionBd();
        try {
            //recuperez le dernier id qui a ete inserer
            ps=conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                prof =new Professeur(rs.getInt("id"), 
                                              rs.getString("nom_complet"), 
                                              rs.getString("grade"), 
                                              rs.getString("nci")); 
                                
                

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            this.fermerConnexionBd();
            return prof;
    }

    @Override
    public List<Professeur> findAll() {
        List<Professeur> profs=new ArrayList<>();
        this.ouvrirConnexionBd();
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=    stm.executeQuery(SQL_SELECT_ALL);
            while(rs.next()){
                         Professeur   prof =new Professeur(rs.getInt("id"), 
                            rs.getString("nom_complet"), 
                            rs.getString("grade"), 
                            rs.getString("nci")); 
                        profs.add(prof);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBd();
        return profs;
        
    }

    @Override
    public Professeur findByNci(String nci) {
        Professeur prof=null;
        this.ouvrirConnexionBd();
        try {
            //recuperez le dernier id qui a ete inserer
            ps=conn.prepareStatement(SQL_SELECT_BY_NCI);
            ps.setString(1, nci);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                  prof =new Professeur(rs.getInt("id"), 
                            rs.getString("nom_complet"), 
                            rs.getString("grade"), 
                            rs.getString("nci")); 
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBd();
        return prof;
    }
    
}
