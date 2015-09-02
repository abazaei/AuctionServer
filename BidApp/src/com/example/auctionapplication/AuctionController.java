package com.example.auctionapplication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.net.Socket;

import com.example.auctionapplicationIntermed.AuctionItem;
import com.example.auctionapplicationIntermed.CrudModel;
import com.example.auctionapplicationIntermed.CrudModel.Command;

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
		updateID();
	}

	public String toString(double d){
		return d+"";

	}
	
	public void updateID(){
		Thread i = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try(Socket s = new Socket("10.0.2.2", 31415);
						ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream())){
					oos.writeObject(new CrudModel(Command.UPDATEID, String.valueOf(model.getItem().getItemID())));
					oos.flush();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		i.start();
		
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
	public void delete(final int itemID) throws IOException {
		Thread i = new Thread( new Runnable() {

			@Override
			public void run() {
				try (Socket s = new Socket("10.0.2.2", 31415);
						ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream())){
					oos.writeObject(new CrudModel(CrudModel.Command.DELETE, String.valueOf(itemID)));
					oos.flush();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		i.start();
		try {
			i.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finish();
	}
}
