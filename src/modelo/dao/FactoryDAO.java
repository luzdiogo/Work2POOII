package modelo.dao;

import java.io.IOException;
import java.sql.SQLException;

import jdbc.DB;

public class FactoryDAO {

	public static AlunoDAO createAlunoDAO() throws IOException, SQLException {
		return new AlunoDAOImpl(DB.getConexao());
	}
}
