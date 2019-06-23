/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.ImportShoppingListOutput;

/**
 * Response method for importShoppingList
 */
@CommandDescription(name="importShoppingListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="importShoppingListResponse")
public interface ImportShoppingListResponse extends MessageHandler {

	void importShoppingListResponse(ImportShoppingListOutput response);
	
	void importShoppingListResponseError(ErrorPayload error);

}
