# classe de proprietário questão 1 letra b
import endereco

class Proprietario:

    def __init__(self, nome, cpf, identidade, cep, estado, cidade, rua, numero, iptu):
        self.nome = nome
        self.cpf = cpf
        self.identidade = identidade
        self.endereco = endereco(cep, estado, cidade, rua, numero)
        self.iptu = iptu
        self.ListaImoveis = []

    # sobrecarga de construtor
    def __init__(self, nome, cpf, identidade, cep, rua, numero):
        self(nome, cpf, identidade, cep, "Bahia", "Salvador", rua, numero)
    #gets e sets

    def get_nome(self):
        return self.nome
    
    def set_nome(self, nome):
        self.nome = nome

    def get_cpf(self):
        return self.cpf
    
    def set_cpf(self, cpf):
        self.cpf = cpf

    def get_identidade(self):
        return self.identidade
    
    def set_identidade(self, identidade):
        self.identidade = identidade

    def get_cep(self):
        return self.cep
    
    def set_cep(self, cep):
        self.cep = cep

    def get_estado(self):
        return self.estado
    
    def set_estado(self, estado):
        self.estado = estado

    def get_cidade(self):
        return self.cidade
    
    def set_cidade(self, cidade):
        self.cidade = cidade

    def get_rua(self):
        return self.rua
    
    def set_rua(self, rua):
        self.rua = rua

    def get_numero(self):
        return self.numero
    
    def set_numero(self, numero):
        self.numero = numero

    def get_iptu(self):
        return self.iptu
    
    def set_iptu(self, iptu):
        self.iptu = iptu

    #questão 1 letra d (ATUALIZA ENDEREÇO)

    def atualizaEndereco(self, cep, estado, cidade, rua, numero):
        self.cep = cep
        self.estado = estado
        self.cidade = cidade
        self.rua = rua
        self.numero = numero

    #sobrecarga de método

    def atualizaEndereco(self, cep, rua, numero):
        self.cep = cep
        self.rua = rua
        self.numero = numero

    #questão 2 cadastra imovel

    def cadastraImovel(self, imovel):
        if imovel.getEndereco().equals(self.endereco):
            print("Você não pode cadastrar um imóvel no mesmo endereço do proprietário")
            return False
        elif(self.listaImoveis.contains(imovel)):
            print("Imóvel já cadastrado")
            return False
        else:
            self.listaImoveis.append(imovel)
            return True
        
    #questão 2 letra a (LISTA IMOVEIS)

    def listaImoveis(self, tipo):
        cnt = 1
        print("Listando imóveis do tipo " + tipo + ": \n")
        for i in self.listaImoveis:
            if i.getTipo() == tipo:
                print("Imóvel " + str(cnt) + ": \n")
                print(i)

    