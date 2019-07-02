package br.com.senior.furb.basico.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senior.furb.basico.ShoppingListBaseRepository;

@Repository
public interface ShoppingListRepository extends ShoppingListBaseRepository {

	@Modifying
	@Query(value = "DELETE FROM shopping_list_items WHERE shopping_list_id = :id", nativeQuery = true)
	void deleteShoppingListItems(@Param("id") UUID id);

	@Modifying
	@Query(value = "DELETE FROM item_list i WHERE NOT EXISTS (SELECT s.items_id FROM shopping_list_items s WHERE s.items_id = i.id )", nativeQuery = true)
	void deleteListItems();

}
