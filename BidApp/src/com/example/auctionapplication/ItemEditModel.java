package com.example.auctionapplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.example.auctionapplicationIntermed.AuctionItem;

import edu.neumont.csc180.mvc.Model;

public class ItemEditModel implements Model<ItemEditModel> {

	private static final long serialVersionUID = 1L;
	
	private String ItemName;
	
	private String image;
	private String Description;
	private Date startDate;
	private Date endDate;
	
	private int ItemID;
	
	
	AuctionItem item;
	
	
	private Model.Listener<ItemEditModel> listener;

	public ItemEditModel(AuctionItem i) {
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
	public void setListener(edu.neumont.csc180.mvc.Model.Listener<ItemEditModel> listener) {
		
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


}
