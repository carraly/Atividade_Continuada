package br.edu.cs.poo.ac.seguro.entidades;

public enum TipoSinistro {
	COLISAO(1,"Colis\u00E3o"),
	INCENDIO(2,"Inc\u00EAndio"),
	FURTO(3, "Furto"),
	ENCHENTE(4, "Enchente"),
	DEPREDACAO(5, "Depreda\u00E7\u00E3o");

	private final int codigo;
	private final String nome;
	
	private TipoSinistro(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public static TipoSinistro getTipoSinistro(int codigo) {
		TipoSinistro[] tipos = TipoSinistro.values();

		for(TipoSinistro tipo : tipos) {
			if(tipo.getCodigo() == codigo) {
				return tipo;
			}
		}
		return null;
	}
}