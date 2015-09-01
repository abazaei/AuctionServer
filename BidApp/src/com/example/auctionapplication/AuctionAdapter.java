package com.example.auctionapplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




import com.example.auctionapplicationIntermed.AuctionItem;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class AuctionAdapter extends BaseAdapter{

	private List<AuctionListView> itemlist = new ArrayList<>();


	public AuctionAdapter(Context context, Collection<AuctionItem> itemlist){
		
		for(AuctionItem item : itemlist){
			
			AuctionListView view = (AuctionListView)
			android.view.View.inflate(context, R.layout.items_list_view, null);
			AuctionModel am = new AuctionModel(item);
			am.setListener(view);
			this.itemlist.add(view);
			
		}

	}

	@Override
	public android.view.View getView(int position, android.view.View convertView, ViewGroup parent) {
		return itemlist.get(position);
	}

	@Override
	public int getCount() {

		return itemlist.size();
	}

	@Override
	public Object getItem(int position) {
		return itemlist.get(position).getModel();
	}

	@Override
	public long getItemId(int position) {
		return position;
	}




}
