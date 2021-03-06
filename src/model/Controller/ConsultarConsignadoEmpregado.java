package model.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Bean.Consignado;

/**
 * Servlet implementation class ConsultarConsignadoEmpregado
 */
@WebServlet("/ConsultarConsignadoEmpregado")
public class ConsultarConsignadoEmpregado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        Consignado consig = new Consignado();
	        boolean resposta = true;
	       
	       
	        consig.setCpf(request.getParameter("txtCPF"));
	        
	        try {
	            resposta= consig.consultar(consig);
	        } catch (Exception ex) {
	            Logger.getLogger(ConsultarConsignadoEmpregado.class.getName()).log(Level.SEVERE, null, ex);
	        }
	       request.setAttribute("consigResp", consig);
	       RequestDispatcher rd = request.getRequestDispatcher("ConsultarConsignado.jsp");
	       rd.forward(request, response);
	        
	        
	    }
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarConsignadoEmpregado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
