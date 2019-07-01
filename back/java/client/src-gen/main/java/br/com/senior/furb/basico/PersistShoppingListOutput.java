package br.com.senior.furb.basico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.senior.furb.basico.BasicoValidator;
import br.com.senior.furb.basico.*;

public class PersistShoppingListOutput {
    
    /**
     * Status da persistência
     */
    public PersistStatus status;
    
    public PersistShoppingListOutput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public PersistShoppingListOutput(PersistStatus status) {
        this.status = status;
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
        if (status != null) {
            ret = 31 * ret + status.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersistShoppingListOutput)) {
            return false;
        }
        PersistShoppingListOutput other = (PersistShoppingListOutput) obj;
        if ((status == null) != (other.status == null)) {
            return false;
        }
        if ((status != null) && !status.equals(other.status)) {
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
    	sb.append("status=<");
    	if (status == null) {
    		sb.append("null");
    	} else {
    		status.toString(sb, appended);
    	}
    	sb.append('>');
    	sb.append(']');
    }
    
}
