package modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;


@MappedSuperclass
public abstract class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fnumero")
	private Integer numero;
	
	@NotNull
	@Column(name = "fnome")
	private String nome;
	
	@NotNull
	@Column(name = "fsexo")
	private String sexo;
	
	@NotNull
	@Column(name = "faniversario")
	@Temporal(TemporalType.DATE)
	private Date data_aniversario;
	
	@NotEmpty
	@Column(name = "fsalario")
	private Double salario;

	@ManyToOne
	@JoinColumn(name="depart_numero")
	private Departamento departamento;
	
	@OneToMany(mappedBy="funcionario")
	private List<Dependente> dependentes;
	
	@ManyToMany(mappedBy = "funcionarios")
	private List<Endereco> enderecos;
	
	public Funcionario() { }
		
	public Funcionario(String nome, String sexo, Date data_aniversario, Double salario) {
		this.nome = nome;
		this.sexo = sexo;
		this.data_aniversario = data_aniversario;
		this.salario = salario;
	}
	
	public Funcionario(Integer numero, String nome, String sexo, Date data_aniversario, Double salario) {
		this.numero = numero;
		this.nome = nome;
		this.sexo = sexo;
		this.data_aniversario = data_aniversario;
		this.salario = salario;
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
		return data_aniversario;
	}

	public void setDataAniversario(Date data_aniversario) {
		this.data_aniversario = data_aniversario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
}