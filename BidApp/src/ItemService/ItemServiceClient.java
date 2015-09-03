package ItemService;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import android.util.Log;

import com.example.auctionapplicationIntermed.AuctionItem;
import com.example.auctionapplicationIntermed.CrudModel;
import com.example.auctionapplicationIntermed.ItemClientException;
import com.example.auctionapplicationIntermed.ItemNotFoundException;
import com.example.auctionapplicationIntermed.CrudModel.Command;


public class ItemServiceClient implements ItemService {

	static HashMap<Long, AuctionItem> itemlist = new HashMap<>();
	//	static BidServer dbc = new BidServer();



	public void setList(HashMap<Long, AuctionItem> il){
		this.itemlist = il;
	}

	public Collection<AuctionItem> timeCheck (Collection<AuctionItem> items){

		Collection<AuctionItem> newitems = new ArrayList<>();

		for (AuctionItem auctionItem : items) {
			if(auctionItem.getEndDate().after(new Date())){
				newitems.add(auctionItem);
			}
		}

		return newitems;
	}

	public AuctionItem bid(long id, BigDecimal bidIncrease) throws Exception{
		System.out.println("Name of Item Bidded on Is : "+itemlist.get(id).getName());
		if(itemlist.get(id).getEndDate().after(new Date())){
			itemlist.get(id).setBidPrice(itemlist.get(id).getBidPrice().add(bidIncrease));
			//connect to socket
			//send the id , bidincrease
			try(Socket s = new Socket("localhost", 31415)){
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(id);
				oos.writeObject(bidIncrease);
				oos.flush();
			}


		}
		else
			throw new ItemClientException("Can't bid on this time");

		return itemlist.get(id);
	}
	public static void addItem(AuctionItem newitem) throws IOException{
		//dbc.writeToDB(newitem);

		itemlist.put((long) newitem.getItemID(), newitem);
	}
	public static void addItemToList(AuctionItem newitem) throws IOException{


		itemlist.put((long) newitem.getItemID(), newitem);
	} 
	public static  void update(AuctionItem item) throws Exception{
		if(itemlist.get(item.getItemID())!=(null)){
			throw new ItemNotFoundException("No Item with the selected id!?");
		}
		//dbc.updateLine(item);

		itemlist.put((long) item.getItemID(), item);
	}

	public static void delete (Long l) throws IOException, ItemNotFoundException{
		if(itemlist.get(l).equals(null)){
			throw new ItemNotFoundException("No Item with the selected id!?");
		}
		itemlist.remove(l);
		//dbc.deleteLine(l);
	}

	//	public Collection<AuctionItem> search(String query){
	//
	//		String [ ] words = query.split(" ");

	//		Stack <Predicate> P = new Stack<>();
	//		Stack <String> S = new Stack<>();
	//		Collection <AuctionItem> i = new ArrayList<>();
	//
	//		for(String s : words){
	//			if(s.equals("and")){
	//				S.push(s);
	//			}
	//			else if(s.equals("or")){
	//				if(S.isEmpty()){
	//					S.push(s);
	//				}
	//				else if(S.peek().equals("and")){
	//					while(true){
	//						if(S.isEmpty()){
	//							break;
	//						}
	//						else if(S.peek().equals("and")){
	//							S.pop();
	//							if(P.size() >= 2)
	//								P.push(new AndPredicate(P.pop(),P.pop()));
	//						}
	//						else break;
	//					}
	//					S.push(s);
	//				}
	//				else S.push(s);
	//			}
	//			else P.push(new Contain(s));
	//		}
	//		while(true){
	//			if(P.isEmpty()){
	//				break;
	//			}
	//			else if(P.peek().equals("and")){
	//				S.pop();
	//				if(P.size() >= 2){
	//
	//					P.push(new AndPredicate(P.pop(),P.pop()));
	//
	//				}
	//
	//			}
	//			else { 
	//				if(P.size() >= 2){
	//					P.push(new OrPredicate(P.pop(),P.pop()));
	//				}
	//				else{
	//					break;
	//				}
	//			}
	//		}


	//return timeCheck(CollectionUtils.filter(itemlist.values(), P.pop()));
	//	}

	public void getItems(HashMap<Long, AuctionItem> items){
		this.itemlist = items;
	}

	public void deleteItemInList(Long valueOf) throws Exception {

		if(itemlist.get(valueOf)==null){
			//null because log is ran each time the window is created
			throw new ItemNotFoundException("No Item with the selected id!?");


		}


		itemlist.remove(valueOf);

	}


	public void updateItemToList(AuctionItem auctionItem) {
		itemlist.put((long) auctionItem.getItemID(), auctionItem);
	}

	public void itemBid(Long id, BigDecimal bidIncrease) throws Exception {
		Log.wtf("bidproblem", String.valueOf(bidIncrease));
		if(itemlist.get(id).getEndDate().after(new Date())){

			itemlist.get(id).setBidPrice(itemlist.get(id).getBidPrice().add(bidIncrease));

		}
		else
			throw new ItemClientException("Can't bid on this time");
		//NOT PROPERLY READING IN BIDS! It is not BIDDING!
	}

	@Override
	public Collection<AuctionItem> search(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void crudDispatch(final CrudModel cM){
		Thread i = new Thread(new Runnable() {

			@Override
			public void run() {
				try(Socket s = new Socket("10.0.2.2", 31415);
						ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream())){
					oos.writeObject(cM);

					oos.flush();
					
					ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
					
					


				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		i.start();
	}
	public static HashMap<Long, AuctionItem> readServerMap(final CrudModel cM){
		final Socket s;
		final HashMap<Long, AuctionItem> hM = new HashMap<>();

		Thread i = new Thread(new Runnable() {
			@Override
			public void run() {
				try (Socket s = new Socket("10.0.2.2", 31415); 
						ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream())){
					     /* (HashMap<Long,AuctionItem>)ois.readObject();*/
					
					oos.writeObject(cM);
					oos.flush();
					
					ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
					Long l;
					for(AuctionItem i : (Collection<AuctionItem>)ois.readObject()){
						System.out.println("adding an item : " + i.toString());
						hM.put(l = new Long(i.getItemID()), i);

					}

				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		i.start();
		
		try{
			i.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println(hM);
		return hM;


	}


}
