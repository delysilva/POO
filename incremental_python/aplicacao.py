# classe para os menus da aplicação

class aplicacao:
    def __init__(self):
        listaProprietarios = []

    def menuPrincipal(self):
        print("Bem vindo ao sistema de aluguel de imóveis")
        print("1 - Cadastrar proprietário")
        print("2 - Alugar imóvel")
        print("3 - Fazer login")
        print("4 - Sair")

    
    def menuProprietario(self, proprietario):
        print("Bem vindo, " + proprietario.get_nome() + "!")
        print("1 - Cadastrar imóvel")
        print("2 - Editar imóvel")
        print("3 - Sair")

    def menuImovel(self, imovel):
        print(f"Esse espaço se refere ao imóvel do estado {imovel.get_endereco().get_estado()}, cidade {imovel.get_endereco().get_cidade()}, rua {imovel.get_endereco().get_rua()}, número {imovel.get_endereco().get_numero()}")
        print("1 - Atualizar endereço")
        print("2 - Bloquear data")
        print("3 - Desbloquear data")
        print("4 - Sair")
