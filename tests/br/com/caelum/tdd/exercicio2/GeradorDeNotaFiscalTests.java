package br.com.caelum.tdd.exercicio2;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GeradorDeNotaFiscalTests {

	private static final double PRECISAO = 0.00001;
	private EnviadorDeEmail email;
	private NotaFiscalDao dao;
	private GeradorDeNotaFiscal gerador;
	private Sap sap;

	@Before
	public void setUp() {
		email = mock(EnviadorDeEmail.class);
		dao = mock(NotaFiscalDao.class);
		sap = mock(Sap.class);
		//TODO 
		/**
		 * Usar padrão Observer para cria uma Interface Observador com método 
		 * notifica(NotaFiscal notaFiscal)
		 */
		
		gerador = new GeradorDeNotaFiscal(Arrays.asList(email, dao, sap));
	}
	
	@Test
	public void deveGerarNotaCom6PorCentoDeImposto() {
		Fatura fatura = new Fatura(1000, "cliente 1");
		
		NotaFiscal nf = gerador.gera(fatura);
		
		assertEquals(1000 * 0.06, nf.getImpostos(), PRECISAO);
	}
	
	@Test
	public void deveEnviarEmailComANotaFiscal() {

		Fatura fatura = new Fatura(1000, "cliente 1");
		NotaFiscal nf = gerador.gera(fatura);
		
		verify(email).enviaEmail(nf);
	}
	
	@Test
	public void devePersistirANotaFiscalGerada() {
		Fatura fatura = new Fatura(1000, "cliente 1");
		
		NotaFiscal nf = gerador.gera(fatura);
		
		verify(dao).persiste(nf);
	}
	
	@Test
	public void deveEnviarParaSap()
	{
		Fatura fatura = new Fatura(1000.0, "cliente 1");
		
		NotaFiscal notaFiscal = gerador.gera(fatura);
		
		verify(sap).envia(notaFiscal);
		
	}
}
