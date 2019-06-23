/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.ExportCategoryOutput;

/**
 * Response method for exportCategory
 */
@CommandDescription(name="exportCategoryResponse", kind=CommandKind.ResponseCommand, requestPrimitive="exportCategoryResponse")
public interface ExportCategoryResponse extends MessageHandler {

	void exportCategoryResponse(ExportCategoryOutput response);
	
	void exportCategoryResponseError(ErrorPayload error);

}
