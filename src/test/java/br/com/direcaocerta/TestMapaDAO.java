package br.com.direcaocerta;

import java.util.List;

import br.com.direcaocerta.entidades.Mapa;
import br.com.direcaocerta.persistencia.jdbc.MapaDAO;


public class TestMapaDAO {

	public static void main(String[] args) {

		// testBuscarTodos();
		//testBuscarPorId();
		testCadastrar();
		// testAlterar();
		// testExcluir();
	}

	public static void testCadastrar() {

		Mapa mapa = new Mapa();
	
		// Criando o Mapa no banco

		mapa.setId_mapa(1);
		mapa.setLat_mapa("23324234");
		mapa.setLog_mapa("439483948");
		mapa.setVelocidade("44");

		MapaDAO mapaDAO = new MapaDAO();
		mapaDAO.cadastrar(mapa);

		System.out.println("mapa Cadastrado com Sucesso!");
	}

	public static void testAlterar() {

		Mapa mapa = new Mapa();

		mapa.setId_mapa(2);
		mapa.setLat_mapa("4324io2");
		mapa.setLog_mapa("4324242");
		mapa.setVelocidade("432");
		
		MapaDAO mapaDAO = new MapaDAO();
		mapaDAO.alterar(mapa);

		System.out.println("Alterado com Sucesso!");
	}

	public static void testExcluir() {
		
		Mapa mapa = new Mapa();
		mapa.setId_mapa(1);

		MapaDAO mapaDao = new MapaDAO();
		mapaDao.excluir(mapa);

		System.out.println("Excluido com Sucesso!");

	}

	public static void testSalvar() {
		
		Mapa mapa = new Mapa();

		mapa.setId_mapa(2);
		mapa.setLat_mapa("4324io2");
		mapa.setLog_mapa("4324242");
		mapa.setVelocidade("432");
		
		MapaDAO mapaDAO = new MapaDAO();
		mapaDAO.salvar(mapa);

		System.out.println("Alterado com Sucesso!");

	}

	private static void testBuscarPorId() {

		MapaDAO mapaDAO = new MapaDAO();
		Mapa mapa = mapaDAO.buscarPorId(1);
		System.out.println(mapa);
	}

	private static void testBuscarTodos() {

		MapaDAO mapaDAO = new MapaDAO();
		List<Mapa> lista = mapaDAO.buscarTodos();
		for (Mapa e : lista) {
			System.out.println(e);
		}

		Mapa mapa = mapaDAO.buscarPorId(1);
		System.out.println(mapa);
	}
}
