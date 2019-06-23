/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for listShoppingList
 */
@CommandDescription(name="listShoppingListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="listShoppingListResponse")
public interface ListShoppingListResponse extends MessageHandler {

	void listShoppingListResponse(ShoppingList.PagedResults response);
	
	void listShoppingListResponseError(ErrorPayload error);

}
