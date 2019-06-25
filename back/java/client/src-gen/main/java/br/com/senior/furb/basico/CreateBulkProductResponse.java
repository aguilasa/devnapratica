/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.CreateBulkProductOutput;

/**
 * Response method for createBulkProduct
 */
@CommandDescription(name="createBulkProductResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createBulkProductResponse")
public interface CreateBulkProductResponse extends MessageHandler {

	void createBulkProductResponse(CreateBulkProductOutput response);
	
	void createBulkProductResponseError(ErrorPayload error);

}
