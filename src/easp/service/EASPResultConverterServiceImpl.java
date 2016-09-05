package easp.service;

import java.sql.ResultSet;

import easp.model.EASPCustomer;
import easp.model.EASPInvoice;
import easp.serviceAPI.EASPResultConverterService;

public class EASPResultConverterServiceImpl implements EASPResultConverterService {

	@Override
	public EASPCustomer[] convertToCustomers(ResultSet r) {
		EASPCustomer[] result = null;
		return result;
	}

	@Override
	public EASPInvoice[] convertToInvoices(ResultSet r) {
		// TODO Auto-generated method stub
		return null;
	}

}
