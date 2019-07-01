package br.com.senior.furb.basico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.senior.furb.basico.BasicoValidator;
import br.com.senior.furb.basico.*;

/**
 * Item da lista
 */
public class ItemListDto {
    
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
    
    public ItemListDto() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public ItemListDto(String id, Product product, Double quantity, Double price, Boolean checked, String note) {
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
    public ItemListDto(Product product, Double quantity, Double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
    
    public void validate() {
        validate(true);
    }
    
    public void validate(boolean required) {
        validate(null, required);
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
        if (product != null) {
            ret = 31 * ret + product.hashCode();
        }
        if (quantity != null) {
            ret = 31 * ret + quantity.hashCode();
        }
        if (price != null) {
            ret = 31 * ret + price.hashCode();
        }
        if (checked != null) {
            ret = 31 * ret + checked.hashCode();
        }
        if (note != null) {
            ret = 31 * ret + note.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemListDto)) {
            return false;
        }
        ItemListDto other = (ItemListDto) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        if ((product == null) != (other.product == null)) {
            return false;
        }
        if ((product != null) && !product.equals(other.product)) {
            return false;
        }
        if ((quantity == null) != (other.quantity == null)) {
            return false;
        }
        if ((quantity != null) && !quantity.equals(other.quantity)) {
            return false;
        }
        if ((price == null) != (other.price == null)) {
            return false;
        }
        if ((price != null) && !price.equals(other.price)) {
            return false;
        }
        if ((checked == null) != (other.checked == null)) {
            return false;
        }
        if ((checked != null) && !checked.equals(other.checked)) {
            return false;
        }
        if ((note == null) != (other.note == null)) {
            return false;
        }
        if ((note != null) && !note.equals(other.note)) {
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
