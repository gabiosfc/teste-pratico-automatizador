#language:pt

Funcionalidade: Validar cenários de teste

  @test #cenário 1
  Cenário: Validar Especificações do Produto
    Dado que estou na pagina inicial do site
    Quando eu clicar na opção Special Offer no menu
    E eu clicar no botão See offer
    Então eu devo validar que as especificações do produto estão conforme as informações do banco de dados

  @test #cenário 2
  Cenário: Validar Alteração de Cor do Produto no Carrinho
    Dado que estou na pagina inicial do site
    Quando eu clicar na opção Special Offer no menu
    E eu clicar no botão See offer
    E eu alterar a cor do produto para a cor especificada
    E eu clicar no botão Add to cart
    Então eu devo validar que o produto foi adicionado ao carrinho com a cor selecionada

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

  @test #cenário 4
  Cenário: Remover Produto do Carrinho de Compras
    Dado que estou na pagina inicial do site
    Quando eu clicar na opção Special Offer no menu
    E eu clicar no botão See offer
    E eu clicar no botão Add to cart
    E eu clicar no ícone do carrinho de compras
    E eu remover o produto do carrinho de compras
    Então eu devo validar que o carrinho de compras está vazio