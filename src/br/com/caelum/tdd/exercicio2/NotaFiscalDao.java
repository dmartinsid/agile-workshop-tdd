package br.com.caelum.tdd.exercicio2;

public interface NotaFiscalDao extends Observador {
	void persiste(NotaFiscal nf);
}
