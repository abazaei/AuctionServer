package com.example.auctionapplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.example.auctionapplicationIntermed.AuctionItem;

import edu.neumont.csc180.mvc.Model;

public class AuctionModel implements Model<AuctionModel> {

	private static final long serialVersionUID = 1L;
	
	private String ItemName;
	private double BidPrice;
	private String image;
	private int ItemID;
	
	
	AuctionItem item;
	
	
	private Model.Listener<AuctionModel> listener;

	public AuctionModel(){
		
	}
	public AuctionModel(AuctionItem i) {
		this.item = i;
		
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
		listener.update(this);
	}

	public BigDecimal getBidPrice() {
		return item.getBidPrice();
		
	}

	public void setBidPrice(BigDecimal d) {
		item.setBidPrice(d);
		listener.update(this);
	}

	@Override
	public void setListener(edu.neumont.csc180.mvc.Model.Listener<AuctionModel> listener) {
		
		this.listener = listener;
		listener.update(this);
	}

	public AuctionItem getItem() {
		
		return item;
	}
	public void setItem(AuctionItem passeditem){
		this.item = passeditem;
		listener.update(this);
	}
	public int getItemID() {
		return ItemID;
	}
	public void setItemID(int itemID) {
		ItemID = itemID;
		
		
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
