package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
@NamedQueries({ @NamedQuery(name = "Projeto.findByDepartamento", query = "from Projeto c "
		+ "where c.departamento.numero = :numero") })
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;

	@NotNull
	private String nome;

	@NotEmpty
	private Integer tempo;

	@ManyToOne
	@JoinColumn
	private Departamento departamento;

	@OneToMany(mappedBy = "projeto")
	private List<PesquisadorProjeto> pesquisadorProjetos;

	public Projeto() {
		this.pesquisadorProjetos = new ArrayList<>();
	}

	public Projeto(String nome, Integer tempo, Departamento departamento) {
		super();
		this.nome = nome;
		this.tempo = tempo;
		this.departamento = departamento;
		this.pesquisadorProjetos = new ArrayList<>();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<PesquisadorProjeto> getPesquisadorProjetos() {
		return pesquisadorProjetos;
	}

	public void setPesquisadorProjetos(List<PesquisadorProjeto> pesquisadorProjetos) {
		this.pesquisadorProjetos = pesquisadorProjetos;
	}

	@Override
	public String toString() {
		return "Projeto [numero=" + numero + ", nome=" + nome + ", tempo=" + tempo + ", departamento=" + departamento
				+ "]";
	}

}