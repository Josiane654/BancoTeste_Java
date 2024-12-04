import java.util.*;

public class Conta {

    int numero_conta;
    String titular_conta;
    double saldo;

    Scanner entrada = new Scanner(System.in);

    public Conta(String nome_titular, double saldo_inicial){
        this.titular_conta = nome_titular;
        this.saldo = saldo_inicial;

        Random gerador_numero = new Random();
        numero_conta = gerador_numero.nextInt(1000);
    }

    public void VerSaldo(){
        System.out.println("O número da conta é: " + numero_conta);
        System.out.println("O nome do titular é: " + titular_conta);
        System.out.println("O saldo da conta é: " + saldo);
    }

    public void Saque(double valor_saque){
        if (saldo >= valor_saque){
            saldo = saldo - valor_saque;
            System.out.println("Seu saldo atual é de: " + saldo);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void Deposito(double valor_deposito){
        if (valor_deposito <=0){
            System.out.println("Depósito inválido!");
        } else {
            saldo = saldo + valor_deposito;
            System.out.println("Depósito realizado com sucesso!");
            System.out.println("Seu saldo atual é de: " + saldo);
        }
    }

    public void Iniciar(){
        int opcao;

        do {
            Exibir_menu();
            opcao = entrada.nextInt();
            Escolher_funcao(opcao);
        } while (opcao != 4);
    }

    public void Emprestimo(double emprestimo){

        if (emprestimo <= saldo){
            saldo = saldo + emprestimo;
            System.out.println("Empréstimo concedido! Saldo atual: " + saldo);
        } else {
            System.out.println("Empréstimo não permitido.");
        }
    }

    public void Boleto (double boleto){

        if (boleto <= saldo){
            saldo = saldo - boleto;
            System.out.println("Pagamento de " + boleto + " realizado com sucesso!");
            System.out.println("Seu saldo atual: " + saldo);
        } else {
            System.out.println("Saldo insuficiente!");
        }

    }

    public void Exibir_menu(){
        System.out.println("Bem-vindo(a) ao banco Vouvi!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Ver saldo");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Empréstimos");
        System.out.println("5 - Pagamento de boletos");
        System.out.println("6 - Finalizar");
    }

    public void Escolher_funcao(int opcao){
        double saque;
        double deposito;
        double emprestimo;
        int boleto;

        switch(opcao){
            case 1:
                VerSaldo();
                break;
            case 2:
                System.out.println("Digite o valor a ser sacado: ");
                saque = entrada.nextDouble();
                Saque(saque);
                break;
            case 3:
                System.out.println("Digite o valor a ser depositado: ");
                deposito = entrada.nextDouble();
                Deposito(deposito);
                break;
            case 4:
                System.out.println("Digite o valor do empréstimo: ");
                emprestimo = entrada.nextDouble();
                Emprestimo(emprestimo);
                break;
            case 5:
                Random gerador_numero = new Random();
                boleto = gerador_numero.nextInt(30000);
                Boleto (boleto);
                break;
            case 6:
                System.out.println("Operação finalizada!");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
