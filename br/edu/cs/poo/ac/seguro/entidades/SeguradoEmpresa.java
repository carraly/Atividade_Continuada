import java.math.BigDecimal;
import java.time.LocalDate;

public class SeguradoEmpresa extends Segurado {
    private String cnpj;
    private double faturamento;
    private boolean ehLocadoraDeVeiculos;

    public SeguradoEmpresa(String nome, Endereco endereco, LocalDate dataCriacao, BigDecimal bonus, String cnpj, double faturamento, boolean ehLocadoraDeVeiculos) {
        super(nome, endereco, dataCriacao, bonus);
        this.cnpj = cnpj;
        this.faturamento = faturamento;
        this.ehLocadoraDeVeiculos = ehLocadoraDeVeiculos;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }

    public Boolean getEhLocadoraDeVeiculos() {
        return ehLocadoraDeVeiculos;
    }

    public void setEhLocadoraDeVeiculos(Boolean ehLocadoraDeVeiculos) {
        this.ehLocadoraDeVeiculos = ehLocadoraDeVeiculos;
    }

    public LocalDate getDataAbertura() {
        return super.getDataCriacao();
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        super.setDataCriacao(dataAbertura);
    }
}
