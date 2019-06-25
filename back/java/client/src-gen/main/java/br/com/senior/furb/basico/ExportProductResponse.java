/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.ExportProductOutput;

/**
 * Response method for exportProduct
 */
@CommandDescription(name="exportProductResponse", kind=CommandKind.ResponseCommand, requestPrimitive="exportProductResponse")
public interface ExportProductResponse extends MessageHandler {

	void exportProductResponse(ExportProductOutput response);
	
	void exportProductResponseError(ErrorPayload error);

}
