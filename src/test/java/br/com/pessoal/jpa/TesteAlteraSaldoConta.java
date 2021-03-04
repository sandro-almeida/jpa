package br.com.pessoal.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pessoal.jpa.modelo.Conta;

public class TesteAlteraSaldoConta {

    public static void main (String[] args) {
        // "contas" eh a persistence-unit, definida no arquivo persistence.xml.
        //
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();

        Conta conta = entityManager.find(Conta.class, 1L);

        // NAO foi necessario chamar o entityManager para persistir a alteracao no BD,
        // pois o metodo find() acima fez com que a entidade Conta passasse para o
        // estado 'Managed'
        //
        entityManager.getTransaction().begin();
        conta.setSaldo(20.0);
        entityManager.getTransaction().commit();

        entityManager.close();

    }
}

