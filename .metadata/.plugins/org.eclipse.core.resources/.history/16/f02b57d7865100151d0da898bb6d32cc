package com.example.auctionapplication;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;

import com.example.auctionapplicationIntermed.DateParser;
import com.example.auctionapplicationIntermed.MoneyParser;

import ItemService.ItemServiceClient;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import edu.neumont.csc180.mvc.Model;
import edu.neumont.csc180.mvc.View;

public class AuctionView extends LinearLayout implements View<AuctionModel>, Model.Listener<AuctionModel> {

	private Button BidButton;
	private Button BidButton5;
	private Button EditButton;

	private TextView ItemForSale;
	private TextView ItemPrice;
	private TextView Description;
	private TextView DateLeftField;
	private ImageView image;

	private Listener listener;
	private AuctionModel model;
	private Button DeleteButton;

	ItemServiceClient isc = new ItemServiceClient();


	public AuctionView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public AuctionModel getModel(){
		return model;
	}

	@Override
	protected void 	onFinishInflate(){

		super.onFinishInflate();
		BidButton = (Button)findViewById(R.id.bid_button);
		BidButton5 = (Button)findViewById(R.id.bid_button5);
		EditButton = (Button)findViewById(R.id.editButton);
		DeleteButton = (Button)findViewById(R.id.deleteButton);
		Description = (TextView)findViewById(R.id.itemDescription);
		ItemForSale = (TextView)findViewById(R.id.itemforsale);
		ItemPrice = (TextView)findViewById(R.id.itembidprice);
		image = (ImageView)findViewById(R.id.imageView1);
		DateLeftField = (TextView)findViewById(R.id.timeleftfield);

		if(model != null)
			if(model.getItem().getEndDate().before(new Date())){
				BidButton.setVisibility(INVISIBLE);
				BidButton5.setVisibility(INVISIBLE);
			}

		EditButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(android.view.View v) {
				listener.editItem();

			}
		});

		DeleteButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(android.view.View v) {
				try {
					listener.delete(model.getItem().getItemID());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		BidButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(android.view.View v) {

				try {
					model.setItem(isc.bid(model.getItem().getItemID(), BigDecimal.valueOf(1.0)));
				} catch (Exception e) {
					Toast.makeText(getContext(), "Outdated Item!", Toast.LENGTH_SHORT).show();
				}
				Toast.makeText(getContext(), "Bid Placed at "+ ItemPrice.getText().toString() + "!", Toast.LENGTH_SHORT).show();

			}	
		});	
		BidButton5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(android.view.View v) {

				try {
					model.setItem(isc.bid(model.getItem().getItemID(), BigDecimal.valueOf(5.0)));
				} catch (Exception e) {
					Toast.makeText(getContext(), "Outdated Item!", Toast.LENGTH_SHORT).show();
				}
				Toast.makeText(getContext(), "Bid Placed at "+ ItemPrice.getText().toString() + "!", Toast.LENGTH_SHORT).show();

			}	
		});	
		System.out.println("ON Finish Inflate END");
	}
	public void setListener(View.Listener listener){
		this.listener = (Listener)listener;

	}
	@Override
	public void update(AuctionModel data) {
		model = data;
		
		if(data.getItem() != null){
			int id = getResources().getIdentifier(data.getItem().getImage(), "drawable", getContext().getPackageName());


			ItemForSale.setText(data.getItem().getName());
			Description.setText(data.getItem().getDescription());
			ItemPrice.setText(("$"+MoneyParser.format(data.getItem().getBidPrice()))); //number format this
			image.setImageDrawable(getResources().getDrawable(id));
			DateLeftField.setText(DateParser.formatTimeUntil(data.getItem().getEndDate()));
		}


	}

	public interface Listener extends View.Listener{
		void productDisplay(String name);
		void delete(int itemID) throws IOException;
		void editItem();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ItemForSale == null) ? 0 : ItemForSale.hashCode());
		result = prime * result
				+ ((ItemPrice == null) ? 0 : ItemPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuctionView other = (AuctionView) obj;
		if (ItemForSale == null) {
			if (other.ItemForSale != null)
				return false;
		} else if (!ItemForSale.equals(other.ItemForSale))
			return false;
		if (ItemPrice == null) {
			if (other.ItemPrice != null)
				return false;
		} else if (!ItemPrice.equals(other.ItemPrice))
			return false;
		return true;
	}
}
