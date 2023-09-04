#language: pt
Funcionalidade: Carrinho de compras

  @test #cenário 2
  Cenário: Validar Alteração de Cor do Produto no Carrinho
    Dado que estou na pagina inicial do site
    Quando eu clicar na opção Special Offer no menu
    E eu clicar no botão See offer
    E eu alterar a cor do produto para a cor especificada
    E eu clicar no botão Add to cart
    Então eu devo validar que o produto foi adicionado ao carrinho com a cor selecionada


  @test #cenário 4
  Cenário: Remover Produto do Carrinho de Compras
    Dado que estou na pagina inicial do site
    Quando eu clicar na opção Special Offer no menu
    E eu clicar no botão See offer
    E eu clicar no botão Add to cart
    E eu clicar no ícone do carrinho de compras
    E eu remover o produto do carrinho de compras
    Então eu devo validar que o carrinho de compras está vazio