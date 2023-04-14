
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class GerenciarFuncionario {
    public List<Funcionario> funcionarios = new ArrayList<>();
    public Scanner sc = new Scanner(System.in);

    
    
    
    public static void main(String[] args) {
        GerenciarFuncionario gerenciarFuncionario = new GerenciarFuncionario();
        int opcao;

        do {
            System.out.println(" 1 - Cadastrar um funcionario");
            System.out.println(" 2  - Consultare um funcionario");
            System.out.println(" 3 - Bonificar um funcionário");
            System.out.println(" 4 - Bonificar todos os funcionários");
            System.out.println(" 5 - Ativar ou desativar um uncionário");
            System.out.println(" 6 - Sair");
            System.out.println("Digite a opção desejada: ");

            opcao = Integer.parseInt(gerenciarFuncionario.sc.nextLine());

            switch (opcao) {
                case 1:
                    gerenciarFuncionario.execCadastrar();
                    break;
                case 2:
                    gerenciarFuncionario.execConsultar();
                    break;
                case 3:
                    gerenciarFuncionario.execBonificarUnico();
                    break;
                case 4:
                    gerenciarFuncionario.execBonificar();
                    break;
                case 5:
                    gerenciarFuncionario.execAtivoDesativo();
                    break;
                case 9:
                    gerenciarFuncionario.execSair();
                    break;
                default:
                    System.out.println("Opcção inválida, por favor,digite novamente");
            }

            System.out.println("Pressione ENTER para continuar...");
            gerenciarFuncionario.sc.nextLine();
        } while (opcao != 9);
    }


    
    public void execSair() {
        System.out.println("Saindo do sistema");
        System.exit(0);
    }

    
    
    
    
    public void execCadastrar() {

        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite o número de registro: ");
        long registro = Long.parseLong(sc.nextLine());

        System.out.println("Digite o departamento: ");
        String departamento = sc.nextLine();

        System.out.println("Digite o RG: ");
        String rg = sc.nextLine();

        System.out.println("Digite o salário: ");
        double salario = Double.parseDouble(sc.nextLine());

        Funcionario funcionario = new Funcionario();

        funcionario.setRegistro(registro);
        funcionario.setDepartamento(departamento);
        funcionario.setNome(nome);
        funcionario.setRg(rg);
        funcionario.setSalario(salario);

        funcionarios.add(funcionario);

        System.out.println("Funcionário cadastrado com sucesso!");
        System.out.println(funcionario);
    }

    
    
    
    /**
     * O que era extamente para fazer no método "isEstaAtivo?
     * Tive de pedir ajuda para o pessoal da sala por que eu não entendi muito bem o que era para fazer....
     */
    public void execAtivoDesativo() {
        System.out.println("Digite o registro do funcionário: ");
        long registro = Long.parseLong(sc.nextLine());

        Funcionario funcionario = buscarFuncionario(registro);

        if (funcionario == null) {
            System.out.println("Funcionário não cadastrado no sistema.");
            return;
        }

        boolean estaAtivo = funcionario.isEstaAtivo();
        System.out.println("Estado atual do funcionário: " + funcionario.status());

        System.out.println("Deseja alterar o estado do funcionário para " + funcionario.status(!estaAtivo) + "? (S/N)");
        String opcao = sc.nextLine();

        if (opcao.equalsIgnoreCase("S")) {
            funcionario.setEstaAtivo(!estaAtivo);
            System.out.println("Estado do funcionário alterado com sucesso para " + funcionario.status());
            return;
        }

        System.out.println("Estado do funcionário permanece como " + funcionario.status(estaAtivo));
    }

    public void execConsultarUnico() {
        System.out.println("Digite o registro do funcionário: ");
        long registro = Long.parseLong(sc.nextLine());

        Funcionario funcionario = buscarFuncionario(registro);

        if (funcionario == null) {
            System.out.println("Funcionário não cadastrado no sistema.");
            return;
        }

        System.out.println(funcionario);
    }

    private Funcionario buscarFuncionario(long registro) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getRegistro() == registro) {
                return funcionario;
            }
        }

        return null;
    }

    
    
    
    public void execBonificarUnico() {
        System.out.println("Digite onúmero de registro: ");
        long registro = Long.parseLong(sc.nextLine());

        System.out.println("Digite o valor da bonificação: ");
        double salario = Double.parseDouble(sc.nextLine());

        Funcionario funcionario = buscarFuncionario(registro);

        if (funcionario == null) {
            System.out.println("Funcionário não existe");
            return;
        }

        if (funcionario.isEstaAtivo()) {
            funcionario.bonificar(salario);

            System.out.println("Funcionario: " + funcionario);
            System.out.println(funcionario+ "foi bonificado com sucesso no valor de " + salario);
            return;
        }

        System.out.println("Funcionrio inativo, bonificacao invalida.");
    }

    
    
    
    public void execBonificar() {
        System.out.println("Digite o valor da bonificação: ");
        double salario = Double.parseDouble(sc.nextLine());

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.isEstaAtivo())
                funcionario.bonificar(salario);
        }

        System.out.println("Funcionários bonificiados com sucesso.");
        System.out.println("Valor da bonificação: " + salario);
    }
    public void execConsultar() {
        int opcao;

        do {

            System.out.println(" 1 - Listar todos os funcionarios");
            System.out.println(" 2 - Consultar um funcionario");
            System.out.println(" 3 - Voltar ao menu principal");
            System.out.print("Escollha uma opção: ");

            opcao = Integer.parseInt(sc.nextLine());

            
            switch (opcao) {
                case 1 -> {
                    for (Funcionario funcionario : funcionarios) {
                        System.out.println(funcionario);
                    }
                }
                case 2 -> execConsultarUnico();
                case 3 -> System.out.println("Voltando ao menu principal");
                default -> System.out.println("Opção inválida. Digite novamente a opção desejadaa.");
            }
        
        } while (opcao != 3);
    
    
    }
}

