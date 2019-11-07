package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.DependenteController;
import controller.FuncionarioController;
import models.Funcionario;

public class FuncionarioView {

	private static FuncionarioView funcionarioView;
	private Scanner scanner;

	private FuncionarioView() {
		scanner = new Scanner(System.in);
	}

	private static void exibirMenuDeFuncionarios() {
		System.out.println("+---------------------------------+");
		System.out.println("| [0] Voltar                      |");
		System.out.println("| [1] Adicionar                   |");
		System.out.println("| [2] Remover                     |");
		System.out.println("| [3] Ver Todos                   |");
		System.out.println("| [4] Buscar por ID               |");
		System.out.println("| [5] Adicionar Dependente        |");
		System.out.println("+---------------------------------+");
	}

	public void iniciar() {
		boolean executando = true;

		while (executando) {
			exibirMenuDeFuncionarios();

			String opcaoMenuDeFuncionarios = scanner.nextLine();

			switch (opcaoMenuDeFuncionarios) {
			case "0":
				executando = false;
				break;

			case "1":
				System.out.println("Informe o nome do funcionario: ");
				String nomeFuncionario = scanner.nextLine();

				System.out.println("Informe a rua do funcionario: ");
				String ruaFuncionario = scanner.nextLine();

				System.out.println("Informe o numero da casa do funcionario: ");
				Integer numeroCasaFuncionario = 0;
				try {
					numeroCasaFuncionario = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("O numero informado nao e valido");
					break;
				}

				System.out.println("Informe a cidade do funcionario: ");
				String cidadeFuncionario = scanner.nextLine();

				System.out.println("Informe o sexo do funcionario: ");
				String sexoFuncionario = scanner.nextLine();

				System.out.println("Informe a data de aniversario(nascimento) do funcionario: ");
				Date dataAniversarioFuncionario;
				try {
					dataAniversarioFuncionario = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
				} catch (ParseException e) {
					System.out.println("A data informada nao e valida");
					break;
				}

				System.out.println("Informe o salario do funcionario: ");
				Double salarioFuncionario;
				try {
					salarioFuncionario = Double.parseDouble(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("O salario informado nao e valido");
					break;
				}

				System.out.println("Informe o departamento do funcionario: ");
				Integer numeroDepartamento;
				try {
					numeroDepartamento = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("O salario informado nao e valido");
					break;
				}

				System.out.println("Informe o tipo do funcionario: ");
				System.out.println(
						"[0] Pesquisador		[1] Secretario		[2] Funcionario de Limpeza 		[*] Cancelar");

				String tipoFuncionario = scanner.nextLine();

				if (tipoFuncionario.equals("0")) {
					System.out.println("Informe a area de atuacao do pesquisador: ");
					String areaAtuacaoPesquisador = scanner.nextLine();

					new FuncionarioController().adicionarPesquisador(nomeFuncionario, sexoFuncionario,
							dataAniversarioFuncionario, salarioFuncionario, ruaFuncionario, numeroCasaFuncionario,
							cidadeFuncionario, numeroDepartamento, areaAtuacaoPesquisador);

					System.out.println("Pesquisador salvo com sucesso");
				} else if (tipoFuncionario.equals("1")) {
					System.out.println("Informe o grau de escolaridade do secretario: ");
					String grauEscolaridadeSecretario = scanner.nextLine();

					new FuncionarioController().adicionarSecretario(nomeFuncionario, sexoFuncionario,
							dataAniversarioFuncionario, salarioFuncionario, ruaFuncionario, numeroCasaFuncionario,
							cidadeFuncionario, numeroDepartamento, grauEscolaridadeSecretario);

					System.out.println("Secretario salvo com sucesso");
				} else if (tipoFuncionario.equals("2")) {
					System.out.println("Informe a jornada de trabalho em horas do funcionario de limpeza: ");
					Integer jornadaTrabalhoFuncionarioLimpeza;
					try {
						jornadaTrabalhoFuncionarioLimpeza = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("A jornada de trabalho informada nao e valida");
						break;
					}

					System.out.println("Informe o cargo do funcionario de limpeza: ");
					String cargoFuncionarioLimpeza;
					try {
						cargoFuncionarioLimpeza = scanner.nextLine();
					} catch (Exception e) {
						System.out.println("O cargo informado nao e valida");
						break;
					}

					System.out.println("Informe a ID do gerente: ");
					Integer numeroGerenteFuncionarioLimpeza;
					try {
						numeroGerenteFuncionarioLimpeza = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("A ID informada nao e valida");
						break;
					}

					new FuncionarioController().adicionarFuncionarioLimpeza(nomeFuncionario, sexoFuncionario,
							dataAniversarioFuncionario, salarioFuncionario, ruaFuncionario, numeroCasaFuncionario,
							cidadeFuncionario, numeroDepartamento, jornadaTrabalhoFuncionarioLimpeza,
							cargoFuncionarioLimpeza, numeroGerenteFuncionarioLimpeza);

					System.out.println("Funcionario de limpeza salvo com sucesso");
				}

				break;

			case "2":
				System.out.println("Informe o numero do funcionario: ");

				try {
					Integer numero = Integer.parseInt(scanner.nextLine());
					new FuncionarioController().removerFuncionario(numero);
				} catch (NumberFormatException e) {
					System.out.println("O numero informado não a valido!");
				}

				System.out.println("Funcionario removido com sucesso");
				break;

			case "3":
				List<Funcionario> funcionarios = new FuncionarioController().buscarTodosOsFuncionarios();

				for (Funcionario funcionario : funcionarios) {
					System.out.println(funcionario);
				}

				break;

			case "4":
				System.out.println("Informe o numero do funcionario: ");

				try {
					Integer numero = Integer.parseInt(scanner.nextLine());
					Funcionario funcionario = new FuncionarioController().buscarFuncionarioPorNumero(numero);

					System.out.println(funcionario);
				} catch (NumberFormatException e) {
					System.out.println("O numero informado não e valido!");
				}

				break;

			case "5":
				System.out.println("Informe o numero do funcionario: ");
				Integer numeroFuncDependente = Integer.parseInt(scanner.nextLine());

				try {

				} catch (NumberFormatException e) {
					System.out.println("O numero informado nao e valido");
					break;
				}

				System.out.println("Informe o nome do dependente: ");
				String nomeDependente = scanner.nextLine();

				System.out.println("Informe o sexo do dependente: ");
				String sexo = scanner.nextLine();

				System.out.println("Informe a data de aniversario(nascimento) do dependente: ");
				Date dataAniversarioDependente = null;

				try {
					dataAniversarioFuncionario = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
				} catch (ParseException e) {
					System.out.println("A data informada nao e valida");
					break;
				}

				System.out.println("Informe o grau de parentesco do dependente com o funcionario: ");
				String grauparentesco = scanner.nextLine();

				new DependenteController().adicionarDependente(numeroFuncDependente, nomeDependente, sexo,
						dataAniversarioDependente, grauparentesco);

				System.out.println("Dependente cadastrado");
				break;
			default:
				System.out.println("Opcao invalida");
				break;
			}
		}
	}

	public static FuncionarioView getInstance() {
		if (funcionarioView == null) {
			funcionarioView = new FuncionarioView();
		}

		return funcionarioView;
	}

}
