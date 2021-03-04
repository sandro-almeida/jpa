package br.com.pessoal.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
    private String nome;
    private String profissao;
    private String endereco;

		@OneToOne //Esta anotacao cria uma FK na tabela Cliente, que referencia a Conta
		@JoinColumn(unique = true) //Esta anotacao nao permite que mais de uma Conta seja associada a um Cliente, conforme esperado (visto que a associacao eh One-to-One); entretanto, ela so vale se for definida no momento da criacao da tabela; ou seja, se for definida apos a criacao da tabela, entao ela nao surte efeito
    private Conta conta;

	public Cliente () {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
    }
    
    public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
    }
    
    public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
    }
    
    public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Cliente: [id=" + this.id +
            "; nome=" + this.nome +
            "; profissao=" + this.profissao +
            "; endereco=" + this.endereco +
            "; conta=" + this.conta +
			"]";
	}

}
