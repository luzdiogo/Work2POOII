package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	private static Connection conexao;
	
	//Obter as propriedades de conexão: JAVA - DATABASE
	public static Properties getPropriedades() throws IOException, SQLException {
		Properties propriedades = new Properties();
		FileInputStream file = new FileInputStream("./properties/db.properties");
		propriedades.load(file);
		return propriedades;
	}
	//Criar uma conexão: JAVA - DATABASE
	public static Connection getConexao() throws IOException, SQLException {
		String host;
		String user;
		String password;
		Properties prop = DB.getPropriedades();
		
		host = prop.getProperty("host");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		//Gerenciar conexão com o Banco de Dados
		conexao = DriverManager.getConnection(host, user, password);
		return conexao;
	}
	//Fechar uma conexão: JAVA - DATABASE
	public static void CloseConnection() throws SQLException {
		if (conexao != null) {
			conexao.close();
		}	
	}	
}