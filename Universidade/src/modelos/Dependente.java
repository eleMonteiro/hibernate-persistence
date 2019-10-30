package modelos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.NotNull;

@Entity
public class Dependente {

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

	@NotNull
	private String grauParentesco;

	@ManyToOne
	private Funcionario funcionario;

	public Dependente() {
	}

	public Dependente(String nome, String sexo, Date data_aniversario, String grau_parentesco) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = data_aniversario;
		this.grauParentesco = grau_parentesco;
	}

	public Dependente(Integer numero, String nome, String sexo, Date data_aniversario, String grau_parentesco) {
		this.numero = numero;
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = data_aniversario;
		this.grauParentesco = grau_parentesco;
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

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Dependente { Nome: " + nome + ", Sexo: " + sexo + ", Data Aniversario: " + dataAniversario
				+ ", Grau Parentesco: " + grauParentesco + " }";
	}

}
