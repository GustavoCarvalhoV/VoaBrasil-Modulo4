package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import modelos.Destinos;

@WebServlet(urlPatterns = {"/destino", "/destino-save", "/destino-edit", "/destino-update", "/destino-delete"})
public class DestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	DestinoDAO Ddao = new DestinoDAO();
	Destinos destino = new Destinos();
    public DestinoServlet() {
        super();  
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String route = request.getServletPath();
		switch (route) {
		case "/destino":
			read(request,response);
			break;
		case "/destino-save":
			save(request,response);
			break;
		case "/destino-edit":
			edit(request,response);
			break;
		case "/destino-update":
			update(request,response);
			break;
		case "/destino-delete":
			delete(request,response);
			
			break;
		default:
			
			break;
		}
		
	}
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Destinos destino = new Destinos();
		destino.setCidade(request.getParameter("cidade"));
		destino.setEstado(request.getParameter("estado"));
			
		if(request.getParameter("id")!=null){
			destino.setId(Integer.parseInt(request.getParameter("id")));
			Ddao.update(destino);
			
		}else {
			Ddao.create(destino);			
		}
		response.sendRedirect("./destino");						
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		destino = Ddao.readById(id);			
		request.setAttribute("destino", destino);	
		RequestDispatcher rd=request.getRequestDispatcher("./editardestino.jsp");
		rd.forward(request, response);
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		destino.setId(Integer.parseInt(request.getParameter("id")));
		destino.setCidade(request.getParameter("cidade"));
		destino.setEstado(request.getParameter("cidade"));
				
		Ddao.update(destino);
		response.sendRedirect("destino");
	}
	
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Destinos>destinos = Ddao.read();
		request.setAttribute("destinos", destinos);
		RequestDispatcher rd=request.getRequestDispatcher("./destino.jsp");
		rd.forward(request, response);		
		}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Ddao.delete(id);
		response.sendRedirect("./destino");		
	}
}
