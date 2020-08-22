package br.com.hazaru.cartoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hazaru.cartoes.entity.DetalhaCartao;

public interface CartoesRepository extends JpaRepository<DetalhaCartao, Long>{

	/*List<DetalhaCartao> findByBanco(String cartao);*/

	//List<DetalhaCartao> findById(int id);

	//List<DetalhaCartao> findByNumCartao(String numCartao);

	List<DetalhaCartao> findByNumeroCartao(String numeroCartao);

/*	List<DetalhaCartao> findByBanco(String banco);
*/
	
	
}
