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
import dao.PassagemDAO;
import dao.UsuarioDAO;
import modelos.Passagens;

@WebServlet(urlPatterns = {"/passagem", "/passagem-save", "/passagem-edit", "/passagem-update", "/passagem-delete"})
public class PassagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	UsuarioDAO Udao = new UsuarioDAO();
	PassagemDAO Pdao = new PassagemDAO();
	DestinoDAO Ddao = new DestinoDAO();
	Passagens passagem = new Passagens();
	
    public PassagemServlet() {
        super();  
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String route = request.getServletPath();
		switch (route) {
		case "/passagem":
			read(request,response);
			break;
		case "/passagem-save":
			save(request,response);
			break;
		case "/passagem-edit":
			edit(request,response);
			break;
		case "/passagem-update":
			update(request,response);
			break;
		case "/passagem-delete":
			delete(request,response);
			
			break;
		default:
			
			break;
		}
		
	}
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Passagens passagem = new Passagens();
		int idusuario = Integer.parseInt(request.getParameter("usuario"));
		int iddestino = Integer.parseInt(request.getParameter("destino"));
		passagem.setUsuario(Udao.readById(idusuario));
		passagem.setDestino(Ddao.readById(iddestino));
		
		passagem.setDataIda(request.getParameter("dataIda"));
		passagem.setDataVolta(request.getParameter("dataVolta"));
		passagem.setHorario(request.getParameter("horario"));
		passagem.setPreco(Float.parseFloat(request.getParameter("preco")));
		
		if(request.getParameter("id")!=null){
			passagem.setId(Integer.parseInt(request.getParameter("id")));
			Pdao.update(passagem);
			
		}else {
			Pdao.create(passagem);			
		}
		response.sendRedirect("./passagem");
		
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		passagem = Pdao.readById(id);			
		request.setAttribute("passagem", passagem);	
		RequestDispatcher rd=request.getRequestDispatcher("./editarpassagem.jsp");
		rd.forward(request, response);
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		passagem.setId(Integer.parseInt(request.getParameter("id")));
		passagem.setDataIda(request.getParameter("dataIda"));
		passagem.setDataVolta(request.getParameter("dataVolta"));
		passagem.setHorario(request.getParameter("horario"));
		passagem.setPreco(Float.parseFloat(request.getParameter("preco")));
	
		
		Pdao.update(passagem);
		response.sendRedirect("passagem");
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Passagens>passagens = Pdao.read();
		request.setAttribute("passagens", passagens);
		RequestDispatcher rd=request.getRequestDispatcher("./passagem.jsp");
		rd.forward(request, response);		
		}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Pdao.delete(id);
		response.sendRedirect("./passagem");		
	}
}

