# classe endereço Questão 2

class endereco:

    def __init__(self, cep, estado, cidade, rua, numero):
        self.cep = cep
        self.estado = estado
        self.cidade = cidade
        self.rua = rua
        self.numero = numero

    #gets e sets

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

    def equals(self, endereco):
        if self.cep == endereco.get_cep() and self.estado == endereco.get_estado() and self.cidade == endereco.get_cidade() and self.rua == endereco.get_rua() and self.numero == endereco.get_numero():
            return True
        else:
            return False
    
    def __str__(self):
        return "CEP: " + self.cep + "\nEstado: " + self.estado + "\nCidade: " + self.cidade + "\nRua: " + self.rua + "\nNúmero: " + str(self.numero)