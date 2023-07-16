package br.com.nttdata.teste1;

public class Cliente {
    private String nome_cliente;
    private Telefone telefone;
    private Conta conta;

    public Cliente(String nome_cliente, Telefone telefone, Conta conta) {
        this.nome_cliente = nome_cliente;
        this.telefone = telefone;
        this.conta = conta;
    }

    public void setNome(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome() {
        return this.nome_cliente;
    }

    public void setLinha(Telefone telefone) {
        this.telefone = telefone;
    }

    public Telefone getTelefone() {
        return this.telefone;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Conta getConta() {
        return this.conta;
    }

    public boolean realizarRecarga(int valor) {
        if (conta == null){
            System.out.println("Conta inexistente.");
            return false;
        }
        if (telefone == null){
            System.out.println("Cliente não possui telefone associado.");
            return false;
        }

        if (conta.getSaldo() < valor){
            System.out.println("Saldo insuficiente!");
            return false;
        }
        if (valor <= 0){
            System.out.println("Valor da recarga deve ser maior que 0.");
            return false;
        }

        telefone.setSaldo(telefone.getSaldo() + valor);
        conta.setSaldo(conta.getSaldo() - valor);
        System.out.println("Recarga realizada com sucesso!");
        return true;
    }
}