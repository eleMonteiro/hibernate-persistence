package main;

import java.util.Scanner;

import view.DepartamentoView;
import view.FuncionarioView;
import view.ProjetoView;

public class Main {

	private static void exibirMenuPrincipal() {
		System.out.println("+---------------------------------+");
		System.out.println("| [0] Sair                        |");
		System.out.println("| [1] Departamentos               |");
		System.out.println("| [2] Funcionarios                |");
		System.out.println("| [3] Projetos                    |");
		System.out.println("+---------------------------------+");
	}

	public static void main(String[] args) {
		boolean executando = true;
		Scanner scanner = new Scanner(System.in);

		while (executando) {
			exibirMenuPrincipal();

			String opcaoMenuPrincipal = scanner.nextLine();

			switch (opcaoMenuPrincipal) {
			case "0":
				executando = false;

				System.out.println("Saindo...");

				break;

			case "1":
				DepartamentoView departamentoView = DepartamentoView.getInstance();
				departamentoView.iniciar();

				break;

			case "2":
				FuncionarioView funcionarioView = FuncionarioView.getInstance();
				funcionarioView.iniciar();

				break;

			case "3":
				ProjetoView projetoView = ProjetoView.getInstance();
				projetoView.iniciar();

				break;

			default:
				System.out.println("Opcao invalida");

				break;
			}
		}

		scanner.close();
	}
}