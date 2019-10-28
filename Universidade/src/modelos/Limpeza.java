package modelos;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.NotNull;


@Entity
@AttributeOverride(name = "numero", column=@Column(name="funcionario_id"))
public class Limpeza extends Funcionario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lnumero")
	private Integer numero;
	
	@NotNull
	@Column(name = "jornadaTrabalho")
	private Integer joranada_trabalho;
	
	@OneToOne(mappedBy="limpeza")
	@JoinColumn(name="supervisor")
	private Limpeza limpeza;

	public Limpeza() {
	
	}
	
	public Limpeza(String nome, String sexo, Date data_aniversario, Double salario, Integer joranada_trabalho) {
		super(nome, sexo, data_aniversario, salario);
		this.joranada_trabalho = joranada_trabalho;
	}	
	
	public Integer getJoranadaTrabalho() {
		return joranada_trabalho;
	}

	public void setJoranadaTrabalho(Integer joranada_trabalho) {
		this.joranada_trabalho = joranada_trabalho;
	}
	
}
