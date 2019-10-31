package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PesquisadorProjeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn
	private FuncionarioPesquisador pesquisador;

	@ManyToOne
	@JoinColumn
	private Projeto projeto;

	private Integer horasSemanais;

	public PesquisadorProjeto() {

	}

	public PesquisadorProjeto(FuncionarioPesquisador pesquisador, Projeto projeto, Integer horaSemanais) {
		super();
		this.pesquisador = pesquisador;
		this.projeto = projeto;
		this.horasSemanais = horaSemanais;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FuncionarioPesquisador getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(FuncionarioPesquisador pesquisador) {
		this.pesquisador = pesquisador;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Integer getHoraSemanais() {
		return horasSemanais;
	}

	public void setHoraSemanais(Integer horasSemanais) {
		this.horasSemanais = horasSemanais;
	}

	@Override
	public String toString() {
		return ""+ projeto;
	}

	
	
}