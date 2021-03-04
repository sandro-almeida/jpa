package br.com.pessoal.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pessoal.jpa.modelo.Conta;

public class TesteCriaContaComSaldo {

    public static void main (String[] args) {
        // "contas" eh a persistence-unit, definida no arquivo persistence.xml.
        //
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Juliana");
        conta.setAgencia(12345);
        conta.setNumero(54321);
        conta.setSaldo(500.0);

        entityManager.getTransaction().begin();

        entityManager.persist(conta);

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}

