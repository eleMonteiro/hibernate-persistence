package modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "numero")
public class Pesquisador extends Funcionario {

	@NotNull
	private String areaAtuacao;

	@ManyToMany
	@JoinTable(name = "pesquisador_projeto", joinColumns = @JoinColumn(name = "pesquisador_id"), inverseJoinColumns = @JoinColumn(name = "projeto_id"))
	private List<Projeto> projetos;

	public Pesquisador() {

	}

	public Pesquisador(String nome, String sexo, Date data_aniversario, Double salario, String area_atuacao) {
		super(nome, sexo, data_aniversario, salario);
		this.areaAtuacao = area_atuacao;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	@Override
	public String toString() {
		return super.toString() + " > Pesquisador [areaAtuacao=" + areaAtuacao + ", projetos=" + projetos + "]";
	}

}
