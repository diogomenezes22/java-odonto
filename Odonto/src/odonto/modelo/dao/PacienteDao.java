package odonto.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import ondoto.framework.dao.CreateDaoException;
import ondoto.framework.dao.DaoHelper;
import odonto.modelo.entidade.Paciente;

/**
 * 
 * @author luan
 *
 */

public class PacienteDao {

	private DaoHelper daoHelper;
	
	
	public PacienteDao() {
		daoHelper = new DaoHelper();
	}
	
	public void inserir (Paciente paciente) throws CreateDaoException {
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			
			conn = daoHelper.getConnection();
			int index = 0;
			stm = conn.prepareStatement("insert into paciente (nome, rg, cpf, sexo) values (?, ?, ?, ?)");
			stm.setString(++index, paciente.getNome());
			stm.setString(++index, paciente.getRg());
			stm.setString(++index, paciente.getCpf());
			stm.setString(++index, paciente.getSexo().toString());
			stm.executeUpdate();
			
		} catch (SQLException e) {
			throw new CreateDaoException("Não foi possivel realizar a transação!", e);
			
		} finally {
			daoHelper.realeseAll(conn, stm);
		}
		
		
		
	}
}
