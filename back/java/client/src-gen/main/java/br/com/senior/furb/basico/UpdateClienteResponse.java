/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.Cliente;

/**
 * Response method for updateCliente
 */
@CommandDescription(name="updateClienteResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updateClienteResponse")
public interface UpdateClienteResponse extends MessageHandler {

	void updateClienteResponse(Cliente response);
	
	void updateClienteResponseError(ErrorPayload error);

}
