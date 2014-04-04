package com.realandylawton.bitcampwear.activity;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.realandylawton.bitcampwear.R;
import org.w3c.dom.Text;

public class ChampionshipActivity extends Activity {

    public static final String EXTRA_HANDLE_CHAMPIONSHIP = "handle_championship";

    @InjectView(R.id.choice_text) protected TextView mChoiceText;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_championship);
        ButterKnife.inject(this);

        if(getIntent().hasExtra(EXTRA_HANDLE_CHAMPIONSHIP)) {
            String choice = getIntent().getExtras().getString(EXTRA_HANDLE_CHAMPIONSHIP);
            onChoiceSelected(choice);
        }

    }

    private void onChoiceSelected(String choice) {
        mChoiceText.setText(choice);
    }

}
