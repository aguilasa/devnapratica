package br.com.senior.furb.basico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.senior.furb.basico.BasicoValidator;
import br.com.senior.furb.basico.*;

/**
 * Categoria
 */
public class CategoryDto {
    
    /**
     * Código
     */
    public String id;
    /**
     * Descrição da categoria
     */
    public String description;
    
    public CategoryDto() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public CategoryDto(String id, String description) {
        this.id = id;
        this.description = description;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public CategoryDto(String description) {
        this.description = description;
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
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryDto)) {
            return false;
        }
        CategoryDto other = (CategoryDto) obj;
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
    	sb.append("description=").append(description == null ? "null" : description);
    	sb.append(']');
    }
    
}
