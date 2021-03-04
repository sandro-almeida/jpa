package br.com.pessoal.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pessoal.jpa.modelo.Conta;
import br.com.pessoal.jpa.modelo.Movimentacao;
import br.com.pessoal.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {

    public static void main (String[] args) {

        Conta conta = new Conta();
        conta.setTitular("Dora");
        conta.setAgencia(4444);
        conta.setNumero(5555);
        conta.setSaldo(1200.0);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Mercado");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        movimentacao.setValor(new BigDecimal(250));
        movimentacao.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        // conta passa para o estado Managed e agora possui um id; 
        // nao tem como salvar a movimentacao sem antes salvar a conta
        //
        entityManager.persist(conta); 
        entityManager.persist(movimentacao);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

}

