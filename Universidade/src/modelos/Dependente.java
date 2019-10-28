package modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.NotNull;

@Entity
public class Dependente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "depnumero")
	private Integer numero;

	@NotNull
	@Column(name = "depnome")
	private String nome;

	@NotNull
	@Column(name = "depsexo")
	private String sexo;

	@NotNull
	@Column(name = "depaniversario")
	@Temporal(TemporalType.DATE)
	private Date data_aniversario;

	@NotNull
	@Column(name = "depparentesco")
	private String grau_parentesco;

	@ManyToOne
	@JoinColumn(name = "func_numero")
	private Funcionario funcionario;

	public Dependente() {
	}

	public Dependente(String nome, String sexo, Date data_aniversario, String grau_parentesco) {
		this.nome = nome;
		this.sexo = sexo;
		this.data_aniversario = data_aniversario;
		this.grau_parentesco = grau_parentesco;
	}

	public Dependente(Integer numero, String nome, String sexo, Date data_aniversario, String grau_parentesco) {
		this.numero = numero;
		this.nome = nome;
		this.sexo = sexo;
		this.data_aniversario = data_aniversario;
		this.grau_parentesco = grau_parentesco;
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

	public Date getData_aniversario() {
		return data_aniversario;
	}

	public void setData_aniversario(Date data_aniversario) {
		this.data_aniversario = data_aniversario;
	}

	public String getGrau_parentesco() {
		return grau_parentesco;
	}

	public void setGrau_parentesco(String grau_parentesco) {
		this.grau_parentesco = grau_parentesco;
	}

	@Override
	public String toString() {
		return "Dependente { Nome: " + nome + ", Sexo: " + sexo + ", Data Aniversario: " + data_aniversario
				+ ", Grau Parentesco: " + grau_parentesco + " }";
	}

}
