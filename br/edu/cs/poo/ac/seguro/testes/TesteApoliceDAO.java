package br.edu.cs.poo.ac.seguro.testes;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.cs.poo.ac.seguro.daos.ApoliceDAO;
import br.edu.cs.poo.ac.seguro.entidades.Apolice;

public class TesteApoliceDAO extends TesteDAO {
    private ApoliceDAO dao = new ApoliceDAO();

    protected Class getClasse() {
        return Apolice.class;
    }

    @Test
    public void teste01() {
        String numero = "00000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        cadastro.incluir(ap, numero);
        Apolice result = dao.buscar(numero);
        Assertions.assertNotNull(result);
    }

    @Test
    public void teste02() {
        String numero = "10000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        cadastro.incluir(ap, numero);
        Apolice result = dao.buscar("11000000");
        Assertions.assertNull(result);
    }

    @Test
    public void teste03() {
        String numero = "22000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        cadastro.incluir(ap, numero);
        boolean ret = dao.excluir(numero);
        Assertions.assertTrue(ret);
    }

    @Test
    public void teste04() {
        String numero = "33000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        cadastro.incluir(ap, numero);
        boolean ret = dao.excluir("33100000");
        Assertions.assertFalse(ret);
    }

    @Test
    public void teste05() {
        String numero = "44000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        boolean ret = dao.incluir(ap);
        Assertions.assertTrue(ret);
        Apolice result = dao.buscar(numero);
        Assertions.assertNotNull(result);
    }

    @Test
    public void teste06() {
        String numero = "55000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        cadastro.incluir(ap, numero);
        boolean ret = dao.incluir(ap);
        Assertions.assertFalse(ret);
    }

    @Test
    public void teste07() {
        String numero = "66000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        boolean ret = dao.alterar(ap);
        Assertions.assertFalse(ret);
        Apolice result = dao.buscar(numero);
        Assertions.assertNull(result);
    }

    @Test
    public void teste08() {
        String numero = "77000000";
        Apolice ap = new Apolice(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        ap.setNumero(numero);
        cadastro.incluir(ap, numero);
        ap = new Apolice(null, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN);
        ap.setNumero(numero);
        boolean ret = dao.alterar(ap);
        Assertions.assertTrue(ret);
    }
}