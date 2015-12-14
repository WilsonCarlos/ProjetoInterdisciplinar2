package br.com.direcaocerta.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.direcaocerta.entidades.Empresa;
import br.com.direcaocerta.persistencia.jdbc.EmpresaDAO;

@WebServlet("/empresacontroller.do")
public class EmpresaController extends HttpServlet{

	
	public EmpresaController() {
		
		System.out.println("Construtor da empresa");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		String acao = req.getParameter("acao");
	
		if (acao.equals("exc")) {
			String id_empresa = req.getParameter("id_empresa");
			Empresa empresa = new Empresa();

			if(id_empresa!=null){
				empresa.setId_empresa(Integer.parseInt(id_empresa));
			}
			
			EmpresaDAO empresaDAO = new EmpresaDAO();
			empresaDAO.excluir(empresa);
			
			resp.sendRedirect("empresacontroller.do?acao=lis");
			
		}else if(acao.equals("lis")){
			
			EmpresaDAO empresaDAO = new EmpresaDAO();
			List<Empresa> listaempresa = empresaDAO.buscarTodos();
			
			req.setAttribute("listaempresa", listaempresa);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("listEmpresa.jsp");	
			
			dispatcher.forward(req, resp);
			
		}else if(acao.equals("alt")){
			String id_empresa = req.getParameter("id_empresa");
			EmpresaDAO empresaDAO = new EmpresaDAO();
			Empresa empresa = empresaDAO.buscarPorId(Integer.parseInt(id_empresa));
			req.setAttribute("empresa", empresa);
			RequestDispatcher dispatcher = req.getRequestDispatcher("formalterarempresa.html");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		System.out.println("post");
	
		String id_empresa = req.getParameter("id_empresa");
		String nome_empresa = req.getParameter  ("nome_empresa");
		String login_empresa = req.getParameter("login_empresa");
		String senha_empresa = req.getParameter("senha_empresa");
		String cnpj_empresa = req.getParameter ("cnpj_empresa");
		String telefone_empresa = req.getParameter("telefone_empresa");
		
		Empresa empresa = new Empresa();
		
		if(id_empresa!=null){
			empresa.setId_empresa(Integer.parseInt(id_empresa));
		}

		empresa.setNome_empresa(nome_empresa);
		empresa.setLogin_empresa(login_empresa);
		empresa.setSenha_empresa(senha_empresa);
		empresa.setCnpj_empresa(cnpj_empresa);
		empresa.setTelefone_empresa(telefone_empresa);
		
		
		EmpresaDAO empresaDAO = new EmpresaDAO();
		
		empresaDAO.salvar(empresa);
						   
		resp.sendRedirect("index.html");

	}
}