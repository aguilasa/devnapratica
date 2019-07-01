package br.com.senior.furb.basico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.senior.furb.basico.BasicoValidator;
import br.com.senior.furb.basico.*;

/**
 * Status da persistência
 */
public class PersistStatus {
    
    /**
     * Processado
     */
    public Boolean processed;
    
    public PersistStatus() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public PersistStatus(Boolean processed) {
        this.processed = processed;
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
        if (processed != null) {
            ret = 31 * ret + processed.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersistStatus)) {
            return false;
        }
        PersistStatus other = (PersistStatus) obj;
        if ((processed == null) != (other.processed == null)) {
            return false;
        }
        if ((processed != null) && !processed.equals(other.processed)) {
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
    	sb.append("processed=").append(processed == null ? "null" : processed);
    	sb.append(']');
    }
    
}
