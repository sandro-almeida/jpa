package br.com.pessoal.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pessoal.jpa.modelo.Categoria;
import br.com.pessoal.jpa.modelo.Conta;
import br.com.pessoal.jpa.modelo.Movimentacao;
import br.com.pessoal.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

    public static void main (String[] args) {

        Categoria categoria = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negócios");

        Conta conta = new Conta();
        conta.setId(1L);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Viagem à SP");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal(330));
        movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
        movimentacao.setConta(conta);

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setData(LocalDateTime.now());
        movimentacao2.setDescricao("Viagem ao Rio");
        movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal(440));
        movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));
        movimentacao2.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.persist(categoria2);
        entityManager.persist(movimentacao);
        entityManager.persist(movimentacao2);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

}

