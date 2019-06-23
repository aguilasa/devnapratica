/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.ShoppingList;

/**
 * Response method for retrieveShoppingList
 */
@CommandDescription(name="retrieveShoppingListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="retrieveShoppingListResponse")
public interface RetrieveShoppingListResponse extends MessageHandler {

	void retrieveShoppingListResponse(ShoppingList response);
	
	void retrieveShoppingListResponseError(ErrorPayload error);

}
