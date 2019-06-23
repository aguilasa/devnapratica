/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;

import java.util.function.Supplier;

import br.com.senior.messaging.Message;
import br.com.senior.messaging.IMessenger;
import br.com.senior.messaging.utils.DtoJsonConverter;
import br.com.senior.sdl.user.UserIdentifier;

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

import br.com.senior.furb.basico.BasicoValidator;
import br.com.senior.furb.basico.BasicoException;
import br.com.senior.furb.basico.BasicoConstants;

/**
* Trabalho Final
*/
public class BasicoStubImpl  implements BasicoStub {

	protected final Supplier<IMessenger> messengerSupplier;
	protected final UserIdentifier userId;
	protected final Supplier<Message> messageSupplier;

	/**
	 * Use {@link #BasicoStubImpl(MessengerSupplier, UserIdentifier, MessageSupplier)} instead.
	 */
	@Deprecated
	public BasicoStubImpl(IMessenger messenger, UserIdentifier userId) {
		this(new InstanceMessengerSupplier(messenger), userId, null);
	}

	/**
	 * @param messengerSupplier Supplies current service messenger.
	 * @param userId Provides tenant and user name to send or publish messages.
	 * @param messageSupplier Supplies current message being processed by service. Used to send messages by foolowup.
	 */
	public BasicoStubImpl(Supplier<IMessenger> messengerSupplier, UserIdentifier userId, Supplier<Message> messageSupplier) {
		this.messengerSupplier = messengerSupplier;
		this.userId = userId;
		this.messageSupplier = messageSupplier;
	}

	/**
	 * Chamada síncrona para o método getMetadata
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public GetMetadataOutput getMetadata(GetMetadataInput input, long timeout) {
		br.com.senior.furb.basico.impl.GetMetadataImpl impl = new br.com.senior.furb.basico.impl.GetMetadataImpl(messengerSupplier, userId, messageSupplier);
		return impl.getMetadata(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método getMetadata
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 */
	@Override
	public void getMetadata(GetMetadataInput input) {
		br.com.senior.furb.basico.impl.GetMetadataImpl impl = new br.com.senior.furb.basico.impl.GetMetadataImpl(messengerSupplier, userId, messageSupplier);
		impl.getMetadata(input);
	}
	
	/**
	 * Chamada assíncrona para o método getMetadata
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 */
	@Override
	public CompletableFuture<GetMetadataOutput> getMetadataRequest(GetMetadataInput input) {
		br.com.senior.furb.basico.impl.GetMetadataImpl impl = new br.com.senior.furb.basico.impl.GetMetadataImpl(messengerSupplier, userId, messageSupplier);
		return impl.getMetadataRequest(input);
	}
	/**
	 * Chamada síncrona para o método importCategory
	 * This is a public operation
	 * 
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ImportCategoryOutput importCategory(ImportCategoryInput input, long timeout) {
		br.com.senior.furb.basico.impl.ImportCategoryImpl impl = new br.com.senior.furb.basico.impl.ImportCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.importCategory(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método importCategory
	 * This is a public operation
	 * 
	 */
	@Override
	public void importCategory(ImportCategoryInput input) {
		br.com.senior.furb.basico.impl.ImportCategoryImpl impl = new br.com.senior.furb.basico.impl.ImportCategoryImpl(messengerSupplier, userId, messageSupplier);
		impl.importCategory(input);
	}
	
	/**
	 * Chamada assíncrona para o método importCategory
	 * This is a public operation
	 * 
	 */
	@Override
	public CompletableFuture<ImportCategoryOutput> importCategoryRequest(ImportCategoryInput input) {
		br.com.senior.furb.basico.impl.ImportCategoryImpl impl = new br.com.senior.furb.basico.impl.ImportCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.importCategoryRequest(input);
	}
	/**
	 * Chamada síncrona para o método exportCategory
	 * This is a public operation
	 * 
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ExportCategoryOutput exportCategory(ExportCategoryInput input, long timeout) {
		br.com.senior.furb.basico.impl.ExportCategoryImpl impl = new br.com.senior.furb.basico.impl.ExportCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportCategory(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método exportCategory
	 * This is a public operation
	 * 
	 */
	@Override
	public void exportCategory(ExportCategoryInput input) {
		br.com.senior.furb.basico.impl.ExportCategoryImpl impl = new br.com.senior.furb.basico.impl.ExportCategoryImpl(messengerSupplier, userId, messageSupplier);
		impl.exportCategory(input);
	}
	
	/**
	 * Chamada assíncrona para o método exportCategory
	 * This is a public operation
	 * 
	 */
	@Override
	public CompletableFuture<ExportCategoryOutput> exportCategoryRequest(ExportCategoryInput input) {
		br.com.senior.furb.basico.impl.ExportCategoryImpl impl = new br.com.senior.furb.basico.impl.ExportCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportCategoryRequest(input);
	}
	/**
	 * Chamada síncrona para o método importItemList
	 * This is a public operation
	 * 
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ImportItemListOutput importItemList(ImportItemListInput input, long timeout) {
		br.com.senior.furb.basico.impl.ImportItemListImpl impl = new br.com.senior.furb.basico.impl.ImportItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.importItemList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método importItemList
	 * This is a public operation
	 * 
	 */
	@Override
	public void importItemList(ImportItemListInput input) {
		br.com.senior.furb.basico.impl.ImportItemListImpl impl = new br.com.senior.furb.basico.impl.ImportItemListImpl(messengerSupplier, userId, messageSupplier);
		impl.importItemList(input);
	}
	
