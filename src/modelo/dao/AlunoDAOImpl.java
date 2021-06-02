package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.Aluno;

public class AlunoDAOImpl implements AlunoDAO {

	private Connection conexao;
	
	public AlunoDAOImpl(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Aluno obj) {
		//Define parêmetros para inserir dados no DB SQL (INSERT)
		try {		
		PreparedStatement pst = conexao.prepareStatement (
			"INSERT INTO aluno "
			+ "(nome, sexo) "
			+ "VALUES (?, ?);", 
			Statement.RETURN_GENERATED_KEYS
		);
			pst.setString(1, obj.getNome());
			pst.setString(2, obj.getSexo());
			/*pst.setDate(3, new java.sql.Date(obj.getDt_nasc().getTime())); */

			int linhas = pst.executeUpdate();
			
			if (linhas > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					obj.setId(rs.getInt(1));
				}
			}
		}
		catch(SQLException e) {
		e.printStackTrace();
	}	
	}
	@Override
	public void update(Aluno obj) {
		//Define parêmetros para inserir dados no DB SQL (UPDATE)
		try {		
			PreparedStatement pst = conexao.prepareStatement (
				"UPDATE aluno "
				+ "SET nome= ?, sexo= ? "
				+ "WHERE id= ?;"
			);
				pst.setString(1, obj.getNome());
				pst.setString(2, obj.getSexo());
				/*pst.setDate(3, new java.sql.Date(obj.getDt_nasc().getTime())); */
				pst.setInt(3,  obj.getId());
				
				pst.executeUpdate();
			}
			catch(SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	//Define parêmetros para inserir dados no DB SQL (DELETE)
	public void deleteByid(int id) {
		PreparedStatement pst = null;
		try {
			pst = conexao.prepareStatement(
					"DELETE FROM aluno WHERE id= ?");
			pst.setInt(1, id);		
			pst.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
	}	

	@Override
	//Define parêmetros para inserir dados no DB SQL (SELECT BY ID)
	public Aluno findByid(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conexao.prepareStatement(
					"SELECT a.* "
					+ "FROM aluno a "
					+ "WHERE id = ?");
			pst.setInt(1, id);		
			rs = pst.executeQuery();
			
			if(rs.next()) {
				Aluno a = new Aluno();
				a.setId(rs.getInt(0));
				a.setNome(rs.getString(1));
				a.setSexo(rs.getString(2));
				/* a.setDt_nasc(rs.getDate(3)); */
				return a;
			}
			return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Aluno> getLista() {
		
		try {
			List<Aluno> alunos = new ArrayList<Aluno>();
			PreparedStatement pst = this.conexao.
					prepareStatement("SELECT * FROM aluno");		
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Aluno obj = new Aluno();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setSexo(rs.getString("sexo"));	
				
				alunos.add(obj);
			}
			rs.close();
			pst.close();
			return alunos;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}