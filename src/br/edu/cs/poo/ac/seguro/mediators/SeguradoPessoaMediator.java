package br.edu.cs.poo.ac.seguro.mediators;

import br.edu.cs.poo.ac.seguro.daos.SeguradoPessoaDAO;
import br.edu.cs.poo.ac.seguro.entidades.SeguradoPessoa;

public class SeguradoPessoaMediator {
    SeguradoMediator seguradoMediator = SeguradoMediator.getInstancia();
    SeguradoPessoaDAO seguradoPessoaDAO = new SeguradoPessoaDAO();
    private static SeguradoPessoaMediator instancia = new SeguradoPessoaMediator();

    private SeguradoPessoaMediator() {

    }

	public String validarCpf(String cpf) {
		if (StringUtils.ehNuloOuBranco(cpf) == true) {
			return "CPF deve ser informado";
		}else if (cpf.length() != 11) {
			return "CPF deve ter 11 caracteres";
		}else if (ValidadorCpfCnpj.ehCpfValido(cpf) == false) {
			return "CPF com d\u00EDgito inv\u00E1lido";
		}
		return null;
	}
	public String validarRenda(double renda) {
		if (renda < 0) {
			return "Renda deve ser maior ou igual \u00E0 zero";
		}
		return null;
	}
	public String incluirSeguradoPessoa(SeguradoPessoa seg) {
		String ret = validarSeguradoPessoa(seg);

		if (ret != null) {
			return ret;
		}else if (seguradoPessoaDAO.buscar(seg.getCpf()) != null) {
			return "CPF do segurado pessoa j\u00E1 existente";
		}

		seguradoPessoaDAO.incluir(seg);
		return null;
	}
	public String alterarSeguradoPessoa(SeguradoPessoa seg) {
		String ret = validarSeguradoPessoa(seg);

		if (ret != null) {
			return ret;
		}else if (seguradoPessoaDAO.buscar(seg.getCpf()) == null) {
			return "CPF do segurado pessoa n\u00E3o existente";
		}

		seguradoPessoaDAO.alterar(seg);
		return null;
	}
	public String excluirSeguradoPessoa(String cpf) {
		if (seguradoPessoaDAO.buscar(cpf) == null) {
			return "CPF do segurado pessoa n\u00E3o existente";
		}

		seguradoPessoaDAO.excluir(cpf);
		return null;
	}
	public SeguradoPessoa buscarSeguradoPessoa(String cpf) {
		return seguradoPessoaDAO.buscar(cpf);
	}
	public String validarSeguradoPessoa(SeguradoPessoa seg) {
		if (StringUtils.ehNuloOuBranco(seg.getNome()) == true) {
			return "Nome deve ser informado";
		}else if (seg.getEndereco() == null) {
			return "Endere\u00E7o deve ser informado";
		}else if (seg.getDataNascimento() == null) {
			return "Data do nascimento deve ser informada";
		}else if (ValidadorCpfCnpj.ehCpfValido(seg.getCpf()) == false) {
			return "CPF com d\u00EDgito inv\u00E1lido";
		}else if (seg.getRenda() < 0) {
			return "Renda deve ser maior ou igual \u00E0 zero";
		}
		return null;
	}

    public static SeguradoPessoaMediator getInstancia() {
        return instancia;
    }
}