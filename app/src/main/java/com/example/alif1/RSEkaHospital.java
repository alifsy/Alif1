package com.example.alif1;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSEkaHospital extends ListActivity

{
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listAct = new String[] {"Call Center","SMS Center","Driving Direction","Website","Info di Google","Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAct));
    }

    protected void onListItemClick (ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center")) {
                String nomortelfon ="tel:0761-6989999";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortelfon));


            } else if (pilihan.equals("SMS Center")) {
                String smsText="Alif Syahputra /L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:082268184202"));
                a.putExtra("smsbody",smsText);


            } else if (pilihan.equals("Driving Direction")){
                String rslokasi = "https://maps.app.goo.gl/q8DHoTGP2GQpiT9SA";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(rslokasi));


            } else if (pilihan.equals("Website")){
                String website = "https://www.ekahospital.com/id";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(website));


            } else if (pilihan.equals("Info Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Rumah Sakit Eka Hospital");
            }

            startActivity(a);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
