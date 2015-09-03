package com.example.auctionapplication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import com.example.auctionapplicationIntermed.AuctionItem;
import com.example.auctionapplicationIntermed.CrudModel;

import edu.neumont.csc180.mvc.Controller;
import ItemService.ItemServiceClient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ItemEditController extends Controller<SearchModel> implements ItemEditView.Listener{

	//ArrayList<AuctionModel> allitems = new ArrayList<AuctionModel>();
	ItemServiceClient isc = new ItemServiceClient();
	
	
	public ItemEditController(){	
		
		super(new SearchModel(), "activity_item_edit"); //Model, and Name of View
	}
	
	@Override
	public void editItem(final CrudModel cM) throws IOException {
		System.out.println("connect sending cM:UPDATE");
//		Thread i =
//				new Thread(new Runnable() {
//					@Override
//					public void run() {
//						System.out.println("connect sending cM:UPDATE, outside try");
//						try(Socket s = new Socket("10.0.2.2", 31415);
//								ObjectOutputStream ooos = new ObjectOutputStream(s.getOutputStream())){
//							System.out.println("connect sending cM");
//							ooos.writeObject(cM);
//							ooos.flush();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//					}
//				});
//
//		i.start();
//		try {
//			i.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(!i.isAlive()){
//			this.finish();
//		}
		ItemServiceClient.crudDispatch(cM);
		
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
