package br.com.caelum.tdd.exercicio1;

public enum Cargo {
	DESENVOLVEDOR {
		@Override
		public double calculaSalarioLiquido(double salarioBase) {
			if(salarioBase > 3000.0) {
				return salarioBase * 0.8;
			}
			else {
				return salarioBase * 0.9;
			}
		}
	},
	DBA {
		@Override
		public double calculaSalarioLiquido(double salarioBase) {
			// TODO Auto-generated method stub
			return 0;
		}
	},
	TESTADOR {
		@Override
		public double calculaSalarioLiquido(double salarioBase) {
			// TODO Auto-generated method stub
			return 0;
		}
	},
	GERENTE_DE_PROJETOS {
		@Override
		public double calculaSalarioLiquido(double salarioBase) {
			// TODO Auto-generated method stub
			return 0;
		}
	};

	public abstract double calculaSalarioLiquido(double salarioBase) ;
}
