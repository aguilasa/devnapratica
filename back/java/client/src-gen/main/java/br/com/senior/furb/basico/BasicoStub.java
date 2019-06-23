/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;

import java.util.concurrent.CompletableFuture;

import br.com.senior.furb.basico.GetMetadataInput;
import br.com.senior.furb.basico.GetMetadataOutput;
import br.com.senior.furb.basico.ImportCategoryInput;
import br.com.senior.furb.basico.ImportCategoryOutput;
import br.com.senior.furb.basico.ExportCategoryInput;
import br.com.senior.furb.basico.ExportCategoryOutput;
import br.com.senior.furb.basico.ImportItemListInput;
import br.com.senior.furb.basico.ImportItemListOutput;
import br.com.senior.furb.basico.ExportItemListInput;
import br.com.senior.furb.basico.ExportItemListOutput;
import br.com.senior.furb.basico.ImportShoppingListInput;
import br.com.senior.furb.basico.ImportShoppingListOutput;
import br.com.senior.furb.basico.ExportShoppingListInput;
import br.com.senior.furb.basico.ExportShoppingListOutput;
import br.com.senior.furb.basico.GetDependenciesOutput;
import br.com.senior.furb.basico.Category;
import br.com.senior.furb.basico.CreateBulkCategoryInput;
import br.com.senior.furb.basico.CreateBulkCategoryOutput;
import br.com.senior.furb.basico.ItemList;
import br.com.senior.furb.basico.CreateBulkItemListInput;
import br.com.senior.furb.basico.CreateBulkItemListOutput;
import br.com.senior.furb.basico.ShoppingList;
import br.com.senior.furb.basico.CreateBulkShoppingListInput;
import br.com.senior.furb.basico.CreateBulkShoppingListOutput;
import br.com.senior.furb.basico.ServiceStartedPayload;
import br.com.senior.furb.basico.NotifyUserEventPayload;
import br.com.senior.furb.basico.ImportCategoryEventPayload;
import br.com.senior.furb.basico.ExportCategoryEventPayload;
import br.com.senior.furb.basico.ImportItemListEventPayload;
import br.com.senior.furb.basico.ExportItemListEventPayload;
import br.com.senior.furb.basico.ImportShoppingListEventPayload;
import br.com.senior.furb.basico.ExportShoppingListEventPayload;

