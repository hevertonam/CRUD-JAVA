package br.com.agenda.factory;
//cria a conexão com banco

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//Nome do usuario do mysql
	private static final String USERNAME = "root";
	
	//senha
	private static final String PASSWORD = "@Ham271200";
	
	//caminho do BD, porta
	//jdbc - padrão que utiliza para fazer integração com bd. mapear com chega ao BD
	private static final String DATABASE_URL= "jdbc:mysql://localhost:3306/agenda";

//	criar forma para fazer conexão com BD
	
	public static Connection createConnectionToMySQL() throws Exception {
		//faz com que a class seja carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		
		//cria a conexão com o BD
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		 
		return connection;
	}
	
	public static void main(String[] args) {
		
		//recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testar se a conexão é nula
		if(con!=null) {
		System.out.println("Conexão obtida com sucesso!");
		con.close();
		}
	}
	
	
	
	
	
}
