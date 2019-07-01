package br.com.senior.furb.basico.handler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.senior.furb.basico.PersistShoppingList;
import br.com.senior.furb.basico.PersistShoppingListInput;
import br.com.senior.furb.basico.PersistShoppingListOutput;
import br.com.senior.furb.basico.ShoppingListCrudService;
import br.com.senior.furb.basico.ShoppingListEntity;
import br.com.senior.furb.basico.ShoppingList.Id;
import br.com.senior.furb.basico.repositories.ItemListRepository;
import br.com.senior.furb.basico.repositories.ShoppingListRepository;
import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.messaging.model.ServiceException;

@HandlerImpl
public class PersistShoppingListHandler implements PersistShoppingList {

	private PersistShoppingListInput input;

	private PersistShoppingListOutput output = new PersistShoppingListOutput();

	@Autowired
	private ShoppingListRepository shoppingListRepository;

	@Autowired
	private ItemListRepository itemListRepository;

	@Autowired
	private ShoppingListCrudService shoppingListCrud;

	@Override
	public PersistShoppingListOutput persistShoppingList(PersistShoppingListInput request) {
		this.input = request;
		persist();
		return output;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	private ShoppingListEntity retrieveShoppingList(String id) {
		if (!StringUtils.isEmpty(id)) {
			return this.shoppingListRepository.findOne(java.util.UUID.fromString(id));
		}
		return null;
	}

	private void persist() {
		String id = input.shoppingList.id;
		ShoppingListEntity entity = retrieveShoppingList(id);
	}

}
