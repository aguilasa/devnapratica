package br.com.senior.furb.basico.pedido;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.furb.basico.RetornaEstoque;
import br.com.senior.furb.basico.RetornaEstoqueInput;
import br.com.senior.furb.basico.RetornaEstoqueOutput;
import br.com.senior.messaging.model.HandlerImpl;

@HandlerImpl
public class HandlerEstoqueImpl implements RetornaEstoque {

	@Autowired
	ItemRepositoryCustom itemRespositoryCustom;

	@Override
	public RetornaEstoqueOutput retornaEstoque(RetornaEstoqueInput request) {
		RetornaEstoqueOutput dados = new RetornaEstoqueOutput();

		Long qtdItensEncontrados = itemRespositoryCustom.findQuantityById(request.idPedido);

		if (qtdItensEncontrados == 0) {
			dados.message = "Não foram encontrados intens em estoque";
		} else {
			dados.qtd = qtdItensEncontrados;
			dados.message = "Estoque aprovado";
		}

		return dados;
	}

}
