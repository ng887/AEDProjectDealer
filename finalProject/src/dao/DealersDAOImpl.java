package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import finalProject01.dto.Dealer;

public class DealersDAOImpl implements DealersDAO {

	private HashMap<String, Dealer> dealers;
	private List<String> dealerNameList = new ArrayList<String>();
	//private List<Dealer> dealers;
	private String[] dealerColumns;

	public DealersDAOImpl(String fileName) {
		dealers = new  HashMap<String, Dealer> ();
		new DealersParser().ReadFileHelper(new File(fileName));
	}

	@Override
	public void readDealers() {
		Dealer dealer = new Dealer();
		dealer.setId(dealerColumns[0]);
		dealer.setName(dealerColumns[1]);
		dealer.setUrl(dealerColumns[2]);
		addDealer(dealer);
	}

	private void addDealer(Dealer dealer) {
		if (!dealers.containsKey(dealer.getName())) {
			dealers.put(dealer.getName(), dealer);
			dealerNameList.add(dealerColumns[1]);
		}
	}


	/*@Override
	public HashMap<String, Dealer> getDealers() {
		return dealers;
	}*/

	@Override
	public List<String> getDealerNameList(){
		return dealerNameList;
	}



	@Override
	public String getDealerIDByName(String name) {
		if (dealers.containsKey(name)) {
			Dealer dealer = dealers.get(name);
			return dealer.getId();
		}
		return null;

	}


	class DealersParser extends ReadFile {


		@Override
		public void ReadFileLine(String line) {
			dealerColumns = line.split("\\|");
			readDealers();

			/*dealers.put(dealer.getName(), dealer);
			dealerNameList.add(dealerColumns[1]);*/

		}

	}

}

