import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class TesteConn {

	public static void main(String[] args)
	{
		Connection conexao = null;
		// O drive do banco deve ser anexado as bibliotecas do projeto
		String url = "jdbc:oracle:thin:rm@//172.17.107.3:1521/rmpr";
		String user = "rm";
		String password = "rm";
		String sql = "select * from ppessoa where codigo='3481'";
		
		try{
			
			conexao = DriverManager.getConnection(url, user, password);
			Statement stmt= null;
			stmt= conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			/*ResultSetMetaData rsmd = rs.getMetaData();
			System.out.print(rsmd.getColumnCount()); //imprimir quantidade de colunas
			System.out.print("SUCESSO!");*/
			
		}
		catch(SQLException e){
			System.out.print("Conexão falhou. Verifique o console para mais detalhes");
			e.printStackTrace();
			return;
		}

	} 
}

