package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    public static final String EXTRA_DEPARTURE = "fr.wildcodeschool.blablawild.DEPARTURE";
    public static final String EXTRA_DESTINATION = "fr.wildcodeschool.blablawild.DESTINATION";
    public static final String EXTRA_DATE = "fr.wildcodeschool.blablawild.DATE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
    }

    public void sendItinerary(View view){

        final EditText departure = findViewById(R.id.editTextDeparture);
        final EditText destination = findViewById(R.id.editTextDestination);
        final EditText date = findViewById(R.id.editTextDate);

        if (departure.getText().toString().matches("")||destination.getText().toString().matches("")){
            Toast searchToast = Toast.makeText(getApplicationContext(), getResources().getString(R.string.search_error), Toast.LENGTH_SHORT);
            searchToast.setGravity(Gravity.BOTTOM, 0, 100);
            searchToast.show();
        }
        else{
            Intent itineraryListIntent = new Intent(this, ItineraryListActivity.class);
            itineraryListIntent.putExtra(EXTRA_DEPARTURE, departure.getText().toString());
            itineraryListIntent.putExtra(EXTRA_DESTINATION, destination.getText().toString());
            itineraryListIntent.putExtra(EXTRA_DATE, date.getText().toString());
            startActivity(itineraryListIntent);
        }


    }
}