	/**
	 * Chamada assíncrona para o método importItemList
	 * This is a public operation
	 * 
	 */
	@Override
	public CompletableFuture<ImportItemListOutput> importItemListRequest(ImportItemListInput input) {
		br.com.senior.furb.basico.impl.ImportItemListImpl impl = new br.com.senior.furb.basico.impl.ImportItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.importItemListRequest(input);
	}
	/**
	 * Chamada síncrona para o método exportItemList
	 * This is a public operation
	 * 
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ExportItemListOutput exportItemList(ExportItemListInput input, long timeout) {
		br.com.senior.furb.basico.impl.ExportItemListImpl impl = new br.com.senior.furb.basico.impl.ExportItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportItemList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método exportItemList
	 * This is a public operation
	 * 
	 */
	@Override
	public void exportItemList(ExportItemListInput input) {
		br.com.senior.furb.basico.impl.ExportItemListImpl impl = new br.com.senior.furb.basico.impl.ExportItemListImpl(messengerSupplier, userId, messageSupplier);
		impl.exportItemList(input);
	}
	
	/**
	 * Chamada assíncrona para o método exportItemList
	 * This is a public operation
	 * 
	 */
	@Override
	public CompletableFuture<ExportItemListOutput> exportItemListRequest(ExportItemListInput input) {
		br.com.senior.furb.basico.impl.ExportItemListImpl impl = new br.com.senior.furb.basico.impl.ExportItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportItemListRequest(input);
	}
	/**
	 * Chamada síncrona para o método importShoppingList
	 * This is a public operation
	 * 
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ImportShoppingListOutput importShoppingList(ImportShoppingListInput input, long timeout) {
		br.com.senior.furb.basico.impl.ImportShoppingListImpl impl = new br.com.senior.furb.basico.impl.ImportShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.importShoppingList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método importShoppingList
	 * This is a public operation
	 * 
	 */
	@Override
	public void importShoppingList(ImportShoppingListInput input) {
		br.com.senior.furb.basico.impl.ImportShoppingListImpl impl = new br.com.senior.furb.basico.impl.ImportShoppingListImpl(messengerSupplier, userId, messageSupplier);
		impl.importShoppingList(input);
	}
	
	/**
	 * Chamada assíncrona para o método importShoppingList
	 * This is a public operation
	 * 
	 */
	@Override
	public CompletableFuture<ImportShoppingListOutput> importShoppingListRequest(ImportShoppingListInput input) {
		br.com.senior.furb.basico.impl.ImportShoppingListImpl impl = new br.com.senior.furb.basico.impl.ImportShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.importShoppingListRequest(input);
	}
	/**
	 * Chamada síncrona para o método exportShoppingList
	 * This is a public operation
	 * 
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ExportShoppingListOutput exportShoppingList(ExportShoppingListInput input, long timeout) {
		br.com.senior.furb.basico.impl.ExportShoppingListImpl impl = new br.com.senior.furb.basico.impl.ExportShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportShoppingList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método exportShoppingList
	 * This is a public operation
	 * 
	 */
	@Override
	public void exportShoppingList(ExportShoppingListInput input) {
		br.com.senior.furb.basico.impl.ExportShoppingListImpl impl = new br.com.senior.furb.basico.impl.ExportShoppingListImpl(messengerSupplier, userId, messageSupplier);
		impl.exportShoppingList(input);
	}
	
	/**
	 * Chamada assíncrona para o método exportShoppingList
	 * This is a public operation
	 * 
	 */
	@Override
	public CompletableFuture<ExportShoppingListOutput> exportShoppingListRequest(ExportShoppingListInput input) {
		br.com.senior.furb.basico.impl.ExportShoppingListImpl impl = new br.com.senior.furb.basico.impl.ExportShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportShoppingListRequest(input);
	}
	/**
	 * Chamada síncrona para o método listCategory
	 * This is a public operation
	 * The 'list' request primitive for the Category entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Category.PagedResults listCategory(Category.PageRequest input, long timeout) {
		br.com.senior.furb.basico.impl.ListCategoryImpl impl = new br.com.senior.furb.basico.impl.ListCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.listCategory(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método listCategory
	 * This is a public operation
	 * The 'list' request primitive for the Category entity.
	 */
	@Override
	public void listCategory(Category.PageRequest input) {
		br.com.senior.furb.basico.impl.ListCategoryImpl impl = new br.com.senior.furb.basico.impl.ListCategoryImpl(messengerSupplier, userId, messageSupplier);
		impl.listCategory(input);
	}
	
