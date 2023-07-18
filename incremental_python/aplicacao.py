# classe para os menus da aplicação
from datetime import date
import proprietario
import imovel

# questão 3

class aplicacao:
    def __init__(self):
        self.listaProprietarios = []

    def get_listaProprietarios(self):
        return self.listaProprietarios

##### ESSA FUNÇÃO NÃO FAZ PARTE DA PROPOSTA, É APENAS PARA TESTE #   
    def set_listaProprietarios(self, array):        #  
        self.listaProprietarios = array            #
##################################################################

    def menuPrincipal(self):
        print("\033[36mBem vindo ao sistema de aluguel de imóveis\033[0m")
        print("\033[34m1 - Cadastrar proprietário")
        print("2 - Alugar imóvel")
        print("3 - Fazer login")
        print("4 - Sair \n \033[0m")

    def menuCadastrarProprietario(self):
        print("Vamos te cadastrar no nosso sistema! \n")
        print("Digite seu nome:")
        inputNome = input()
        inputNome = inputNome.capitalize()
        print("Digite seu CPF:")
        inputCPF = input()
        print("Digite sua identidade:")
        inputIdentidade = input()

        print("Digite seu CEP:")
        inputCEP = input()
        print("Digite seu estado (Digite no formato em sigla):")
        inputEstado = input()
        inputEstado = inputEstado.upper()
        print("Digite sua cidade:")
        inputCidade = input()
        inputCidade = inputCidade.capitalize()
        print("Digite sua rua:")
        inputRua = input()
        inputRua = inputRua.capitalize()
        print("Digite o número da sua casa/apartamento:")
        inputNumero = input()

        for tproprietario in self.get_listaProprietarios():
            if tproprietario.get_cpf() == inputCPF:
                print("\033[31mCPF já cadastrado \033[0m\n")
                return None
        user_proprietario = proprietario.proprietario(inputNome, inputCPF, inputIdentidade, inputCEP, inputEstado, inputCidade, inputRua, inputNumero)
        self.get_listaProprietarios().append(user_proprietario)
        print("\033[32mProprietário cadastrado com sucesso! \033[0m\n")
        return user_proprietario



    def menuAlugarImovel(self):
        arrayProprietarios = self.get_listaProprietarios()
        print("Digite o estado em que deseja alugar o imóvel (Sigla):")
        inputEstado = input()
        inputEstado = inputEstado.upper()
        print("Digite a cidade em que deseja alugar o imóvel:")
        inputCidade = input()
        inputCidade = inputCidade.capitalize()

        print("\n Os imóveis disponíveis são: \n")
        cnt = 1
        temp = []
        for proprietario in arrayProprietarios:
            for imovel in proprietario.get_listaImoveis():
                if imovel.get_endereco().get_estado() == inputEstado and imovel.get_endereco().get_cidade() == inputCidade:
                    print(f"Imóvel {cnt}")
                    print(f"Do proprietário {proprietario.get_nome()}")
                    print(imovel)
                    print("\n")
                    cnt += 1
                    temp.append(imovel)

        print("Digite o número do imóvel que deseja alugar")
        inputNumero = input()

        imovelToCheck = temp[int(inputNumero) - 1]

        print("\n Digite a data em que deseja alugar:")
        print("Dia:")
        inputDiaInicio = input()
        print("Mês:")
        inputMesInicio = input()
        print("Ano:")
        inputAnoInicio = input()

        print("\n Digite o número de dias que deseja alugar:")
        inputDias = input()
        
        
        for i in range (0, int(inputDias)):
            if not imovelToCheck.get_agenda().isDisponivel(date(int(inputAnoInicio), int(inputMesInicio), int(inputDiaInicio) + i)):
                print("\033[31mImóvel indisponível nessa data\033[0m")
                return False
            
        data = date(int(inputAnoInicio), int(inputMesInicio), int(inputDiaInicio))    
        if data < date.today():
                print("\033[31mOps, você não pode alugar um imóvel no passado haha!\033[0m")
                return False
        
        for i in range (0, int(inputDias)):    
            imovelToCheck.get_agenda().alugarData(date(int(inputAnoInicio), int(inputMesInicio), int(inputDiaInicio) + i))
        print("\033[32mImóvel alugado com sucesso!\033[0m")
        return True

        
        

    def menuLogin(self):
        print("Digite seu CPF:")
        inputCPF = input()
        print("Digite sua identidade:")
        inputIdentidade = input()

        for proprietario in self.get_listaProprietarios():
            if proprietario.get_cpf() == inputCPF and proprietario.get_identidade() == inputIdentidade:
                return proprietario

        print("\n Proprietário não cadastrado")
        return None

    
    def menuProprietario(self, proprietario):
        print("\n\033[36mBem vindo, " + proprietario.get_nome() + "!\033[0m")
        print("\033[34m1 - Cadastrar imóvel")
        print("2 - Editar imóvel")
        print("3 - Lista de imóveis")
        print("4 - Sair \033[0m\n")

