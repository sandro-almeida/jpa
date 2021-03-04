package br.com.pessoal.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.pessoal.jpa.modelo.Conta;
import br.com.pessoal.jpa.modelo.Movimentacao;

public class TesteJPQL_V2 {

    public static void main (String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(2L);

        // Movimentacao tem que ser com M maiusculo, pois eh o nome da classe
        // Esta eh uma query no formato JPQL
        //
        //String jpql = "select m from Movimentacao m where m.conta.id = 2";
        String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";

        // Usa TypedQuery para evitar o warning que estava dando ao retornar o conteudo de query.getResultList()
        //
        TypedQuery<Movimentacao> query = entityManager.createQuery(jpql, Movimentacao.class);
        query.setParameter("pConta", conta);
        List<Movimentacao> resultList = query.getResultList();

        for (Movimentacao movimentacao : resultList) {
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
        }

        entityManager.close();
    }
}

