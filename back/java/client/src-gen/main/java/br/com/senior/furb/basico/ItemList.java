package br.com.senior.furb.basico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import br.com.senior.messaging.model.EntityDescription;
import br.com.senior.messaging.model.EntityId;

/**
 * Item da lista
 */
@EntityDescription
public class ItemList {
    
    public static class Id {
    	
        public String id;
        
        public Id() {
        }
        
        public Id(String itemListId) {
            this.id = itemListId;
        }
        
        public String getItemListId() {
            return id;
        }
        
        public String getId() {
            return id;
        }
        
    	public void normalize(Map<String, Object> headers) {
    		BasicoNormalizer.normalize(this, headers);
    	}
    	
    }
    
    public static class PagedResults {
    	public Long totalPages;
    	public Long totalElements;
    	
        public List<ItemList> contents;
        
        public PagedResults() {
        }
        
        public PagedResults(List<ItemList> contents) {
            this.contents = contents;
        }
        
        public PagedResults(List<ItemList> contents, Long totalPages, Long totalElements) {
            this.contents = contents;
            this.totalPages = totalPages;
            this.totalElements = totalElements;
        }
    }
    
    public static class PageRequest {
        public Long offset;
        public Long size;
        public boolean translations;
        public String orderBy;
        public String filter;
        public List<String> displayFields;
        public boolean useCustomFilter;
        
        public PageRequest() {
        }
        
        public PageRequest(Long offset, Long size) {
            this(offset, size, null, null);
        }
        
        public PageRequest(Long offset, Long size, String orderBy) {
            this(offset, size, orderBy, null);
        }
        
        public PageRequest(Long offset, Long size, String orderBy, String filter) {
            this(offset, size, orderBy, filter, null);
       	}
       	
        public PageRequest(Long offset, Long size, String orderBy, String filter, List<String> displayFields) {
            this(offset, size, orderBy, filter, displayFields, false);
       	}
        
        public PageRequest(Long offset, Long size, String orderBy, String filter, List<String> displayFields, boolean useCustomFilter) {
        	this.offset = offset;
        	this.size = size;
        	this.orderBy = orderBy;
        	this.filter = filter;
        	this.displayFields = displayFields;
        	this.useCustomFilter = useCustomFilter;
        }
    }

    @EntityId
    /**
     * Código
     */
    public String id;
    /**
     * Produto
     */
    public Product product;
    /**
     * Quantidade
     */
    public Double quantity;
    /**
     * Preço
     */
    public Double price;
    /**
     * Checado
     */
    public Boolean checked;
    /**
     * Observação
     */
    public String note;
    
    public ItemList() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public ItemList(String id, Product product, Double quantity, Double price, Boolean checked, String note) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.checked = checked;
        this.note = note;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public ItemList(Product product, Double quantity, Double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
    
    public void normalize(Map<String, Object> headers) {
    	BasicoNormalizer.normalize(this, headers);
    }
    
    public void validate() {
    	validate(true);
    }
    
    public void validate(boolean required) {
    	validate(null, true);
    }
    
    public void validate(Map<String, Object> headers, boolean required) {
    	validate(headers, required, new ArrayList<>());
    }
    
    void validate(Map<String, Object> headers, boolean required, List<Object> validated) {
    	BasicoValidator.validate(this, headers, required, validated);
    }
    @Override
    public int hashCode() {
        int ret = 1;
        if (id != null) {
            ret = 31 * ret + id.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemList)) {
            return false;
        }
        ItemList other = (ItemList) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	toString(sb, new ArrayList<>());
    	return sb.toString();
    }
    
    void toString(StringBuilder sb, List<Object> appended) {
    	sb.append(getClass().getSimpleName()).append(" [");
    	if (appended.contains(this)) {
    		sb.append("<Previously appended object>").append(']');
    		return;
    	}
    	appended.add(this);
    	sb.append("id=").append(id == null ? "null" : id).append(", ");
    	sb.append("product=<");
    	if (product == null) {
    		sb.append("null");
    	} else {
    		product.toString(sb, appended);
    	}
    	sb.append('>').append(", ");
    	sb.append("quantity=").append(quantity == null ? "null" : quantity).append(", ");
    	sb.append("price=").append(price == null ? "null" : price).append(", ");
    	sb.append("checked=").append(checked == null ? "null" : checked).append(", ");
    	sb.append("note=").append(note == null ? "null" : note);
    	sb.append(']');
    }
    
}
