/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.furb.basico;

import br.com.senior.messaging.model.*;

@SubscriptionDescription(domain="furb", service="basico", event="importItemListEvent")
public interface ImportItemListEvent extends MessageHandler {
    public void importItemListEvent(ImportItemListEventPayload payload);
    
}
