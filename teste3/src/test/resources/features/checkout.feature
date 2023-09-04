#language: pt

Funcionalidade: Validar página de checkout

  @test #cenário 3
  Cenário: Validar Página de Checkout
    Dado que estou na pagina inicial do site
    Quando eu pesquisar pelo produto usando o ícone de pesquisa
    E eu selecionar o produto pesquisado
    E eu alterar a cor do produto para uma diferente do BD
    E eu alterar a quantidade desejada de produtos
    E eu clicar no botão Add to cart
    E eu acessar a página de checkout
    Então eu devo validar que a soma dos valores corresponde ao valor total
    E eu devo alterar a cor no banco de dados conforme cor selecionada
