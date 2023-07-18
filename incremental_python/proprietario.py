# classe de proprietário questão 1 letra b
import endereco
import imovel

class proprietario:

    def __init__(self, nome, cpf, identidade, cep, estado, cidade, rua, numero):
        self.nome = nome
        self.cpf = cpf
        self.identidade = identidade
        self.endereco = endereco.endereco(cep, estado, cidade, rua, numero)
        self.ListaImoveis = []

    # falta a sobrecarga do construtor

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
        return self.endereco.get_cep()
    
    def set_cep(self, cep):
        self.endereco.set_cep(cep)

    def get_estado(self):
        return self.endereco.get_estado()
    
    def set_estado(self, estado):
        self.endereco.set_estado(estado)

    def get_cidade(self):
        return self.endereco.get_cidade()
    
    def set_cidade(self, cidade):
        self.endereco.set_cidade(cidade)

    def get_rua(self):
        return self.endereco.get_rua()
    
    def set_rua(self, rua):
        self.endereco.set_rua(rua)

    def get_numero(self):
        return self.endereco.get_numero()
    
    def set_numero(self, numero):
        self.endereco.set_numero(numero)

    def get_iptu(self):
        return self.endereco.get_iptu()
    
    def set_iptu(self, iptu):
        self.endereco.set_iptu(iptu)

    def get_listaImoveis(self):
        return self.ListaImoveis
    
    def get_endereco(self):
        return self.endereco

    #questão 1 letra d (ATUALIZA ENDEREÇO)

    def atualizaEndereco(self, cep, rua, numero, estado=None, cidade=None):
        self.endereco.set_cep(cep)
        if estado is not None or cidade is not None:
            self.endereco.set_estado(estado)
            self.endereco.set_cidade(cidade)
        self.rua = rua
        self.numero = numero

    #sobrecarga de método NÃO FUNCIONA

#   def atualizaEndereco(self, cep, rua, numero):
#        self.cep = cep
#        self.rua = rua
#        self.numero = numero

    #questão 2 cadastra imovel

    def cadastraImovel(self, imovel):
        if imovel.get_endereco().get_cep() == self.endereco.get_cep() and imovel.get_endereco().get_rua() == self.endereco.get_rua() and imovel.get_endereco().get_numero() == self.endereco.get_numero():
            print("\033[31mVocê não pode cadastrar um imóvel no mesmo endereço do proprietário\033[0m")
            return False
        elif(imovel in self.ListaImoveis):
            print("Imóvel já cadastrado")
            return False
        else:
            self.ListaImoveis.append(imovel)
            print("Imóvel cadastrado com sucesso")
            return True
        
    #questão 2 letra a (LISTA IMOVEIS)

    def listaImoveis(self, tipo):
        tipo = tipo.lower()
        tipo = tipo.capitalize()
        if tipo != "Todos":
            cnt = 1
            print("Listando imóveis do tipo " + tipo + ": \n")
            for i in self.get_listaImoveis():
                if i.get_tipo() == tipo:
                    print("Imóvel " + str(cnt) + ": \n")
                    print(i)
                    cnt += 1
        else:
            cnt = 1
            print("Listando todos os imóveis: \n")
            for i in self.get_listaImoveis():
                print("Imóvel " + str(cnt) + ": \n")
                print(i)
                cnt += 1


    def getImovel(self, index):
        return self.ListaImoveis[index]

    