/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for listItemList
 */
@CommandDescription(name="listItemListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="listItemListResponse")
public interface ListItemListResponse extends MessageHandler {

	void listItemListResponse(ItemList.PagedResults response);
	
	void listItemListResponseError(ErrorPayload error);

}
