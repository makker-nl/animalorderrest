package nl.vs.fuse.animalorder.beans;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.camel.Message;

public class JpaParameters {

	public static final String JPA_PARS = "CamelJpaParameters";
	public static final String JPA_ID_PAR = "orderId";
	
	public void setOrderId(Exchange exchange, @Header(JPA_ID_PAR)Integer id) {
		Message in = exchange.getIn();
		@SuppressWarnings("unchecked")
		Map <String, Object> parameters = (Map <String, Object>)in.getHeader(JPA_PARS);
		if (parameters == null) {
			parameters = new HashMap<String, Object>();
			in.setHeader(JPA_PARS, parameters);
		}
		parameters.put(JPA_ID_PAR, id);		
	}
}
