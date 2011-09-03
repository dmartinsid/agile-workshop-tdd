package br.com.caelum.tdd.exercicio3;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FaturaTest {

	@Test
	public void deveMarcarComoPagaFaturaComSomaDePagamentosMaiorQueValorDaFatura()
	{
		Fatura fatura = new Fatura("sun", 1000.0);
		
		List<Boleto> boletosPagos = Arrays.asList(new Boleto(600), new Boleto(400));
		
		new ProcessadorDeBoletos().processa(boletosPagos, fatura);
		
		assertTrue(fatura.isPago());
		
	}
	
	@Test
	public void deveMarcarComoNaoPagaFaturaComSomaDePagamentosMenorQueValorDaFatura()
	{
		Fatura fatura = new Fatura("sun", 1000.0);
		
		List<Boleto> boletosPagos = Arrays.asList(new Boleto(600), new Boleto(399));
		
		new ProcessadorDeBoletos().processa(boletosPagos, fatura);
		
		assertFalse(fatura.isPago());
		
	}
}
