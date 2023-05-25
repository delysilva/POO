package Classes;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

//definir aplicação que vai gerenciar a interação com o usuário.


// A implementação iniciará com três opções: Alugar um imóvel ou Se tornar um proprietário ou Fazer Login.

// Para alugar um imóvel, o usuário deverá informar a cidade na qual deseja alugar um imóvel, podendo especificar o tipo.
// Para cadastrar um imóvel, o usuário deverá informar todos os atributos necessários.
public class Aplicacao {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        BancoDeProprietarios sistema = new BancoDeProprietarios();
        int opcao = 0;
        while(opcao != 4){
            menu();
            opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    alugarImovel(sistema);
                    break;
                case 2:
                    cadastrarProprietario(sistema);
                    break;
                case 3:
                    fazerLogin(sistema);
                    break;
                case 4:
                    System.out.println("Obrigado por utilizar nosso sistema!\n");
                    break;
                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        }
    }

    // MENU PRINCIPAL
    public static void menu(){
        System.out.println("Bem vindo ao sistema de aluguel de imóveis\n");
        System.out.println("Escolha uma das opções abaixo:\n");
        System.out.println("1 - Alugar um imóvel");
        System.out.println("2 - Se tornar um proprietário");
        System.out.println("3 - Fazer Login");
        System.out.println("4 - Sair\n");
    }

    // ALUGAR IMOVEL
    public static void alugarImovel(BancoDeProprietarios sistema){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Digite o estado no qual deseja alugar um imóvel:");
        String estado = scanner.nextLine();
        System.out.println("Digite a cidade na qual deseja alugar um imóvel:");
        String cidade = scanner.nextLine();
        // talvez fosse possível implementar filtros de busca por preço, tipo de imóvel, etc.

        // retomarei depois, falta implementar uma busca por data de disponibilidade(IMPORTANTE). FEITO
        System.out.println("Esses são os imóveis disponíveis para aluguel de acordo com as suas especificações:");
        sistema.consultaImoveis(estado, cidade);
        System.out.println("Digite o número do imóvel que deseja alugar:");
        int numero = scanner1.nextInt();
        Imovel imovel = sistema.getImovel(estado, cidade, numero);
        alugar(imovel, sistema);
    }

    public static void alugar(Imovel imovel, BancoDeProprietarios sistema){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Vamos decidir o dia da sua estadia:\n");
        System.out.println("Digite o ano em que pretende alugar o imóvel:");
        int ano = scanner1.nextInt();
        System.out.println("Digite o mês em que pretende alugar o imóvel:");
        int mes = scanner1.nextInt();
        System.out.println("Digite o dia em que pretende alugar o imóvel:");
        int dia = scanner1.nextInt();
        System.out.println("Vamos verificar se o imóvel está disponível para aluguel na data especificada:\n");
        if(imovel.isDisponivel(ano, mes, dia)){
            System.out.println("O imóvel está disponível para aluguel na data especificada!\n");
            System.out.println("Deseja alugar o imóvel?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            int opcao = scanner1.nextInt();
            if(opcao == 1){
                imovel.alugar(ano, mes, dia);
                System.out.println("Imóvel alugado em seu nome! Obrigado por utilizar nosso sistema!\n");
                System.out.println("Vamos te redirecionar para o menu principal.\n");
                System.out.println("______________________________________________________\n");
            }else{
                System.out.println("Obrigado por utilizar nosso sistema!\n");
            }
        }else{
            System.out.println("O imóvel não está disponível para aluguel na data especificada. :(\n");
            System.out.println("Deseja tentar outra data?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            int opcao = scanner1.nextInt();
            if(opcao == 1){
                alugarImovel(sistema);
            }else{
                System.out.println("Obrigado por utilizar nosso sistema!\n");
            }
        }
    }

    // CADASTRAR PROPRIETARIO
    public static void cadastrarProprietario(BancoDeProprietarios sistema){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite seu CPF:");
        String cpf = scanner.nextLine();
        System.out.println("Digite sua identidade:");
        String identidade = scanner.nextLine();
        System.out.println("Digite seu CEP:");
        String cep = scanner.nextLine();
        System.out.println("Digite seu estado:");
        String estado = scanner.nextLine();
        System.out.println("Digite sua cidade:");
        String cidade = scanner.nextLine();
        System.out.println("Digite sua rua:");
        String rua = scanner.nextLine();
        System.out.println("Digite o número da sua casa:");
        int numero = scanner1.nextInt();
        Proprietario proprietario = new Proprietario(nome, cpf, identidade, cep, estado, cidade, rua, numero);
        System.out.println("Pronto " + proprietario.getNome()+"!\nVamos cadastrar o seu primeiro Imóvel!\n");
        sistema.addProprietario(proprietario);
        cadastrarImovel(proprietario);
    }

    // CADASTRAR IMOVEL
    public static void cadastrarImovel(Proprietario proprietario){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Digite o CEP do seu imóvel:");
        String cep = scanner.nextLine();
        System.out.println("Digite o estado do seu imóvel:");
        String estado = scanner.nextLine();
        System.out.println("Digite a cidade do seu imóvel:");
        String cidade = scanner.nextLine();
        System.out.println("Digite a rua do seu imóvel:");
        String rua = scanner.nextLine();
        System.out.println("Digite o número do seu imóvel:");
        int numero = scanner1.nextInt();
        System.out.println("Digite o tipo do seu imóvel: (Casa, Apartamento, Kitnet, etc.)");
        String tipo = scanner.nextLine();
        System.out.println("Digite a utilidade do seu imóvel: (Residencial, Comercial, etc.)");
        String utilidade = scanner.nextLine();
        System.out.println("Digite o valor do IPTU do seu imóvel:");
        float iptu = scanner1.nextFloat();
        Imovel imovel = new Imovel(cep, estado, cidade, rua, numero, tipo, utilidade, iptu);
        proprietario.addImovel(imovel);
        System.out.println("Imóvel cadastrado com sucesso"+proprietario.getNome()+"!\n");
    }

    // FAZER LOGIN
    public static void fazerLogin(BancoDeProprietarios sistema){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu CPF:");
        String cpf = scanner.nextLine();
        Proprietario proprietario = sistema.getProprietario(cpf);
        if(proprietario != null){
            System.out.println("Olá, "+proprietario.getNome()+"!\n");
            System.out.println("Bem vindo de volta!");
            menuProprietario(proprietario);
        }else{
            System.out.println("Desculpa, não encontramos o seu CPF no nosso sistema!\n");
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Para se tornar um proprietário, digite 1\nPara tentar novamente, digite 2\nPara sair, digite 3");
            int opcao = scanner1.nextInt();
            switch(opcao){
                case 1:
                    cadastrarProprietario(sistema);
                    break;
                case 2:
                    fazerLogin(sistema);
                    break;
                case 3:
                    System.out.println("Obrigado por utilizar nosso sistema!\n");
                    break;
                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        }
    }

    // USUARIO PROPRIETARIO
    // esse menu só é acessado quando o usuário já está logado no sistema
    public static void menuProprietario(Proprietario proprietario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma das opções abaixo:\n");
        System.out.println("1 - Cadastrar um novo imóvel");
        System.out.println("2 - Editar um imóvel");
        System.out.println("3 - Remover um imóvel");
        System.out.println("4 - Verificar os imóveis disponíveis para aluguel");
        System.out.println("5 - Sair\n");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                cadastrarImovel(proprietario);
                break;
            case 2:
                editarImovel(proprietario);
                break;
            case 3:
                removerImovel(proprietario);
                break;
            case 4:
                verificarImoveisDisponiveis(proprietario);
                break;
            case 5:
                System.out.println("Obrigado por utilizar nosso sistema!\n");
                break;
            default:
                System.out.println("Opção inválida!\n");
                break;
        }
    }

    public static void editarImovel(Proprietario proprietario){
        proprietario.listaImoveis();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Digite o número do imóvel que deseja editar:");
        int numero = scanner1.nextInt();
        Imovel imovel = proprietario.getImovelIndex(numero);
        menuEditarImovel(imovel);
    }

    public static void removerImovel(Proprietario proprietario){
        proprietario.listaImoveis();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Digite o número do imóvel que deseja remover:");
        int numero = scanner1.nextInt();
        proprietario.removeImovelIndex(numero);
        System.out.println("Imóvel removido com sucesso!\n");
        menuProprietario(proprietario);
    }

    public static void verificarImoveisDisponiveis(Proprietario proprietario){
        System.out.println("Imóveis disponíveis para aluguel:\n");
        proprietario.listaImoveis();
        menuProprietario(proprietario);
    }

    public static void menuEditarImovel(Imovel imovel){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma das opções abaixo:\n");
        System.out.println("1 - Bloquear data da Agenda do Imóvel");
        System.out.println("2 - Editar IPTU do Imóvel");
        System.out.println("3 - Bloquear Agenda do Imóvel");
        System.out.println("4 - Sair\n");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Vamos bloquear uma data:");
                System.out.println("Digite o dia:");
                int dia = scanner1.nextInt();
                System.out.println("Digite o mês:");
                int mes = scanner1.nextInt();
                System.out.println("Digite o ano:");
                int ano = scanner1.nextInt();
                imovel.bloquearData(dia, mes, ano);
                System.out.println("Data bloqueada com sucesso!\n");
                menuEditarImovel(imovel);
                break;
            case 2:
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Digite o novo valor do IPTU:");
                float iptu = scanner2.nextFloat();
                imovel.setIptu(iptu);
                break;
            case 3:
                System.out.println("Essa ação irá limpar todos os aluguéis, já agendados, do imóvel!");
                System.out.println("Deseja continuar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                int opcao2 = scanner.nextInt();
                switch(opcao2){
                    case 1:
                        imovel.bloquearAgenda();
                        break;
                    case 2:
                        menuEditarImovel(imovel);
                        break;
                    default:
                        System.out.println("Opção inválida!\n");
                        menuEditarImovel(imovel);
                        break;
                }
            case 4:
                System.out.println("Obrigado por utilizar nosso sistema!\n");
                break;
            default:
                System.out.println("Opção inválida!\n");
                menuEditarImovel(imovel);
                break;
        }
    }

}
