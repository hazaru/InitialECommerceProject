package br.com.hazaru.cartoes.form;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.hazaru.cartoes.controller.CartaoController;
import br.com.hazaru.cartoes.entity.Banco;
import br.com.hazaru.cartoes.entity.DetalhaCartao;

public class DetalhaCartaoForm {	
		
	@Enumerated(EnumType.STRING)
	private Banco bandeira = Banco.ITAU;
	@NotNull @NotEmpty
	private String numeroCartao;	
	@NotNull @NotEmpty
	private String banco; 
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String validade;
	@NotNull @NotEmpty
	private int cv;
	
	public Banco getBandeira() {
		return bandeira;
	}
	public void setBandeira(Banco bandeira) {
		this.bandeira = bandeira;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
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
	
	public DetalhaCartao converter()
	{
		return new DetalhaCartao(bandeira, numeroCartao, banco, nome, validade, cv);
	}
	
}
