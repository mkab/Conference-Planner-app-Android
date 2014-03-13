package com.example.mesconferences.presentations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.example.mesconferences.R;

public class PresentationView extends FragmentActivity {

  private TextView title;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.presentation_view);

    title = (TextView) findViewById(R.id.tvPresentation);

    Intent intent = getIntent();

    title.setText(intent.getStringExtra("pres"));

  }

}
