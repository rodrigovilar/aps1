public class Produto {

    private int id;
    private String descricao;
    private double preco;
    private double ipi;
    private double peso;
    
    public Produto() { }
    
    public Produto(int id, String descricao, double preco, double ipi) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.ipi = ipi;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public void setIpi(double ipi) {
        this.ipi = ipi;
    }
    
    public double getIpi() {
        return ipi;
    }

    public double getPrecoComImposto() {
        return getPreco() * (1 + getIpi());
    }
}
