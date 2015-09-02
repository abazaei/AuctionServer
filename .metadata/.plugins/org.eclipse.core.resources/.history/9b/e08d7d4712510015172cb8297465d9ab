package com.example.auctionapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.auctionapplicationIntermed.AuctionItem;

import android.widget.EditText;
import edu.neumont.csc180.mvc.Model;

public class SearchModel implements Model<SearchModel> {

	private Model.Listener<SearchModel> listener;
	private static int idCounter = 0;
	private HashMap<Long, AuctionItem> itemlist = new HashMap<>();
	private AuctionItem item;
	EditText searchQuery;
	Double searchedItemPrice;

	// Results variable or whatever TODO

	public SearchModel(HashMap<Long, AuctionItem> arrayList) {
		this.itemlist = arrayList;
	}

	public SearchModel() {

	}

	@Override
	public void setListener(
			edu.neumont.csc180.mvc.Model.Listener<SearchModel> listener) {
		this.listener = listener;
		listener.update(this);
	}

	public HashMap<Long, AuctionItem> getItems() {
		return itemlist;
	}

	public EditText getSearchQuery() {
		return searchQuery;

	}

	public void setSearchQuery(EditText s) {
		searchQuery = s;
		listener.update(this);
	}

	public Double getSearchedItemPrice() {
		return searchedItemPrice;
	}

	public void setSearchedItemPrice(Double searchedItemPrice) {
		this.searchedItemPrice = searchedItemPrice;
		listener.update(this);

	}

	public void setItems(HashMap<Long, AuctionItem> itemlist) {
		this.itemlist = itemlist;
		listener.update(this);

	}

	public void addItemToList(AuctionItem item) {
		itemlist.put((long) item.getItemID(),item);
		listener.update(this);
	}

	public AuctionItem getItem() {
		return item;
	}

	public void setItem(AuctionItem item) {
		this.item = item;
	}

	public int getIdCounter() {
		return idCounter;
	}

	public void setIdCounter(int idCounter) {
		this.idCounter = idCounter;
	}

}
