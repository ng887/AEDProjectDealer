package finalProject01.service;

import java.util.List;

import finalProject01.dao.DealersDAO;
import finalProject01.dao.DealersDAOImpl;


public class DealerManagerImpl implements DealerManager {

	DealersDAO dealerDAO = new DealersDAOImpl();

	//@Autowired
	//DealersDAO dealerDAO;

	/*@Override
	public List<Dealer> getAllDealersInSystem() {
		// TODO Auto-generated method stub
		return null;
	}
	 */

	@Override
	public List<String> getAllDealerNamesInSystem() {
		return dealerDAO.getDealerNameList();
	}

	@Override
	public String getDealerIDByNameInSystem(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	

	/*@Override
	public HashMap<String, Dealer> getDealersInSystem() {
		return dealerDAO.getDealers();
	}*/

}
