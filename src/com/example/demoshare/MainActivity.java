package com.example.demoshare;

import java.util.List;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Telephony.Sms.Conversations;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private GridView gridView;
	private Context context;
	private RelativeLayout rela;
	private Myadapter adapter;
	private int[] images = {R.drawable.por_sm1,R.drawable.por_sm2,
			R.drawable.por_sm3,R.drawable.por_sm4,
			R.drawable.por_sm5,R.drawable.por_sm6,
			R.drawable.por_sm7,R.drawable.por_sm8,
			R.drawable.por_sm9,R.drawable.por_sm10,
			R.drawable.por_sm11,R.drawable.por_sm12,
			R.drawable.por_sm13,R.drawable.por_sm14,
			R.drawable.por_sm15,R.drawable.por_sm16,
			R.drawable.por_sm3,R.drawable.por_sm4,
			R.drawable.por_sm5,R.drawable.por_sm6,
			R.drawable.por_sm7,R.drawable.por_sm8,
			R.drawable.por_sm9,R.drawable.por_sm10,
			R.drawable.por_sm11,R.drawable.por_sm12,
			R.drawable.por_sm13,R.drawable.por_sm14,
			R.drawable.por_sm15,R.drawable.por_sm16,
			R.drawable.por_sm3,R.drawable.por_sm4,
			R.drawable.por_sm5,R.drawable.por_sm6,
			R.drawable.por_sm7,R.drawable.por_sm8,
			R.drawable.por_sm9,R.drawable.por_sm10,
			R.drawable.por_sm11,R.drawable.por_sm12,
			R.drawable.por_sm13,R.drawable.por_sm14,
			R.drawable.por_sm15,R.drawable.por_sm16,
			R.drawable.por_sm3,R.drawable.por_sm4,
			R.drawable.por_sm5,R.drawable.por_sm6,
			R.drawable.por_sm7,R.drawable.por_sm8,
			R.drawable.por_sm9,R.drawable.por_sm10,
			R.drawable.por_sm11,R.drawable.por_sm12,
			R.drawable.por_sm13,R.drawable.por_sm14,
			R.drawable.por_sm15,R.drawable.por_sm16
	};
	
	private Handler mHandler = new Handler(){
		
		public void handleMessage(android.os.Message msg) {
			
			if(msg.what == 1){
				rela.setVisibility(View.GONE);
				gridView.setAdapter(adapter);
			}
		};
		
	}; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		context = this;
		gridView = (GridView) this.findViewById(R.id.gridView);
		rela = (RelativeLayout)this.findViewById(R.id.main_rela);
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				InitList();
			}
			
		   }).start();
		
	}
	
	private  void InitList(){
		adapter = new Myadapter();
		mHandler.sendEmptyMessage(1);
		
	}
	
	
	
	
	class Myadapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return images.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final Viewholder holderViewholder;
			if(convertView == null){
				convertView = View.inflate(context, R.layout.grid_item, null);
				holderViewholder = new Viewholder();
				holderViewholder.linearLayout = (RelativeLayout) convertView.findViewById(R.id.relative_item);
				holderViewholder.imageView = (ImageView)convertView.findViewById(R.id.image_item);
				holderViewholder.imageView2 = (ImageView)convertView.findViewById(R.id.image_choice);
				convertView.setTag(holderViewholder);
			}else{
				holderViewholder = (Viewholder)convertView.getTag();
			}
			holderViewholder.imageView.setBackgroundResource(images[position]);
			holderViewholder.linearLayout.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if(v.isSelected()){
						v.setBackgroundColor(Color.parseColor("#ffffff"));
						holderViewholder.imageView2.setBackgroundResource(R.drawable.no_choice);
						v.setSelected(false);
					}else{
						v.setBackgroundColor(Color.parseColor("#29BAF3"));
						holderViewholder.imageView2.setBackgroundResource(R.drawable.choice);
						v.setSelected(true);
					}
					
				}
			});
			return convertView;
		}
		
		class Viewholder{
			private RelativeLayout linearLayout;
			private ImageView imageView;
			private ImageView imageView2;
		}
		
	}

}
