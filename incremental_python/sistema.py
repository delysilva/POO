import proprietario
import imovel
import endereco

listaProprietarios = []

while(True):
    #menu
    print("Bem vindo ao sistema de aluguel de imóveis")
    print("1 - Cadastrar proprietário")
    print("2 - Fazer login")
    print("3 - Alugar imóvel")
    print("4 - Sair \n")

    opcao = int(input("Digite a opção desejada: \n"))

    if opcao == 1:
        print("Cadastro de proprietário")
        nome = input("Digite o nome do proprietário: \n")
        identidade = input("Digite a identidade do proprietário: \n")
        cpf = input("Digite o cpf do proprietário: \n")
        cep = input("Digite o cep do proprietário: \n")
        estado = input("Digite o estado do proprietário: \n")
        cidade = input("Digite a cidade do proprietário: \n")
        rua = input("Digite a rua do proprietário: \n")
        numero = input("Digite o número do proprietário: \n")
        if estado == "Bahia" and cidade == "Salvador":
            proprietario = proprietario.Proprietario(nome, identidade, cpf, cep, rua, numero)
        else:
            proprietario = proprietario.Proprietario(nome, identidade, cpf, cep, estado, cidade, rua, numero)

        listaProprietarios.append(proprietario)
        print("Proprietário cadastrado com sucesso \n")

    elif opcao == 2:
        print("Bem vindo a área de Login")