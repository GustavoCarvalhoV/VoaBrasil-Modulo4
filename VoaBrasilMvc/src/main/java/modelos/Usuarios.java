package modelos;

public class Usuarios {
	
	private int id;
	private String nome;
	private String sobrenome;
	private String rg;
	private String cpf;
	private String contato;
	private String email;
	private String senha;
	
	public Usuarios() {	
	}
	
	
	public Usuarios(int id, String nome, String sobrenome, String rg, String cpf, String contato, String email,
			String senha) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.rg = rg;
		this.cpf = cpf;
		this.contato = contato;
		this.email = email;
		this.senha = senha;
	}


	public Usuarios(String nome, String sobrenome, String rg, String cpf, String contato, String email, String senha) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.rg = rg;
		this.cpf = cpf;
		this.contato = contato;
		this.email = email;
		this.senha = senha;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getContato() {
		return contato;
	}


	public void setContato(String contato) {
		this.contato = contato;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", rg=" + rg + ", cpf=" + cpf
				+ ", contato=" + contato + ", email=" + email + ", senha=" + senha + "]";
	}
	
	
	
	
	
}
