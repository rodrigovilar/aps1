import java.util.*;

public class Venda {
    
    private int id;
    private ArrayList<ItemVenda> itens = new ArrayList<>();
    private Estado estadoCliente;
    private Transportadora transportadora;

    public Venda(int id, Estado estadoCliente, Transportadora transportadora) {
        this.id = id;
        this.estadoCliente = estadoCliente;
        this.transportadora = transportadora;
    }
    
    public Estado getEstadoCliente() {
        return estadoCliente;
    }
    
    public void addNoCarrinho(Produto produto, double quantidade) {
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setQuantidade(quantidade);
        itemVenda.setProduto(produto);
        this.itens.add(itemVenda);
    }
    
    public double getPrecoTotal() {
        double total = somarItens();
        total *= 1 + getAliquotaICMS();
        return total + getFrete();
    }
    
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
