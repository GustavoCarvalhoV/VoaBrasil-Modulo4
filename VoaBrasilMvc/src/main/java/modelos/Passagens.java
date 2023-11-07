package modelos;

public class Passagens {
	
	private int id;
	private float preco;
	private String horario;
	private String dataIda;
	private String dataVolta;
	
	Usuarios usuario;
	Destinos destino;
	
	
	public Passagens() {
	}


	public Passagens(int id, float preco, String horario, String dataIda, String dataVolta, Usuarios usuario,
			Destinos destino) {
		this.id = id;
		this.preco = preco;
		this.horario = horario;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.usuario = usuario;
		this.destino = destino;
	}


	public Passagens(float preco, String horario, String dataIda, String dataVolta, Usuarios usuario,
			Destinos destino) {
		this.preco = preco;
		this.horario = horario;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.usuario = usuario;
		this.destino = destino;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}


	public String getDataIda() {
		return dataIda;
	}


	public void setDataIda(String dataIda) {
		this.dataIda = dataIda;
	}


	public String getDataVolta() {
		return dataVolta;
	}


	public void setDataVolta(String dataVolta) {
		this.dataVolta = dataVolta;
	}


	public Usuarios getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}


	public Destinos getDestino() {
		return destino;
	}


	public void setDestino(Destinos destino) {
		this.destino = destino;
	}


	@Override
	public String toString() {
		return "Passagens [id=" + id + ", preco=" + preco + ", horario=" + horario + ", dataIda=" + dataIda
				+ ", dataVolta=" + dataVolta + ", usuario=" + usuario + ", destino=" + destino + "]";
	}
	
	
	
	
	
	
	
	
	
}
