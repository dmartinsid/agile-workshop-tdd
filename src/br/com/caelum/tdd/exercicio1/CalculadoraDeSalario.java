package br.com.caelum.tdd.exercicio1;

import static br.com.caelum.tdd.exercicio1.Cargo.DBA;
import static br.com.caelum.tdd.exercicio1.Cargo.DESENVOLVEDOR;
import static br.com.caelum.tdd.exercicio1.Cargo.TESTADOR;
import static br.com.caelum.tdd.exercicio1.Cargo.GERENTE_DE_PROJETOS;;

public class CalculadoraDeSalario {


	public double calcula(Funcionario funcionario) {
		if(DESENVOLVEDOR.equals(funcionario.getCargo())) {
			return funcionario.getCargo().calculaSalarioLiquido(funcionario.getSalarioBase());
		}
		
		if(DBA.equals(funcionario.getCargo()) || TESTADOR.equals(funcionario.getCargo())) {
			return quinzeOuVinteECincoPorCentoDeDescontoNo(funcionario);
		}
		if(GERENTE_DE_PROJETOS.equals(funcionario.getCargo()))
		{
			return funcionario.getSalarioBase() >= 5000 ? funcionario.getSalarioBase() * 0.8 : funcionario.getSalarioBase() * 0.85; 
		}
		
		throw new RuntimeException("funcionario invalido");
	}

	
	

	private double quinzeOuVinteECincoPorCentoDeDescontoNo(Funcionario funcionario) {
		if(funcionario.getSalarioBase() > 2000.0) {
			return funcionario.getSalarioBase() * 0.75;
		}
		else {
			return funcionario.getSalarioBase() * 0.85;
		}
	}

}
