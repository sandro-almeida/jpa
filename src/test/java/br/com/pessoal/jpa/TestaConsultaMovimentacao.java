package br.com.pessoal.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pessoal.jpa.modelo.Movimentacao;

public class TestaConsultaMovimentacao {

    public static void main (String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();

        Movimentacao movimentacao = entityManager.find(Movimentacao.class, 1L);

        System.out.println("Movimentacao: " + movimentacao);

        entityManager.close();
    }

}

