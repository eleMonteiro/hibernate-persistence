package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "numero")
public class Pesquisador extends Funcionario {

	@NotNull
	private String areaAtuacao;

	@OneToMany(mappedBy = "pesquisador")
	private List<Trabalho> trabalhos;

	public Pesquisador() {
		this.trabalhos = new ArrayList<Trabalho>();
	}

	public Pesquisador(String nome, String sexo, Date data_aniversario, Double salario, String area_atuacao) {
		super(nome, sexo, data_aniversario, salario);
		this.areaAtuacao = area_atuacao;
		this.trabalhos = new ArrayList<Trabalho>();
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public void addProjeto(Trabalho trabalho) {
		this.trabalhos.add(trabalho);
	}
	
	@Override
	public String toString() {
		return super.toString() + " > Pesquisador [areaAtuacao=" + areaAtuacao + ", projetos= "+ trabalhos+"]";
	}
}