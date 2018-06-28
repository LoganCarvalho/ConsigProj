package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Bean.Consignado;

public class ConsignadoDAO {
	
	 public boolean consultar(Consignado consig) throws Exception {

	        Connection conexao = ConnectionFactory.getConnection();
	        ResultSet resposta = null;
	        boolean ok = false;
	        StringBuilder sql = new StringBuilder();

	        try {
	            sql.append("select * tabelaConsignado");
	            sql.append(" where matricula_aluno = ?");
	            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
	            stmt.setString(1, consig.getCpf());
	           
	            
	            resposta = stmt.executeQuery();
	            while (resposta.next()) { 
	                
	                consig.setMargem(Integer.parseInt(resposta.getString("margem_consignado"))); //o campo em azul dever ser o valor do consigando que vem da query
	                   
	                ok = true;
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
