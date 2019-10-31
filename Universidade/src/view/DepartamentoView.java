package view;

import java.util.List;
import java.util.Scanner;

import controller.DepartamentoController;
import models.Departamento;

public class DepartamentoView {

	private static DepartamentoView departamentoView;
	private Scanner scanner;

	private DepartamentoView() {
		scanner = new Scanner(System.in);
	}

	private static void exibirMenuDeDepartamentos() {
		System.out.println("+---------------------------------+");
		System.out.println("| [0] Voltar                      |");
		System.out.println("| [1] Adicionar                   |");
		System.out.println("| [2] Remover                     |");
		System.out.println("| [3] Ver Todos                   |");
		System.out.println("| [4] Buscar por ID               |");
		System.out.println("+---------------------------------+");
	}

	public void iniciar() {
		boolean executando = true;

		while (executando) {
			exibirMenuDeDepartamentos();

			String opcaoMenuDeDepartamentos = scanner.nextLine();

			switch (opcaoMenuDeDepartamentos) {
			case "0":
				executando = false;
				break;

			case "1":
				System.out.println("Informe o nome do departamento: ");

				String nome = scanner.nextLine();
				new DepartamentoController().adicionarDepartamento(nome);

				System.out.println("Departamento salvo com sucesso");
				break;

			case "2":
				System.out.println("Informe o numero do departamento: ");

				try {
					Integer numero = Integer.parseInt(scanner.nextLine());
					new DepartamentoController().removerDepartamento(numero);
				} catch (NumberFormatException e) {
					System.out.println("O numero informado não a valido!");
				}

				System.out.println("Departamento removido com sucesso");
				break;

			case "3":
				List<Departamento> departamentos = new DepartamentoController().buscarTodosOsDepartamentos();

				for (Departamento departamento : departamentos) {
					System.out.println(departamento);
				}

				break;

			case "4":
				System.out.println("Informe o numero do departamento: ");

				try {
					Integer numero = Integer.parseInt(scanner.nextLine());
					Departamento departamento = new DepartamentoController().buscarDepartamentoPorNumero(numero);

					System.out.println(departamento);
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

	public static DepartamentoView getInstance() {
		if (departamentoView == null) {
			departamentoView = new DepartamentoView();
		}

		return departamentoView;
	}
}
