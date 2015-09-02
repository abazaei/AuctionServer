package com.example.auctionapplication;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import com.example.auctionapplicationIntermed.AuctionItem;

import edu.neumont.csc180.mvc.Controller;
import ItemService.ItemServiceClient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ItemEditController extends Controller<SearchModel> implements ItemEditView.Listener{

	//ArrayList<AuctionModel> allitems = new ArrayList<AuctionModel>();
	ItemServiceClient isc = new ItemServiceClient();
	
	
	public ItemEditController(){	
		
		super(new SearchModel(), "activity_item_edit"); //Model, and Name of View
	}
	
	@Override
	public void editItem(AuctionItem item) throws IOException {
		
		Intent newintent = new Intent(this, SearchController.class);
//		model.addItemToList(item);
		newintent.putExtra("Items", model.getItems());	//CURRENTLY NOT UPDATING THE SEARCH VIEW
		newintent.putExtra("ViewName", "activity_search");	
		newintent.putExtra("firstTime", false);
		try {
			isc.update(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResult(ItemEditController.RESULT_OK, newintent);
		
		finish(); 
		
		
	}	

	@Override
	protected void onCreate(Bundle bundle){
		Bundle extra = this.getIntent().getExtras(); //Gets all the information into this bundle
		this.viewName = "activity_item_edit";
		if(extra != null)
		{
			this.model = new SearchModel(); //gets the item
			model.setItem((AuctionItem) extra.get("Item"));
		}
	

		super.onCreate(bundle); 
		setContentView(); //sets the viewname and model, MVC Helper.

	}

	@Override
	public int idGenerator() {
		
		int i = (int) Math.random()*1000000;
		if(model.getItem()!= null){
			return model.getItem().getItemID();
		}
		return i;
	}


	@Override
	public void modelUpdate(BigDecimal startBid, String string, String string2,
			Date startDate, Date endDate) {
	
		
	}

}
