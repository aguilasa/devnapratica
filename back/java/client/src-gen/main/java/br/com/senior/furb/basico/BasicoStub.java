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
import br.com.senior.furb.basico.ImportProductInput;
import br.com.senior.furb.basico.ImportProductOutput;
import br.com.senior.furb.basico.ExportProductInput;
import br.com.senior.furb.basico.ExportProductOutput;
import br.com.senior.furb.basico.ImportItemListInput;
import br.com.senior.furb.basico.ImportItemListOutput;
import br.com.senior.furb.basico.ExportItemListInput;
import br.com.senior.furb.basico.ExportItemListOutput;
import br.com.senior.furb.basico.ImportShoppingListInput;
import br.com.senior.furb.basico.ImportShoppingListOutput;
import br.com.senior.furb.basico.ExportShoppingListInput;
import br.com.senior.furb.basico.ExportShoppingListOutput;
import br.com.senior.furb.basico.ImportClienteInput;
import br.com.senior.furb.basico.ImportClienteOutput;
import br.com.senior.furb.basico.ExportClienteInput;
import br.com.senior.furb.basico.ExportClienteOutput;
import br.com.senior.furb.basico.GetDependenciesOutput;
import br.com.senior.furb.basico.Category;
import br.com.senior.furb.basico.CreateBulkCategoryInput;
import br.com.senior.furb.basico.CreateBulkCategoryOutput;
import br.com.senior.furb.basico.Product;
import br.com.senior.furb.basico.CreateBulkProductInput;
import br.com.senior.furb.basico.CreateBulkProductOutput;
import br.com.senior.furb.basico.ItemList;
import br.com.senior.furb.basico.CreateBulkItemListInput;
import br.com.senior.furb.basico.CreateBulkItemListOutput;
import br.com.senior.furb.basico.ShoppingList;
import br.com.senior.furb.basico.CreateBulkShoppingListInput;
import br.com.senior.furb.basico.CreateBulkShoppingListOutput;
import br.com.senior.furb.basico.Cliente;
import br.com.senior.furb.basico.CreateBulkClienteInput;
import br.com.senior.furb.basico.CreateBulkClienteOutput;
import br.com.senior.furb.basico.ServiceStartedPayload;
import br.com.senior.furb.basico.NotifyUserEventPayload;
import br.com.senior.furb.basico.ImportCategoryEventPayload;
import br.com.senior.furb.basico.ExportCategoryEventPayload;
import br.com.senior.furb.basico.ImportProductEventPayload;
import br.com.senior.furb.basico.ExportProductEventPayload;
import br.com.senior.furb.basico.ImportItemListEventPayload;
import br.com.senior.furb.basico.ExportItemListEventPayload;
import br.com.senior.furb.basico.ImportShoppingListEventPayload;
import br.com.senior.furb.basico.ExportShoppingListEventPayload;
import br.com.senior.furb.basico.ImportClienteEventPayload;
import br.com.senior.furb.basico.ExportClienteEventPayload;

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
	ImportProductOutput importProduct(ImportProductInput input, long timeout);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona
	 */
	void importProduct(ImportProductInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportProductOutput> importProductRequest(ImportProductInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportProductOutput exportProduct(ExportProductInput input, long timeout);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona
	 */
	void exportProduct(ExportProductInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportProductOutput> exportProductRequest(ExportProductInput input);
	
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
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ImportClienteOutput importCliente(ImportClienteInput input, long timeout);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona
	 */
	void importCliente(ImportClienteInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportClienteOutput> importClienteRequest(ImportClienteInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportClienteOutput exportCliente(ExportClienteInput input, long timeout);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona
	 */
	void exportCliente(ExportClienteInput input);
	
	/**
	 * This is a public operation
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportClienteOutput> exportClienteRequest(ExportClienteInput input);
	
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
	 * The 'list' request primitive for the Product entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Product.PagedResults listProduct(Product.PageRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the Product entity.
	 * Chamada assíncrona
	 */
	void listProduct(Product.PageRequest input);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the Product entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Product.PagedResults> listProductRequest(Product.PageRequest input);
	
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
	 * The 'list' request primitive for the Cliente entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Cliente.PagedResults listCliente(Cliente.PageRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the Cliente entity.
	 * Chamada assíncrona
	 */
	void listCliente(Cliente.PageRequest input);
	
	/**
	 * This is a public operation
	 * The 'list' request primitive for the Cliente entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Cliente.PagedResults> listClienteRequest(Cliente.PageRequest input);
	
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
	 * The 'create' request primitive for the Product entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Product createProduct(Product input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Product entity.
	 * Chamada assíncrona
	 */
	void createProduct(Product input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Product entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Product> createProductRequest(Product input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Product entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkProductOutput createBulkProduct(CreateBulkProductInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Product entity.
	 * Chamada assíncrona
	 */
	void createBulkProduct(CreateBulkProductInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Product entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkProductOutput> createBulkProductRequest(CreateBulkProductInput input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Product entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Product createMergeProduct(Product input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Product entity.
	 * Chamada assíncrona
	 */
	void createMergeProduct(Product input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Product entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Product> createMergeProductRequest(Product input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Product entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Product retrieveProduct(Product.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Product entity.
	 * Chamada assíncrona
	 */
	void retrieveProduct(Product.Id input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Product entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Product> retrieveProductRequest(Product.Id input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Product entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Product updateProduct(Product input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Product entity.
	 * Chamada assíncrona
	 */
	void updateProduct(Product input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Product entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Product> updateProductRequest(Product input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Product entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Product updateMergeProduct(Product input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Product entity.
	 * Chamada assíncrona
	 */
	void updateMergeProduct(Product input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Product entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Product> updateMergeProductRequest(Product input);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Product entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deleteProduct(Product.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Product entity.
	 * Chamada assíncrona
	 */
	void deleteProduct(Product.Id input);
	
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
	 * This is a public operation
	 * The 'create' request primitive for the Cliente entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Cliente createCliente(Cliente input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Cliente entity.
	 * Chamada assíncrona
	 */
	void createCliente(Cliente input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Cliente entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Cliente> createClienteRequest(Cliente input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Cliente entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkClienteOutput createBulkCliente(CreateBulkClienteInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Cliente entity.
	 * Chamada assíncrona
	 */
	void createBulkCliente(CreateBulkClienteInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Cliente entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkClienteOutput> createBulkClienteRequest(CreateBulkClienteInput input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Cliente entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Cliente createMergeCliente(Cliente input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Cliente entity.
	 * Chamada assíncrona
	 */
	void createMergeCliente(Cliente input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Cliente entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Cliente> createMergeClienteRequest(Cliente input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Cliente entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Cliente retrieveCliente(Cliente.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Cliente entity.
	 * Chamada assíncrona
	 */
	void retrieveCliente(Cliente.Id input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Cliente entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Cliente> retrieveClienteRequest(Cliente.Id input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Cliente entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Cliente updateCliente(Cliente input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Cliente entity.
	 * Chamada assíncrona
	 */
	void updateCliente(Cliente input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Cliente entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Cliente> updateClienteRequest(Cliente input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Cliente entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Cliente updateMergeCliente(Cliente input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Cliente entity.
	 * Chamada assíncrona
	 */
	void updateMergeCliente(Cliente input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Cliente entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Cliente> updateMergeClienteRequest(Cliente input);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Cliente entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deleteCliente(Cliente.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Cliente entity.
	 * Chamada assíncrona
	 */
	void deleteCliente(Cliente.Id input);
	


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
	* Chamada assíncrona para o método publishImportProductEvent 
	* This is a public operation
	*/
	void publishImportProductEvent( ImportProductEventPayload input );
			
	
	/**
	* Chamada assíncrona para o método publishExportProductEvent 
	* This is a public operation
	*/
	void publishExportProductEvent( ExportProductEventPayload input );
			
	
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
			
	
	/**
	* Chamada assíncrona para o método publishImportClienteEvent 
	* This is a public operation
	*/
	void publishImportClienteEvent( ImportClienteEventPayload input );
			
	
	/**
	* Chamada assíncrona para o método publishExportClienteEvent 
	* This is a public operation
	*/
	void publishExportClienteEvent( ExportClienteEventPayload input );
			
	

}
