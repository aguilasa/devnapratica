package br.com.senior.furb.basico.handler;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.furb.basico.PersistShoppingList;
import br.com.senior.furb.basico.PersistShoppingListInput;
import br.com.senior.furb.basico.PersistShoppingListOutput;
import br.com.senior.furb.basico.ShoppingList;
import br.com.senior.furb.basico.ShoppingListHandler;
import br.com.senior.messaging.model.HandlerImpl;

@HandlerImpl
public class PersistShoppingListHandler implements PersistShoppingList {

	private PersistShoppingListInput input;

	private PersistShoppingListOutput output = new PersistShoppingListOutput();

	@Autowired
	private ShoppingListHandler shoppingListHandler;

	@Override
	public PersistShoppingListOutput persistShoppingList(PersistShoppingListInput request) {
		this.input = request;
		persist();
		return output;
	}

	private void persist() {
		this.output.shoppingList = null;
		String id = input.shoppingList.id;
		try {
			this.shoppingListHandler.deleteShoppingList(new ShoppingList.Id(id));
		} catch (Exception e) {
		}
		try {
			this.output.shoppingList = this.shoppingListHandler.createShoppingList(input.shoppingList);
		} catch (Exception e) {
		}
	}

}
