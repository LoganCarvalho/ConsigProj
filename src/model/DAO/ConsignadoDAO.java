package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Bean.Consignado;

public class ConsignadoDAO {
	
	 public double consultar(Consignado consig) throws Exception {

	        Connection conexao = ConnectionFactory.getConnection();
	        ResultSet resposta = null;
	        double ok;
	        StringBuilder sql = new StringBuilder();

	        try {
	            sql.append("select * tabelaConsignado");
	            sql.append(" where matricula_aluno = ?");
	            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
	            stmt.setString(1, consig.getCpf());
	           
	            
	            resposta = stmt.executeQuery();
	            while (resposta.next()) { 
	                aluno.setMatricula(Integer.parseInt(resposta.getString("matricula_aluno")));
	                aluno.setNome(resposta.getString("nome_aluno"));
	                aluno.setSaldo(Integer.parseInt(resposta.getString("saldo_aluno")));
	                aluno.setTurma(resposta.getString("turma_aluno"));
	                aluno.setTurno(resposta.getString("turno_aluno"));
	                   
	                //ok =; //valor double;
	            }
	        } catch (SQLException error) {
	            System.out.println(error.getMessage());
	        } finally {
	            if (conexao != null) {
	                ConnectionFactory.FecharConexao(conexao, null, resposta);
	            }
	        }
	        return ok;
	    }

}
