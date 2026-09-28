package br.edu.cs.poo.ac.seguro.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.cs.poo.ac.seguro.daos.SinistroDAO;
import br.edu.cs.poo.ac.seguro.entidades.Sinistro;
import br.edu.cs.poo.ac.seguro.entidades.TipoSinistro;

public class TesteSinistroDAO extends TesteDAO {
    private SinistroDAO dao = new SinistroDAO();

    protected Class getClasse() {
        return Sinistro.class;
    }

    @Test
    public void teste01() {
        String numero = "00000000";
        Sinistro sin = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario", BigDecimal.ZERO, TipoSinistro.COLISAO);
        sin.setNumero(numero);
        cadastro.incluir(sin, numero);
        Sinistro result = dao.buscar(numero);
        Assertions.assertNotNull(result);
    }

    @Test
    public void teste02() {
        String numero = "10000000";
        Sinistro sin = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario", BigDecimal.ZERO, TipoSinistro.COLISAO);
        sin.setNumero(numero);
        cadastro.incluir(sin, numero);
        Sinistro result = dao.buscar("11000000");
        Assertions.assertNull(result);
    }

    @Test
    public void teste03() {
        String numero = "22000000";
        Sinistro sin = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario", BigDecimal.ZERO, TipoSinistro.COLISAO);
        sin.setNumero(numero);
        cadastro.incluir(sin, numero);
        boolean ret = dao.excluir(numero);
        Assertions.assertTrue(ret);
    }

    @Test
    public void teste04() {
        String numero = "33000000";
        Sinistro sin = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario", BigDecimal.ZERO, TipoSinistro.COLISAO);
        sin.setNumero(numero);
        cadastro.incluir(sin, numero);
        boolean ret = dao.excluir("33100000");
        Assertions.assertFalse(ret);
    }

    @Test
    public void teste05() {
        String numero = "44000000";
        Sinistro sin = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario", BigDecimal.ZERO, TipoSinistro.COLISAO);
        sin.setNumero(numero);
        boolean ret = dao.incluir(sin);
        Assertions.assertTrue(ret);
        Sinistro result = dao.buscar(numero);
        Assertions.assertNotNull(result);
    }

    @Test
    public void teste06() {
        String numero = "55000000";
        Sinistro sin = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario", BigDecimal.ZERO, TipoSinistro.COLISAO);
        sin.setNumero(numero);
        cadastro.incluir(sin, numero);
        boolean ret = dao.incluir(sin);
        Assertions.assertFalse(ret);
    }

    @Test
    public void teste07() {
        String numero = "66000000";
        Sinistro sin = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario", BigDecimal.ZERO, TipoSinistro.COLISAO);
        sin.setNumero(numero);
        boolean ret = dao.alterar(sin);
        Assertions.assertFalse(ret);
        Sinistro result = dao.buscar(numero);
        Assertions.assertNull(result);
    }

    @Test
    public void teste08() {
        String numero = "77000000";
        Sinistro sin = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario", BigDecimal.ZERO, TipoSinistro.COLISAO);
        sin.setNumero(numero);
        cadastro.incluir(sin, numero);
        sin = new Sinistro(null, LocalDateTime.now(), LocalDateTime.now(), "usuario2", BigDecimal.TEN, TipoSinistro.INCENDIO);
        sin.setNumero(numero);
        boolean ret = dao.alterar(sin);
        Assertions.assertTrue(ret);
    }
}