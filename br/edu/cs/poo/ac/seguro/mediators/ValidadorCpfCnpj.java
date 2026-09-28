package br.edu.cs.poo.ac.seguro.mediators;

public class ValidadorCpfCnpj {
	public static boolean ehCnpjValido(String cnpj) {
		if (cnpj.length() != 14) {
            return false;
        }

		char primeiro = cnpj.charAt(0);
		for (int i = 0; i < cnpj.length(); i++) {
			if (cnpj.charAt(i) != primeiro) {
				break;
			}
			if (i == cnpj.length()-1) {
				return false;
			}
		}

		int pesosPrimeiroDigito[] = {5,4,3,2,9,8,7,6,5,4,3,2};
		int pesosSegundoDigito[] = {6,5,4,3,2,9,8,7,6,5,4,3,2};

		int digitoVerificador = -1;
		int indexDigitoVerificador = 12;
		long somaCnpj = 0;
		long restoDivisao = -1;

		for (int i = 0; i < indexDigitoVerificador; i++) {
			int numeroAtual = Character.getNumericValue(cnpj.charAt(i));
			somaCnpj += numeroAtual * pesosPrimeiroDigito[i];
		}
		
		restoDivisao = somaCnpj % 11;
		if (restoDivisao < 2) {
			digitoVerificador = 0;
		}else {
			digitoVerificador = 11 - restoDivisao;
		}

		if (Character.getNumericValue(cnpj.charAt(indexDigitoVerificador)) != digitoVerificador) {
			return false;
		}

		digitoVerificador = -1;
		indexDigitoVerificador = 13;
		somaCnpj = 0;
		restoDivisao = -1;

		for (int i = 0; i < indexDigitoVerificador; i++) {
			int numeroAtual = Character.getNumericValue(cnpj.charAt(i));
			somaCnpj += numeroAtual * pesosSegundoDigito[i];
		}
		
		restoDivisao = somaCnpj % 11;
		if (restoDivisao < 2) {
			digitoVerificador = 0;
		}else {
			digitoVerificador = 11 - restoDivisao;
		}

		if (Character.getNumericValue(cnpj.charAt(indexDigitoVerificador)) != digitoVerificador) {
			return false;
		}

		return true; 
	}
	
	public static boolean ehCpfValido(String cpf) {
        if (cpf.length() != 11) {
            return false;
        }

		char primeiro = cpf.charAt(0);
		for (int i = 0; i < cpf.length(); i++) {
			if (cpf.charAt(i) != primeiro) {
				break;
			}
			if (i == cpf.length()-1) {
				return false;
			}
		}

		int digitoVerificador = -1;
		int indexDigitoVerificador = 9;
		long somaCpf = 0;
		long restoDivisao = -1;

		for (int i = 0; i < indexDigitoVerificador; i++) {
			int numeroAtual = Character.getNumericValue(cpf.charAt(i));
			somaCpf += numeroAtual * (10-i);
		}
		
		restoDivisao = somaCpf % 11;
		if (restoDivisao < 2) {
			digitoVerificador = 0;
		}else {
			digitoVerificador = 11 - restoDivisao;
		}

		if (Character.getNumericValue(cpf.charAt(indexDigitoVerificador)) != digitoVerificador) {
			return false;
		}

		digitoVerificador = -1;
		indexDigitoVerificador = 10;
		somaCpf = 0;
		restoDivisao = -1;

		for (int i = 0; i < indexDigitoVerificador; i++) {
			int numeroAtual = Character.getNumericValue(cpf.charAt(i));
			somaCpf += numeroAtual * (11-i);
		}
		
		restoDivisao = somaCpf % 11;
		if (restoDivisao < 2) {
			digitoVerificador = 0;
		}else {
			digitoVerificador = 11 - restoDivisao;
		}

		if (Character.getNumericValue(cpf.charAt(indexDigitoVerificador)) != digitoVerificador) {
			return false;
		}

		return true; 
	}
}