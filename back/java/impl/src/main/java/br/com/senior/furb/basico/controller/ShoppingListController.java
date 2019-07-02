package br.com.senior.furb.basico.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senior.furb.basico.CategoryDto;
import br.com.senior.furb.basico.CategoryEntity;
import br.com.senior.furb.basico.ItemListDto;
import br.com.senior.furb.basico.ItemListEntity;
import br.com.senior.furb.basico.PersistShoppingListInput;
import br.com.senior.furb.basico.PersistShoppingListOutput;
import br.com.senior.furb.basico.ProductDto;
import br.com.senior.furb.basico.ProductEntity;
import br.com.senior.furb.basico.ShoppingListDto;
import br.com.senior.furb.basico.ShoppingListEntity;
import br.com.senior.furb.basico.ShoppingListQueryInput;
import br.com.senior.furb.basico.ShoppingListQueryOutput;
import br.com.senior.furb.basico.repositories.ItemListRepository;
import br.com.senior.furb.basico.repositories.ProductRepository;
import br.com.senior.furb.basico.repositories.ShoppingListRepository;

@Component
public class ShoppingListController extends ControllerBase {

	@Autowired
	private ShoppingListRepository shoppingListRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ItemListRepository itemListRepository;

	public PersistShoppingListOutput persistShoppingList(PersistShoppingListInput request) {
		PersistShoppingListOutput output = new PersistShoppingListOutput();
		ShoppingListEntity entity = persistEntity(request.shoppingList);
		output.shoppingList = toDto(entity);
		shoppingListRepository.deleteListItems();
		return output;
	}

	public ShoppingListQueryOutput shoppingListQuery(ShoppingListQueryInput request) {
		ShoppingListQueryOutput output = new ShoppingListQueryOutput();
		ShoppingListEntity entity = findEntity(UUID.fromString(request.id));
		output.result = toDto(entity);
		return output;
	}

	private ShoppingListEntity persistEntity(ShoppingListDto dto) {
		ShoppingListEntity entity = findEntityFromDto(dto);
		entity.setDescription(dto.description);
		entity.setItems(toEntity(dto.items));
		return shoppingListRepository.saveAndFlush(entity);
	}

	private ShoppingListEntity findEntityFromDto(ShoppingListDto dto) {
		if (!StringUtils.isEmpty(dto.id)) {
			return findEntity(UUID.fromString(dto.id), true);
		}
		ShoppingListEntity entity = new ShoppingListEntity();
		entity.setId(UUID.randomUUID());
		return entity;
	}

	private ShoppingListEntity findEntity(UUID id) {
		return findEntity(id, false);
	}

	private ShoppingListEntity findEntity(UUID id, boolean clear) {
		ShoppingListEntity entity = shoppingListRepository.findOne(id);
		if (entity != null && clear) {
			entity.getItems().clear();
		}
		return entity;
	}

	private ShoppingListDto toDto(ShoppingListEntity entity) {
		ShoppingListDto result = new ShoppingListDto();
		if (entity != null) {
			result.id = entity.getId().toString();
			result.description = entity.getDescription();
			result.items = toDto(entity.getItems());
		}
		return result;
	}

	private List<ItemListDto> toDto(List<ItemListEntity> items) {
		if (items != null && !items.isEmpty()) {
			return items.stream().map(this::toItemListDto).collect(Collectors.toList());
		}
		return new ArrayList<ItemListDto>();
	}

	private List<ItemListEntity> toEntity(List<ItemListDto> items) {
		if (items != null && !items.isEmpty()) {
			return items.stream().map(this::toItemListEntity).collect(Collectors.toList());
		}
		return new ArrayList<ItemListEntity>();
	}

	private ItemListEntity toItemListEntity(ItemListDto dto) {
		ItemListEntity result = new ItemListEntity();
		result.setId(UUID.randomUUID());
		result.setProduct(toEntity(dto.product));
		result.setQuantity(dto.quantity);
		result.setPrice(dto.price);
		result.setChecked(dto.checked != null ? dto.checked : false);
		result.setNote(dto.note);
		return itemListRepository.saveAndFlush(result);
	}

	private ProductEntity toEntity(ProductDto product) {
		return productRepository.findOne(UUID.fromString(product.id));
	}

	private ItemListDto toItemListDto(ItemListEntity entity) {
		ItemListDto result = new ItemListDto();
		result.id = entity.getId().toString();
		result.product = toProductDto(entity.getProduct());
		result.quantity = entity.getQuantity();
		result.price = entity.getPrice();
		result.checked = entity.getChecked();
		result.note = entity.getNote();
		return result;
	}

	private ProductDto toProductDto(ProductEntity entity) {
		ProductDto result = new ProductDto();
		result.id = entity.getId().toString();
		result.description = entity.getDescription();
		result.unit = entity.getUnit();
		result.category = toCategoryDto(entity.getCategory());
		return result;
	}

	private CategoryDto toCategoryDto(CategoryEntity entity) {
		CategoryDto result = new CategoryDto();
		result.id = entity.getId().toString();
		result.description = entity.getDescription();
		return result;
	}

}
