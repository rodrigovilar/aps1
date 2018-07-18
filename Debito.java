public class Debito implements FormaDePagamento{

    public double getCustoFormaPagamento(double valor) {
        return valor * 0.03;
    }

}

