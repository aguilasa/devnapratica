/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.ImportCategoryOutput;

/**
 * Response method for importCategory
 */
@CommandDescription(name="importCategoryResponse", kind=CommandKind.ResponseCommand, requestPrimitive="importCategoryResponse")
public interface ImportCategoryResponse extends MessageHandler {

	void importCategoryResponse(ImportCategoryOutput response);
	
	void importCategoryResponseError(ErrorPayload error);

}
