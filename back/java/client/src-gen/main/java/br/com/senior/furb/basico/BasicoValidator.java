/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.senior.messaging.Message;

/**
 * Validators for payloads accepted/produced by endpoints in basico.
 */
public class BasicoValidator {
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.Category toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Category toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Category toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.Category toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (headers != null) {
    		String entityId = headers.containsKey(Message.ENTITY_ID_HEADER) ? headers.get(Message.ENTITY_ID_HEADER).toString() : null;
    		if (entityId != null && toValidate != null && toValidate.id != null && !toValidate.id.toString().equals(entityId)) {
    			throw new IllegalArgumentException("Payload id '" + toValidate.id + "' differs from header id '" + entityId + "'.");
    		}
    	}
    	if (required) {
    		if (toValidate.description == null) {
    			throw new IllegalArgumentException("description is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.Product toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Product toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Product toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.Product toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (headers != null) {
    		String entityId = headers.containsKey(Message.ENTITY_ID_HEADER) ? headers.get(Message.ENTITY_ID_HEADER).toString() : null;
    		if (entityId != null && toValidate != null && toValidate.id != null && !toValidate.id.toString().equals(entityId)) {
    			throw new IllegalArgumentException("Payload id '" + toValidate.id + "' differs from header id '" + entityId + "'.");
    		}
    	}
    	if (required) {
    		if (toValidate.description == null) {
    			throw new IllegalArgumentException("description is required");
    		}
    	}
    	if (required) {
    		if (toValidate.unit == null) {
    			throw new IllegalArgumentException("unit is required");
    		}
    	}
    	if (required) {
    		if (toValidate.category == null) {
    			throw new IllegalArgumentException("category is required");
    		}
    		if (toValidate.category.id == null) {
    			throw new IllegalArgumentException("category.id is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ItemList toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ItemList toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ItemList toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ItemList toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (headers != null) {
    		String entityId = headers.containsKey(Message.ENTITY_ID_HEADER) ? headers.get(Message.ENTITY_ID_HEADER).toString() : null;
    		if (entityId != null && toValidate != null && toValidate.id != null && !toValidate.id.toString().equals(entityId)) {
    			throw new IllegalArgumentException("Payload id '" + toValidate.id + "' differs from header id '" + entityId + "'.");
    		}
    	}
    	if (required) {
    		if (toValidate.product == null) {
    			throw new IllegalArgumentException("product is required");
    		}
    		if (toValidate.product.id == null) {
    			throw new IllegalArgumentException("product.id is required");
    		}
    	}
    	if (required) {
    		if (toValidate.quantity == null) {
    			throw new IllegalArgumentException("quantity is required");
    		}
    	}
    	if (required) {
    		if (toValidate.price == null) {
    			throw new IllegalArgumentException("price is required");
    		}
    	}
    	if (required) {
    		if (toValidate.checked == null) {
    			throw new IllegalArgumentException("checked is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ShoppingList toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ShoppingList toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ShoppingList toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ShoppingList toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (headers != null) {
    		String entityId = headers.containsKey(Message.ENTITY_ID_HEADER) ? headers.get(Message.ENTITY_ID_HEADER).toString() : null;
    		if (entityId != null && toValidate != null && toValidate.id != null && !toValidate.id.toString().equals(entityId)) {
    			throw new IllegalArgumentException("Payload id '" + toValidate.id + "' differs from header id '" + entityId + "'.");
    		}
    	}
    	if (required) {
    		if (toValidate.description == null) {
    			throw new IllegalArgumentException("description is required");
    		}
    	}
    	if (required) {
    		if (toValidate.items == null || toValidate.items.isEmpty()) {
    			throw new IllegalArgumentException("items is required, at least one value must be present");
    		}
    		for (ItemList it : toValidate.items) {
    			if (it.id == null) {
    				throw new IllegalArgumentException("items[].id is required");
    			}
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.Cliente toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Cliente toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Cliente toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.Cliente toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (headers != null) {
    		String entityId = headers.containsKey(Message.ENTITY_ID_HEADER) ? headers.get(Message.ENTITY_ID_HEADER).toString() : null;
    		if (entityId != null && toValidate != null && toValidate.id != null && !toValidate.id.toString().equals(entityId)) {
    			throw new IllegalArgumentException("Payload id '" + toValidate.id + "' differs from header id '" + entityId + "'.");
    		}
    	}
    	if (required) {
    		if (toValidate.nome == null) {
    			throw new IllegalArgumentException("nome is required");
    		}
    	}
    	if (required) {
    		if (toValidate.dataNascimento == null) {
    			throw new IllegalArgumentException("dataNascimento is required");
    		}
    	}
    	if (required) {
    		if (toValidate.cpf == null) {
    			throw new IllegalArgumentException("cpf is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ServiceStartedPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ServiceStartedPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ServiceStartedPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ServiceStartedPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.domain == null) {
    			throw new IllegalArgumentException("domain is required");
    		}
    	}
    	if (required) {
    		if (toValidate.service == null) {
    			throw new IllegalArgumentException("service is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.NotifyUserEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.NotifyUserEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.NotifyUserEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.NotifyUserEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.notificationKind == null) {
    			throw new IllegalArgumentException("notificationKind is required");
    		}
    	}
    	if (required) {
    		if (toValidate.notificationPriority == null) {
    			throw new IllegalArgumentException("notificationPriority is required");
    		}
    	}
    	if (required) {
    		if (toValidate.notificationSubject == null) {
    			throw new IllegalArgumentException("notificationSubject is required");
    		}
    	}
    	if (required) {
    		if (toValidate.notificationContent == null) {
    			throw new IllegalArgumentException("notificationContent is required");
    		}
    	}
    	if (required) {
    		if (toValidate.sourceDomain == null) {
    			throw new IllegalArgumentException("sourceDomain is required");
    		}
    	}
    	if (required) {
    		if (toValidate.sourceService == null) {
    			throw new IllegalArgumentException("sourceService is required");
    		}
    	}
    	if (required) {
    		if (toValidate.destinationUser == null) {
    			throw new IllegalArgumentException("destinationUser is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.EmailNotifyUserEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.EmailNotifyUserEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.EmailNotifyUserEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.EmailNotifyUserEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.notificationKind == null) {
    			throw new IllegalArgumentException("notificationKind is required");
    		}
    	}
    	if (required) {
    		if (toValidate.notificationPriority == null) {
    			throw new IllegalArgumentException("notificationPriority is required");
    		}
    	}
    	if (required) {
    		if (toValidate.notificationSubject == null) {
    			throw new IllegalArgumentException("notificationSubject is required");
    		}
    	}
    	if (required) {
    		if (toValidate.notificationContent == null) {
    			throw new IllegalArgumentException("notificationContent is required");
    		}
    	}
    	if (required) {
    		if (toValidate.sourceDomain == null) {
    			throw new IllegalArgumentException("sourceDomain is required");
    		}
    	}
    	if (required) {
    		if (toValidate.sourceService == null) {
    			throw new IllegalArgumentException("sourceService is required");
    		}
    	}
    	if (required) {
    		if (toValidate.destinationUser == null) {
    			throw new IllegalArgumentException("destinationUser is required");
    		}
    	}
    	if (required) {
    		if (toValidate.from == null) {
    			throw new IllegalArgumentException("from is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.PushNotifyUserEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.PushNotifyUserEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.PushNotifyUserEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.PushNotifyUserEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.notificationKind == null) {
    			throw new IllegalArgumentException("notificationKind is required");
    		}
    	}
    	if (required) {
    		if (toValidate.notificationPriority == null) {
    			throw new IllegalArgumentException("notificationPriority is required");
    		}
    	}
    	if (required) {
    		if (toValidate.notificationSubject == null) {
    			throw new IllegalArgumentException("notificationSubject is required");
    		}
    	}
    	if (required) {
    		if (toValidate.notificationContent == null) {
    			throw new IllegalArgumentException("notificationContent is required");
    		}
    	}
    	if (required) {
    		if (toValidate.sourceDomain == null) {
    			throw new IllegalArgumentException("sourceDomain is required");
    		}
    	}
    	if (required) {
    		if (toValidate.sourceService == null) {
    			throw new IllegalArgumentException("sourceService is required");
    		}
    	}
    	if (required) {
    		if (toValidate.destinationUser == null) {
    			throw new IllegalArgumentException("destinationUser is required");
    		}
    	}
    	if (required) {
    		if (toValidate.applicationId == null) {
    			throw new IllegalArgumentException("applicationId is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.GetMetadataInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.GetMetadataInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.GetMetadataInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.GetMetadataInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.GetMetadataOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.GetMetadataOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.GetMetadataOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.GetMetadataOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.metadata == null) {
    			throw new IllegalArgumentException("metadata is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.BlobReference toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.BlobReference toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.BlobReference toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.BlobReference toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.targetObjectId == null) {
    			throw new IllegalArgumentException("targetObjectId is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.BasicErrorPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.BasicErrorPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.BasicErrorPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.BasicErrorPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportError toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportError toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportError toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportError toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.errorType == null) {
    			throw new IllegalArgumentException("errorType is required");
    		}
    	}
    	if (required) {
    		if (toValidate.lineNumber == null) {
    			throw new IllegalArgumentException("lineNumber is required");
    		}
    	}
    	if (required) {
    		if (toValidate.bean == null) {
    			throw new IllegalArgumentException("bean is required");
    		}
    	}
    	if (required) {
    		if (toValidate.message == null) {
    			throw new IllegalArgumentException("message is required");
    		}
    	}
    	if (required) {
    		if (toValidate.exceptionClass == null) {
    			throw new IllegalArgumentException("exceptionClass is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.Fielddto toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Fielddto toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Fielddto toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.Fielddto toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.id == null) {
    			throw new IllegalArgumentException("id is required");
    		}
    	}
    	if (required) {
    		if (toValidate.name == null) {
    			throw new IllegalArgumentException("name is required");
    		}
    	}
    	if (required) {
    		if (toValidate.fieldType == null) {
    			throw new IllegalArgumentException("fieldType is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.Hookdto toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Hookdto toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Hookdto toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.Hookdto toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.hookFunction == null) {
    			throw new IllegalArgumentException("hookFunction is required");
    		}
    	}
    	if (required) {
    		if (toValidate.script == null) {
    			throw new IllegalArgumentException("script is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.Layoutdto toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Layoutdto toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Layoutdto toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.Layoutdto toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.id == null) {
    			throw new IllegalArgumentException("id is required");
    		}
    	}
    	if (required) {
    		if (toValidate.description == null) {
    			throw new IllegalArgumentException("description is required");
    		}
    	}
    	if (required) {
    		if (toValidate.fileFormat == null) {
    			throw new IllegalArgumentException("fileFormat is required");
    		}
    	}
    	if (required) {
    		if (toValidate.errorStrategy == null) {
    			throw new IllegalArgumentException("errorStrategy is required");
    		}
    	}
    	if (required) {
    		if (toValidate.skipLines == null) {
    			throw new IllegalArgumentException("skipLines is required");
    		}
    	}
    	if (required) {
    		if (toValidate.fields == null || toValidate.fields.isEmpty()) {
    			throw new IllegalArgumentException("fields is required, at least one value must be present");
    		}
    		for (Fielddto it : toValidate.fields) {
    			it.validate(null, required, validated);
    		}
    	}
    	if (toValidate.hooks != null) {
    		for (Hookdto it : toValidate.hooks) {
    			it.validate(null, true, validated);
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportReport toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportReport toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportReport toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportReport toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.id == null) {
    			throw new IllegalArgumentException("id is required");
    		}
    	}
    	if (required) {
    		if (toValidate.startTime == null) {
    			throw new IllegalArgumentException("startTime is required");
    		}
    	}
    	if (required) {
    		if (toValidate.endTime == null) {
    			throw new IllegalArgumentException("endTime is required");
    		}
    	}
    	if (required) {
    		if (toValidate.uri == null) {
    			throw new IllegalArgumentException("uri is required");
    		}
    	}
    	if (required) {
    		if (toValidate.beanClass == null) {
    			throw new IllegalArgumentException("beanClass is required");
    		}
    	}
    	if (required) {
    		if (toValidate.serviceClass == null) {
    			throw new IllegalArgumentException("serviceClass is required");
    		}
    	}
    	if (required) {
    		if (toValidate.layout == null) {
    			throw new IllegalArgumentException("layout is required");
    		}
    		toValidate.layout.validate(null, required, validated);
    	}
    	if (required) {
    		if (toValidate.sucessCount == null) {
    			throw new IllegalArgumentException("sucessCount is required");
    		}
    	}
    	if (required) {
    		if (toValidate.errorsCount == null) {
    			throw new IllegalArgumentException("errorsCount is required");
    		}
    	}
    	if (required) {
    		if (toValidate.filteredCount == null) {
    			throw new IllegalArgumentException("filteredCount is required");
    		}
    	}
    	if (required) {
    		if (toValidate.skippedCount == null) {
    			throw new IllegalArgumentException("skippedCount is required");
    		}
    	}
    	if (toValidate.importErrors != null) {
    		for (ImportError it : toValidate.importErrors) {
    			it.validate(null, true, validated);
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportEventStatus toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportEventStatus toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportEventStatus toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportEventStatus toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.importerId == null) {
    			throw new IllegalArgumentException("importerId is required");
    		}
    	}
    	if (required) {
    		if (toValidate.eventType == null) {
    			throw new IllegalArgumentException("eventType is required");
    		}
    	}
    	if (required) {
    		if (toValidate.recordCount == null) {
    			throw new IllegalArgumentException("recordCount is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportEventStatus toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportEventStatus toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportEventStatus toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportEventStatus toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.importerId == null) {
    			throw new IllegalArgumentException("importerId is required");
    		}
    	}
    	if (required) {
    		if (toValidate.eventType == null) {
    			throw new IllegalArgumentException("eventType is required");
    		}
    	}
    	if (required) {
    		if (toValidate.status == null) {
    			throw new IllegalArgumentException("status is required");
    		}
    	}
    	if (required) {
    		if (toValidate.recordCount == null) {
    			throw new IllegalArgumentException("recordCount is required");
    		}
    	}
    	if (required) {
    		if (toValidate.importReport != null) {
    			toValidate.importReport.validate(null, true, validated);
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportConfig toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportConfig toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportConfig toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportConfig toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.uri == null) {
    			throw new IllegalArgumentException("uri is required");
    		}
    	}
    	if (required) {
    		if (toValidate.layout == null) {
    			throw new IllegalArgumentException("layout is required");
    		}
    		toValidate.layout.validate(null, required, validated);
    	}
    	if (required) {
    		if (toValidate.async == null) {
    			throw new IllegalArgumentException("async is required");
    		}
    	}
    	if (required) {
    		if (toValidate.errorStrategy == null) {
    			throw new IllegalArgumentException("errorStrategy is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportConfig toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportConfig toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportConfig toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportConfig toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.uri == null) {
    			throw new IllegalArgumentException("uri is required");
    		}
    	}
    	if (required) {
    		if (toValidate.layout == null) {
    			throw new IllegalArgumentException("layout is required");
    		}
    		toValidate.layout.validate(null, required, validated);
    	}
    	if (required) {
    		if (toValidate.async == null) {
    			throw new IllegalArgumentException("async is required");
    		}
    	}
    	if (required) {
    		if (toValidate.batchSize == null) {
    			throw new IllegalArgumentException("batchSize is required");
    		}
    	}
    	if (required) {
    		if (toValidate.errorStrategy == null) {
    			throw new IllegalArgumentException("errorStrategy is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportCategoryInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportCategoryInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportCategoryInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportCategoryInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.config == null) {
    			throw new IllegalArgumentException("config is required");
    		}
    		toValidate.config.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportCategoryOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportCategoryOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportCategoryOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportCategoryOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.importJobId == null) {
    			throw new IllegalArgumentException("importJobId is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportCategoryInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportCategoryInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportCategoryInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportCategoryInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.config == null) {
    			throw new IllegalArgumentException("config is required");
    		}
    		toValidate.config.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportCategoryOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportCategoryOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportCategoryOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportCategoryOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.exportJobId == null) {
    			throw new IllegalArgumentException("exportJobId is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportCategoryEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportCategoryEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportCategoryEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportCategoryEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.eventpl == null) {
    			throw new IllegalArgumentException("eventpl is required");
    		}
    		toValidate.eventpl.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportCategoryEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportCategoryEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportCategoryEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportCategoryEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.eventpl == null) {
    			throw new IllegalArgumentException("eventpl is required");
    		}
    		toValidate.eventpl.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportProductInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportProductInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportProductInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportProductInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.config == null) {
    			throw new IllegalArgumentException("config is required");
    		}
    		toValidate.config.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportProductOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportProductOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportProductOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportProductOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.importJobId == null) {
    			throw new IllegalArgumentException("importJobId is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportProductInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportProductInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportProductInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportProductInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.config == null) {
    			throw new IllegalArgumentException("config is required");
    		}
    		toValidate.config.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportProductOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportProductOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportProductOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportProductOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.exportJobId == null) {
    			throw new IllegalArgumentException("exportJobId is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportProductEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportProductEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportProductEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportProductEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.eventpl == null) {
    			throw new IllegalArgumentException("eventpl is required");
    		}
    		toValidate.eventpl.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportProductEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportProductEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportProductEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportProductEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.eventpl == null) {
    			throw new IllegalArgumentException("eventpl is required");
    		}
    		toValidate.eventpl.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportItemListInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportItemListInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportItemListInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportItemListInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.config == null) {
    			throw new IllegalArgumentException("config is required");
    		}
    		toValidate.config.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportItemListOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportItemListOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportItemListOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportItemListOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.importJobId == null) {
    			throw new IllegalArgumentException("importJobId is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportItemListInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportItemListInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportItemListInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportItemListInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.config == null) {
    			throw new IllegalArgumentException("config is required");
    		}
    		toValidate.config.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportItemListOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportItemListOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportItemListOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportItemListOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.exportJobId == null) {
    			throw new IllegalArgumentException("exportJobId is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportItemListEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportItemListEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportItemListEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportItemListEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.eventpl == null) {
    			throw new IllegalArgumentException("eventpl is required");
    		}
    		toValidate.eventpl.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportItemListEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportItemListEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportItemListEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportItemListEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.eventpl == null) {
    			throw new IllegalArgumentException("eventpl is required");
    		}
    		toValidate.eventpl.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportShoppingListInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportShoppingListInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportShoppingListInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportShoppingListInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.config == null) {
    			throw new IllegalArgumentException("config is required");
    		}
    		toValidate.config.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportShoppingListOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportShoppingListOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportShoppingListOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportShoppingListOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.importJobId == null) {
    			throw new IllegalArgumentException("importJobId is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportShoppingListInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportShoppingListInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportShoppingListInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportShoppingListInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.config == null) {
    			throw new IllegalArgumentException("config is required");
    		}
    		toValidate.config.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportShoppingListOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportShoppingListOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportShoppingListOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportShoppingListOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.exportJobId == null) {
    			throw new IllegalArgumentException("exportJobId is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportShoppingListEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportShoppingListEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportShoppingListEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportShoppingListEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.eventpl == null) {
    			throw new IllegalArgumentException("eventpl is required");
    		}
    		toValidate.eventpl.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportShoppingListEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportShoppingListEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportShoppingListEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportShoppingListEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.eventpl == null) {
    			throw new IllegalArgumentException("eventpl is required");
    		}
    		toValidate.eventpl.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportClienteInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportClienteInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportClienteInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportClienteInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.config == null) {
    			throw new IllegalArgumentException("config is required");
    		}
    		toValidate.config.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportClienteOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportClienteOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportClienteOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportClienteOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.importJobId == null) {
    			throw new IllegalArgumentException("importJobId is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportClienteInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportClienteInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportClienteInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportClienteInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.config == null) {
    			throw new IllegalArgumentException("config is required");
    		}
    		toValidate.config.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportClienteOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportClienteOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportClienteOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportClienteOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.exportJobId == null) {
    			throw new IllegalArgumentException("exportJobId is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ImportClienteEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportClienteEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ImportClienteEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ImportClienteEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.eventpl == null) {
    			throw new IllegalArgumentException("eventpl is required");
    		}
    		toValidate.eventpl.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.ExportClienteEventPayload toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportClienteEventPayload toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.ExportClienteEventPayload toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.ExportClienteEventPayload toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.eventpl == null) {
    			throw new IllegalArgumentException("eventpl is required");
    		}
    		toValidate.eventpl.validate(null, required, validated);
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.Dependency toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Dependency toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.Dependency toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.Dependency toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.domain == null) {
    			throw new IllegalArgumentException("domain is required");
    		}
    	}
    	if (required) {
    		if (toValidate.service == null) {
    			throw new IllegalArgumentException("service is required");
    		}
    	}
    	if (required) {
    		if (toValidate.version == null) {
    			throw new IllegalArgumentException("version is required");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.GetDependenciesOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.GetDependenciesOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.GetDependenciesOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.GetDependenciesOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.dependencies == null || toValidate.dependencies.isEmpty()) {
    			throw new IllegalArgumentException("dependencies is required, at least one value must be present");
    		}
    		for (Dependency it : toValidate.dependencies) {
    			it.validate(null, required, validated);
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkCategoryInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkCategoryInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkCategoryInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkCategoryInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.entities == null || toValidate.entities.isEmpty()) {
    			throw new IllegalArgumentException("entities is required, at least one value must be present");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkCategoryOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkCategoryOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkCategoryOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkCategoryOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkProductInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkProductInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkProductInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkProductInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.entities == null || toValidate.entities.isEmpty()) {
    			throw new IllegalArgumentException("entities is required, at least one value must be present");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkProductOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkProductOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkProductOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkProductOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkItemListInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkItemListInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkItemListInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkItemListInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.entities == null || toValidate.entities.isEmpty()) {
    			throw new IllegalArgumentException("entities is required, at least one value must be present");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkItemListOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkItemListOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkItemListOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkItemListOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkShoppingListInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkShoppingListInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkShoppingListInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkShoppingListInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.entities == null || toValidate.entities.isEmpty()) {
    			throw new IllegalArgumentException("entities is required, at least one value must be present");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkShoppingListOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkShoppingListOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkShoppingListOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkShoppingListOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkClienteInput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkClienteInput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkClienteInput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkClienteInput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    	if (required) {
    		if (toValidate.entities == null || toValidate.entities.isEmpty()) {
    			throw new IllegalArgumentException("entities is required, at least one value must be present");
    		}
    	}
    }
    /**
     * Validates the payload for required fields and valid values.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkClienteOutput toValidate) {
    	validate(toValidate, true);
    }
    
    /**
     * Validates the payload for valid values and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkClienteOutput toValidate, boolean required) {
    	validate(toValidate, null, true);
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkClienteOutput toValidate, Map<String, Object> headers, boolean required) {
    	validate(toValidate, headers, required, new ArrayList<>());
    }
    
    /**
     * Validates the payload for valid values using message headers and checks for required fields if required argument is true ignoring if already validated.
     */
    public static void validate(br.com.senior.furb.basico.CreateBulkClienteOutput toValidate, Map<String, Object> headers, boolean required, List<Object> validated) {
    	if (validated.contains(toValidate)) {
    		return;
    	}
    	validated.add(toValidate);
    	
    }
}
