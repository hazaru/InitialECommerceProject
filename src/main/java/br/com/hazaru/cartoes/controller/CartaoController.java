package br.com.hazaru.cartoes.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.hazaru.cartoes.DTO.DetalhaCartaoDto;
import br.com.hazaru.cartoes.entity.DetalhaCartao;
import br.com.hazaru.cartoes.form.DetalhaCartaoForm;
import br.com.hazaru.cartoes.repository.CartoesRepository;

@RestController
public class CartaoController {
	
	@Autowired
	private CartoesRepository cr;
	
		
	/*	public List<DetalhaCartaoDto> detalhaCartao() {
			DetalhaCartao detalhes = new DetalhaCartao(Banco.SANTANDER, "5228402769086862", "Itau", "Rafael S da Cruz", "01/28", 288);
			return DetalhaCartaoDto.converter(Arrays.asList(detalhes));
		}
*/
		@GetMapping("/cartoes/{numeroCartao}")
		@ResponseBody
		public List<DetalhaCartaoDto> detalhaCartao(@PathVariable(required=true)String numeroCartao){
			if(numeroCartao == null)
			{
			List<DetalhaCartao> dc = cr.findAll();
			return DetalhaCartaoDto.converter(dc);
			}else{
				List<DetalhaCartao> dc = cr.findByNumeroCartao(numeroCartao);
				return DetalhaCartaoDto.converter(dc);
			}
		}
		
		@GetMapping("/cartoes")
		@ResponseBody
		public List<DetalhaCartaoDto> detalhaCartao(){			
			List<DetalhaCartao> dc = cr.findAll();
			return DetalhaCartaoDto.converter(dc);			
		}
		
		@PostMapping
		public ResponseEntity<DetalhaCartaoDto> insereCartao(@RequestBody @Valid DetalhaCartaoForm cartao, UriComponentsBuilder uriBuilder)
		{
			
			DetalhaCartao card = cartao.converter();
			cr.save(card);

			URI uri = uriBuilder.path("/cartoes/{id}").buildAndExpand(card.getId()).toUri();
			return ResponseEntity.created(uri).body(new DetalhaCartaoDto(card));
			
		}		
		
	/*@GetMapping("/cartoes")
	public String retornaCartao()
	{
		return "OK";
		
	}*/
}
