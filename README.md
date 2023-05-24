# Programação Orientada a Objetos em Java.
Repositório da disciplina Programação Orientada a Objetos, referente aos Exercícios Incrementais.

O repositório contém os seguintes arquivos:

1. Um arquivo **Main.java** com casos de teste para as classes.

2. Uma pasta **Classes** contendo:

    1. Um arquivo **Imovel.java** (classe correspondente aos objetos do tipo Imóvel, agregada de Proprietário.java).

    2. Um arquivo **Proprietario.java** (classe correspondente aos objetos do tipo Proprietário, agregadora de Imóvel.java).

    3. Um arquivo **Endereco.java** (classe correspondente aos objetos do tipo Endereço, agregada à classe Imóvel.java e agregadora do Enum Estados.java).

    4. Um arquivo **Estados.java** (classe correspondente a um Enum dos estados brasileiros de acordo com suas siglas. A classe é agregada à classe Endereco.java).

    5. Um arquivo **Tipo.java** (Enum para tipos de imóveis, limitando a escolha do usuário. Classe agregada à Imovel.java).

    6. Um arquivo **Agenda.java** (classe correspondente a objetos do tipo Agenda. Classe agregada à Imovel.java).
    
    7. Um arquivo **BancoDeProprietarios.java** (classe responsável por armazenar todos os proprietários do Sistema dentro de um ArrayList, só interage com Aplicacao.java).
     
    8. Um arquivo **Aplicacao.java** (classe com métodos estáticos para o funcionamento do programa, com opções de acessibilidade para o usuário por meio do prompt de comando). 

