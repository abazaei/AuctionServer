package com.example.auctionapplication;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.example.auctionapplicationIntermed.AuctionItem;
import com.example.auctionapplicationIntermed.CrudModel;
import com.example.auctionapplicationIntermed.DateParser;
import com.example.auctionapplicationIntermed.MoneyParser;

import edu.neumont.csc180.mvc.Model;
import edu.neumont.csc180.mvc.View;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ItemAddView extends RelativeLayout implements View<SearchModel>, Model.Listener<SearchModel> {

	private Listener listener;
	
	private Button AddItem;
	

	private EditText ItemName;
	private EditText ItemDescription;
	private EditText ItemPrice;
	private EditText StartDate;
	private EditText EndDate;
	
	

	public ItemAddView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public interface Listener extends View.Listener {

		public void addItem(CrudModel cM) throws IOException;
		int idGenerator();
		
	}

	@Override
	public void setListener(View.Listener listener) {
		this.listener = (Listener) listener;

	}

	protected void 	onFinishInflate(){
		super.onFinishInflate();
		
		AddItem = (Button)findViewById(R.id.add_item);

		ItemName = (EditText)findViewById(R.id.enterName);
		ItemDescription = (EditText)findViewById(R.id.enterItemDescrip);
		ItemPrice = (EditText)findViewById(R.id.enterItemPrice);
		StartDate = (EditText)findViewById(R.id.enterStartDate);
		EndDate = (EditText)findViewById(R.id.enterEndDate);
		
		AddItem.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(android.view.View v) {
				Calendar cal = Calendar.getInstance();
		
				cal.add(Calendar.DATE, 7);
				
				//either send data to controller to create new AuctionItem with data and put in list
				//BigDecimal bidPrice, String name, String image, String description, int itemID, Date StartDate, Date EndDate
				BigDecimal startBid = (BigDecimal) (ItemPrice.getText().toString().isEmpty() ? BigDecimal.valueOf(0.01) : MoneyParser.parse(ItemPrice.getText().toString())); //true set to 0.01. else moneyparser
				Date startDate = StartDate.getText().toString().isEmpty() ? new Date() : DateParser.parse(StartDate.getText().toString());
			    Date endDate = EndDate.getText().toString().isEmpty() ? cal.getTime() : DateParser.parse(EndDate.getText().toString());
				try {
					System.out.println("add item clicked");
//					listener.addItem(new AuctionItem(startBid,ItemName.getText().toString(), ItemDescription.getText().toString().replaceAll(" ", "_"), listener.idGenerator(), startDate, endDate));
					listener.addItem(new CrudModel(CrudModel.Command.ADD, "NAME: " + ItemName.getText().toString() + " DESC: " + ItemDescription.getText().toString() + " STARTPRICE: " + ItemPrice.getText().toString() + " STARTDATE: " + StartDate.getText().toString() + " ENDDATE: " + EndDate.getText().toString()));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			
			}
		});
		

	}

	@Override
	public void update(SearchModel data) {
		
		
	}	

}
