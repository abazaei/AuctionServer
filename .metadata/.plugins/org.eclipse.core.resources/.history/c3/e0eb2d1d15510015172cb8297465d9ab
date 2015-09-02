package com.example.auctionapplication;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.example.auctionapplicationIntermed.AuctionItem;
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

public class ItemEditView extends RelativeLayout implements View<SearchModel>, Model.Listener<SearchModel> {

	private Listener listener;
	
	private Button EditItem;
	

	private EditText ItemName;
	private EditText ItemDescription;
	private EditText ItemPrice;
	private EditText StartDate;
	private EditText EndDate;
	private long id;
	private String image;

	public ItemEditView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public interface Listener extends View.Listener {

		public void editItem(AuctionItem auctionItem) throws IOException;
		int idGenerator();
		public void modelUpdate(BigDecimal startBid, String string, String string2, Date startDate, Date endDate);
		
	}

	@Override
	public void setListener(View.Listener listener) {
		this.listener = (Listener) listener;

	}

	protected void 	onFinishInflate(){
		super.onFinishInflate();
		
		EditItem = (Button)findViewById(R.id.update_item);

		ItemName = (EditText)findViewById(R.id.enterName);
		ItemDescription = (EditText)findViewById(R.id.enterItemDescrip);
		ItemPrice = (EditText)findViewById(R.id.enterItemPrice);
		StartDate = (EditText)findViewById(R.id.enterStartDate);
		EndDate = (EditText)findViewById(R.id.enterEndDate);
		
	
		
		EditItem.setOnClickListener(new OnClickListener() {
			
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
					
					System.out.println(id);
					
					
					
					listener.editItem(new AuctionItem(startBid,ItemName.getText().toString(), ItemDescription.getText().toString().replaceAll(" ", "_"), listener.idGenerator(), startDate, endDate));
					
					
					
				
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			
			}
		});
		

	}

	private void showError(){
		
		ItemPrice.setError("Password and username didn't match");
			
	}
	@Override
	public void update(SearchModel data) {
		
		ItemName.setText(data.getItem().getName());
		ItemDescription.setText(data.getItem().getDescription());;
		
		System.out.println(data.getItem().getItemID());
		this.setId(data.getItem().getItemID());
		
		ItemPrice.setText(String.valueOf((data.getItem().getBidPrice())));
		StartDate.setText(DateParser.format(data.getItem().getStartDate()));
		EndDate.setText(DateParser.format(data.getItem().getEndDate()));
//		private EditText ItemPrice;
//		private EditText StartDate;
//		private EditText EndDate
	}	

}
