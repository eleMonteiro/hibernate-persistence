package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;

	@NotNull
	private String nome;

	@NotNull
	private String sexo;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;

	@NotEmpty
	private Double salario;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Endereco endereco;

	@ManyToOne
	@JoinColumn
	private Departamento departamento;

	@OneToMany(mappedBy = "funcionario")
	private List<Dependente> dependentes;

	public Funcionario() {
		this.dependentes = new ArrayList<>();
	}

	public Funcionario(String nome, String sexo, Date dataAniversario, Double salario, Endereco endereco,
			Departamento departamento) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
		this.endereco = endereco;
		this.departamento = departamento;
		this.dependentes = new ArrayList<>();
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	@Override
	public String toString() {
		return "Funcionario [numero=" + numero + ", nome=" + nome + ", sexo=" + sexo + ", dataAniversario="
				+ dataAniversario + ", salario=" + salario + ", endereco=" + endereco + ", departamento=" + departamento
				+ ", dependentes=" + dependentes + "]";
	}

}