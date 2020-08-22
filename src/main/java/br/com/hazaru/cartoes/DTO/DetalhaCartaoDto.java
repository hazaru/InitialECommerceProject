package br.com.hazaru.cartoes.DTO;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.hazaru.cartoes.entity.Banco;
import br.com.hazaru.cartoes.entity.DetalhaCartao;

public class DetalhaCartaoDto {
	
	
	private String numeroCartao;	
	private String banco; 
	private String nome;
	private String validade;
	private int cv;
	
	
	public DetalhaCartaoDto(DetalhaCartao dc) {		
		this.numeroCartao = dc.getNumeroCartao();
		this.banco = dc.getBanco();
		this.nome = dc.getNome();
		this.validade = dc.getValidade();
		this.cv = dc.getCv();
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
	
	public String getNumCartao() {
		return numeroCartao;
	}
	
	public static List<DetalhaCartaoDto> converter(List<DetalhaCartao> det) {
//		return det.stream().map(DetalhaCartaoDto::new).collect(Collectors.toList());
		return det.stream().map(DetalhaCartaoDto::new).collect(Collectors.toList());
	}
}
