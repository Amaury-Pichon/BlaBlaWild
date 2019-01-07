package fr.wildcodeschool.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.util.*;
import java.text.*;


public class ItinerarySearchActivity extends AppCompatActivity {

    public static final String EXTRA_TRIP = "fr.wildcodeschool.blablawild.EXTRA_TRIP";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        final EditText editDate = (EditText) findViewById(R.id.editTextDate);
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(myCalendar, editDate);
            }

        };


        editDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    public void sendItinerary(View view){

        final EditText departure = findViewById(R.id.editTextDeparture);
        final EditText destination = findViewById(R.id.editTextDestination);
        final EditText editDate = (EditText) findViewById(R.id.editTextDate);

        SearchModel trip = new SearchModel(departure.getText().toString(), destination.getText().toString(), editDate.getText().toString());


        if (departure.getText().toString().matches("")||destination.getText().toString().matches("")){
            Toast searchToast = Toast.makeText(getApplicationContext(), getResources().getString(R.string.search_error), Toast.LENGTH_SHORT);
            searchToast.setGravity(Gravity.BOTTOM, 0, 100);
            searchToast.show();
        }
        else{
            Intent itineraryListIntent = new Intent(this, ItineraryListActivity.class);
//            itineraryListIntent.putExtra(getString(R.string.EXTRA_DEPARTURE), departure.getText().toString());
//            itineraryListIntent.putExtra(getString(R.string.EXTRA_DESTINATION), destination.getText().toString());
//            itineraryListIntent.putExtra(getString(R.string.EXTRA_DATE), editDate.getText().toString());
            itineraryListIntent.putExtra(EXTRA_TRIP, trip);
            startActivity(itineraryListIntent);
        }
    }

    private void updateLabel(Calendar myCalendar, EditText editDate) {
        String myFormat = getString(R.string.date_format_search); //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editDate.setText(sdf.format(myCalendar.getTime()));
    }

}
