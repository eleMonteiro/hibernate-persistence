package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "numero")
public class FuncionarioPesquisador extends Funcionario {

	@NotNull
	private String areaAtuacao;

	@OneToMany(mappedBy = "pesquisador")
	private List<PesquisadorProjeto> pesquisadorProjetos;

	public FuncionarioPesquisador() {
		this.pesquisadorProjetos = new ArrayList<>();
	}

	public FuncionarioPesquisador(Integer numero, String nome, String sexo, Date dataAniversario, Double salario,
			Endereco endereco, Departamento departamento, String areaAtuacao) {
		super(nome, sexo, dataAniversario, salario, endereco, departamento);
		this.areaAtuacao = areaAtuacao;
		this.pesquisadorProjetos = new ArrayList<>();
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public List<PesquisadorProjeto> getPesquisadorProjetos() {
		return pesquisadorProjetos;
	}

	public void setPesquisadorProjetos(List<PesquisadorProjeto> pesquisadorProjetos) {
		this.pesquisadorProjetos = pesquisadorProjetos;
	}

	@Override
	public String toString() {
		return super.toString() + " > FuncionarioPesquisador [areaAtuacao=" + areaAtuacao + ", pesquisadorProjetos="
				+ pesquisadorProjetos + "]";
	}

}