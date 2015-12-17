package br.com.direcaocerta.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.direcaocerta.entidades.Mapa;

public class MapaDAO {

	private Connection con = ConexaoFactory.getConnection();

	
	public void cadastrar(Mapa mapa) {

		String sql = "insert into mapa(lat_mapa, log_mapa, velocidade) values (?,?,?)";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			// substitui as interrogaçoes pelos dados
			preparador.setString(1, mapa.getLat_mapa());
			preparador.setString(2, mapa.getLog_mapa());
			preparador.setString(3, mapa.getVelocidade());
	

			// executando o comando no banco
			preparador.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void alterar(Mapa mapa) {

		String sql = "update mapa set lat_mapa=?, log_mapa=?, velocidade_mapa= ? where id_mapa=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			// substitui as interrogaçoes pelos dados
			preparador.setString(1, mapa.getLat_mapa());
			preparador.setString(2, mapa.getLog_mapa());
			preparador.setString(3, mapa.getVelocidade());
			preparador.setInt(6, mapa.getId_mapa());
			// executando o comando no banco
			preparador.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	public void excluir(Mapa mapa) {
		// TODO Auto-generated method stub

		String sql = "delete from mapa where id_mapa=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			// substitui as interrogaçoes pelos dados
			preparador.setInt(1, mapa.getId_mapa());
			// executando o comando no banco
			preparador.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	public void salvar(Mapa mapa) {
		if (mapa.getId_mapa() != null) {
			alterar(mapa);
		} else {
			cadastrar(mapa);
		}
	}
	
	public Mapa buscarPorId(Integer id_mapa) {

		String sql = "Select * from mapa where id_mapa=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, id_mapa);

			ResultSet resultado = preparador.executeQuery();

			// posicionando o cursor no primeiro registro
			if (resultado.next()) {
				Mapa mapa = new Mapa();

				mapa.setId_mapa(resultado.getInt("id_mapa"));
				mapa.setLat_mapa(resultado.getString("lat_mapa"));
				mapa.setLog_mapa(resultado.getString("log_mapa"));
				mapa.setVelocidade(resultado.getString("velocidade"));		

				return mapa;
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Mapa> buscarTodos() {

		String sql = "Select * from mapa";

		List<Mapa> lista = new ArrayList<Mapa>();

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();

			// posicionando o cursor no primeiro registro
			while (resultado.next()) {
				Mapa mapa = new Mapa();

				mapa.setId_mapa(resultado.getInt("id_mapa"));
				mapa.setLat_mapa(resultado.getString("lat_mapa"));
				mapa.setLog_mapa(resultado.getString("log_mapa"));
				mapa.setVelocidade(resultado.getString("velocidade"));
				

				lista.add(mapa);
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}