package easp.serviceAPI;

import java.sql.ResultSet;

import easp.model.EASPCustomer;
import easp.model.EASPInvoice;

public interface EASPResultConverterService {

	public EASPCustomer[] convertToCustomers(ResultSet r);
	
	public EASPInvoice[] convertToInvoices(ResultSet r);
	
}
