package br.com.direcaocerta.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.direcaocerta.entidades.Mapa;
import br.com.direcaocerta.persistencia.jdbc.MapaDAO;

@WebServlet("/mapacontroller.do")
public class MapaController extends HttpServlet{

	
	public MapaController() {
		
		System.out.println("Construtor do mapa");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		String acao = req.getParameter("acao");
	
		if (acao.equals("exc")) {
			String id_mapa = req.getParameter("id_mapa");
			
			Mapa mapa = new Mapa();

			if(id_mapa!=null){
				mapa.setId_mapa(Integer.parseInt(id_mapa));
			}
			
			MapaDAO mapaDAO = new MapaDAO();
			mapaDAO.excluir(mapa);
			
			resp.sendRedirect("mapacontroller.do?acao=lis");
			
		}else if(acao.equals("lis")){
			
			MapaDAO mapaDAO = new MapaDAO();
			List<Mapa> listamapa = mapaDAO.buscarTodos();
			
			req.setAttribute("listamapa", listamapa);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("listmapa.jsp");	
			
			dispatcher.forward(req, resp);
			
		}else if(acao.equals("alt")){
			String id_mapa = req.getParameter("id_mapa");
			MapaDAO mapaDAO = new MapaDAO();
			Mapa mapa = mapaDAO.buscarPorId(Integer.parseInt(id_mapa));
			req.setAttribute("mapa", mapa);
			RequestDispatcher dispatcher = req.getRequestDispatcher("formalterarmapa.html");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		System.out.println("post");
	
		String id_mapa = req.getParameter("id_mapa");
		String lat_mapa = req.getParameter  ("lat_mapa");
		String log_mapa = req.getParameter("log_mapa");
		String velocidade = req.getParameter("velocidade");
		
		Mapa mapa = new Mapa();
		
		if(id_mapa!=null){
			mapa.setId_mapa(Integer.parseInt(id_mapa));
		}
		
		mapa.setLat_mapa(lat_mapa);
		mapa.setLog_mapa(log_mapa);
		mapa.setVelocidade(velocidade);
		
			
		
		MapaDAO mapaDAO = new MapaDAO();
		
		mapaDAO.salvar(mapa);
						   
		resp.sendRedirect("administradorcontroller.do?acao=lis");

	}
}