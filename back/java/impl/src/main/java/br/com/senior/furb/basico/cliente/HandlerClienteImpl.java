package br.com.senior.furb.basico.cliente;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.furb.basico.AlteraStatusCreditoHabilitado;
import br.com.senior.furb.basico.AlteraStatusCreditoHabilitadoInput;
import br.com.senior.furb.basico.AlteraStatusCreditoHabilitadoOutput;
import br.com.senior.messaging.model.HandlerImpl;

@HandlerImpl
public class HandlerClienteImpl implements AlteraStatusCreditoHabilitado {

	@Autowired
	ClienteRepositoryCustom clienteRespositoryCustom;

	@Override
	public AlteraStatusCreditoHabilitadoOutput alteraStatusCreditoHabilitado(
			AlteraStatusCreditoHabilitadoInput request) {
		AlteraStatusCreditoHabilitadoOutput retorno = new AlteraStatusCreditoHabilitadoOutput();

		retorno.statusCreditoHabilitado = clienteRespositoryCustom.alteraStatusCreditoHabilitado(request.idCliente);
		return retorno;
	}

}
