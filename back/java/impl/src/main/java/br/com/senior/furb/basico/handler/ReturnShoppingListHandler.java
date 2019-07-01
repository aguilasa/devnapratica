package br.com.senior.furb.basico.handler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.furb.basico.ReturnShoppingList;
import br.com.senior.furb.basico.ReturnShoppingListInput;
import br.com.senior.furb.basico.ReturnShoppingListOutput;
import br.com.senior.furb.basico.ShoppingList;
import br.com.senior.furb.basico.ShoppingListHandler;
import br.com.senior.messaging.model.HandlerImpl;

@HandlerImpl
public class ReturnShoppingListHandler implements ReturnShoppingList {

	private ReturnShoppingListInput input;

	private ReturnShoppingListOutput output = new ReturnShoppingListOutput();

	@Autowired
	private ShoppingListHandler shoppingListHandler;

	@Override
	public ReturnShoppingListOutput returnShoppingList(ReturnShoppingListInput request) {
		this.input = request;
		process();
		return output;
	}

	private void process() {
		output.shoppingList = null;
		String id = input.id;

		if (!StringUtils.isEmpty(id)) {
			ShoppingList retrieveShoppingList = this.shoppingListHandler.retrieveShoppingList(new ShoppingList.Id(id));
			output.shoppingList = retrieveShoppingList;
		}

	}

}
