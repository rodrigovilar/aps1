public class ItemVenda {

    private double quantidade;
    private Produto produto;
    
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    
    public double getQuantidade() {
        return quantidade;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public Produto getProduto() {
        return produto;
    }
    
    public double getSubTotal() {
        if (this.getProduto() == null) {
            return 0.0;
        }
        
        return this.getQuantidade() * this.getProduto().getPrecoComImposto();
    }
    
    public double getPesoSubTotal() {
        return this.getQuantidade() * this.getProduto().getPeso();
    }
    
    
}
