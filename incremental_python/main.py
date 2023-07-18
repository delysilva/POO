import proprietario
import imovel
import aplicacao

app = aplicacao.aplicacao()
# para testes
array = [proprietario.proprietario("João", "1234", "1234", "1234", "SP", "São Paulo", "Rua 1", "1"), proprietario.proprietario("Maria", "4321", "4321", "4321", "SP", "São Paulo", "Rua 1", "2")]
app.set_listaProprietarios(array)

# execução da questão 3
while(True):
    #menu principal
    print("\n \033[32m################################################################## \033[0m\n")
    app.menuPrincipal()
    opcao = input()

    if opcao == "1":
        user = app.menuCadastrarProprietario()
        if user != None:
            print("Bem vindo ao nosso sistema!")
            app.menuCadastrarImovel(user)

    elif opcao == "2":
        app.menuAlugarImovel()
        
    elif opcao == "3":
        proprietario = app.menuLogin()
        if proprietario != None:
            app.menuProprietario(proprietario)
            opcao2 = input()

            if opcao2 == "1":
                app.menuCadastrarImovel(proprietario)

            elif opcao2 == "2":
                imovel = app.menuEditarImovel(proprietario)
                app.menuImovel(imovel)
                opcao3 = input()
                
                if opcao3 == "1":
                    app.menuAtualizarEndereco(imovel)

                elif opcao3 == "2":
                    app.menuBloquearData(imovel)

                elif opcao3 == "3":
                    app.menuDesbloquearData(imovel)

                elif opcao3 == "4":
                    break

            elif opcao2 == "3":
                app.menuListaImoveis(proprietario)

            elif opcao2 == "4":
                break





    elif opcao == "4":
        break

print("Até logo!")