	/**
	 * Chamada assíncrona para o método listCategory
	 * This is a public operation
	 * The 'list' request primitive for the Category entity.
	 */
	@Override
	public CompletableFuture<Category.PagedResults> listCategoryRequest(Category.PageRequest input) {
		br.com.senior.furb.basico.impl.ListCategoryImpl impl = new br.com.senior.furb.basico.impl.ListCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.listCategoryRequest(input);
	}
	/**
	 * Chamada síncrona para o método listItemList
	 * This is a public operation
	 * The 'list' request primitive for the ItemList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ItemList.PagedResults listItemList(ItemList.PageRequest input, long timeout) {
		br.com.senior.furb.basico.impl.ListItemListImpl impl = new br.com.senior.furb.basico.impl.ListItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.listItemList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método listItemList
	 * This is a public operation
	 * The 'list' request primitive for the ItemList entity.
	 */
	@Override
	public void listItemList(ItemList.PageRequest input) {
		br.com.senior.furb.basico.impl.ListItemListImpl impl = new br.com.senior.furb.basico.impl.ListItemListImpl(messengerSupplier, userId, messageSupplier);
		impl.listItemList(input);
	}
	
	/**
	 * Chamada assíncrona para o método listItemList
	 * This is a public operation
	 * The 'list' request primitive for the ItemList entity.
	 */
	@Override
	public CompletableFuture<ItemList.PagedResults> listItemListRequest(ItemList.PageRequest input) {
		br.com.senior.furb.basico.impl.ListItemListImpl impl = new br.com.senior.furb.basico.impl.ListItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.listItemListRequest(input);
	}
	/**
	 * Chamada síncrona para o método listShoppingList
	 * This is a public operation
	 * The 'list' request primitive for the ShoppingList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ShoppingList.PagedResults listShoppingList(ShoppingList.PageRequest input, long timeout) {
		br.com.senior.furb.basico.impl.ListShoppingListImpl impl = new br.com.senior.furb.basico.impl.ListShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.listShoppingList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método listShoppingList
	 * This is a public operation
	 * The 'list' request primitive for the ShoppingList entity.
	 */
	@Override
	public void listShoppingList(ShoppingList.PageRequest input) {
		br.com.senior.furb.basico.impl.ListShoppingListImpl impl = new br.com.senior.furb.basico.impl.ListShoppingListImpl(messengerSupplier, userId, messageSupplier);
		impl.listShoppingList(input);
	}
	
	/**
	 * Chamada assíncrona para o método listShoppingList
	 * This is a public operation
	 * The 'list' request primitive for the ShoppingList entity.
	 */
	@Override
	public CompletableFuture<ShoppingList.PagedResults> listShoppingListRequest(ShoppingList.PageRequest input) {
		br.com.senior.furb.basico.impl.ListShoppingListImpl impl = new br.com.senior.furb.basico.impl.ListShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.listShoppingListRequest(input);
	}
	/**
	 * Chamada síncrona para o método getDependencies
	 * This is a public operation
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public GetDependenciesOutput getDependencies(long timeout) {
		br.com.senior.furb.basico.impl.GetDependenciesImpl impl = new br.com.senior.furb.basico.impl.GetDependenciesImpl(messengerSupplier, userId, messageSupplier);
		return impl.getDependencies(timeout);
	}
	
	/**
	 * Chamada assíncrona para o método getDependencies
	 * This is a public operation
	 * Returns a list with all dependencies from this service, along with their respective versions
	 */
	@Override
	public void getDependencies() {
		br.com.senior.furb.basico.impl.GetDependenciesImpl impl = new br.com.senior.furb.basico.impl.GetDependenciesImpl(messengerSupplier, userId, messageSupplier);
		impl.getDependencies();
	}
	
	/**
	 * Chamada assíncrona para o método getDependencies
	 * This is a public operation
	 * Returns a list with all dependencies from this service, along with their respective versions
	 */
	@Override
	public CompletableFuture<GetDependenciesOutput> getDependenciesRequest() {
		br.com.senior.furb.basico.impl.GetDependenciesImpl impl = new br.com.senior.furb.basico.impl.GetDependenciesImpl(messengerSupplier, userId, messageSupplier);
		return impl.getDependenciesRequest();
	}
	/**
	 * Chamada síncrona para o método createCategory
	 * This is a public operation
	 * The 'create' request primitive for the Category entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Category createCategory(Category input, long timeout) {
		br.com.senior.furb.basico.impl.CreateCategoryImpl impl = new br.com.senior.furb.basico.impl.CreateCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.createCategory(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createCategory
	 * This is a public operation
	 * The 'create' request primitive for the Category entity.
	 */
	@Override
	public void createCategory(Category input) {
		br.com.senior.furb.basico.impl.CreateCategoryImpl impl = new br.com.senior.furb.basico.impl.CreateCategoryImpl(messengerSupplier, userId, messageSupplier);
		impl.createCategory(input);
	}
	
