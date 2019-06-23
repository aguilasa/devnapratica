/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.CreateBulkShoppingListOutput;

/**
 * Response method for createBulkShoppingList
 */
@CommandDescription(name="createBulkShoppingListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createBulkShoppingListResponse")
public interface CreateBulkShoppingListResponse extends MessageHandler {

	void createBulkShoppingListResponse(CreateBulkShoppingListOutput response);
	
	void createBulkShoppingListResponseError(ErrorPayload error);

}
