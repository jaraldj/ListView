package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AdapterItems> listnewsData= new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvlist=findViewById(R.id.lvList);

        //add data and view it
        listnewsData.add(new AdapterItems(R.drawable.one,"developer","develop apps"));
        listnewsData.add(new AdapterItems(R.drawable.two,"admin","develop apps"));
        listnewsData.add(new AdapterItems(R.drawable.three,"creator","develop apps"));
        myadapter=new MyCustomAdapter(listnewsData);
        lvlist.setAdapter(myadapter);
    }

    public void addnew(View view) {
        listnewsData.add(new AdapterItems(R.drawable.one,"added","develop apps"));
        myadapter.notifyDataSetChanged();
    }

    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<AdapterItems> listnewsDataAdapter;

        public MyCustomAdapter(ArrayList<AdapterItems> listnewsDataAdapter){
            this.listnewsDataAdapter=listnewsDataAdapter;
        }
        @Override
        public int getCount() {
            return listnewsDataAdapter.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflator=getLayoutInflater();
            View myView= mInflator.inflate(R.layout.layout_ticket,null);

            final AdapterItems s=listnewsDataAdapter.get(position);

            ImageView ivimage= myView.findViewById(R.id.ivimage);
            ivimage.setImageResource(+s.ID);

            TextView tvTitle= myView.findViewById(R.id.tvTitle);
            tvTitle.setText(s.JobTitle);
            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),s.JobTitle,Toast.LENGTH_LONG).show();
                }
            });

            TextView tvDesc= myView.findViewById(R.id.tvDesc);
            tvDesc.setText(s.Description);

            return myView;
        }
    }
}