/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for listProduct
 */
@CommandDescription(name="listProductResponse", kind=CommandKind.ResponseCommand, requestPrimitive="listProductResponse")
public interface ListProductResponse extends MessageHandler {

	void listProductResponse(Product.PagedResults response);
	
	void listProductResponseError(ErrorPayload error);

}
