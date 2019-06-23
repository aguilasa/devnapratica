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
 * Response method for createMergeShoppingList
 */
@CommandDescription(name="createMergeShoppingListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createMergeShoppingListResponse")
public interface CreateMergeShoppingListResponse extends MessageHandler {

	void createMergeShoppingListResponse(ShoppingList response);
	
	void createMergeShoppingListResponseError(ErrorPayload error);

}