# Aqui está implementada uma solução para quando o imóvel for em Salvador Bahia, pois python não tem sobrecarga de métodos
    def menuCadastrarImovel(self, proprietario):
        print ("\nVamos cadastrar um imóvel!")
        print("Digite o CEP do imóvel:")
        inputCEP = input()
        print("O imóvel fica em Salvador-BA? (S/N)")
        inputSalvador = input()
        inputSalvador = inputSalvador.upper()

        inputEstado = "BA"
        inputCidade = "Salvador"
        if inputSalvador == "N":
            print("Digite o estado do imóvel:")
            inputEstado = input()
            inputEstado = inputEstado.upper()
            print("Digite a cidade do imóvel:")
            inputCidade = input()
            inputCidade = inputCidade.capitalize()

        print("Digite a rua do imóvel:")
        inputRua = input()
        inputRua = inputRua.capitalize()
        print("Digite o número do imóvel:")
        inputNumero = input()
        print("Digite o valor do IPTU do imóvel:")
        inputIPTU = input()
        print("Digite o tipo do imóvel(Casa, Sítio, Apartamento, etc.):")
        inputTipo = input()
        inputTipo = inputTipo.capitalize()
        print("Digite a utilização do imóvel(Residencial, Comercial, etc.):")
        inputUtilizacao = input()
        inputUtilizacao = inputUtilizacao.capitalize()

        for check_imovel in proprietario.get_listaImoveis():
            if check_imovel.get_endereco().get_cep() == inputCEP and check_imovel.get_endereco().get_estado() == inputEstado and check_imovel.get_endereco().get_cidade() == inputCidade and check_imovel.get_endereco().get_rua() == inputRua and check_imovel.get_endereco().get_numero() == inputNumero:
                print("\n Imóvel já cadastrado")
            
        proprietario.cadastraImovel(imovel.imovel(inputCEP, inputEstado, inputCidade, inputRua, inputNumero, inputIPTU, inputTipo, inputUtilizacao))
    
    def menuListaImoveis(self, proprietario):
        print("\033[36mDeseja listar imóveis por qual tipo?")
        print("\033[34m1 - Todos")
        print("2 - Casa")
        print("3 - Apartamento")
        print("4 - Outro\033[0m")
        option = input()
        if option == "4":
            print("Digite o tipo dos imóveis a listar:")
            inputTipo = input()

        elif option == "1":
            inputTipo = "Todos"
        
        elif option == "2":
            inputTipo = "Casa"

        elif option == "3":
            inputTipo = "Apartamento"

        proprietario.listaImoveis(inputTipo)


    
    def menuEditarImovel(self, proprietario):
        proprietario.listaImoveis("Todos")
        print("\n Digite o número do imóvel que deseja editar:")

        inputNumero = input()
        imovel = proprietario.getImovel(int(inputNumero) - 1)
        return imovel




    def menuImovel(self, imovel):
        print(f"\n\033[36mEsse espaço se refere ao imóvel do estado {imovel.get_endereco().get_estado()}, cidade {imovel.get_endereco().get_cidade()}, rua {imovel.get_endereco().get_rua()}, número {imovel.get_endereco().get_numero()}")
        print("\033[34m1 - Atualizar endereço")
        print("2 - Bloquear data")
        print("3 - Desbloquear data")
        print("4 - Sair \033[0m\n")

# não é algo natural mudar um imóvel de localização, mas vamos supor que isso acontece, então tá aqui a implementação
# Aqui também está implementada uma solução para quando o imóvel for em Salvador Bahia, pois python não tem sobrecarga de métodos
    def menuAtualizarEndereco(self, imovel):
        print("Digite o novo CEP do imóvel:")
        inputCEP = input()
        print("O novo endereço continua no mesmo estado e cidade? (S/N)")
        inputSN = input()
        inputSN = inputSN.upper()
        inputCidade = imovel.get_endereco().get_cidade()
        inputEstado = imovel.get_endereco().get_estado()
        if inputSN == "N":
            print("Digite o novo estado do imóvel:")
            inputEstado = input()
            inputEstado = inputEstado.upper()
            print("Digite a nova cidade do imóvel:")
            inputCidade = input()
            inputCidade = inputCidade.capitalize()
            imovel.get_endereco().set_estado(inputEstado)
            imovel.get_endereco().set_cidade(inputCidade)
        print("Digite a nova rua do imóvel:")
        inputRua = input()
        inputRua = inputRua.capitalize()
        print("Digite o novo número do imóvel:")
        inputNumero = input()

        imovel.atualizaEndereco(inputCEP, inputEstado, inputCidade, inputRua, inputNumero)

        print("\n Endereço atualizado com sucesso!")

    def menuBloquearData(self, imovel):
        print("\n Digite a data que deseja bloquear:")
        print("Dia:")
        inputDia = input()
        print("Mês:")
        inputMes = input()
        print("Ano:")
        inputAno = input()

        imovel.get_agenda().bloquearData(date(int(inputAno), int(inputMes), int(inputDia)))

        print("\n Data bloqueada com sucesso! \n")

    def menuDesbloquearData(self, imovel):
        print("\nDigite a data que deseja desbloquear:")
        print("Dia:")
        inputDia = input()
        print("Mês:")
        inputMes = input()
        print("Ano:")
        inputAno = input()

        imovel.get_agenda().desbloquearData(date(int(inputAno), int(inputMes), int(inputDia)))

        print("\nData desbloqueada com sucesso!\n")

