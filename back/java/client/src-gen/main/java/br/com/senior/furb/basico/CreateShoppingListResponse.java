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
 * Response method for createShoppingList
 */
@CommandDescription(name="createShoppingListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createShoppingListResponse")
public interface CreateShoppingListResponse extends MessageHandler {

	void createShoppingListResponse(ShoppingList response);
	
	void createShoppingListResponseError(ErrorPayload error);

}
