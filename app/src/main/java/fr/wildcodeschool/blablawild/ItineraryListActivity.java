package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.text.*;
import java.util.ArrayList;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        Intent intent = getIntent();


        SearchModel trip = intent.getParcelableExtra(ItinerarySearchActivity.EXTRA_TRIP);

        String departure = trip.getDeparture();
        String destination = trip.getDestination();
        String date = trip.getDate();

        Toast.makeText(this, date, Toast.LENGTH_SHORT).show();

        CharSequence newTitle = departure + " >> " + destination;
        this.setTitle(newTitle);

        ListView listTrip = findViewById(R.id.list_trip);
        ArrayList<TripModel> results = new ArrayList<TripModel>();

        SimpleDateFormat sdf = new SimpleDateFormat(getString(R.string.date_format_in));

        try {
            results.add(new TripModel("Eric", "Cartman", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripModel("Stan", "Marsh", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripModel("Kenny", "Broflovski", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripModel("Kyle", "McCormick", sdf.parse("21/02/2017-17:00"), 40));
            results.add(new TripModel("Wendy", "Testaburger", sdf.parse("21/02/2017-17:30"), 20));
            results.add(new TripModel("Amaury", "Pichon", sdf.parse("21/11/2018-18:30"), 200));
        } catch (ParseException e) {
        }
        TripAdapter adapter = new TripAdapter(this, results);
        listTrip.setAdapter(adapter);

    }
}
