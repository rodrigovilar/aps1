import java.util.*;


public class SistemaCormecioEletronico {
    
    private static ArrayList<Venda> vendas = new ArrayList<Venda>();

    public static Venda criarVenda(int id) {
        Venda venda = new Venda(id, Estado.PB, null);
        vendas.add(venda);
        return venda;
    }

}
