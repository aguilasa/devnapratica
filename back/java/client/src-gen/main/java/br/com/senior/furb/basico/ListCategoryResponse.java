/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for listCategory
 */
@CommandDescription(name="listCategoryResponse", kind=CommandKind.ResponseCommand, requestPrimitive="listCategoryResponse")
public interface ListCategoryResponse extends MessageHandler {

	void listCategoryResponse(Category.PagedResults response);
	
	void listCategoryResponseError(ErrorPayload error);

}
