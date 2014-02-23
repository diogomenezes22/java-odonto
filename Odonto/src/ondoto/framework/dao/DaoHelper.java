/**
 * 
 */
package ondoto.framework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



/**
 * @author luan
 *
 */
public class DaoHelper {

	/**
	 * Fornecer conexão ao banco de dados
	 * @return Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		
		Connection conn = null;
		
		try {
			Class.forName("org.mysql.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/odonto", "root", "luan");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void realese(Statement stm) {
		if (stm == null) 
			return;
		
		try {
			stm.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar o Statemant!\n"
												+ "Erro: " + e.getMessage());
		}
		
	}
	
	public void realese(Connection conn) {
		if (conn == null) 
			return;
		
		try {
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar o Connection!\n"
												+ "Erro: " + e.getMessage());
		}
		
	}
	
	public void realese(ResultSet rs) {
		if (rs == null) 
			return;
		
		try {
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar o ResultSet\n"
												+ "Erro: " + e.getMessage());
		}
		
	}
	
	public void realeseAll(Connection conn, Statement stm) {
		realese(conn);
		realese(stm);
	}
	
	public void realeseAll(Connection conn, Statement stm, ResultSet rs) {
		realese(rs);
		realeseAll(conn, stm);
	}
	
	
}
