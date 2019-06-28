package br.com.senior.furb.basico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import br.com.senior.messaging.model.EntityDescription;
import br.com.senior.messaging.model.EntityId;

/**
 * Entidade que representa o cliente
 */
@EntityDescription
public class Cliente {
    
    public static class Id {
    	
        public String id;
        
        public Id() {
        }
        
        public Id(String clienteId) {
            this.id = clienteId;
        }
        
        public String getClienteId() {
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
    	
        public List<Cliente> contents;
        
        public PagedResults() {
        }
        
        public PagedResults(List<Cliente> contents) {
            this.contents = contents;
        }
        
        public PagedResults(List<Cliente> contents, Long totalPages, Long totalElements) {
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
     * Chave primaria
     */
    public String id;
    /**
     * Nome do cliente
     */
    public String nome;
    /**
     * Data de nascimento
     */
    public java.time.LocalDate dataNascimento;
    /**
     * Tem credito habilitado
     */
    public Boolean creditoHabilitado = false;
    /**
     * CPF do cliente
     */
    public String cpf;
    /**
     * id da foto
     */
    public String idFoto;
    
    public Cliente() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public Cliente(String id, String nome, java.time.LocalDate dataNascimento, Boolean creditoHabilitado, String cpf, String idFoto) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.creditoHabilitado = creditoHabilitado != null ? creditoHabilitado : false;
        this.cpf = cpf;
        this.idFoto = idFoto;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public Cliente(String nome, java.time.LocalDate dataNascimento, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
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
        if (!(obj instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) obj;
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
    	sb.append("nome=").append(nome == null ? "null" : nome).append(", ");
    	sb.append("dataNascimento=").append(dataNascimento == null ? "null" : dataNascimento).append(", ");
    	sb.append("creditoHabilitado=").append(creditoHabilitado == null ? "null" : creditoHabilitado).append(", ");
    	sb.append("cpf=").append(cpf == null ? "null" : cpf).append(", ");
    	sb.append("idFoto=").append(idFoto == null ? "null" : idFoto);
    	sb.append(']');
    }
    
}
