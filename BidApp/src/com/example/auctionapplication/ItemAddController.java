package com.example.auctionapplication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.example.auctionapplicationIntermed.AuctionItem;
import com.example.auctionapplicationIntermed.CrudModel;

import edu.neumont.csc180.mvc.Controller;
import ItemService.ItemServiceClient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ItemAddController extends Controller<SearchModel> implements ItemAddView.Listener{

	//ArrayList<AuctionModel> allitems = new ArrayList<AuctionModel>();
	ItemServiceClient isc = new ItemServiceClient();
	int counter = 0;


	public ItemAddController(){	

		super(new SearchModel(), "activity_item_add"); //Model, and Name of View
	}


	@Override
	public void addItem(final CrudModel cM) throws IOException {


		//		model.addItemToList(newitem); //New Model

		//		isc.addItem(newitem);
		//		Intent newintent = new Intent(this, SearchController.class);
		//		newintent.putExtra("Items", model.getItems());
		//		newintent.putExtra("firstTime", false);
		//
		//		this.startActivity(newintent);
		System.out.println("connect sending cM:ADD");
		Thread i =
				new Thread(new Runnable() {
					@Override
					public void run() {
						System.out.println("connect sending cM:ADD, outside try");
						try(Socket s = new Socket("10.0.2.2", 31415);
								ObjectOutputStream ooos = new ObjectOutputStream(s.getOutputStream())){
							System.out.println("connect sending cM");
							ooos.writeObject(cM);
							ooos.flush();
						} catch (IOException e) {
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
		if(!i.isAlive()){
			this.finish();
		}
	}


	@Override
	protected void onCreate(Bundle bundle){
		Bundle extra = this.getIntent().getExtras(); //Gets all the information into this bundle
		this.viewName = "activity_item_add";
		if(extra != null)
		{
			this.model = new SearchModel((HashMap<Long, AuctionItem>) extra.get("Items")); //gets the item
		}


		super.onCreate(bundle); 
		setContentView(); //sets the viewname and model, MVC Helper.

	}

	@Override
	public int idGenerator() {


		return model.getItems().size()+1;

	}

}