	/**
	 * Chamada assíncrona para o método createCategory
	 * This is a public operation
	 * The 'create' request primitive for the Category entity.
	 */
	@Override
	public CompletableFuture<Category> createCategoryRequest(Category input) {
		br.com.senior.furb.basico.impl.CreateCategoryImpl impl = new br.com.senior.furb.basico.impl.CreateCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.createCategoryRequest(input);
	}
	/**
	 * Chamada síncrona para o método createBulkCategory
	 * This is a public operation
	 * The 'createBulk' request primitive for the Category entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public CreateBulkCategoryOutput createBulkCategory(CreateBulkCategoryInput input, long timeout) {
		br.com.senior.furb.basico.impl.CreateBulkCategoryImpl impl = new br.com.senior.furb.basico.impl.CreateBulkCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkCategory(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkCategory
	 * This is a public operation
	 * The 'createBulk' request primitive for the Category entity.
	 */
	@Override
	public void createBulkCategory(CreateBulkCategoryInput input) {
		br.com.senior.furb.basico.impl.CreateBulkCategoryImpl impl = new br.com.senior.furb.basico.impl.CreateBulkCategoryImpl(messengerSupplier, userId, messageSupplier);
		impl.createBulkCategory(input);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkCategory
	 * This is a public operation
	 * The 'createBulk' request primitive for the Category entity.
	 */
	@Override
	public CompletableFuture<CreateBulkCategoryOutput> createBulkCategoryRequest(CreateBulkCategoryInput input) {
		br.com.senior.furb.basico.impl.CreateBulkCategoryImpl impl = new br.com.senior.furb.basico.impl.CreateBulkCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkCategoryRequest(input);
	}
	/**
	 * Chamada síncrona para o método createMergeCategory
	 * This is a public operation
	 * The 'createMerge' request primitive for the Category entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Category createMergeCategory(Category input, long timeout) {
		br.com.senior.furb.basico.impl.CreateMergeCategoryImpl impl = new br.com.senior.furb.basico.impl.CreateMergeCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeCategory(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeCategory
	 * This is a public operation
	 * The 'createMerge' request primitive for the Category entity.
	 */
	@Override
	public void createMergeCategory(Category input) {
		br.com.senior.furb.basico.impl.CreateMergeCategoryImpl impl = new br.com.senior.furb.basico.impl.CreateMergeCategoryImpl(messengerSupplier, userId, messageSupplier);
		impl.createMergeCategory(input);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeCategory
	 * This is a public operation
	 * The 'createMerge' request primitive for the Category entity.
	 */
	@Override
	public CompletableFuture<Category> createMergeCategoryRequest(Category input) {
		br.com.senior.furb.basico.impl.CreateMergeCategoryImpl impl = new br.com.senior.furb.basico.impl.CreateMergeCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeCategoryRequest(input);
	}
	/**
	 * Chamada síncrona para o método retrieveCategory
	 * This is a public operation
	 * The 'retrieve' request primitive for the Category entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Category retrieveCategory(Category.Id input, long timeout) {
		br.com.senior.furb.basico.impl.RetrieveCategoryImpl impl = new br.com.senior.furb.basico.impl.RetrieveCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveCategory(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveCategory
	 * This is a public operation
	 * The 'retrieve' request primitive for the Category entity.
	 */
	@Override
	public void retrieveCategory(Category.Id input) {
		br.com.senior.furb.basico.impl.RetrieveCategoryImpl impl = new br.com.senior.furb.basico.impl.RetrieveCategoryImpl(messengerSupplier, userId, messageSupplier);
		impl.retrieveCategory(input);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveCategory
	 * This is a public operation
	 * The 'retrieve' request primitive for the Category entity.
	 */
	@Override
	public CompletableFuture<Category> retrieveCategoryRequest(Category.Id input) {
		br.com.senior.furb.basico.impl.RetrieveCategoryImpl impl = new br.com.senior.furb.basico.impl.RetrieveCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveCategoryRequest(input);
	}
	/**
	 * Chamada síncrona para o método updateCategory
	 * This is a public operation
	 * The 'update' request primitive for the Category entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Category updateCategory(Category input, long timeout) {
		br.com.senior.furb.basico.impl.UpdateCategoryImpl impl = new br.com.senior.furb.basico.impl.UpdateCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateCategory(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateCategory
	 * This is a public operation
	 * The 'update' request primitive for the Category entity.
	 */
	@Override
	public void updateCategory(Category input) {
		br.com.senior.furb.basico.impl.UpdateCategoryImpl impl = new br.com.senior.furb.basico.impl.UpdateCategoryImpl(messengerSupplier, userId, messageSupplier);
		impl.updateCategory(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateCategory
	 * This is a public operation
	 * The 'update' request primitive for the Category entity.
	 */
	@Override
	public CompletableFuture<Category> updateCategoryRequest(Category input) {
		br.com.senior.furb.basico.impl.UpdateCategoryImpl impl = new br.com.senior.furb.basico.impl.UpdateCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateCategoryRequest(input);
	}
	/**
	 * Chamada síncrona para o método updateMergeCategory
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Category entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Category updateMergeCategory(Category input, long timeout) {
		br.com.senior.furb.basico.impl.UpdateMergeCategoryImpl impl = new br.com.senior.furb.basico.impl.UpdateMergeCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeCategory(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeCategory
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Category entity.
	 */
	@Override
	public void updateMergeCategory(Category input) {
		br.com.senior.furb.basico.impl.UpdateMergeCategoryImpl impl = new br.com.senior.furb.basico.impl.UpdateMergeCategoryImpl(messengerSupplier, userId, messageSupplier);
		impl.updateMergeCategory(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeCategory
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Category entity.
	 */
	@Override
	public CompletableFuture<Category> updateMergeCategoryRequest(Category input) {
		br.com.senior.furb.basico.impl.UpdateMergeCategoryImpl impl = new br.com.senior.furb.basico.impl.UpdateMergeCategoryImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeCategoryRequest(input);
	}
	/**
	 * Chamada síncrona para o método deleteCategory
	 * This is a public operation
	 * The 'delete' request primitive for the Category entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public void deleteCategory(Category.Id input, long timeout) {
		br.com.senior.furb.basico.impl.DeleteCategoryImpl impl = new br.com.senior.furb.basico.impl.DeleteCategoryImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteCategory(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método deleteCategory
	 * This is a public operation
	 * The 'delete' request primitive for the Category entity.
	 */
	@Override
	public void deleteCategory(Category.Id input) {
		br.com.senior.furb.basico.impl.DeleteCategoryImpl impl = new br.com.senior.furb.basico.impl.DeleteCategoryImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteCategory(input);
	}
	
	/**
	 * Chamada síncrona para o método createItemList
	 * This is a public operation
	 * The 'create' request primitive for the ItemList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ItemList createItemList(ItemList input, long timeout) {
		br.com.senior.furb.basico.impl.CreateItemListImpl impl = new br.com.senior.furb.basico.impl.CreateItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.createItemList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createItemList
	 * This is a public operation
	 * The 'create' request primitive for the ItemList entity.
	 */
	@Override
	public void createItemList(ItemList input) {
		br.com.senior.furb.basico.impl.CreateItemListImpl impl = new br.com.senior.furb.basico.impl.CreateItemListImpl(messengerSupplier, userId, messageSupplier);
		impl.createItemList(input);
	}
	
	/**
	 * Chamada assíncrona para o método createItemList
	 * This is a public operation
	 * The 'create' request primitive for the ItemList entity.
	 */
	@Override
	public CompletableFuture<ItemList> createItemListRequest(ItemList input) {
		br.com.senior.furb.basico.impl.CreateItemListImpl impl = new br.com.senior.furb.basico.impl.CreateItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.createItemListRequest(input);
	}
	/**
	 * Chamada síncrona para o método createBulkItemList
	 * This is a public operation
	 * The 'createBulk' request primitive for the ItemList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public CreateBulkItemListOutput createBulkItemList(CreateBulkItemListInput input, long timeout) {
		br.com.senior.furb.basico.impl.CreateBulkItemListImpl impl = new br.com.senior.furb.basico.impl.CreateBulkItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkItemList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkItemList
	 * This is a public operation
	 * The 'createBulk' request primitive for the ItemList entity.
	 */
	@Override
	public void createBulkItemList(CreateBulkItemListInput input) {
		br.com.senior.furb.basico.impl.CreateBulkItemListImpl impl = new br.com.senior.furb.basico.impl.CreateBulkItemListImpl(messengerSupplier, userId, messageSupplier);
		impl.createBulkItemList(input);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkItemList
	 * This is a public operation
	 * The 'createBulk' request primitive for the ItemList entity.
	 */
	@Override
	public CompletableFuture<CreateBulkItemListOutput> createBulkItemListRequest(CreateBulkItemListInput input) {
		br.com.senior.furb.basico.impl.CreateBulkItemListImpl impl = new br.com.senior.furb.basico.impl.CreateBulkItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkItemListRequest(input);
	}
	/**
	 * Chamada síncrona para o método createMergeItemList
	 * This is a public operation
	 * The 'createMerge' request primitive for the ItemList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ItemList createMergeItemList(ItemList input, long timeout) {
		br.com.senior.furb.basico.impl.CreateMergeItemListImpl impl = new br.com.senior.furb.basico.impl.CreateMergeItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeItemList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeItemList
	 * This is a public operation
	 * The 'createMerge' request primitive for the ItemList entity.
	 */
	@Override
	public void createMergeItemList(ItemList input) {
		br.com.senior.furb.basico.impl.CreateMergeItemListImpl impl = new br.com.senior.furb.basico.impl.CreateMergeItemListImpl(messengerSupplier, userId, messageSupplier);
		impl.createMergeItemList(input);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeItemList
	 * This is a public operation
	 * The 'createMerge' request primitive for the ItemList entity.
	 */
	@Override
	public CompletableFuture<ItemList> createMergeItemListRequest(ItemList input) {
		br.com.senior.furb.basico.impl.CreateMergeItemListImpl impl = new br.com.senior.furb.basico.impl.CreateMergeItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeItemListRequest(input);
	}
	/**
	 * Chamada síncrona para o método retrieveItemList
	 * This is a public operation
	 * The 'retrieve' request primitive for the ItemList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ItemList retrieveItemList(ItemList.Id input, long timeout) {
		br.com.senior.furb.basico.impl.RetrieveItemListImpl impl = new br.com.senior.furb.basico.impl.RetrieveItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveItemList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveItemList
	 * This is a public operation
	 * The 'retrieve' request primitive for the ItemList entity.
	 */
	@Override
	public void retrieveItemList(ItemList.Id input) {
		br.com.senior.furb.basico.impl.RetrieveItemListImpl impl = new br.com.senior.furb.basico.impl.RetrieveItemListImpl(messengerSupplier, userId, messageSupplier);
		impl.retrieveItemList(input);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveItemList
	 * This is a public operation
	 * The 'retrieve' request primitive for the ItemList entity.
	 */
	@Override
	public CompletableFuture<ItemList> retrieveItemListRequest(ItemList.Id input) {
		br.com.senior.furb.basico.impl.RetrieveItemListImpl impl = new br.com.senior.furb.basico.impl.RetrieveItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveItemListRequest(input);
	}
	/**
	 * Chamada síncrona para o método updateItemList
	 * This is a public operation
	 * The 'update' request primitive for the ItemList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ItemList updateItemList(ItemList input, long timeout) {
		br.com.senior.furb.basico.impl.UpdateItemListImpl impl = new br.com.senior.furb.basico.impl.UpdateItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateItemList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateItemList
	 * This is a public operation
	 * The 'update' request primitive for the ItemList entity.
	 */
	@Override
	public void updateItemList(ItemList input) {
		br.com.senior.furb.basico.impl.UpdateItemListImpl impl = new br.com.senior.furb.basico.impl.UpdateItemListImpl(messengerSupplier, userId, messageSupplier);
		impl.updateItemList(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateItemList
	 * This is a public operation
	 * The 'update' request primitive for the ItemList entity.
	 */
	@Override
	public CompletableFuture<ItemList> updateItemListRequest(ItemList input) {
		br.com.senior.furb.basico.impl.UpdateItemListImpl impl = new br.com.senior.furb.basico.impl.UpdateItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateItemListRequest(input);
	}
	/**
	 * Chamada síncrona para o método updateMergeItemList
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ItemList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ItemList updateMergeItemList(ItemList input, long timeout) {
		br.com.senior.furb.basico.impl.UpdateMergeItemListImpl impl = new br.com.senior.furb.basico.impl.UpdateMergeItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeItemList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeItemList
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ItemList entity.
	 */
	@Override
	public void updateMergeItemList(ItemList input) {
		br.com.senior.furb.basico.impl.UpdateMergeItemListImpl impl = new br.com.senior.furb.basico.impl.UpdateMergeItemListImpl(messengerSupplier, userId, messageSupplier);
		impl.updateMergeItemList(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeItemList
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ItemList entity.
	 */
	@Override
	public CompletableFuture<ItemList> updateMergeItemListRequest(ItemList input) {
		br.com.senior.furb.basico.impl.UpdateMergeItemListImpl impl = new br.com.senior.furb.basico.impl.UpdateMergeItemListImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeItemListRequest(input);
	}
	/**
	 * Chamada síncrona para o método deleteItemList
	 * This is a public operation
	 * The 'delete' request primitive for the ItemList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public void deleteItemList(ItemList.Id input, long timeout) {
		br.com.senior.furb.basico.impl.DeleteItemListImpl impl = new br.com.senior.furb.basico.impl.DeleteItemListImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteItemList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método deleteItemList
	 * This is a public operation
	 * The 'delete' request primitive for the ItemList entity.
	 */
	@Override
	public void deleteItemList(ItemList.Id input) {
		br.com.senior.furb.basico.impl.DeleteItemListImpl impl = new br.com.senior.furb.basico.impl.DeleteItemListImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteItemList(input);
	}
	
	/**
	 * Chamada síncrona para o método createShoppingList
	 * This is a public operation
	 * The 'create' request primitive for the ShoppingList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ShoppingList createShoppingList(ShoppingList input, long timeout) {
		br.com.senior.furb.basico.impl.CreateShoppingListImpl impl = new br.com.senior.furb.basico.impl.CreateShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.createShoppingList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createShoppingList
	 * This is a public operation
	 * The 'create' request primitive for the ShoppingList entity.
	 */
	@Override
	public void createShoppingList(ShoppingList input) {
		br.com.senior.furb.basico.impl.CreateShoppingListImpl impl = new br.com.senior.furb.basico.impl.CreateShoppingListImpl(messengerSupplier, userId, messageSupplier);
		impl.createShoppingList(input);
	}
	
	/**
	 * Chamada assíncrona para o método createShoppingList
	 * This is a public operation
	 * The 'create' request primitive for the ShoppingList entity.
	 */
	@Override
	public CompletableFuture<ShoppingList> createShoppingListRequest(ShoppingList input) {
		br.com.senior.furb.basico.impl.CreateShoppingListImpl impl = new br.com.senior.furb.basico.impl.CreateShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.createShoppingListRequest(input);
	}
	/**
	 * Chamada síncrona para o método createBulkShoppingList
	 * This is a public operation
	 * The 'createBulk' request primitive for the ShoppingList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public CreateBulkShoppingListOutput createBulkShoppingList(CreateBulkShoppingListInput input, long timeout) {
		br.com.senior.furb.basico.impl.CreateBulkShoppingListImpl impl = new br.com.senior.furb.basico.impl.CreateBulkShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkShoppingList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkShoppingList
	 * This is a public operation
	 * The 'createBulk' request primitive for the ShoppingList entity.
	 */
	@Override
	public void createBulkShoppingList(CreateBulkShoppingListInput input) {
		br.com.senior.furb.basico.impl.CreateBulkShoppingListImpl impl = new br.com.senior.furb.basico.impl.CreateBulkShoppingListImpl(messengerSupplier, userId, messageSupplier);
		impl.createBulkShoppingList(input);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkShoppingList
	 * This is a public operation
	 * The 'createBulk' request primitive for the ShoppingList entity.
	 */
	@Override
	public CompletableFuture<CreateBulkShoppingListOutput> createBulkShoppingListRequest(CreateBulkShoppingListInput input) {
		br.com.senior.furb.basico.impl.CreateBulkShoppingListImpl impl = new br.com.senior.furb.basico.impl.CreateBulkShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkShoppingListRequest(input);
	}
	/**
	 * Chamada síncrona para o método createMergeShoppingList
	 * This is a public operation
	 * The 'createMerge' request primitive for the ShoppingList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ShoppingList createMergeShoppingList(ShoppingList input, long timeout) {
		br.com.senior.furb.basico.impl.CreateMergeShoppingListImpl impl = new br.com.senior.furb.basico.impl.CreateMergeShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeShoppingList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeShoppingList
	 * This is a public operation
	 * The 'createMerge' request primitive for the ShoppingList entity.
	 */
	@Override
	public void createMergeShoppingList(ShoppingList input) {
		br.com.senior.furb.basico.impl.CreateMergeShoppingListImpl impl = new br.com.senior.furb.basico.impl.CreateMergeShoppingListImpl(messengerSupplier, userId, messageSupplier);
		impl.createMergeShoppingList(input);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeShoppingList
	 * This is a public operation
	 * The 'createMerge' request primitive for the ShoppingList entity.
	 */
	@Override
	public CompletableFuture<ShoppingList> createMergeShoppingListRequest(ShoppingList input) {
		br.com.senior.furb.basico.impl.CreateMergeShoppingListImpl impl = new br.com.senior.furb.basico.impl.CreateMergeShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeShoppingListRequest(input);
	}
	/**
	 * Chamada síncrona para o método retrieveShoppingList
	 * This is a public operation
	 * The 'retrieve' request primitive for the ShoppingList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ShoppingList retrieveShoppingList(ShoppingList.Id input, long timeout) {
		br.com.senior.furb.basico.impl.RetrieveShoppingListImpl impl = new br.com.senior.furb.basico.impl.RetrieveShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveShoppingList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveShoppingList
	 * This is a public operation
	 * The 'retrieve' request primitive for the ShoppingList entity.
	 */
	@Override
	public void retrieveShoppingList(ShoppingList.Id input) {
		br.com.senior.furb.basico.impl.RetrieveShoppingListImpl impl = new br.com.senior.furb.basico.impl.RetrieveShoppingListImpl(messengerSupplier, userId, messageSupplier);
		impl.retrieveShoppingList(input);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveShoppingList
	 * This is a public operation
	 * The 'retrieve' request primitive for the ShoppingList entity.
	 */
	@Override
	public CompletableFuture<ShoppingList> retrieveShoppingListRequest(ShoppingList.Id input) {
		br.com.senior.furb.basico.impl.RetrieveShoppingListImpl impl = new br.com.senior.furb.basico.impl.RetrieveShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveShoppingListRequest(input);
	}
	/**
	 * Chamada síncrona para o método updateShoppingList
	 * This is a public operation
	 * The 'update' request primitive for the ShoppingList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ShoppingList updateShoppingList(ShoppingList input, long timeout) {
		br.com.senior.furb.basico.impl.UpdateShoppingListImpl impl = new br.com.senior.furb.basico.impl.UpdateShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateShoppingList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateShoppingList
	 * This is a public operation
	 * The 'update' request primitive for the ShoppingList entity.
	 */
	@Override
	public void updateShoppingList(ShoppingList input) {
		br.com.senior.furb.basico.impl.UpdateShoppingListImpl impl = new br.com.senior.furb.basico.impl.UpdateShoppingListImpl(messengerSupplier, userId, messageSupplier);
		impl.updateShoppingList(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateShoppingList
	 * This is a public operation
	 * The 'update' request primitive for the ShoppingList entity.
	 */
	@Override
	public CompletableFuture<ShoppingList> updateShoppingListRequest(ShoppingList input) {
		br.com.senior.furb.basico.impl.UpdateShoppingListImpl impl = new br.com.senior.furb.basico.impl.UpdateShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateShoppingListRequest(input);
	}
	/**
	 * Chamada síncrona para o método updateMergeShoppingList
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ShoppingList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ShoppingList updateMergeShoppingList(ShoppingList input, long timeout) {
		br.com.senior.furb.basico.impl.UpdateMergeShoppingListImpl impl = new br.com.senior.furb.basico.impl.UpdateMergeShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeShoppingList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeShoppingList
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ShoppingList entity.
	 */
	@Override
	public void updateMergeShoppingList(ShoppingList input) {
		br.com.senior.furb.basico.impl.UpdateMergeShoppingListImpl impl = new br.com.senior.furb.basico.impl.UpdateMergeShoppingListImpl(messengerSupplier, userId, messageSupplier);
		impl.updateMergeShoppingList(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeShoppingList
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ShoppingList entity.
	 */
	@Override
	public CompletableFuture<ShoppingList> updateMergeShoppingListRequest(ShoppingList input) {
		br.com.senior.furb.basico.impl.UpdateMergeShoppingListImpl impl = new br.com.senior.furb.basico.impl.UpdateMergeShoppingListImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeShoppingListRequest(input);
	}
	/**
	 * Chamada síncrona para o método deleteShoppingList
	 * This is a public operation
	 * The 'delete' request primitive for the ShoppingList entity.
	 * @throws BasicoMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public void deleteShoppingList(ShoppingList.Id input, long timeout) {
		br.com.senior.furb.basico.impl.DeleteShoppingListImpl impl = new br.com.senior.furb.basico.impl.DeleteShoppingListImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteShoppingList(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método deleteShoppingList
	 * This is a public operation
	 * The 'delete' request primitive for the ShoppingList entity.
	 */
	@Override
	public void deleteShoppingList(ShoppingList.Id input) {
		br.com.senior.furb.basico.impl.DeleteShoppingListImpl impl = new br.com.senior.furb.basico.impl.DeleteShoppingListImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteShoppingList(input);
	}
	


	/**
	* Chamada assíncrona para o método publishServiceStarted
	* Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	*/
	public void publishServiceStarted( ServiceStartedPayload input ) {
	
		Message message = new Message(userId.getTenant(), BasicoConstants.DOMAIN, BasicoConstants.SERVICE, BasicoConstants.Events.SERVICE_STARTED, DtoJsonConverter.toJSON(input));
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new BasicoException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	* Chamada assíncrona para o método publishNotifyUserEvent
	* Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	*/
	public void publishNotifyUserEvent( NotifyUserEventPayload input ) {
	
		Message message = new Message(userId.getTenant(), BasicoConstants.DOMAIN, BasicoConstants.SERVICE, BasicoConstants.Events.NOTIFY_USER_EVENT, DtoJsonConverter.toJSON(input));
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new BasicoException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	* Chamada assíncrona para o método publishImportCategoryEvent
	* This is a public operation
	*/
	public void publishImportCategoryEvent( ImportCategoryEventPayload input ) {
	
		Message message = new Message(userId.getTenant(), BasicoConstants.DOMAIN, BasicoConstants.SERVICE, BasicoConstants.Events.IMPORT_CATEGORY_EVENT, DtoJsonConverter.toJSON(input));
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new BasicoException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	* Chamada assíncrona para o método publishExportCategoryEvent
	* This is a public operation
	*/
	public void publishExportCategoryEvent( ExportCategoryEventPayload input ) {
	
		Message message = new Message(userId.getTenant(), BasicoConstants.DOMAIN, BasicoConstants.SERVICE, BasicoConstants.Events.EXPORT_CATEGORY_EVENT, DtoJsonConverter.toJSON(input));
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new BasicoException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	* Chamada assíncrona para o método publishImportItemListEvent
	* This is a public operation
	*/
	public void publishImportItemListEvent( ImportItemListEventPayload input ) {
	
		Message message = new Message(userId.getTenant(), BasicoConstants.DOMAIN, BasicoConstants.SERVICE, BasicoConstants.Events.IMPORT_ITEM_LIST_EVENT, DtoJsonConverter.toJSON(input));
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new BasicoException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	* Chamada assíncrona para o método publishExportItemListEvent
	* This is a public operation
	*/
	public void publishExportItemListEvent( ExportItemListEventPayload input ) {
	
		Message message = new Message(userId.getTenant(), BasicoConstants.DOMAIN, BasicoConstants.SERVICE, BasicoConstants.Events.EXPORT_ITEM_LIST_EVENT, DtoJsonConverter.toJSON(input));
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new BasicoException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	* Chamada assíncrona para o método publishImportShoppingListEvent
	* This is a public operation
	*/
	public void publishImportShoppingListEvent( ImportShoppingListEventPayload input ) {
	
		Message message = new Message(userId.getTenant(), BasicoConstants.DOMAIN, BasicoConstants.SERVICE, BasicoConstants.Events.IMPORT_SHOPPING_LIST_EVENT, DtoJsonConverter.toJSON(input));
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new BasicoException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	* Chamada assíncrona para o método publishExportShoppingListEvent
	* This is a public operation
	*/
	public void publishExportShoppingListEvent( ExportShoppingListEventPayload input ) {
	
		Message message = new Message(userId.getTenant(), BasicoConstants.DOMAIN, BasicoConstants.SERVICE, BasicoConstants.Events.EXPORT_SHOPPING_LIST_EVENT, DtoJsonConverter.toJSON(input));
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new BasicoException("Erro ao enviar a mensagem", e);
		}
	}
	

	private void addMessageHeaders(Message message) {
		message.setUsername(userId.getUsername());
		if (userId.isTrusted()) {
			message.addHeader("trusted", true);
		}
	}
}