/**
* Trabalho Final
*/
public interface BasicoStub {

	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	GetMetadataOutput getMetadata(GetMetadataInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * Chamada assíncrona
	 */
	void getMetadata(GetMetadataInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetMetadataOutput> getMetadataRequest(GetMetadataInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ImportCategoryOutput importCategory(ImportCategoryInput input, long timeout);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona
	 */
	void importCategory(ImportCategoryInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportCategoryOutput> importCategoryRequest(ImportCategoryInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportCategoryOutput exportCategory(ExportCategoryInput input, long timeout);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona
	 */
	void exportCategory(ExportCategoryInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportCategoryOutput> exportCategoryRequest(ExportCategoryInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ImportItemListOutput importItemList(ImportItemListInput input, long timeout);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona
	 */
	void importItemList(ImportItemListInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportItemListOutput> importItemListRequest(ImportItemListInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportItemListOutput exportItemList(ExportItemListInput input, long timeout);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona
	 */
	void exportItemList(ExportItemListInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportItemListOutput> exportItemListRequest(ExportItemListInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ImportShoppingListOutput importShoppingList(ImportShoppingListInput input, long timeout);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona
	 */
	void importShoppingList(ImportShoppingListInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportShoppingListOutput> importShoppingListRequest(ImportShoppingListInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportShoppingListOutput exportShoppingList(ExportShoppingListInput input, long timeout);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona
	 */
	void exportShoppingList(ExportShoppingListInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportShoppingListOutput> exportShoppingListRequest(ExportShoppingListInput input);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the Category entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Category.PagedResults listCategory(Category.PageRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the Category entity.
	 * Chamada assíncrona
	 */
	void listCategory(Category.PageRequest input);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the Category entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Category.PagedResults> listCategoryRequest(Category.PageRequest input);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the ItemList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ItemList.PagedResults listItemList(ItemList.PageRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the ItemList entity.
	 * Chamada assíncrona
	 */
	void listItemList(ItemList.PageRequest input);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the ItemList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ItemList.PagedResults> listItemListRequest(ItemList.PageRequest input);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the ShoppingList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ShoppingList.PagedResults listShoppingList(ShoppingList.PageRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the ShoppingList entity.
	 * Chamada assíncrona
	 */
	void listShoppingList(ShoppingList.PageRequest input);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the ShoppingList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ShoppingList.PagedResults> listShoppingListRequest(ShoppingList.PageRequest input);
	
	/**
	 * This is a public operation
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	GetDependenciesOutput getDependencies(long timeout);
	
	/**
	 * This is a public operation
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * Chamada assíncrona
	 */
	void getDependencies();
	
	/**
	 * This is a public operation
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetDependenciesOutput> getDependenciesRequest();
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Category entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Category createCategory(Category input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Category entity.
	 * Chamada assíncrona
	 */
	void createCategory(Category input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Category entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Category> createCategoryRequest(Category input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Category entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkCategoryOutput createBulkCategory(CreateBulkCategoryInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Category entity.
	 * Chamada assíncrona
	 */
	void createBulkCategory(CreateBulkCategoryInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Category entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkCategoryOutput> createBulkCategoryRequest(CreateBulkCategoryInput input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Category entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Category createMergeCategory(Category input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Category entity.
	 * Chamada assíncrona
	 */
	void createMergeCategory(Category input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Category entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Category> createMergeCategoryRequest(Category input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Category entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Category retrieveCategory(Category.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Category entity.
	 * Chamada assíncrona
	 */
	void retrieveCategory(Category.Id input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Category entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Category> retrieveCategoryRequest(Category.Id input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Category entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Category updateCategory(Category input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Category entity.
	 * Chamada assíncrona
	 */
	void updateCategory(Category input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Category entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Category> updateCategoryRequest(Category input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Category entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Category updateMergeCategory(Category input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Category entity.
	 * Chamada assíncrona
	 */
	void updateMergeCategory(Category input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Category entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Category> updateMergeCategoryRequest(Category input);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Category entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deleteCategory(Category.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Category entity.
	 * Chamada assíncrona
	 */
	void deleteCategory(Category.Id input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the ItemList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ItemList createItemList(ItemList input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the ItemList entity.
	 * Chamada assíncrona
	 */
	void createItemList(ItemList input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the ItemList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ItemList> createItemListRequest(ItemList input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the ItemList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkItemListOutput createBulkItemList(CreateBulkItemListInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the ItemList entity.
	 * Chamada assíncrona
	 */
	void createBulkItemList(CreateBulkItemListInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the ItemList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkItemListOutput> createBulkItemListRequest(CreateBulkItemListInput input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the ItemList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ItemList createMergeItemList(ItemList input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the ItemList entity.
	 * Chamada assíncrona
	 */
	void createMergeItemList(ItemList input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the ItemList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ItemList> createMergeItemListRequest(ItemList input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the ItemList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ItemList retrieveItemList(ItemList.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the ItemList entity.
	 * Chamada assíncrona
	 */
	void retrieveItemList(ItemList.Id input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the ItemList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ItemList> retrieveItemListRequest(ItemList.Id input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the ItemList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ItemList updateItemList(ItemList input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the ItemList entity.
	 * Chamada assíncrona
	 */
	void updateItemList(ItemList input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the ItemList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ItemList> updateItemListRequest(ItemList input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ItemList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ItemList updateMergeItemList(ItemList input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ItemList entity.
	 * Chamada assíncrona
	 */
	void updateMergeItemList(ItemList input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ItemList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ItemList> updateMergeItemListRequest(ItemList input);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the ItemList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deleteItemList(ItemList.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the ItemList entity.
	 * Chamada assíncrona
	 */
	void deleteItemList(ItemList.Id input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the ShoppingList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ShoppingList createShoppingList(ShoppingList input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the ShoppingList entity.
	 * Chamada assíncrona
	 */
	void createShoppingList(ShoppingList input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the ShoppingList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ShoppingList> createShoppingListRequest(ShoppingList input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the ShoppingList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkShoppingListOutput createBulkShoppingList(CreateBulkShoppingListInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the ShoppingList entity.
	 * Chamada assíncrona
	 */
	void createBulkShoppingList(CreateBulkShoppingListInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the ShoppingList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkShoppingListOutput> createBulkShoppingListRequest(CreateBulkShoppingListInput input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the ShoppingList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ShoppingList createMergeShoppingList(ShoppingList input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the ShoppingList entity.
	 * Chamada assíncrona
	 */
	void createMergeShoppingList(ShoppingList input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the ShoppingList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ShoppingList> createMergeShoppingListRequest(ShoppingList input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the ShoppingList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ShoppingList retrieveShoppingList(ShoppingList.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the ShoppingList entity.
	 * Chamada assíncrona
	 */
	void retrieveShoppingList(ShoppingList.Id input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the ShoppingList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ShoppingList> retrieveShoppingListRequest(ShoppingList.Id input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the ShoppingList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ShoppingList updateShoppingList(ShoppingList input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the ShoppingList entity.
	 * Chamada assíncrona
	 */
	void updateShoppingList(ShoppingList input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the ShoppingList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ShoppingList> updateShoppingListRequest(ShoppingList input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ShoppingList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ShoppingList updateMergeShoppingList(ShoppingList input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ShoppingList entity.
	 * Chamada assíncrona
	 */
	void updateMergeShoppingList(ShoppingList input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ShoppingList entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ShoppingList> updateMergeShoppingListRequest(ShoppingList input);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the ShoppingList entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deleteShoppingList(ShoppingList.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the ShoppingList entity.
	 * Chamada assíncrona
	 */
	void deleteShoppingList(ShoppingList.Id input);
	


	/**
	* Chamada assíncrona para o método publishServiceStarted 
	* Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	*/
	void publishServiceStarted( ServiceStartedPayload input );
			
	
	/**
	* Chamada assíncrona para o método publishNotifyUserEvent 
	* Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	*/
	void publishNotifyUserEvent( NotifyUserEventPayload input );
			
	
	/**
	* Chamada assíncrona para o método publishImportCategoryEvent 
	* This is a public operation
	*/
	void publishImportCategoryEvent( ImportCategoryEventPayload input );
			
	
	/**
	* Chamada assíncrona para o método publishExportCategoryEvent 
	* This is a public operation
	*/
	void publishExportCategoryEvent( ExportCategoryEventPayload input );
			
	
	/**
	* Chamada assíncrona para o método publishImportItemListEvent 
	* This is a public operation
	*/
	void publishImportItemListEvent( ImportItemListEventPayload input );
			
	
	/**
	* Chamada assíncrona para o método publishExportItemListEvent 
	* This is a public operation
	*/
	void publishExportItemListEvent( ExportItemListEventPayload input );
			
	
	/**
	* Chamada assíncrona para o método publishImportShoppingListEvent 
	* This is a public operation
	*/
	void publishImportShoppingListEvent( ImportShoppingListEventPayload input );
			
	
	/**
	* Chamada assíncrona para o método publishExportShoppingListEvent 
	* This is a public operation
	*/
	void publishExportShoppingListEvent( ExportShoppingListEventPayload input );
			
	

}