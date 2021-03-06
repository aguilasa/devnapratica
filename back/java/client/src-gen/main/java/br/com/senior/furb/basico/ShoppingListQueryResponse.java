/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.ShoppingListQueryOutput;

/**
 * Response method for shoppingListQuery
 */
@CommandDescription(name="shoppingListQueryResponse", kind=CommandKind.ResponseCommand, requestPrimitive="shoppingListQueryResponse")
public interface ShoppingListQueryResponse extends MessageHandler {

	void shoppingListQueryResponse(ShoppingListQueryOutput response);
	
	void shoppingListQueryResponseError(ErrorPayload error);

}
