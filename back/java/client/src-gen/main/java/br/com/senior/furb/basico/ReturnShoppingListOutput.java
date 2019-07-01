package br.com.senior.furb.basico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.senior.furb.basico.BasicoValidator;
import br.com.senior.furb.basico.*;

public class ReturnShoppingListOutput {
    
    /**
     * Lista de compras
     */
    public ShoppingList shoppingList;
    
    public ReturnShoppingListOutput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public ReturnShoppingListOutput(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
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
        if (shoppingList != null) {
            ret = 31 * ret + shoppingList.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReturnShoppingListOutput)) {
            return false;
        }
        ReturnShoppingListOutput other = (ReturnShoppingListOutput) obj;
        if ((shoppingList == null) != (other.shoppingList == null)) {
            return false;
        }
        if ((shoppingList != null) && !shoppingList.equals(other.shoppingList)) {
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
    	sb.append("shoppingList=<");
    	if (shoppingList == null) {
    		sb.append("null");
    	} else {
    		shoppingList.toString(sb, appended);
    	}
    	sb.append('>');
    	sb.append(']');
    }
    
}
