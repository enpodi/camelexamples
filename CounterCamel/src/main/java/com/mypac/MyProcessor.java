package com.mypac;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;

public class MyProcessor implements Processor {
	  ProducerTemplate producer;

	  public void setProducer(ProducerTemplate producer) {
	    this.producer = producer;
	  }



	@Override
	public void process(Exchange exchange) throws Exception {
		// some loop for each message 
//	    for (String template in templates) {
//	       // lets send a new exchange to the producers default destination
//	       // being called back so we can customize the message
//	       producer.send(new Processor() {
//	          public void process(Exchange outExchange) {
//	              outExchange.getIn().setBody("This is the body"); 
//	              // set some headers too?
//	          }
//	       });
//	    }
		
	}
	
}
