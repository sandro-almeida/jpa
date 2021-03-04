package br.com.pessoal.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pessoal.jpa.modelo.Conta;

public class TestandoEstados {

    public static void main (String[] args) {

        Conta conta = new Conta();
        conta.setTitular("Dora");
        conta.setAgencia(4444);
        conta.setNumero(5555);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        // Transient -> Managed
        //
        entityManager.persist(conta);

        // Managed -> Removed
        //
        entityManager.remove(conta);

        entityManager.getTransaction().commit();

        System.out.println("Conta removida: " + conta);

        entityManager.close();
    }

}

