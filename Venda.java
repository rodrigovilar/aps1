import java.util.*;

public class Venda {
    
    private int id;
    private ArrayList<ItemVenda> itens = new ArrayList<>();
    private Estado estadoCliente;
    private Transportadora transportadora;
    private FormaDePagamento formaDePagamento;
    private Cliente cliente;

    public Venda(int id, Estado estadoCliente, Transportadora transportadora) {
        this.id = id;
        this.estadoCliente = estadoCliente;
        this.transportadora = transportadora;
    }
    
    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    
    public FormaDePagamento getFormaDePagamento() {
        return this.formaDePagamento;
    }
    
    public Estado getEstadoCliente() {
        return estadoCliente;
    }
    
    public void addNoCarrinho(Produto produto, double quantidade) {
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setQuantidade(quantidade);
        itemVenda.setProduto(produto);
        if (cliente.isVIP() ) {
            itemVenda.setQuantidade(quantidade + 1);
        }
        this.itens.add(itemVenda);
    }
    
    public double getPrecoTotal() {
        double total = somarItens();
        total *= 1 + getAliquotaICMS();
        total += getFrete();
        total += this.formaDePagamento.getCustoFormaPagamento(total);
        if (cliente.isVIP() ) {
            return total * 0.9;
        }
        
        return total;
    }
    
//    private double getCustoFormaPagamento(double valor) {        
//        switch (formaDePagamento) {          
//            case "Boleto":
//                return 2.5;                
//            case "Crédito":
//                return valor * 0.05;
//            case "Débito":
//                return valor * 0.03;
//        }        
//        retu rn 0.0;
//    }
    
    public double somarItens() {
        double total = 0.0;
        for (ItemVenda item: this.itens) {
            total += item.getSubTotal();
        }
        
        return total;
    }
    
    private double getAliquotaICMS() {
        switch (estadoCliente) {
        
            case PB:
                return 0.17;
            case PE:
                return 0.07;
        }
        
        return 0.0;
    }

    public double getFrete() {
        return this.transportadora.getOrcamento(getPesoTotal(), 
                this.estadoCliente);
    }

    public double getPesoTotal() {
        double total = 0.0;
        for (ItemVenda item: this.itens) {
            total += item.getPesoSubTotal();
        }
        
        return total;
    }
    
}
