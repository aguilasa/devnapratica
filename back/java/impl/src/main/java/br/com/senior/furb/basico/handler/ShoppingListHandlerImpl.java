package br.com.senior.furb.basico.handler;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.furb.basico.PersistShoppingList;
import br.com.senior.furb.basico.PersistShoppingListInput;
import br.com.senior.furb.basico.PersistShoppingListOutput;
import br.com.senior.furb.basico.ShoppingListQuery;
import br.com.senior.furb.basico.ShoppingListQueryInput;
import br.com.senior.furb.basico.ShoppingListQueryOutput;
import br.com.senior.furb.basico.controller.ShoppingListController;
import br.com.senior.messaging.model.HandlerImpl;

@HandlerImpl
public class ShoppingListHandlerImpl implements ShoppingListQuery, PersistShoppingList {
	
	@Autowired
	private ShoppingListController shoppingListController;

	@Override
	public PersistShoppingListOutput persistShoppingList(PersistShoppingListInput request) {
		return shoppingListController.persistShoppingList(request);
	}

	@Override
	public ShoppingListQueryOutput shoppingListQuery(ShoppingListQueryInput request) {
		return shoppingListController.shoppingListQuery(request);
	}

}
