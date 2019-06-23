/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.ExportShoppingListOutput;

/**
 * Response method for exportShoppingList
 */
@CommandDescription(name="exportShoppingListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="exportShoppingListResponse")
public interface ExportShoppingListResponse extends MessageHandler {

	void exportShoppingListResponse(ExportShoppingListOutput response);
	
	void exportShoppingListResponseError(ErrorPayload error);

}
