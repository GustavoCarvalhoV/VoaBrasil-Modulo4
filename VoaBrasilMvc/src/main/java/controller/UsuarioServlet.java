package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import modelos.Usuarios;

@WebServlet(urlPatterns = {"/usuario", "/usuario-save", "/usuario-edit", "/usuario-update", "/usuario-delete"})
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	UsuarioDAO Udao = new UsuarioDAO();
	Usuarios usuario = new Usuarios();
	
    public UsuarioServlet() {
        super();  
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String route = request.getServletPath();
		switch (route) {
		case "/usuario":
			read(request,response);
			break;
		case "/usuario-save":
			save(request,response);
			break;	
		case "/usuario-edit":
			edit(request,response);
			break;	
		case "/usuario-update":
			update(request,response);
			break;	
		case "/usuario-delete":
			delete(request,response);
			
			break;
		default:
			
			break;
		}
		
	}
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Usuarios usuario = new Usuarios();
		usuario.setNome(request.getParameter("nome"));
		usuario.setSobrenome(request.getParameter("sobrenome"));
		usuario.setRg(request.getParameter("rg"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setContato(request.getParameter("contato"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		
		if(request.getParameter("id")!=null){
			usuario.setId(Integer.parseInt(request.getParameter("id")));
			Udao.update(usuario);
			
		}else {
			Udao.create(usuario);			
		}
		response.sendRedirect("./usuario");						
	}
		
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		usuario = Udao.readById(id);			
		request.setAttribute("usuario", usuario);	
		RequestDispatcher rd=request.getRequestDispatcher("./editar.jsp");
		rd.forward(request, response);
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNome(request.getParameter("nome"));
		usuario.setSobrenome(request.getParameter("sobrenome"));
		usuario.setRg(request.getParameter("rg"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setContato(request.getParameter("contato"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		
		Udao.update(usuario);
		response.sendRedirect("usuario");
	}
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Usuarios>usuarios = Udao.read();
		request.setAttribute("usuarios", usuarios);
		RequestDispatcher rd=request.getRequestDispatcher("./usuario.jsp");
		rd.forward(request, response);		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Udao.delete(id);
		response.sendRedirect("./usuario");		
	}
}
