package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato*;
//Parametrização para fazer com que o java se molde a uma estrutura relacional que é o BD
public class ContatoDAO {

	public void save(Contato contato) {
		//vai fazer um parse substituindo ? pelo parametro que vai chegar ai
		String sql = "INSERT INTO contatos(nome, idade, datacadastro) values(?,?,?)";
		
		Connection conn = null;
		//utilizar biblioteca para preparar a estrutura para executar a estrutura do java com o sql
		
		PreparedStatement pstm = null;
		
		
		try {
			//tenta criar connexão com bd
		conn = ConnectionFactory.createConnectionToMySQL();
		
		//criamos uma PreparedStatement para executar uma query
		pstm = (PreparedStatement) conn.prepareStatement(sql); 
		//add valores esperados pela query
		pstm.setString(1, contato.getNome());
		pstm.setInt(2, contato.getIdade());
		pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
		
		//executar query
		
		pstm.execute();
		}catch (Exception e) {
		e.printStackTrace();	
		}finally {
			//fechar as conexões
			try {
				if(pstm !=null) {
					pstm.close();
				}
				if(conn !=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
	
}
