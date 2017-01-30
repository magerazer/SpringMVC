package fr.demos.formation.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import fr.demos.formation.model.Compte;

@Repository
public class CompteDAOMySQL implements CompteDAO {

	private Context context;
	@Resource(name="jdbc/SpringJava") 
	private DataSource dataSource;
	
	@Override
	public void insert(Compte c) throws Exception {
		
		try (Connection cx = dataSource.getConnection()) {
			PreparedStatement pstm = null;
			System.out.println("avant insert");
			
			
			pstm = cx.prepareStatement("INSERT INTO compte VALUES (?, ?, ?)");
			
			pstm.setString(1, c.getMail());
			pstm.setString(2, c.getNom());
			pstm.setString(3, c.getPrenom());
			pstm.setString(4, "1988");
			
			pstm.executeUpdate();

			// ResultSet rs = pstm.executeQuery();
			//
			// while (rs.next()) {
			// String mail = rs.getString("mail");
			// String pwd = rs.getString("pwd");
			//
			// c = new Compte(mail, pwd);
			// }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		

	}

}
