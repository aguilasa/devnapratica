/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;

/**
 * Trabalho Final
 */
public interface BasicoConstants {
    String DOMAIN = "furb";
    String SERVICE = "basico";
    
    interface Commands {
    	/**
    	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
    	 * @see GetMetadataInput the request payload
    	 */
    	String GET_METADATA = "getMetadata";
    	/**
    	 * The success response primitive for getMetadata.
    	 *
    	 * @see #GET_METADATA the request primitive
    	 * @see GetMetadataOutput the response payload
    	 */
    	String GET_METADATA_RESPONSE = "getMetadataResponse";
    	/**
    	 * An error response primitive for getMetadata.
    	 *
    	 * @see #GET_METADATA the request primitive
    	 */
    	String GET_METADATA_ERROR = "getMetadataError";
    	/**
    	 * @see ImportCategoryInput the request payload
    	 */
    	String IMPORT_CATEGORY = "importCategory";
    	/**
    	 * The success response primitive for importCategory.
    	 *
    	 * @see #IMPORT_CATEGORY the request primitive
    	 * @see ImportCategoryOutput the response payload
    	 */
    	String IMPORT_CATEGORY_RESPONSE = "importCategoryResponse";
    	/**
    	 * An error response primitive for importCategory.
    	 *
    	 * @see #IMPORT_CATEGORY the request primitive
    	 */
    	String IMPORT_CATEGORY_ERROR = "importCategoryError";
    	/**
    	 * @see ExportCategoryInput the request payload
    	 */
    	String EXPORT_CATEGORY = "exportCategory";
    	/**
    	 * The success response primitive for exportCategory.
    	 *
    	 * @see #EXPORT_CATEGORY the request primitive
    	 * @see ExportCategoryOutput the response payload
    	 */
    	String EXPORT_CATEGORY_RESPONSE = "exportCategoryResponse";
    	/**
    	 * An error response primitive for exportCategory.
    	 *
    	 * @see #EXPORT_CATEGORY the request primitive
    	 */
    	String EXPORT_CATEGORY_ERROR = "exportCategoryError";
    	/**
    	 * @see ImportProductInput the request payload
    	 */
    	String IMPORT_PRODUCT = "importProduct";
    	/**
    	 * The success response primitive for importProduct.
    	 *
    	 * @see #IMPORT_PRODUCT the request primitive
    	 * @see ImportProductOutput the response payload
    	 */
    	String IMPORT_PRODUCT_RESPONSE = "importProductResponse";
    	/**
    	 * An error response primitive for importProduct.
    	 *
    	 * @see #IMPORT_PRODUCT the request primitive
    	 */
    	String IMPORT_PRODUCT_ERROR = "importProductError";
    	/**
    	 * @see ExportProductInput the request payload
    	 */
    	String EXPORT_PRODUCT = "exportProduct";
    	/**
    	 * The success response primitive for exportProduct.
    	 *
    	 * @see #EXPORT_PRODUCT the request primitive
    	 * @see ExportProductOutput the response payload
    	 */
    	String EXPORT_PRODUCT_RESPONSE = "exportProductResponse";
    	/**
    	 * An error response primitive for exportProduct.
    	 *
    	 * @see #EXPORT_PRODUCT the request primitive
    	 */
    	String EXPORT_PRODUCT_ERROR = "exportProductError";
    	/**
    	 * @see ImportItemListInput the request payload
    	 */
    	String IMPORT_ITEM_LIST = "importItemList";
    	/**
    	 * The success response primitive for importItemList.
    	 *
    	 * @see #IMPORT_ITEM_LIST the request primitive
    	 * @see ImportItemListOutput the response payload
    	 */
    	String IMPORT_ITEM_LIST_RESPONSE = "importItemListResponse";
    	/**
    	 * An error response primitive for importItemList.
    	 *
    	 * @see #IMPORT_ITEM_LIST the request primitive
    	 */
    	String IMPORT_ITEM_LIST_ERROR = "importItemListError";
    	/**
    	 * @see ExportItemListInput the request payload
    	 */
    	String EXPORT_ITEM_LIST = "exportItemList";
    	/**
    	 * The success response primitive for exportItemList.
    	 *
    	 * @see #EXPORT_ITEM_LIST the request primitive
    	 * @see ExportItemListOutput the response payload
    	 */
    	String EXPORT_ITEM_LIST_RESPONSE = "exportItemListResponse";
    	/**
    	 * An error response primitive for exportItemList.
    	 *
    	 * @see #EXPORT_ITEM_LIST the request primitive
    	 */
    	String EXPORT_ITEM_LIST_ERROR = "exportItemListError";
    	/**
    	 * @see ImportShoppingListInput the request payload
    	 */
    	String IMPORT_SHOPPING_LIST = "importShoppingList";
    	/**
    	 * The success response primitive for importShoppingList.
    	 *
    	 * @see #IMPORT_SHOPPING_LIST the request primitive
    	 * @see ImportShoppingListOutput the response payload
    	 */
    	String IMPORT_SHOPPING_LIST_RESPONSE = "importShoppingListResponse";
    	/**
    	 * An error response primitive for importShoppingList.
    	 *
    	 * @see #IMPORT_SHOPPING_LIST the request primitive
    	 */
    	String IMPORT_SHOPPING_LIST_ERROR = "importShoppingListError";
    	/**
    	 * @see ExportShoppingListInput the request payload
    	 */
    	String EXPORT_SHOPPING_LIST = "exportShoppingList";
    	/**
    	 * The success response primitive for exportShoppingList.
    	 *
    	 * @see #EXPORT_SHOPPING_LIST the request primitive
    	 * @see ExportShoppingListOutput the response payload
    	 */
    	String EXPORT_SHOPPING_LIST_RESPONSE = "exportShoppingListResponse";
    	/**
    	 * An error response primitive for exportShoppingList.
    	 *
    	 * @see #EXPORT_SHOPPING_LIST the request primitive
    	 */
    	String EXPORT_SHOPPING_LIST_ERROR = "exportShoppingListError";
    	/**
    	 * @see ImportClienteInput the request payload
    	 */
    	String IMPORT_CLIENTE = "importCliente";
    	/**
    	 * The success response primitive for importCliente.
    	 *
    	 * @see #IMPORT_CLIENTE the request primitive
    	 * @see ImportClienteOutput the response payload
    	 */
    	String IMPORT_CLIENTE_RESPONSE = "importClienteResponse";
    	/**
    	 * An error response primitive for importCliente.
    	 *
    	 * @see #IMPORT_CLIENTE the request primitive
    	 */
    	String IMPORT_CLIENTE_ERROR = "importClienteError";
    	/**
    	 * @see ExportClienteInput the request payload
    	 */
    	String EXPORT_CLIENTE = "exportCliente";
    	/**
    	 * The success response primitive for exportCliente.
    	 *
    	 * @see #EXPORT_CLIENTE the request primitive
    	 * @see ExportClienteOutput the response payload
    	 */
    	String EXPORT_CLIENTE_RESPONSE = "exportClienteResponse";
    	/**
    	 * An error response primitive for exportCliente.
    	 *
    	 * @see #EXPORT_CLIENTE the request primitive
    	 */
    	String EXPORT_CLIENTE_ERROR = "exportClienteError";
    	/**
    	 * The 'list' request primitive for the Category entity.
    	 * @see category.pageRequest the request payload
    	 */
    	String LIST_CATEGORY = "listCategory";
    	/**
    	 * The success response primitive for listCategory.
    	 *
    	 * @see #LIST_CATEGORY the request primitive
    	 * @see Category.PagedResults the response payload
    	 */
    	String LIST_CATEGORY_RESPONSE = "listCategoryResponse";
    	/**
    	 * An error response primitive for listCategory.
    	 *
    	 * @see #LIST_CATEGORY the request primitive
    	 */
    	String LIST_CATEGORY_ERROR = "listCategoryError";
    	/**
    	 * The 'list' request primitive for the Product entity.
    	 * @see product.pageRequest the request payload
    	 */
    	String LIST_PRODUCT = "listProduct";
    	/**
    	 * The success response primitive for listProduct.
    	 *
    	 * @see #LIST_PRODUCT the request primitive
    	 * @see Product.PagedResults the response payload
    	 */
    	String LIST_PRODUCT_RESPONSE = "listProductResponse";
    	/**
    	 * An error response primitive for listProduct.
    	 *
    	 * @see #LIST_PRODUCT the request primitive
    	 */
    	String LIST_PRODUCT_ERROR = "listProductError";
    	/**
    	 * The 'list' request primitive for the ItemList entity.
    	 * @see itemList.pageRequest the request payload
    	 */
    	String LIST_ITEM_LIST = "listItemList";
    	/**
    	 * The success response primitive for listItemList.
    	 *
    	 * @see #LIST_ITEM_LIST the request primitive
    	 * @see ItemList.PagedResults the response payload
    	 */
    	String LIST_ITEM_LIST_RESPONSE = "listItemListResponse";
    	/**
    	 * An error response primitive for listItemList.
    	 *
    	 * @see #LIST_ITEM_LIST the request primitive
    	 */
    	String LIST_ITEM_LIST_ERROR = "listItemListError";
    	/**
    	 * The 'list' request primitive for the ShoppingList entity.
    	 * @see shoppingList.pageRequest the request payload
    	 */
    	String LIST_SHOPPING_LIST = "listShoppingList";
    	/**
    	 * The success response primitive for listShoppingList.
    	 *
    	 * @see #LIST_SHOPPING_LIST the request primitive
    	 * @see ShoppingList.PagedResults the response payload
    	 */
    	String LIST_SHOPPING_LIST_RESPONSE = "listShoppingListResponse";
    	/**
    	 * An error response primitive for listShoppingList.
    	 *
    	 * @see #LIST_SHOPPING_LIST the request primitive
    	 */
    	String LIST_SHOPPING_LIST_ERROR = "listShoppingListError";
    	/**
    	 * The 'list' request primitive for the Cliente entity.
    	 * @see cliente.pageRequest the request payload
    	 */
    	String LIST_CLIENTE = "listCliente";
    	/**
    	 * The success response primitive for listCliente.
    	 *
    	 * @see #LIST_CLIENTE the request primitive
    	 * @see Cliente.PagedResults the response payload
    	 */
    	String LIST_CLIENTE_RESPONSE = "listClienteResponse";
    	/**
    	 * An error response primitive for listCliente.
    	 *
    	 * @see #LIST_CLIENTE the request primitive
    	 */
    	String LIST_CLIENTE_ERROR = "listClienteError";
    	/**
    	 * Returns a list with all dependencies from this service, along with their respective versions
    	 */
    	String GET_DEPENDENCIES = "getDependencies";
    	/**
    	 * The success response primitive for getDependencies.
    	 *
    	 * @see #GET_DEPENDENCIES the request primitive
    	 * @see GetDependenciesOutput the response payload
    	 */
    	String GET_DEPENDENCIES_RESPONSE = "getDependenciesResponse";
    	/**
    	 * An error response primitive for getDependencies.
    	 *
    	 * @see #GET_DEPENDENCIES the request primitive
    	 */
    	String GET_DEPENDENCIES_ERROR = "getDependenciesError";
    	/**
    	 * The 'create' request primitive for the Category entity.
    	 * @see Category the request payload
    	 */
    	String CREATE_CATEGORY = "createCategory";
    	/**
    	 * The success response primitive for createCategory.
    	 *
    	 * @see #CREATE_CATEGORY the request primitive
    	 */
    	String CREATE_CATEGORY_RESPONSE = "createCategoryResponse";
    	/**
    	 * An error response primitive for createCategory.
    	 *
    	 * @see #CREATE_CATEGORY the request primitive
    	 */
    	String CREATE_CATEGORY_ERROR = "createCategoryError";
    	/**
    	 * The 'createBulk' request primitive for the Category entity.
    	 * @see CreateBulkCategoryInput the request payload
    	 */
    	String CREATE_BULK_CATEGORY = "createBulkCategory";
    	/**
    	 * The success response primitive for createBulkCategory.
    	 *
    	 * @see #CREATE_BULK_CATEGORY the request primitive
    	 * @see CreateBulkCategoryOutput the response payload
    	 */
    	String CREATE_BULK_CATEGORY_RESPONSE = "createBulkCategoryResponse";
    	/**
    	 * An error response primitive for createBulkCategory.
    	 *
    	 * @see #CREATE_BULK_CATEGORY the request primitive
    	 */
    	String CREATE_BULK_CATEGORY_ERROR = "createBulkCategoryError";
    	/**
    	 * The 'createMerge' request primitive for the Category entity.
    	 * @see Category the request payload
    	 */
    	String CREATE_MERGE_CATEGORY = "createMergeCategory";
    	/**
    	 * The success response primitive for createMergeCategory.
    	 *
    	 * @see #CREATE_MERGE_CATEGORY the request primitive
    	 */
    	String CREATE_MERGE_CATEGORY_RESPONSE = "createMergeCategoryResponse";
    	/**
    	 * An error response primitive for createMergeCategory.
    	 *
    	 * @see #CREATE_MERGE_CATEGORY the request primitive
    	 */
    	String CREATE_MERGE_CATEGORY_ERROR = "createMergeCategoryError";
    	/**
    	 * The 'retrieve' request primitive for the Category entity.
    	 * @see Category.Id the request payload
    	 */
    	String RETRIEVE_CATEGORY = "retrieveCategory";
    	/**
    	 * The success response primitive for retrieveCategory.
    	 *
    	 * @see #RETRIEVE_CATEGORY the request primitive
    	 */
    	String RETRIEVE_CATEGORY_RESPONSE = "retrieveCategoryResponse";
    	/**
    	 * An error response primitive for retrieveCategory.
    	 *
    	 * @see #RETRIEVE_CATEGORY the request primitive
    	 */
    	String RETRIEVE_CATEGORY_ERROR = "retrieveCategoryError";
    	/**
    	 * The 'update' request primitive for the Category entity.
    	 * @see Category the request payload
    	 */
    	String UPDATE_CATEGORY = "updateCategory";
    	/**
    	 * The success response primitive for updateCategory.
    	 *
    	 * @see #UPDATE_CATEGORY the request primitive
    	 */
    	String UPDATE_CATEGORY_RESPONSE = "updateCategoryResponse";
    	/**
    	 * An error response primitive for updateCategory.
    	 *
    	 * @see #UPDATE_CATEGORY the request primitive
    	 */
    	String UPDATE_CATEGORY_ERROR = "updateCategoryError";
    	/**
    	 * The 'updateMerge' request primitive for the Category entity.
    	 * @see Category the request payload
    	 */
    	String UPDATE_MERGE_CATEGORY = "updateMergeCategory";
    	/**
    	 * The success response primitive for updateMergeCategory.
    	 *
    	 * @see #UPDATE_MERGE_CATEGORY the request primitive
    	 */
    	String UPDATE_MERGE_CATEGORY_RESPONSE = "updateMergeCategoryResponse";
    	/**
    	 * An error response primitive for updateMergeCategory.
    	 *
    	 * @see #UPDATE_MERGE_CATEGORY the request primitive
    	 */
    	String UPDATE_MERGE_CATEGORY_ERROR = "updateMergeCategoryError";
    	/**
    	 * The 'delete' request primitive for the Category entity.
    	 * @see Category.Id the request payload
    	 */
    	String DELETE_CATEGORY = "deleteCategory";
    	/**
    	 * The success response primitive for deleteCategory.
    	 *
    	 * @see #DELETE_CATEGORY the request primitive
    	 */
    	String DELETE_CATEGORY_RESPONSE = "deleteCategoryResponse";
    	/**
    	 * An error response primitive for deleteCategory.
    	 *
    	 * @see #DELETE_CATEGORY the request primitive
    	 */
    	String DELETE_CATEGORY_ERROR = "deleteCategoryError";
    	/**
    	 * The 'create' request primitive for the Product entity.
    	 * @see Product the request payload
    	 */
    	String CREATE_PRODUCT = "createProduct";
    	/**
    	 * The success response primitive for createProduct.
    	 *
    	 * @see #CREATE_PRODUCT the request primitive
    	 */
    	String CREATE_PRODUCT_RESPONSE = "createProductResponse";
    	/**
    	 * An error response primitive for createProduct.
    	 *
    	 * @see #CREATE_PRODUCT the request primitive
    	 */
    	String CREATE_PRODUCT_ERROR = "createProductError";
    	/**
    	 * The 'createBulk' request primitive for the Product entity.
    	 * @see CreateBulkProductInput the request payload
    	 */
    	String CREATE_BULK_PRODUCT = "createBulkProduct";
    	/**
    	 * The success response primitive for createBulkProduct.
    	 *
    	 * @see #CREATE_BULK_PRODUCT the request primitive
    	 * @see CreateBulkProductOutput the response payload
    	 */
    	String CREATE_BULK_PRODUCT_RESPONSE = "createBulkProductResponse";
    	/**
    	 * An error response primitive for createBulkProduct.
    	 *
    	 * @see #CREATE_BULK_PRODUCT the request primitive
    	 */
    	String CREATE_BULK_PRODUCT_ERROR = "createBulkProductError";
    	/**
    	 * The 'createMerge' request primitive for the Product entity.
    	 * @see Product the request payload
    	 */
    	String CREATE_MERGE_PRODUCT = "createMergeProduct";
    	/**
    	 * The success response primitive for createMergeProduct.
    	 *
    	 * @see #CREATE_MERGE_PRODUCT the request primitive
    	 */
    	String CREATE_MERGE_PRODUCT_RESPONSE = "createMergeProductResponse";
    	/**
    	 * An error response primitive for createMergeProduct.
    	 *
    	 * @see #CREATE_MERGE_PRODUCT the request primitive
    	 */
    	String CREATE_MERGE_PRODUCT_ERROR = "createMergeProductError";
    	/**
    	 * The 'retrieve' request primitive for the Product entity.
    	 * @see Product.Id the request payload
    	 */
    	String RETRIEVE_PRODUCT = "retrieveProduct";
    	/**
    	 * The success response primitive for retrieveProduct.
    	 *
    	 * @see #RETRIEVE_PRODUCT the request primitive
    	 */
    	String RETRIEVE_PRODUCT_RESPONSE = "retrieveProductResponse";
    	/**
    	 * An error response primitive for retrieveProduct.
    	 *
    	 * @see #RETRIEVE_PRODUCT the request primitive
    	 */
    	String RETRIEVE_PRODUCT_ERROR = "retrieveProductError";
    	/**
    	 * The 'update' request primitive for the Product entity.
    	 * @see Product the request payload
    	 */
    	String UPDATE_PRODUCT = "updateProduct";
    	/**
    	 * The success response primitive for updateProduct.
    	 *
    	 * @see #UPDATE_PRODUCT the request primitive
    	 */
    	String UPDATE_PRODUCT_RESPONSE = "updateProductResponse";
    	/**
    	 * An error response primitive for updateProduct.
    	 *
    	 * @see #UPDATE_PRODUCT the request primitive
    	 */
    	String UPDATE_PRODUCT_ERROR = "updateProductError";
    	/**
    	 * The 'updateMerge' request primitive for the Product entity.
    	 * @see Product the request payload
    	 */
    	String UPDATE_MERGE_PRODUCT = "updateMergeProduct";
    	/**
    	 * The success response primitive for updateMergeProduct.
    	 *
    	 * @see #UPDATE_MERGE_PRODUCT the request primitive
    	 */
    	String UPDATE_MERGE_PRODUCT_RESPONSE = "updateMergeProductResponse";
    	/**
    	 * An error response primitive for updateMergeProduct.
    	 *
    	 * @see #UPDATE_MERGE_PRODUCT the request primitive
    	 */
    	String UPDATE_MERGE_PRODUCT_ERROR = "updateMergeProductError";
    	/**
    	 * The 'delete' request primitive for the Product entity.
    	 * @see Product.Id the request payload
    	 */
    	String DELETE_PRODUCT = "deleteProduct";
    	/**
    	 * The success response primitive for deleteProduct.
    	 *
    	 * @see #DELETE_PRODUCT the request primitive
    	 */
    	String DELETE_PRODUCT_RESPONSE = "deleteProductResponse";
    	/**
    	 * An error response primitive for deleteProduct.
    	 *
    	 * @see #DELETE_PRODUCT the request primitive
    	 */
    	String DELETE_PRODUCT_ERROR = "deleteProductError";
    	/**
    	 * The 'create' request primitive for the ItemList entity.
    	 * @see ItemList the request payload
    	 */
    	String CREATE_ITEM_LIST = "createItemList";
    	/**
    	 * The success response primitive for createItemList.
    	 *
    	 * @see #CREATE_ITEM_LIST the request primitive
    	 */
    	String CREATE_ITEM_LIST_RESPONSE = "createItemListResponse";
    	/**
    	 * An error response primitive for createItemList.
    	 *
    	 * @see #CREATE_ITEM_LIST the request primitive
    	 */
    	String CREATE_ITEM_LIST_ERROR = "createItemListError";
    	/**
    	 * The 'createBulk' request primitive for the ItemList entity.
    	 * @see CreateBulkItemListInput the request payload
    	 */
    	String CREATE_BULK_ITEM_LIST = "createBulkItemList";
    	/**
    	 * The success response primitive for createBulkItemList.
    	 *
    	 * @see #CREATE_BULK_ITEM_LIST the request primitive
    	 * @see CreateBulkItemListOutput the response payload
    	 */
    	String CREATE_BULK_ITEM_LIST_RESPONSE = "createBulkItemListResponse";
    	/**
    	 * An error response primitive for createBulkItemList.
    	 *
    	 * @see #CREATE_BULK_ITEM_LIST the request primitive
    	 */
    	String CREATE_BULK_ITEM_LIST_ERROR = "createBulkItemListError";
    	/**
    	 * The 'createMerge' request primitive for the ItemList entity.
    	 * @see ItemList the request payload
    	 */
    	String CREATE_MERGE_ITEM_LIST = "createMergeItemList";
    	/**
    	 * The success response primitive for createMergeItemList.
    	 *
    	 * @see #CREATE_MERGE_ITEM_LIST the request primitive
    	 */
    	String CREATE_MERGE_ITEM_LIST_RESPONSE = "createMergeItemListResponse";
    	/**
    	 * An error response primitive for createMergeItemList.
    	 *
    	 * @see #CREATE_MERGE_ITEM_LIST the request primitive
    	 */
    	String CREATE_MERGE_ITEM_LIST_ERROR = "createMergeItemListError";
    	/**
    	 * The 'retrieve' request primitive for the ItemList entity.
    	 * @see ItemList.Id the request payload
    	 */
    	String RETRIEVE_ITEM_LIST = "retrieveItemList";
    	/**
    	 * The success response primitive for retrieveItemList.
    	 *
    	 * @see #RETRIEVE_ITEM_LIST the request primitive
    	 */
    	String RETRIEVE_ITEM_LIST_RESPONSE = "retrieveItemListResponse";
    	/**
    	 * An error response primitive for retrieveItemList.
    	 *
    	 * @see #RETRIEVE_ITEM_LIST the request primitive
    	 */
    	String RETRIEVE_ITEM_LIST_ERROR = "retrieveItemListError";
    	/**
    	 * The 'update' request primitive for the ItemList entity.
    	 * @see ItemList the request payload
    	 */
    	String UPDATE_ITEM_LIST = "updateItemList";
    	/**
    	 * The success response primitive for updateItemList.
    	 *
    	 * @see #UPDATE_ITEM_LIST the request primitive
    	 */
    	String UPDATE_ITEM_LIST_RESPONSE = "updateItemListResponse";
    	/**
    	 * An error response primitive for updateItemList.
    	 *
    	 * @see #UPDATE_ITEM_LIST the request primitive
    	 */
    	String UPDATE_ITEM_LIST_ERROR = "updateItemListError";
    	/**
    	 * The 'updateMerge' request primitive for the ItemList entity.
    	 * @see ItemList the request payload
    	 */
    	String UPDATE_MERGE_ITEM_LIST = "updateMergeItemList";
    	/**
    	 * The success response primitive for updateMergeItemList.
    	 *
    	 * @see #UPDATE_MERGE_ITEM_LIST the request primitive
    	 */
    	String UPDATE_MERGE_ITEM_LIST_RESPONSE = "updateMergeItemListResponse";
    	/**
    	 * An error response primitive for updateMergeItemList.
    	 *
    	 * @see #UPDATE_MERGE_ITEM_LIST the request primitive
    	 */
    	String UPDATE_MERGE_ITEM_LIST_ERROR = "updateMergeItemListError";
    	/**
    	 * The 'delete' request primitive for the ItemList entity.
    	 * @see ItemList.Id the request payload
    	 */
    	String DELETE_ITEM_LIST = "deleteItemList";
    	/**
    	 * The success response primitive for deleteItemList.
    	 *
    	 * @see #DELETE_ITEM_LIST the request primitive
    	 */
    	String DELETE_ITEM_LIST_RESPONSE = "deleteItemListResponse";
    	/**
    	 * An error response primitive for deleteItemList.
    	 *
    	 * @see #DELETE_ITEM_LIST the request primitive
    	 */
    	String DELETE_ITEM_LIST_ERROR = "deleteItemListError";
    	/**
    	 * The 'create' request primitive for the ShoppingList entity.
    	 * @see ShoppingList the request payload
    	 */
    	String CREATE_SHOPPING_LIST = "createShoppingList";
    	/**
    	 * The success response primitive for createShoppingList.
    	 *
    	 * @see #CREATE_SHOPPING_LIST the request primitive
    	 */
    	String CREATE_SHOPPING_LIST_RESPONSE = "createShoppingListResponse";
    	/**
    	 * An error response primitive for createShoppingList.
    	 *
    	 * @see #CREATE_SHOPPING_LIST the request primitive
    	 */
    	String CREATE_SHOPPING_LIST_ERROR = "createShoppingListError";
    	/**
    	 * The 'createBulk' request primitive for the ShoppingList entity.
    	 * @see CreateBulkShoppingListInput the request payload
    	 */
    	String CREATE_BULK_SHOPPING_LIST = "createBulkShoppingList";
    	/**
    	 * The success response primitive for createBulkShoppingList.
    	 *
    	 * @see #CREATE_BULK_SHOPPING_LIST the request primitive
    	 * @see CreateBulkShoppingListOutput the response payload
    	 */
    	String CREATE_BULK_SHOPPING_LIST_RESPONSE = "createBulkShoppingListResponse";
    	/**
    	 * An error response primitive for createBulkShoppingList.
    	 *
    	 * @see #CREATE_BULK_SHOPPING_LIST the request primitive
    	 */
    	String CREATE_BULK_SHOPPING_LIST_ERROR = "createBulkShoppingListError";
    	/**
    	 * The 'createMerge' request primitive for the ShoppingList entity.
    	 * @see ShoppingList the request payload
    	 */
    	String CREATE_MERGE_SHOPPING_LIST = "createMergeShoppingList";
    	/**
    	 * The success response primitive for createMergeShoppingList.
    	 *
    	 * @see #CREATE_MERGE_SHOPPING_LIST the request primitive
    	 */
    	String CREATE_MERGE_SHOPPING_LIST_RESPONSE = "createMergeShoppingListResponse";
    	/**
    	 * An error response primitive for createMergeShoppingList.
    	 *
    	 * @see #CREATE_MERGE_SHOPPING_LIST the request primitive
    	 */
    	String CREATE_MERGE_SHOPPING_LIST_ERROR = "createMergeShoppingListError";
    	/**
    	 * The 'retrieve' request primitive for the ShoppingList entity.
    	 * @see ShoppingList.Id the request payload
    	 */
    	String RETRIEVE_SHOPPING_LIST = "retrieveShoppingList";
    	/**
    	 * The success response primitive for retrieveShoppingList.
    	 *
    	 * @see #RETRIEVE_SHOPPING_LIST the request primitive
    	 */
    	String RETRIEVE_SHOPPING_LIST_RESPONSE = "retrieveShoppingListResponse";
    	/**
    	 * An error response primitive for retrieveShoppingList.
    	 *
    	 * @see #RETRIEVE_SHOPPING_LIST the request primitive
    	 */
    	String RETRIEVE_SHOPPING_LIST_ERROR = "retrieveShoppingListError";
    	/**
    	 * The 'update' request primitive for the ShoppingList entity.
    	 * @see ShoppingList the request payload
    	 */
    	String UPDATE_SHOPPING_LIST = "updateShoppingList";
    	/**
    	 * The success response primitive for updateShoppingList.
    	 *
    	 * @see #UPDATE_SHOPPING_LIST the request primitive
    	 */
    	String UPDATE_SHOPPING_LIST_RESPONSE = "updateShoppingListResponse";
    	/**
    	 * An error response primitive for updateShoppingList.
    	 *
    	 * @see #UPDATE_SHOPPING_LIST the request primitive
    	 */
    	String UPDATE_SHOPPING_LIST_ERROR = "updateShoppingListError";
    	/**
    	 * The 'updateMerge' request primitive for the ShoppingList entity.
    	 * @see ShoppingList the request payload
    	 */
    	String UPDATE_MERGE_SHOPPING_LIST = "updateMergeShoppingList";
    	/**
    	 * The success response primitive for updateMergeShoppingList.
    	 *
    	 * @see #UPDATE_MERGE_SHOPPING_LIST the request primitive
    	 */
    	String UPDATE_MERGE_SHOPPING_LIST_RESPONSE = "updateMergeShoppingListResponse";
    	/**
    	 * An error response primitive for updateMergeShoppingList.
    	 *
    	 * @see #UPDATE_MERGE_SHOPPING_LIST the request primitive
    	 */
    	String UPDATE_MERGE_SHOPPING_LIST_ERROR = "updateMergeShoppingListError";
    	/**
    	 * The 'delete' request primitive for the ShoppingList entity.
    	 * @see ShoppingList.Id the request payload
    	 */
    	String DELETE_SHOPPING_LIST = "deleteShoppingList";
    	/**
    	 * The success response primitive for deleteShoppingList.
    	 *
    	 * @see #DELETE_SHOPPING_LIST the request primitive
    	 */
    	String DELETE_SHOPPING_LIST_RESPONSE = "deleteShoppingListResponse";
    	/**
    	 * An error response primitive for deleteShoppingList.
    	 *
    	 * @see #DELETE_SHOPPING_LIST the request primitive
    	 */
    	String DELETE_SHOPPING_LIST_ERROR = "deleteShoppingListError";
    	/**
    	 * The 'create' request primitive for the Cliente entity.
    	 * @see Cliente the request payload
    	 */
    	String CREATE_CLIENTE = "createCliente";
    	/**
    	 * The success response primitive for createCliente.
    	 *
    	 * @see #CREATE_CLIENTE the request primitive
    	 */
    	String CREATE_CLIENTE_RESPONSE = "createClienteResponse";
    	/**
    	 * An error response primitive for createCliente.
    	 *
    	 * @see #CREATE_CLIENTE the request primitive
    	 */
    	String CREATE_CLIENTE_ERROR = "createClienteError";
    	/**
    	 * The 'createBulk' request primitive for the Cliente entity.
    	 * @see CreateBulkClienteInput the request payload
    	 */
    	String CREATE_BULK_CLIENTE = "createBulkCliente";
    	/**
    	 * The success response primitive for createBulkCliente.
    	 *
    	 * @see #CREATE_BULK_CLIENTE the request primitive
    	 * @see CreateBulkClienteOutput the response payload
    	 */
    	String CREATE_BULK_CLIENTE_RESPONSE = "createBulkClienteResponse";
    	/**
    	 * An error response primitive for createBulkCliente.
    	 *
    	 * @see #CREATE_BULK_CLIENTE the request primitive
    	 */
    	String CREATE_BULK_CLIENTE_ERROR = "createBulkClienteError";
    	/**
    	 * The 'createMerge' request primitive for the Cliente entity.
    	 * @see Cliente the request payload
    	 */
    	String CREATE_MERGE_CLIENTE = "createMergeCliente";
    	/**
    	 * The success response primitive for createMergeCliente.
    	 *
    	 * @see #CREATE_MERGE_CLIENTE the request primitive
    	 */
    	String CREATE_MERGE_CLIENTE_RESPONSE = "createMergeClienteResponse";
    	/**
    	 * An error response primitive for createMergeCliente.
    	 *
    	 * @see #CREATE_MERGE_CLIENTE the request primitive
    	 */
    	String CREATE_MERGE_CLIENTE_ERROR = "createMergeClienteError";
    	/**
    	 * The 'retrieve' request primitive for the Cliente entity.
    	 * @see Cliente.Id the request payload
    	 */
    	String RETRIEVE_CLIENTE = "retrieveCliente";
    	/**
    	 * The success response primitive for retrieveCliente.
    	 *
    	 * @see #RETRIEVE_CLIENTE the request primitive
    	 */
    	String RETRIEVE_CLIENTE_RESPONSE = "retrieveClienteResponse";
    	/**
    	 * An error response primitive for retrieveCliente.
    	 *
    	 * @see #RETRIEVE_CLIENTE the request primitive
    	 */
    	String RETRIEVE_CLIENTE_ERROR = "retrieveClienteError";
    	/**
    	 * The 'update' request primitive for the Cliente entity.
    	 * @see Cliente the request payload
    	 */
    	String UPDATE_CLIENTE = "updateCliente";
    	/**
    	 * The success response primitive for updateCliente.
    	 *
    	 * @see #UPDATE_CLIENTE the request primitive
    	 */
    	String UPDATE_CLIENTE_RESPONSE = "updateClienteResponse";
    	/**
    	 * An error response primitive for updateCliente.
    	 *
    	 * @see #UPDATE_CLIENTE the request primitive
    	 */
    	String UPDATE_CLIENTE_ERROR = "updateClienteError";
    	/**
    	 * The 'updateMerge' request primitive for the Cliente entity.
    	 * @see Cliente the request payload
    	 */
    	String UPDATE_MERGE_CLIENTE = "updateMergeCliente";
    	/**
    	 * The success response primitive for updateMergeCliente.
    	 *
    	 * @see #UPDATE_MERGE_CLIENTE the request primitive
    	 */
    	String UPDATE_MERGE_CLIENTE_RESPONSE = "updateMergeClienteResponse";
    	/**
    	 * An error response primitive for updateMergeCliente.
    	 *
    	 * @see #UPDATE_MERGE_CLIENTE the request primitive
    	 */
    	String UPDATE_MERGE_CLIENTE_ERROR = "updateMergeClienteError";
    	/**
    	 * The 'delete' request primitive for the Cliente entity.
    	 * @see Cliente.Id the request payload
    	 */
    	String DELETE_CLIENTE = "deleteCliente";
    	/**
    	 * The success response primitive for deleteCliente.
    	 *
    	 * @see #DELETE_CLIENTE the request primitive
    	 */
    	String DELETE_CLIENTE_RESPONSE = "deleteClienteResponse";
    	/**
    	 * An error response primitive for deleteCliente.
    	 *
    	 * @see #DELETE_CLIENTE the request primitive
    	 */
    	String DELETE_CLIENTE_ERROR = "deleteClienteError";
    }
    
    interface Events {
    	/**
    	 * Default 'serviceStarted' event.
    	 */
    	String SERVICE_STARTED = "serviceStarted";
    	/**
    	 * Default 'notifyUser' event.
    	 */
    	String NOTIFY_USER_EVENT = "notifyUserEvent";
    	String IMPORT_CATEGORY_EVENT = "importCategoryEvent";
    	String EXPORT_CATEGORY_EVENT = "exportCategoryEvent";
    	String IMPORT_PRODUCT_EVENT = "importProductEvent";
    	String EXPORT_PRODUCT_EVENT = "exportProductEvent";
    	String IMPORT_ITEM_LIST_EVENT = "importItemListEvent";
    	String EXPORT_ITEM_LIST_EVENT = "exportItemListEvent";
    	String IMPORT_SHOPPING_LIST_EVENT = "importShoppingListEvent";
    	String EXPORT_SHOPPING_LIST_EVENT = "exportShoppingListEvent";
    	String IMPORT_CLIENTE_EVENT = "importClienteEvent";
    	String EXPORT_CLIENTE_EVENT = "exportClienteEvent";
    }
    
}
