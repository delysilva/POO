package Classes;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.Period;


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
        System.out.println("Você escolheu o imóvel: " + imovel.toString() + "\n Certo?\n");
        System.out.println("1 - Sim");
        System.out.println("2 - Não (ESCOLHER NOVAMENTE)");
        int opcao = scanner1.nextInt();
        if(opcao == 1){
            alugar(imovel, sistema);
        }
        else{
            alugarImovel(sistema);
        }
    }

    public static void alugar(Imovel imovel, BancoDeProprietarios sistema){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Vamos decidir a duração da sua estadia:\n");
        System.out.println("Digite o ano em que pretende alugar o imóvel:");
        int ano = scanner1.nextInt();
        System.out.println("Digite o mês da data de entrada:");
        int mes = scanner1.nextInt();
        System.out.println("Digite o dia da data de entrada:");
        int dia = scanner1.nextInt();
        System.out.println("Digite o ano de saída do imóvel:");
        int ano1 = scanner1.nextInt();
        System.out.println("Digite o mês da data de saída:");
        int mes1 = scanner1.nextInt();
        System.out.println("Digite o dia da data de saída:");
        int dia1 = scanner1.nextInt();
        System.out.println("Vamos verificar se o imóvel está disponível para aluguel na data/período especificado:\n");
        if(imovel.isDisponivel(ano, mes, dia, ano1, mes1, dia1)){
            System.out.println("O imóvel está disponível para aluguel na data especificada!\n");
            System.out.println("Por favor, digite o índice de sazonalidade correspondente:");
            //Reveillon, índice 20; Carnaval, índice 15; Feriado Alta Estação, índice 10; Feriado Baixa Estação, índice 5; 0:Comum (sem índice).
            System.out.println("1 - Reveillon");
            System.out.println("2 - Carnaval");
            System.out.println("3 - Feriado Alta Estação");
            System.out.println("4 - Feriado Baixa Estação");
            System.out.println("5 - Nenhuma das anteriores");
            int opcao = scanner1.nextInt();
            System.out.println("O valor do aluguel será: \n");
            LocalDate incio = LocalDate.of(ano, mes, dia);
            LocalDate fim = LocalDate.of(ano1, mes1, dia1);
            Period periodo = Period.between(incio, fim);
            int dias = periodo.getDays();
            calculaAluguel(imovel, opcao, dias);
            System.out.println("Deseja alugar o imóvel?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            opcao = scanner1.nextInt();
            if(opcao == 1){
                imovel.alugar(ano, mes, dia, ano, mes1, ano1);
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

    public static void calculaAluguel(Imovel imovel, int sazonalidade, int dias){
        //Reveillon, índice 20; Carnaval, índice 15; Feriado Alta Estação, índice 10; Feriado Baixa Estação, índice 5; 0:Comum (sem índice).
        if(sazonalidade == 1){
            sazonalidade = 20;
        }else if(sazonalidade == 2){
            sazonalidade = 15;
        }
        else if(sazonalidade == 3){
            sazonalidade = 10;
        }
        else if(sazonalidade == 4){
            sazonalidade = 5;
        }
        else{
            sazonalidade = 0;
        }
        float valor =  dias*(imovel.valorAluguel() + imovel.valorAluguel()*(float)sazonalidade);
        System.out.println("R$" + valor);
    }

    // CADASTRAR PROPRIETARIO
    public static void cadastrarProprietario(BancoDeProprietarios sistema){
        // aqui eu trato a exceção de CPF já cadastrado

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite seu CPF:");
        String cpf = scanner.nextLine();
        if(sistema.isCadastrado(cpf)){
            try{
                throw new UsuarioExistenteException("CPF já cadastrado!");
            }
            catch(UsuarioExistenteException e){
                System.out.println(e.getMessage());
                System.out.println("Para tentar novamente, digite 1\nPara sair, digite 2");
                int opcao = scanner1.nextInt();
                switch(opcao){
                    case 1:
                        cadastrarProprietario(sistema);
                        break;
                    case 2:
                        System.out.println("Obrigado por utilizar nosso sistema!\n");
                        break;
                    default:
                        System.out.println("Opção inválida!\n");
                        break;
                }
            }
        }
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
        System.out.println("O seu imóvel está dentro de um condomínio?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.println("\n");
        int opcao = scanner1.nextInt();
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
        if(opcao == 1) {
            System.out.println("Digite o nome do seu condomínio:");
            String nomeCondominio = scanner.nextLine();
            System.out.println("Digite a identificação da sua casa dentro do condomínio:");
            String identificacao = scanner.nextLine();
            Imovel imovel = new UnidadeCompartilhada(nomeCondominio, cep, estado, cidade, rua, numero, tipo, utilidade, iptu, identificacao);
            System.out.println("O seu condomínio possui itens de lazer? (psicina, quadra, etc.)");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            int opcao1 = scanner1.nextInt();
            if (opcao1 == 1) {
                System.out.println("Quantos?");
                int quantidade = scanner1.nextInt();
                for (int i = 0; i < quantidade; i++) {
                    System.out.println("Digite o nome do " + (i+1) + "º item de lazer:");
                    String item = scanner.nextLine();
                    ((UnidadeCompartilhada)imovel).addItensDeLazer(item);
                }
            }
            proprietario.addImovel(imovel);
        }else{
            System.out.println("Digite o tamanho da Área CONSTRUÍDA seu imóvel em metros quadrados:");
            float areaConstruida = scanner1.nextFloat();
            System.out.println("Digite o tamanho da Área TOTAL seu imóvel em metros quadrados:");
            float areaTotal = scanner1.nextFloat();
            Imovel imovel = new UnidadeAutonoma(cep, estado, cidade, rua, numero, tipo, utilidade, iptu, areaConstruida, areaTotal);
            proprietario.addImovel(imovel);
        }
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
                System.out.println("Quantos dias esse bloqueio vai durar?");
                int dias = scanner1.nextInt();
                imovel.bloquearData(dia, mes, ano, dias);
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
