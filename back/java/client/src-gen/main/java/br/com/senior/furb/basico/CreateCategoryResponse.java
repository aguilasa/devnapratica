/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;
import br.com.senior.furb.basico.Category;

/**
 * Response method for createCategory
 */
@CommandDescription(name="createCategoryResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createCategoryResponse")
public interface CreateCategoryResponse extends MessageHandler {

	void createCategoryResponse(Category response);
	
	void createCategoryResponseError(ErrorPayload error);

}
