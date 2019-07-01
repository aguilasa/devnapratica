/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.ReturnShoppingListOutput;

/**
 * Response method for returnShoppingList
 */
@CommandDescription(name="returnShoppingListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="returnShoppingListResponse")
public interface ReturnShoppingListResponse extends MessageHandler {

	void returnShoppingListResponse(ReturnShoppingListOutput response);
	
	void returnShoppingListResponseError(ErrorPayload error);

}
