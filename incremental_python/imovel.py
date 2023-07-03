# Classe imovel questao 1 letra a
import endereco

class Imovel:

    def __init__(self, cep, estado, cidade, rua, numero, iptu, tipo, utilizacao):
        self.endereco = endereco(cep, estado, cidade, rua, numero)
        self.iptu = iptu
        self.tipo = tipo
        self.utilizacao = utilizacao
    
    #gets e sets

    def get_endereco(self):
        return self.endereco
    
    def get_iptu(self):
        return self.iptu
    
    def set_iptu(self, iptu):
        self.iptu = iptu

    def get_tipo(self):
        return self.tipo
    
    def set_tipo(self, tipo):
        self.tipo = tipo

    def get_utilizacao(self):
        return self.utilizacao
    
    def set_utilizacao(self, utilizacao):
        self.utilizacao = utilizacao

    def __str__(self):
        return "Endereço: " + self.endereco.__str__() + "\nIPTU: " + str(self.iptu) + "\nTipo: " + self.tipo + "\nUtilização: " + self.utilizacao