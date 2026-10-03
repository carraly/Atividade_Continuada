package br.edu.cs.poo.ac.seguro.mediators;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.edu.cs.poo.ac.seguro.entidades.Endereco;

public class SeguradoMediator {
    private static SeguradoMediator instancia = new SeguradoMediator();

    private SeguradoMediator() {

    }

	public String validarNome(String nome) {
		if (StringUtils.ehNuloOuBranco(nome) == true) {
			return "Nome deve ser informado";
		}else if (nome.length() > 100) {
			return "Tamanho do nome deve ser no m\u00E1ximo 100 caracteres";
		}
		return null;
	}
	public String validarEndereco(Endereco endereco) {
		if (endereco == null) {
			return "Endere\u00E7o deve ser informado";
		}else if (StringUtils.ehNuloOuBranco(endereco.getLogradouro()) == true) {
			return "Logradouro deve ser informado";
		}else if (StringUtils.ehNuloOuBranco(endereco.getCep()) == true) {
			return "CEP deve ser informado";
		}else if (endereco.getCep().length() != 8) {
			return "Tamanho do CEP deve ser 8 caracteres";
		}else if (StringUtils.temSomenteNumeros(endereco.getCep()) == false) {
			return "CEP deve ter formato NNNNNNNN";
		}else if (StringUtils.ehNuloOuBranco(endereco.getCidade()) == true) {
			return "Cidade deve ser informada";
		}else if (endereco.getCidade().length() > 100) {
			return "Tamanho da cidade deve ser no m\u00E1ximo 100 caracteres";
		}else if (StringUtils.ehNuloOuBranco(endereco.getEstado()) == true) {
			return "Sigla do estado deve ser informada";
		}else if (endereco.getEstado().length() != 2) {
			return "Tamanho da sigla do estado deve ser 2 caracteres";
		}else if (StringUtils.ehNuloOuBranco(endereco.getPais()) == true) {
			return "Pa\u00EDs deve ser informado";
		}else if (endereco.getPais().length() > 40) {
			return "Tamanho do pa\u00EDs deve ser no m\u00E1ximo 40 caracteres";
		}else if (StringUtils.ehNuloOuBranco(endereco.getNumero()) == false) {
			if (endereco.getNumero().length() > 20) {
				return "Tamanho do n\u00FAmero deve ser no m\u00E1ximo 20 caracteres";
			}
		}
		if (StringUtils.ehNuloOuBranco(endereco.getComplemento()) == false) {
			if (endereco.getComplemento().length() > 30) {
				return "Tamanho do complemento deve ser no m\u00E1ximo 30 caracteres";
			}
		}
		return null;
	}
	public String validarDataCriacao(LocalDate dataCriacao) {
		if (dataCriacao == null) {
			return "Data da cria\u00E7\u00E3o deve ser informada";
		}else if (dataCriacao.isAfter(LocalDate.now())) {
			return "Data da cria\u00E7\u00E3o deve ser menor ou igual \u00E0 data atual";
		}
		return null;
	}
	public BigDecimal ajustarDebitoBonus(BigDecimal bonus, BigDecimal valorDebito) {
		if (bonus.compareTo(valorDebito) < 0) {
			return bonus;
		}else {
			return valorDebito;
		}
	}

    public static SeguradoMediator getInstancia() {
        return instancia;
    }
}