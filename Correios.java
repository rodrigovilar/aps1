public class Correios extends Transportadora {

    public double getOrcamento(double peso, Estado destino) {
        
        switch(destino) {
            
            case PB: 
                return peso * 1;
                
            case PE: 
                return peso * 1.5;

            case AM: 
                return peso * 10;
            
        }
        
        
        return 0.0;
    }

}
