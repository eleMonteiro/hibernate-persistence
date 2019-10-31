package view;

import java.util.List;
import java.util.Scanner;

import controller.ProjetoController;
import models.Projeto;

public class ProjetoView {

	private static ProjetoView projetoView;
	private Scanner scanner;

	private ProjetoView() {
		scanner = new Scanner(System.in);
	}

	private static void exibirMenuDeProjetos() {
		System.out.println("+---------------------------------+");
		System.out.println("| [0] Voltar                      |");
		System.out.println("| [1] Adicionar                   |");
		System.out.println("| [2] Remover                     |");
		System.out.println("| [3] Ver Todos                   |");
		System.out.println("| [4] Buscar por ID               |");
		System.out.println("| [5] Buscar por Departamento     |");
		System.out.println("| [6] Adicionar Pesquisador       |");
		System.out.println("+---------------------------------+");
	}

	public void iniciar() {
		boolean executando = true;

		while (executando) {
			exibirMenuDeProjetos();

			String opcaoMenuDeProjetos = scanner.nextLine();

			switch (opcaoMenuDeProjetos) {
			case "0":
				System.out.println("Voltando...");
				break;

			case "1":
				System.out.println("Informe o nome do projeto: ");
				String nomeProjeto = scanner.nextLine();

				System.out.println("Informe o tempo do projeto: ");
				Integer tempoProjeto;
				try {
					tempoProjeto = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("O tempo informado nao e valido");
					break;
				}

				System.out.println("Informe o numero do departamento ao qual o projeto pertence: ");
				Integer numeroDepartamentoProjeto;
				try {
					numeroDepartamentoProjeto = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("O numero do departamento informado nao e valido");
					break;
				}

				new ProjetoController().adicionarProjeto(nomeProjeto, tempoProjeto, numeroDepartamentoProjeto);

				System.out.println("Projeto salvo com sucesso");
				break;

			case "2":
				System.out.println("Informe o numero do projeto: ");

				try {
					Integer numero = Integer.parseInt(scanner.nextLine());
					new ProjetoController().removerProjeto(numero);
				} catch (NumberFormatException e) {
					System.out.println("O numero informado não a valido!");
				}

				System.out.println("Projeto removido com sucesso");
				break;

			case "3":
				List<Projeto> projetos = new ProjetoController().buscarTodosOsProjetos();

				for (Projeto projeto : projetos) {
					System.out.println(projeto);
				}

				break;

			case "4":
				System.out.println("Informe o numero do projeto: ");

				try {
					Integer numero = Integer.parseInt(scanner.nextLine());
					Projeto projeto = new ProjetoController().buscarProjetoPorNumero(numero);

					System.out.println(projeto);
				} catch (NumberFormatException e) {
					System.out.println("O numero informado não e valido!");
				}

				break;

			case "5":
				System.out.println("Informe o numero do departamento: ");

				try {
					Integer numero = Integer.parseInt(scanner.nextLine());
					List<Projeto> projetosDept = new ProjetoController().buscarProjetoPorDepartamento(numero);

					for (Projeto projeto : projetosDept)
						System.out.println(projeto);
				} catch (NumberFormatException e) {
					System.out.println("O numero informado não e valido!");
				}

				break;

			case "6":

				try {
					System.out.println("Informe o numero do projeto: ");
					Integer numero = Integer.parseInt(scanner.nextLine());
					System.out.println("Informe o numero do pesquisador: ");
					Integer numeroPesquisador = Integer.parseInt(scanner.nextLine());
					System.out.println("Informe o numero de horas trabalhadas: ");
					Integer horasTrabalhadas = Integer.parseInt(scanner.nextLine());

					new ProjetoController().adicionarPesquisadorProjeto(numero, numeroPesquisador, horasTrabalhadas);

					System.out.println("Cadastrado!");
				} catch (NumberFormatException e) {
					System.out.println("O numero informado não e valido!");
				}

				break;

			default:
				System.out.println("Opcao invalida");
				break;
			}
		}
	}

	public static ProjetoView getInstance() {
		if (projetoView == null) {
			projetoView = new ProjetoView();
		}

		return projetoView;
	}

}
