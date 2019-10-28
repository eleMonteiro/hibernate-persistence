package modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.NotNull;


@Entity
@AttributeOverride(name = "numero", column=@Column(name="funcionario_id"))
public class Pesquisador extends Funcionario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pesnumero")
	private Integer numero;
	
	@NotNull
	@Column(name = "areaAtuacao")
	private String area_atuacao;

	@ManyToMany
	@JoinTable(
			name="trabalha",
			joinColumns= 
				@JoinColumn(name="pesquisador_id", 
				referencedColumnName="pesnumero"),
			inverseJoinColumns =
				@JoinColumn(name="projeto_id", 
				referencedColumnName="pnumero")
			)
	private List<Projeto> projetos;
	
	public Pesquisador() {

	}

	public Pesquisador(String nome, String sexo, Date data_aniversario, Double salario, String area_atuacao) {
		super(nome, sexo, data_aniversario, salario);
		this.area_atuacao = area_atuacao;
	}
	
	public String getArea_atuacao() {
		return area_atuacao;
	}

	public void setArea_atuacao(String area_atuacao) {
		this.area_atuacao = area_atuacao;
	}
	
	
}
