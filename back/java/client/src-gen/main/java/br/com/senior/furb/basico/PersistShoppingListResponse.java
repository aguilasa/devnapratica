/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.PersistShoppingListOutput;

/**
 * Response method for persistShoppingList
 */
@CommandDescription(name="persistShoppingListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="persistShoppingListResponse")
public interface PersistShoppingListResponse extends MessageHandler {

	void persistShoppingListResponse(PersistShoppingListOutput response);
	
	void persistShoppingListResponseError(ErrorPayload error);

}
