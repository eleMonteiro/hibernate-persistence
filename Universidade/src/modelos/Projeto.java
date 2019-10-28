package modelos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pnumero")
	private Integer numero;
	
	@NotNull
	@Column(name = "pnome")
	private String nome;
	
	@NotEmpty
	@Column(name = "tempoDesen")
	private Integer tempo_desen;
	
	@ManyToOne
	@JoinColumn(name="depart_numero")
	private Departamento departamento;

	@ManyToMany(mappedBy = "projetos")
	private List<Pesquisador> pesquisadores;
	
	public Projeto() {	}
	
	public Projeto(String nome, Integer tempo_desen) {
		this.nome = nome;
		this.tempo_desen = tempo_desen;
	}
	
	public Projeto(Integer numero, String nome, Integer tempo_desen) {
		this.numero = numero;
		this.nome = nome;
		this.tempo_desen = tempo_desen;
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

	public Integer getTempoDesen() {
		return tempo_desen;
	}

	public void setTempoDesen(Integer tempo_desen) {
		this.tempo_desen = tempo_desen;
	}
	
}