package com.example.auctionapplication;

import java.text.NumberFormat;

import com.example.auctionapplicationIntermed.MoneyParser;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import edu.neumont.csc180.mvc.Model;
import edu.neumont.csc180.mvc.View;

public class AuctionListView extends LinearLayout implements View<AuctionModel>, Model.Listener<AuctionModel> {

	public final static int IMAGE_WIDTH = 150;
	public final static int IMAGE_HEIGHT = 150;
	
	private Listener listener;
	private AuctionModel model;
	
	private ImageView image;
	private TextView itemname;
	private TextView itemcurrentbid;

	
	
	public AuctionListView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public AuctionModel getModel(){
		return model;
	}
	
	@Override
	protected void 	onFinishInflate(){

		image = (ImageView) findViewById(R.id.item_image);
		itemname = (TextView) findViewById(R.id.item_name);
		itemcurrentbid = (TextView) findViewById(R.id.item_current_bid);
		
		super.onFinishInflate();
		
	}
	public void setListener(View.Listener listener){
		this.listener = (Listener)listener;

	}
	@Override
	public void update(AuctionModel data) {
		model = data;
		if (itemname != null){
			itemname.setText(data.getItem().getName());
			
			if(data.getItem()!= null){
				int id = getResources().getIdentifier(data.getItem().getImage(), "drawable", getContext().getPackageName());
				LayoutParams imagebound = (LayoutParams) image.getLayoutParams();
				imagebound.width = IMAGE_WIDTH;
				imagebound.height = IMAGE_HEIGHT;
				image.setLayoutParams(imagebound);
				image.setImageDrawable(getResources().getDrawable(id));
			}
			
		
//			Log.wtf("AUCTIONLISTVIEW", ));
			
			itemcurrentbid.setText("$"+MoneyParser.format(data.getItem().getBidPrice())); // this is null
		}
		
		
	}

	public interface Listener extends View.Listener{
		void productDisplay(String name);
	}

	
}
