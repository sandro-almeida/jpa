package br.com.pessoal.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pessoal.jpa.modelo.Cliente;
import br.com.pessoal.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {

    public static void main (String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();

        // ATENCAO: se eu rodar esse codigo novamente, entao vai dar erro, pois a conta de Id=1
        // ja esta associada a um cliente, e NAO pode ser associada a outro cliente, por conta
        // da associacao One-to-One entre Cliente e Conta.
        //
        Conta conta = new Conta();
        conta.setId(1L);

        Cliente cliente = new Cliente();
        cliente.setNome("Astrogildo");
        cliente.setEndereco("Rua do Ouvidor, 101");
        cliente.setProfissao("Professor");
        cliente.setConta(conta);
        
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

}

