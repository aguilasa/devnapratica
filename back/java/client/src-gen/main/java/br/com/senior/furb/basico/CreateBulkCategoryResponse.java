/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.CreateBulkCategoryOutput;

/**
 * Response method for createBulkCategory
 */
@CommandDescription(name="createBulkCategoryResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createBulkCategoryResponse")
public interface CreateBulkCategoryResponse extends MessageHandler {

	void createBulkCategoryResponse(CreateBulkCategoryOutput response);
	
	void createBulkCategoryResponseError(ErrorPayload error);

}
