package modelos;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Trabalho {

	@ManyToOne
    @JoinColumn(name="numero")
	private Funcionario pesquisador;

	@ManyToOne
    @JoinColumn(name="numero")
	private Projeto projeto;
		
	private Integer horaSemanais;

	public Trabalho(Integer horas) {
		this.horaSemanais = horas;
	}

	public Funcionario getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(Pesquisador pesquisador) {
		this.pesquisador = pesquisador;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Integer getHoraSemanais() {
		return horaSemanais;
	}

	public void setHoraSemanais(Integer horaSemanais) {
		this.horaSemanais = horaSemanais;
	}	
}