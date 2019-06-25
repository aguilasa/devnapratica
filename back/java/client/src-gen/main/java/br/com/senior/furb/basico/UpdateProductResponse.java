/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.Product;

/**
 * Response method for updateProduct
 */
@CommandDescription(name="updateProductResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updateProductResponse")
public interface UpdateProductResponse extends MessageHandler {

	void updateProductResponse(Product response);
	
	void updateProductResponseError(ErrorPayload error);

}
