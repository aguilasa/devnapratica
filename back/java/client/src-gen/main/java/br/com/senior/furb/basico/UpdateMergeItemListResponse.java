/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.ItemList;

/**
 * Response method for updateMergeItemList
 */
@CommandDescription(name="updateMergeItemListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updateMergeItemListResponse")
public interface UpdateMergeItemListResponse extends MessageHandler {

	void updateMergeItemListResponse(ItemList response);
	
	void updateMergeItemListResponseError(ErrorPayload error);

}
