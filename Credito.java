public class Credito implements FormaDePagamento{

    public double getCustoFormaPagamento(double valor) {
        return valor * 0.05;
    }

}
