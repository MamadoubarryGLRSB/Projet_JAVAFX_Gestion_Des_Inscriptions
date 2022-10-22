package ism.inscriptions.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ism.inscriptions.core.MysqlDb;
import ism.inscriptions.entities.Etudiant;
import ism.inscriptions.repositories.IEtudiantRepository;

public class EtudiantRepository extends MysqlDb implements IEtudiantRepository {
    private final String SQL_INSERT="INSERT INTO `user` (`nom_complet`,`matricule`, `tuteur`,`role`,`classe_id`) VALUES (?,?,?,?,?)";
    private final String SQL_SELECT_ALL="select * from user where role like 'ROLE_ETUDIANT' ";
    private final String SQL_SELECT_INSCRITS_ANNEE="select * from user u,inscription i,classe c where "
                                                     + "  role like 'ROLE_ETUDIANT' and  "
                                                     + "  u.id_user=i.etu_id and i.classe_id=c.id_classe"
                                                     + "  and annee_scolaire like ?";
    private final String SQL_SELECT_BY_MATRICULE="select * from user where role like 'ROLE_ETUDIANT' and matricule like ? ";
    private final String SQL_SELECT_INSCRITS_ANNEE_CLASSE="select * from user u,inscription i,classe c where "
                                                     + "  role like 'ROLE_ETUDIANT' and  "
                                                     + "  u.id_user=i.etu_id and i.classe_id=c.id_classe"
                                                     + "  and annee_scolaire like ?"
                                                     + "  and c.id_classe=?";
    ClasseRepository classeRepository=new ClasseRepository();
    @Override
    public Etudiant insert(Etudiant etu) {
        this.ouvrirConnexionBd();
        try {
                ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1,etu.getNom_complet());  
                ps.setString(2,etu.getMatricule());
                ps.setString(3,etu.getTuteur());
                ps.setString(4,etu.getRole());
                ps.setInt(5,etu.getClasse().getId());
                ps.executeUpdate();
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()){

                    etu.setId(rs.getInt(1));
                }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBd();
        return etu;
    }
    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants=new ArrayList<>();
        this.ouvrirConnexionBd();
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=    stm.executeQuery(SQL_SELECT_ALL);
            while(rs.next()){
                    Etudiant etu =new Etudiant(rs.getInt("id"), 
                                                rs.getString("nom_complet"), 
                                                rs.getString("matricule"),
                                                rs.getString("tuteur"));
                                                
                                            
                etudiants.add(etu);
                }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBd();
        return etudiants;
    }

    @Override
    public List<Etudiant> findAll(String annee) {
        List<Etudiant> etudiants=new ArrayList<>();
        this.ouvrirConnexionBd();
        
        try {
            ps=conn.prepareStatement(SQL_SELECT_INSCRITS_ANNEE);
            ps.setString(1,annee);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Etudiant etu =new Etudiant(rs.getInt("id"), 
                                            rs.getString("nom_complet"), 
                                            rs.getString("matricule"),
                                            rs.getString("tuteur"));
                    etu.setClasse(classeRepository.findById(rs.getInt("id_classe")));
                etudiants.add(etu);
                }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBd();
        return etudiants;
    }
    
    @Override
    public Etudiant findByMatricule(String matricule) {
        Etudiant etudiant=null;
        this.ouvrirConnexionBd();
        try {
            //recuperez le dernier id qui a ete inserer
            ps=conn.prepareStatement(SQL_SELECT_BY_MATRICULE);
            ps.setString(1,matricule);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                                etudiant =new Etudiant(rs.getInt("id"), 
                                rs.getString("nom_complet"), 
                                rs.getString("matricule"),
                                rs.getString("tuteur"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBd();
        return etudiant;
    }
    @Override
    public List<Etudiant> findAll(String annee, int idclasse) {
        List<Etudiant> etudiants=new ArrayList<>();
        this.ouvrirConnexionBd();
        
        try {
            ps=conn.prepareStatement(SQL_SELECT_INSCRITS_ANNEE_CLASSE);
            ps.setString(1, annee);
            ps.setInt(2, idclasse);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                                Etudiant etu =new Etudiant(rs.getInt("id"), 
                                rs.getString("nom_complet"), 
                                rs.getString("matricule"),
                                rs.getString("tuteur"));
                etu.setClasse(classeRepository.findById(rs.getInt("classe_id")));
                etudiants.add(etu);
                }
            
        } catch (SQLException e) {
        
            e.printStackTrace();
        }
        this.fermerConnexionBd();
        return etudiants;
    }
    
}
