#language:pt

Funcionalidade: Validar especificações do produto

  @test #cenário 1
  Cenário: Validar Especificações do Produto
    Dado que estou na pagina inicial do site
    Quando eu clicar na opção Special Offer no menu
    E eu clicar no botão See offer
    Então eu devo validar que as especificações do produto estão conforme as informações do banco de dados
