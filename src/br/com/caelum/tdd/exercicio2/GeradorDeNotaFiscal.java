package br.com.caelum.tdd.exercicio2;

import java.util.List;

public class GeradorDeNotaFiscal {

	//TODO refatorar com Composite
	private List<Observador> observadores;
	

	public GeradorDeNotaFiscal(List<Observador> observadores) {
		this.observadores = observadores;
	}
	
	public NotaFiscal gera(Fatura fatura) {
		
		double valor = fatura.getValorMensal();
		
		NotaFiscal notaFiscal = new NotaFiscal(valor, impostoSimplesSobreO(valor));
		
		for(Observador observador: observadores)
			observador.notifica(notaFiscal);
		
		return notaFiscal;
	}

	private double impostoSimplesSobreO(double valor) {
		return valor * 0.06;
	}
}
