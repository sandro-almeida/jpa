package br.com.pessoal.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pessoal.jpa.modelo.Conta;

public class TesteCriaConta {

    public static void main (String[] args) {
        // "contas" eh a persistence-unit, definida no arquivo persistence.xml.
        //
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Maria");
        conta.setAgencia(1234);
        conta.setNumero(4321);

        entityManager.getTransaction().begin();

        entityManager.persist(conta);

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}

