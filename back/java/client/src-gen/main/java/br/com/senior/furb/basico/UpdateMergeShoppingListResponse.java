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
 * Response method for updateMergeShoppingList
 */
@CommandDescription(name="updateMergeShoppingListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updateMergeShoppingListResponse")
public interface UpdateMergeShoppingListResponse extends MessageHandler {

	void updateMergeShoppingListResponse(ShoppingList response);
	
	void updateMergeShoppingListResponseError(ErrorPayload error);

}
