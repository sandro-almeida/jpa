package br.com.pessoal.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pessoal.jpa.modelo.Conta;

public class TesteCriaContaComSaldoV2 {

    public static void main (String[] args) {
        // "contas" eh a persistence-unit, definida no arquivo persistence.xml.
        //
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Bia");
        conta.setAgencia(22345);
        conta.setNumero(54322);
        conta.setSaldo(1000.0);

        entityManager.getTransaction().begin();

        entityManager.persist(conta);

        entityManager.getTransaction().commit();

        entityManager.close();

        EntityManager entityManager2 = emf.createEntityManager();
        System.out.println("Id da conta nova: " + conta.getId());

        // Neste momento, conta esta no estado "Detached", pois o EntityManager foi fechado
        //
        conta.setSaldo(2000.0);

        entityManager2.getTransaction().begin();
        // Conta volta para o estado "Managed" com o merge, e o commit persiste no BD a 
        // alteracao no saldo
        //
        entityManager2.merge(conta);
        entityManager2.getTransaction().commit();


    }
}

