package br.com.pessoal.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.pessoal.jpa.modelo.Categoria;
import br.com.pessoal.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoCategoria {

    public static void main (String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();

        // NAO funciona usando a categoria com o construtor com parametro,
        // pois a JPA indica que esta referenciando um objeto no estado transiente
        Categoria categoria = new Categoria("Viagem");
        
        categoria = new Categoria();
        categoria.setId(1L);

        // Uso do join
        //
        String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

        // Usa TypedQuery para evitar o warning que estava dando ao retornar o conteudo de query.getResultList()
        //
        TypedQuery<Movimentacao> query = entityManager.createQuery(jpql, Movimentacao.class);
        query.setParameter("pCategoria", categoria);
        List<Movimentacao> resultList = query.getResultList();

        for (Movimentacao movimentacao : resultList) {
            System.out.println("Categoria: " + movimentacao.getCategorias());
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
        }

        entityManager.close();
    }
}

