package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        Intent intent = getIntent();
        String departure = intent.getStringExtra(ItinerarySearchActivity.EXTRA_DEPARTURE);
        String destination = intent.getStringExtra((ItinerarySearchActivity.EXTRA_DESTINATION));

        CharSequence newTitle = departure + " >> " + destination;
        this.setTitle(newTitle);

    }
}
