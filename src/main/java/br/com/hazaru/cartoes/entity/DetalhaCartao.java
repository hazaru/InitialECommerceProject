package br.com.hazaru.cartoes.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.hazaru.cartoes.repository.CartoesRepository;

@Entity
public class DetalhaCartao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	@Enumerated(EnumType.STRING)
	private Banco bandeira;
	private String numeroCartao;
	private String banco;
	private String nome;
	private String validade;
	private int cv;
	
	public DetalhaCartao(){}
	
	public DetalhaCartao(Banco bandeira, String numeroCartao, String banco, String nome, String validade, int cv) {		
		this.bandeira = bandeira;
		this.numeroCartao = numeroCartao;
		this.banco = banco;
		this.nome = nome;
		this.validade = validade;
		this.cv = cv;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Banco getBandeira() {
		return bandeira;
	}
	public void setBandeira(Banco bandeira) {
		this.bandeira = bandeira;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public int getCv() {
		return cv;
	}
	public void setCv(int cv) {
		this.cv = cv;
	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	@Override
	public String toString() {	
		return "O numero do cartão é " + getNumeroCartao();
	}

	public DetalhaCartao converter(CartoesRepository cr) {	
		DetalhaCartao cartao = (DetalhaCartao) cr.findByNumeroCartao(numeroCartao);
		return new DetalhaCartao(bandeira, numeroCartao, banco, nome, validade, cv);
	}
}
