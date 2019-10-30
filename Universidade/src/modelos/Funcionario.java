package modelos;

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
	private Integer numeroFuncionario;

	@NotNull
	private String nome;

	@NotNull
	private String sexo;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;

	@NotEmpty
	private Double salario;

	@ManyToOne
	@JoinColumn(name = "numero")
	private Departamento departamento;

	@OneToMany(mappedBy = "funcionario")
	private List<Dependente> dependentes;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco")
	private Endereco enderecos;

	public Funcionario() {
		dependentes = new ArrayList<Dependente>();
	}

	public Funcionario(String nome, String sexo, Date data_aniversario, Double salario) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = data_aniversario;
		this.salario = salario;
		dependentes = new ArrayList<Dependente>();
	}

	public Funcionario(Integer numero, String nome, String sexo, Date data_aniversario, Double salario) {
		this.numeroFuncionario = numero;
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = data_aniversario;
		this.salario = salario;
		dependentes = new ArrayList<Dependente>();
	}

	public Integer getNumero() {
		return numeroFuncionario;
	}

	public void setNumero(Integer numero) {
		this.numeroFuncionario = numero;
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

	public void setEndereco(Endereco endereco) {
		this.enderecos = endereco;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
	@Override
	public String toString() {
		return "Funcionario [numero=" + numeroFuncionario + ", nome=" + nome + ", sexo=" + sexo + ", dataAniversario="
				+ dataAniversario + ", salario=" + salario + ", departamento=" + departamento + ", dependentes="
				+ dependentes + ", enderecos=" + enderecos + "]";
	}

}