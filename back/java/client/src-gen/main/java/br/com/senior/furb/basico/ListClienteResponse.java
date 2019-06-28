/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for listCliente
 */
@CommandDescription(name="listClienteResponse", kind=CommandKind.ResponseCommand, requestPrimitive="listClienteResponse")
public interface ListClienteResponse extends MessageHandler {

	void listClienteResponse(Cliente.PagedResults response);
	
	void listClienteResponseError(ErrorPayload error);

}
