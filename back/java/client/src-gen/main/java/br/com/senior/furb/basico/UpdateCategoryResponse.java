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
 * Response method for updateCategory
 */
@CommandDescription(name="updateCategoryResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updateCategoryResponse")
public interface UpdateCategoryResponse extends MessageHandler {

	void updateCategoryResponse(Category response);
	
	void updateCategoryResponseError(ErrorPayload error);

}
