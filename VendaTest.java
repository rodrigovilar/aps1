

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VendaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VendaTest
{
    /**
     * Default constructor for test class VendaTest
     */
    public VendaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void trocarFormaPagamento()
    {
        Correios correios1 = new Correios();
        Venda venda1 = new Venda(1, Estado.PB, correios1);
        Produto produto1 = new Produto(1, "Agua", 1, 0);
        venda1.addNoCarrinho(produto1, 1000);
        produto1.setPeso(1);
        Boleto boleto1 = new Boleto();
        Credito credito1 = new Credito();
        Debito debito1 = new Debito();
        venda1.setFormaDePagamento(boleto1);
        assertEquals(2172.5, venda1.getPrecoTotal(), 0.1);
        venda1.setFormaDePagamento(credito1);
        assertEquals(2278.5, venda1.getPrecoTotal(), 0.1);
        venda1.setFormaDePagamento(debito1);
        assertEquals(2235.1, venda1.getPrecoTotal(), 0.1);
    }
}

