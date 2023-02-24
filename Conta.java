import java.util.ArrayList;

public class Conta {

    static ArrayList<Conta> contas = new ArrayList<>();

    // atributos = caracteristicas de um "possivel" objeto.
    double saldo = 0.0;
    int agencia;
    int numero;
    String titular;

    public Conta(int agencia, String titular, int numero) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;


    }



    //Métodos = Ações possíveis de execução de um objeto.
    public double debito(double valor) {
        return saldo -= valor;
    }

    public double credito(double valor) {
        return saldo += valor;
    }

    public double transferencia(double valor, Conta recebedor) {
        recebedor.credito(valor);
        return this.debito(valor);

    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", titular='" + titular + '\'' +
                '}';
    }
}
