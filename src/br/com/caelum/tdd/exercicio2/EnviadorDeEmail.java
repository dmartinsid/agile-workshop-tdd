package br.com.caelum.tdd.exercicio2;


public interface EnviadorDeEmail extends Observador{

	void enviaEmail(NotaFiscal nf);
}
