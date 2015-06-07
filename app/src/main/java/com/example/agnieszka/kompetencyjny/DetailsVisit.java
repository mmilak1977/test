package com.example.agnieszka.kompetencyjny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class DetailsVisit extends Activity implements View.OnClickListener {

    TextView titleTV, dateTV, hourTV;
    Button removeVisitBtn, delayVisitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_visit);

       Intent receiveVisitDataIntent = getIntent();
        Bundle myBundle = receiveVisitDataIntent.getExtras();

        String titleVisit = myBundle.getString("titleVisit");
        String dateVisit = myBundle.getString("dateVisit");
        String hourVisit = myBundle.getString("hourVisit");

        initialize();
        setValueControls(titleVisit, dateVisit, hourVisit); //przyspisanie wartosci kontrolka

        listeners();
    }


    private void initialize()
    {
        titleTV = (TextView) findViewById(R.id.visitTitleDetails);
        dateTV = (TextView) findViewById(R.id.visitDateDetails);
        hourTV = (TextView) findViewById(R.id.visitHourDetails);

        removeVisitBtn = (Button) findViewById(R.id.removeVisit);
        delayVisitBtn = (Button) findViewById(R.id.delayVisit);
    }

    private void setValueControls(String title, String date, String hour)
    {
        titleTV.setText(title);
        dateTV.setText(date);
        hourTV.setText(hour);
    }

    private void listeners()
    {
        removeVisitBtn.setOnClickListener((View.OnClickListener) this);
        delayVisitBtn.setOnClickListener((View.OnClickListener) this);
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
    public void onClick(View v) {

        if(v == removeVisitBtn)
        {
            print(getString(R.string.removeVisitMessage));
            finish();
        }

        if(v == delayVisitBtn)
        {
            print(getString(R.string.delayVisitMessage));
            finish();
        }

    }

    public void print(String text)
    {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
