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
 * Response method for createMergeCategory
 */
@CommandDescription(name="createMergeCategoryResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createMergeCategoryResponse")
public interface CreateMergeCategoryResponse extends MessageHandler {

	void createMergeCategoryResponse(Category response);
	
	void createMergeCategoryResponseError(ErrorPayload error);

}
