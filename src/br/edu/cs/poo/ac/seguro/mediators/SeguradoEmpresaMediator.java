package br.edu.cs.poo.ac.seguro.mediators;

import br.edu.cs.poo.ac.seguro.daos.SeguradoEmpresaDAO;
import br.edu.cs.poo.ac.seguro.entidades.SeguradoEmpresa;

public class SeguradoEmpresaMediator {
    SeguradoMediator seguradoMediator = SeguradoMediator.getInstancia();
    SeguradoEmpresaDAO seguradoEmpresaDAO = new SeguradoEmpresaDAO();
    private static SeguradoEmpresaMediator instancia = new SeguradoEmpresaMediator();

    private SeguradoEmpresaMediator() {

    }

	public String validarCnpj(String cnpj) {
		if (StringUtils.ehNuloOuBranco(cnpj) == true) {
			return "CNPJ deve ser informado";
		}else if (cnpj.length() != 14) {
			return "CNPJ deve ter 14 caracteres";
		}else if (ValidadorCpfCnpj.ehCnpjValido(cnpj) == false) {
			return "CNPJ com d\u00EDgito inv\u00E1lido";
		}
		return null;
	}
	public String validarFaturamento(double faturamento) {
		if (faturamento <= 0) {
			return "Faturamento deve ser maior que zero";
		}
		return null;
	}
	public String incluirSeguradoEmpresa(SeguradoEmpresa seg) {
		String ret = validarSeguradoEmpresa(seg);

		if (ret != null) {
			return ret;
		}else if (seguradoEmpresaDAO.buscar(seg.getCnpj()) != null) {
			return "CNPJ do segurado empresa j\u00E1 existente";
		}

		seguradoEmpresaDAO.incluir(seg);
		return null;
	}
	public String alterarSeguradoEmpresa(SeguradoEmpresa seg) {
		String ret = validarSeguradoEmpresa(seg);

		if (ret != null) {
			return ret;
		}else if (seguradoEmpresaDAO.buscar(seg.getCnpj()) == null) {
			return "CNPJ do segurado empresa n\u00E3o existente";
		}

		seguradoEmpresaDAO.alterar(seg);
		return null;
	}
	public String excluirSeguradoEmpresa(String cnpj) {
		if (seguradoEmpresaDAO.buscar(cnpj) == null) {
			return "CNPJ do segurado empresa n\u00E3o existente";
		}

		seguradoEmpresaDAO.excluir(cnpj);
		return null;
	}
	public SeguradoEmpresa buscarSeguradoEmpresa(String cnpj) {
		return seguradoEmpresaDAO.buscar(cnpj);
	}
	public String validarSeguradoEmpresa(SeguradoEmpresa seg) {
		if (StringUtils.ehNuloOuBranco(seg.getNome()) == true) {
			return "Nome deve ser informado";
		}else if (seg.getEndereco() == null) {
			return "Endere\u00E7o deve ser informado";
		}else if (seg.getDataAbertura() == null) {
			return "Data da abertura deve ser informada";
		}else if (ValidadorCpfCnpj.ehCnpjValido(seg.getCnpj()) == false) {
			return "CNPJ com d\u00EDgito inv\u00E1lido";
		}else if (seg.getFaturamento() <= 0) {
			return "Faturamento deve ser maior que zero";
		}
		return null;
	}

    public static SeguradoEmpresaMediator getInstancia() {
        return instancia;
    }
}