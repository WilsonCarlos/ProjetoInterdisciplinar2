package br.com.direcaocerta.entidades;

public class Mapa {

	private Integer id_mapa;
	private String lat_mapa;
	private String log_mapa;
	private String velocidade;
	public Integer getId_mapa() {
		return id_mapa;
	}
	public void setId_mapa(Integer id_mapa) {
		this.id_mapa = id_mapa;
	}
	public String getLat_mapa() {
		return lat_mapa;
	}
	public void setLat_mapa(String lat_mapa) {
		this.lat_mapa = lat_mapa;
	}
	public String getLog_mapa() {
		return log_mapa;
	}
	public void setLog_mapa(String log_mapa) {
		this.log_mapa = log_mapa;
	}
	public String getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}
	@Override
	public String toString() {
		return "Mapa [id_mapa=" + id_mapa + ", lat_mapa=" + lat_mapa
				+ ", log_mapa=" + log_mapa + ", velocidade=" + velocidade
				+ ", getId_mapa()=" + getId_mapa() + ", getLat_mapa()="
				+ getLat_mapa() + ", getLog_mapa()=" + getLog_mapa()
				+ ", getVelocidade()=" + getVelocidade() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}