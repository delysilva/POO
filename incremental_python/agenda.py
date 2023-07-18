#classe da agenda questão 3
from datetime import date

class agenda:
    def __init__(self):
        self.datasBloqueadas = []
        self.datasAlugadas = []

    def isDisponivel(self, data):
        if data in self.datasBloqueadas or data in self.datasAlugadas:
            return False
        else:
            return True
    
    def bloquearData(self, data):
        if self.datasBloqueadas.count(data) == 1:
            print("Data já bloqueada")
            return False
        if self.datasAlugadas.count(data) == 1:
            self.datasAlugadas.remove(data)

        self.datasBloqueadas.append(data)
        return True
    
    def desbloquearData(self, data):
        if self.datasBloqueadas.count(data) == 0:
            print("Data não bloqueada")
            return False
        self.datasBloqueadas.remove(data)
        return True

    def alugarData(self, data):
        if (self.isDisponivel(data)):
            self.datasAlugadas.append(data)
            return True
        else:
            print("Data não disponível")
            return False
    