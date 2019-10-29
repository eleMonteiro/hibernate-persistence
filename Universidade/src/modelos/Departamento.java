package modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.NotNull;

@Entity
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;

	@NotNull
	private String nome;

	@OneToMany(mappedBy = "departamento")
	private List<Funcionario> funcionarios;

	@OneToMany(mappedBy = "departamento")
	private List<Projeto> projetos;

	public Departamento() {

	}

	public Departamento(Integer numero) {
		this.numero = numero;
	}

	public Departamento(String nome) {
		this.nome = nome;
	}

	public Departamento(Integer numero, String nome) {
		super();
		this.numero = numero;
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Departamento { Numero: " + numero + ", Nome: " + nome + " }";
	}

}
