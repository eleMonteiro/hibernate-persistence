package modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
@NamedQueries({
	@NamedQuery( name = "Projeto.findByDepartamento", query = "from Projeto c "
			+ "where c.departamento.numero = :numero")
})
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;

	@NotNull
	private String nome;

	@NotEmpty
	private Integer tempo;

	@ManyToOne
	private Departamento departamento;

	@OneToMany(mappedBy = "projeto")
	private List<Trabalho> trabalhos;

	public Projeto() {
		
	}

	public Projeto(String nome, Integer tempo_desen) {
		this.nome = nome;
		this.tempo = tempo_desen;
	}

	public Projeto(Integer numero, String nome, Integer tempo_desen) {
		this.numero = numero;
		this.nome = nome;
		this.tempo = tempo_desen;
	}

	public Projeto(String nome, Integer tempo_desen, Departamento departamento) {
		this.nome = nome;
		this.tempo = tempo_desen;
		this.departamento = departamento;
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
	
	public void addPesquisador(Trabalho pesquisador) {
		this.trabalhos.add(pesquisador);
	}

	@Override
	public String toString() {
		return "Projeto { Numero: " + numero + ", Nome: " + nome + ", Tempo: " + tempo + " }";
	}	
}