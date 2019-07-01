package br.com.senior.furb.basico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.senior.furb.basico.BasicoValidator;
import br.com.senior.furb.basico.*;

/**
 * Produto
 */
public class ProductDto {
    
    /**
     * Código
     */
    public String id;
    /**
     * Descrição do produto
     */
    public String description;
    /**
     * Unidade de medida
     */
    public Unit unit;
    /**
     * Categoria
     */
    public CategoryDto category;
    
    public ProductDto() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public ProductDto(String id, String description, Unit unit, CategoryDto category) {
        this.id = id;
        this.description = description;
        this.unit = unit;
        this.category = category;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public ProductDto(String description, Unit unit, CategoryDto category) {
        this.description = description;
        this.unit = unit;
        this.category = category;
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
        if (description != null) {
            ret = 31 * ret + description.hashCode();
        }
        if (unit != null) {
            ret = 31 * ret + unit.hashCode();
        }
        if (category != null) {
            ret = 31 * ret + category.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDto)) {
            return false;
        }
        ProductDto other = (ProductDto) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        if ((description == null) != (other.description == null)) {
            return false;
        }
        if ((description != null) && !description.equals(other.description)) {
            return false;
        }
        if ((unit == null) != (other.unit == null)) {
            return false;
        }
        if ((unit != null) && !unit.equals(other.unit)) {
            return false;
        }
        if ((category == null) != (other.category == null)) {
            return false;
        }
        if ((category != null) && !category.equals(other.category)) {
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
    	sb.append("description=").append(description == null ? "null" : description).append(", ");
    	sb.append("unit=").append(unit == null ? "null" : unit).append(", ");
    	sb.append("category=<");
    	if (category == null) {
    		sb.append("null");
    	} else {
    		category.toString(sb, appended);
    	}
    	sb.append('>');
    	sb.append(']');
    }
    
}
