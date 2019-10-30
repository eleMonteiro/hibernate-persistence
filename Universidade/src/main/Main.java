package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.DepartamentoController;
import controller.FuncionarioController;
import controller.ProjetoController;
import modelos.Departamento;
import modelos.Funcionario;
import modelos.Projeto;

public class Main {

	private static void exibirMenuPrincipal() {
		System.out.println("+---------------------------------+");
		System.out.println("| [0] Sair                        |");
		System.out.println("| [1] Departamentos               |");
		System.out.println("| [2] Funcionarios                |");
		System.out.println("| [3] Projetos                    |");
		System.out.println("+---------------------------------+");
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

	private static void exibirMenuDeProjetos() {
		System.out.println("+---------------------------------+");
		System.out.println("| [0] Voltar                      |");
		System.out.println("| [1] Adicionar                   |");
		System.out.println("| [2] Remover                     |");
		System.out.println("| [3] Ver Todos                   |");
		System.out.println("| [4] Buscar por ID               |");
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
//			Menu de Departamentos
			case "1":
				exibirMenuDeDepartamentos();

				String opcaoMenuDeDepartamentos = scanner.nextLine();

				switch (opcaoMenuDeDepartamentos) {
				case "0":
					System.out.println("Voltando...");
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

				break;

			// Menu de Funcionarios
			case "2":
				exibirMenuDeFuncionarios();

				String opcaoMenuDeFuncionarios = scanner.nextLine();

				switch (opcaoMenuDeFuncionarios) {
				case "0":
					System.out.println("Voltando...");
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
					Integer departamento;
					try {
						departamento = Integer.parseInt(scanner.nextLine());
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

						new FuncionarioController().adicionarPesquisador(nomeFuncionario, ruaFuncionario,
								numeroCasaFuncionario, cidadeFuncionario, sexoFuncionario, dataAniversarioFuncionario,
								salarioFuncionario, areaAtuacaoPesquisador, departamento);

						System.out.println("Pesquisador salvo com sucesso");
					} else if (tipoFuncionario.equals("1")) {
						System.out.println("Informe o grau de escolaridade do secretario: ");
						String grauEscolaridadeSecretario = scanner.nextLine();

						new FuncionarioController().adicionarSecretario(nomeFuncionario, ruaFuncionario,
								numeroCasaFuncionario, cidadeFuncionario, sexoFuncionario, dataAniversarioFuncionario,
								salarioFuncionario, grauEscolaridadeSecretario, departamento);

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
						String cargo;
						try {
							cargo = scanner.nextLine();
						} catch (Exception e) {
							System.out.println("O cargo informado nao e valida");
							break;
						}

						System.out.println("Informe a ID do gerente: ");
						Integer idGerenteFuncionarioLimpeza;
						try {
							idGerenteFuncionarioLimpeza = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("A ID informada nao e valida");
							break;
						}

						new FuncionarioController().adicionarFuncionarioLimpeza(nomeFuncionario, ruaFuncionario,
								numeroCasaFuncionario, cidadeFuncionario, sexoFuncionario, dataAniversarioFuncionario,
								salarioFuncionario, jornadaTrabalhoFuncionarioLimpeza, idGerenteFuncionarioLimpeza, cargo, departamento);

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

				default:
					System.out.println("Opcao invalida");
					break;
				}

				break;

//			Menu de Projetos
			case "3":
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

				default:
					System.out.println("Opcao invalida");
					break;
				}

				break;

			default:
				System.out.println("Opcao invalida");

				break;
			}
		}

		scanner.close();
	}
}