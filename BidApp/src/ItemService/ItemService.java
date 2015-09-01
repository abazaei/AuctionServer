package ItemService;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import android.util.Log;

import com.example.auctionapplicationIntermed.AuctionItem;

public interface ItemService {
	
	public AuctionItem bid(long id, BigDecimal bidIncrease) throws Exception;
	public Collection<AuctionItem> timeCheck (Collection<AuctionItem> items);
	public Collection<AuctionItem> search(String query);
	public void getItems(HashMap<Long, AuctionItem> items);
	public void setList(HashMap<Long, AuctionItem> il);
	public void deleteItemInList(Long valueOf) throws Exception;
	public void updateItemToList(AuctionItem auctionItem);
	public void itemBid(Long id, BigDecimal bidIncrease) throws Exception;

}
