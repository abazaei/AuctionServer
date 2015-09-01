package com.example.auctionapplication;

import java.io.IOException;
import java.math.BigDecimal;

import com.example.auctionapplicationIntermed.AuctionItem;

import ItemService.ItemServiceClient;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import edu.neumont.csc180.mvc.*;

public class AuctionController extends Controller<AuctionModel> implements AuctionView.Listener {


	
	
	public AuctionController(){	
		
		super(new AuctionModel(), "auction_controller"); //Model, and Name of View
	}
	
	@Override
	protected void onCreate(Bundle bundle){
		Bundle extra = this.getIntent().getExtras(); //Gets all the information into this bundle
		this.viewName = (String) extra.get("ViewName"); //gets the viewname
		this.model = new AuctionModel((AuctionItem) extra.get("AuctionItem")); //gets the item
		super.onCreate(bundle); 
		setContentView(); //sets the viewname and model, MVC Helper.
	}
	
	public String toString(double d){
		return d+"";
		
	}
	
	
	public void toSearchMenu(android.view.View view){
	Intent intent = new Intent(AuctionController.this, SearchController.class);
//		startActivity(intent);
		finish();
	}
	
	@Override
	public void productDisplay(String name) {
		model.setItemName(name);	
		
		
	}

	@Override
	public void editItem() {
		Intent intent = new Intent(this, ItemEditController.class);
		intent.putExtra("Item", model.getItem());
		Log.w("PUTEXTRA", String.valueOf(model.getItem()));// YOU LEFT IT OFF HERE TO FIGURE OUT WHY IT CANT EDIT BECAUSE OF ID DIFFERNECES AND NULLS
		finish();
		this.startActivity(intent);
		
	}

	@Override	
	public void delete(int itemID) throws IOException {
		try {
			ItemServiceClient.delete((long) itemID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finish();
	}




}
