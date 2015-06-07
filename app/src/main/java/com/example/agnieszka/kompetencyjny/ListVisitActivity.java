package com.example.agnieszka.kompetencyjny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class ListVisitActivity extends Activity implements AdapterView.OnItemClickListener {

    ArrayList<MyVisit> arrayVisit;
    ListView listViewVisit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_visit);

        arrayVisit = new ArrayList<MyVisit>();
        
        MyVisit firstVisit = new MyVisit(1, "Pierwsza wizyta", "2015-06-07", "12:00");
        MyVisit secondVisit = new MyVisit(2, "Druga wizyta", "2015-06-15", "10:30");
        MyVisit thirdVisit = new MyVisit(3, "Trzecia wizyta", "2015-09-30", "10:00");
        MyVisit fourthVisit = new MyVisit(4, "Czwarta wizyta", "2015-08-02", "10:30");
        MyVisit fifthVisit = new MyVisit(5, "Piata wizyta", "2015-10-11", "11:00");
        MyVisit sixthVisit = new MyVisit(6, "Szosta wizyta", "2015-07-07", "11:30");
        MyVisit seventhVisit = new MyVisit(7, "Siodma wizyta", "2015-06-08", "09:00");
        MyVisit eigthVisit = new MyVisit(8, "Osma wizyta", "2015-08-09", "10:00");
        MyVisit ninethVisit = new MyVisit(9, "Dziewiata wizyta", "2015-07-11", "15:00");
        MyVisit tenVisit = new MyVisit(10, "Dziesiata wizyta", "2015-08-16", "13:00");


        arrayVisit.add(firstVisit);
        arrayVisit.add(secondVisit);
        arrayVisit.add(thirdVisit);
        arrayVisit.add(fourthVisit);
        arrayVisit.add(fifthVisit);
        arrayVisit.add(sixthVisit);
        arrayVisit.add(seventhVisit);
        arrayVisit.add(eigthVisit);
        arrayVisit.add(ninethVisit);
        arrayVisit.add(tenVisit);

        listViewVisit = (ListView) findViewById(R.id.list_visit);
        ListVisitAdapter adapter = new ListVisitAdapter(this, arrayVisit);
        listViewVisit.setAdapter(adapter);
        listViewVisit.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details_visit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.details_visit_settings:

                finish();
                break;
        }

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        MyVisit selectedVisit = arrayVisit.get(position);

        try{
            Intent showDetailsVisitIntent = new Intent(ListVisitActivity.this, DetailsVisit.class);

            Bundle visitData = new Bundle();
            visitData.putString("titleVisit", selectedVisit.getTitleVisit());
            visitData.putString("dateVisit", selectedVisit.getDateVisit());
            visitData.putString("hourVisit", selectedVisit.getHourVisit());

            showDetailsVisitIntent.putExtras(visitData);

            startActivityForResult(showDetailsVisitIntent, 1122);

        } catch(Exception e)
        {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }

    }
}
