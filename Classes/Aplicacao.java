package Classes;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

//definir aplicação que vai gerenciar a interação com o usuário.


// A implementação iniciará com três opções: Alugar um imóvel ou Se tornar um proprietário ou Fazer Login.

// Para alugar um imóvel, o usuário deverá informar a cidade na qual deseja alugar um imóvel, podendo especificar o tipo.
// Para cadastrar um imóvel, o usuário deverá informar todos os atributos necessários.
public class Aplicacao {

    public static void main(String[] args) {
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

    public static void menu(){
        System.out.println("Bem vindo ao sistema de aluguel de imóveis\n");
        System.out.println("Escolha uma das opções abaixo:\n");
        System.out.println("1 - Alugar um imóvel");
        System.out.println("2 - Se tornar um proprietário");
        System.out.println("3 - Fazer Login");
        System.out.println("4 - Sair\n");
    }

    public static void alugarImovel(BancoDeProprietarios sistema){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o estado no qual deseja alugar um imóvel:");
        String estado = scanner.nextLine();
        System.out.println("Digite a cidade na qual deseja alugar um imóvel:");
        String cidade = scanner.nextLine();
        // talvez fosse possível implementar filtros de busca por preço, tipo de imóvel, etc.

        // retomarei depois, falta implementar uma busca por data de disponibilidade(IMPORTANTE).
        System.out.println("Esses são os imóveis disponíveis para aluguel de acordo com as suas especificações:");

    }

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
        System.out.println("Pronto" + proprietario.getNome()+"!\nVamos cadastrar o seu primeiro Imóvel!\n");
        cadastrarImovel(proprietario);
    }

    public static void cadastrarImovel(Proprietario proprietario){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Digite o
    }
}
