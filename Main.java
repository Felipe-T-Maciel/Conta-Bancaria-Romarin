//Conta Bancaria feita pelo Romarin
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Conta Conta;


    public static void main(String[] args) {
        contaspadrao();
        telaInicial();
        login();
    }

    public static void telaInicial(){
        int opcao;
        do {
            System.out.println("""
                Tela de login
                
                1 - Login
                2 - Registrar-se
                3 - Sair
                > """);
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    login();
                    break;
                case 2:
                    cadastro();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while(true);
    }

    public static void cadastro(){
        System.out.println("\n\t!!!Contas padrao tem o numero de 1 a 6!!!\n");
        System.out.println("Titular da conta: ");
        String titular = sc.next();
        System.out.println("numero da conta: ");
        int numero = sc.nextInt();
        System.out.println("agencia: ");
        int agencia = sc.nextInt();
        Conta contaNova = new Conta(agencia, titular, numero);
        Conta.contas.add(contaNova);
    }

    public static void operacao(int operacao){
        switch (operacao) {
            case 1:
                Conta.credito(definevalor());
                System.out.println("\n\n---------------------------");
                System.out.println("Saldo da sua conta: "+Conta.saldo+"$");

                break;

            case 2:
                Conta.debito(definevalor());
                System.out.println("\n\n---------------------------");
                System.out.println("Saldo da sua conta: "+Conta.saldo+"$");


                break;

            case 3:
                Conta conta2 = defineConta();
                Conta.transferencia(definevalor(), defineConta());
                System.out.println("\n\n---------------------------");
                System.out.println("Saldo da sua conta: "+Conta.saldo+"$");
                System.out.println("Saldo da conta de "+ conta2.titular+": "+conta2.saldo+"$ | numero da conta: "+conta2.numero);

                break;
            case 4:
                Conta = null;
                System.exit(0);
                break;
        }
    }

    public static void contaspadrao(){
        Conta novaConta1 = new Conta(123,"wesley ", 1);
        Conta novaConta2 = new Conta(321,"maiquadi ", 2);
        Conta novaConta3 = new Conta(456,"kaique ", 3);
        Conta novaConta4 = new Conta(7889,"davi ", 4);
        Conta novaConta5 = new Conta(910,"junatas ", 5);
        Conta novaConta6 = new Conta(123,"stassun ", 6);

        Conta.contas.add(novaConta1);
        Conta.contas.add(novaConta2);
        Conta.contas.add(novaConta3);
        Conta.contas.add(novaConta4);
        Conta.contas.add(novaConta5);
    }

    public static void login(){
        do {
            System.out.println("numero da Conta: ");
            int num = sc.nextInt();
            Conta = buscarContas(num);
        }while(Conta==null);
        do{
            operacao(menu());
        }while (Conta!=null);
    }

    public  static  int  menu(){
        int opcao;
        do{
            System.out.println(
                "\nMenu principal "+ Conta.titular+
                "\n"+
                "\n1 - Depósito"+
                "\n2 - Débito"+
                "\n3 - Transferencia"+
                "\n4 - Sair"+
                "\n: ");
            opcao = sc.nextInt();
        }while(opcao<1 || opcao >4);
        return opcao;
    }

    public static double definevalor(){
        double valor;
        do {
            System.out.println("Qual o valor da operação? ");
            valor = sc.nextDouble();
        }while (valor<=0 && Conta.saldo >= valor);
        return valor;
    }

    public static Conta defineConta(){
        System.out.println("Informe o numero da Conta para transferencia: ");
        return buscarContas(sc.nextInt());
    }

    public static Conta buscarContas(int num){
        Conta cont = null;
        for (Conta contaFor : Conta.contas) {
            if (contaFor.numero == num){
                cont = contaFor;
            }
        }
        return cont;
    }
}
