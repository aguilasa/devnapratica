/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.ExportItemListOutput;

/**
 * Response method for exportItemList
 */
@CommandDescription(name="exportItemListResponse", kind=CommandKind.ResponseCommand, requestPrimitive="exportItemListResponse")
public interface ExportItemListResponse extends MessageHandler {

	void exportItemListResponse(ExportItemListOutput response);
	
	void exportItemListResponseError(ErrorPayload error);

}
