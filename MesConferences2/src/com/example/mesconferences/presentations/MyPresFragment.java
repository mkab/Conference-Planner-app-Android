package com.example.mesconferences.presentations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mesconferences.R;

public class MyPresFragment extends ListFragment {

  private MyPresAdapter adapter;
  private TextView title, description;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.list_view_presentation, container, false);
    title = (TextView) view.findViewById(R.id.tvMesconf);
    description = (TextView) view.findViewById(R.id.tvConfDesc);
    return view;
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    adapter = new MyPresAdapter(getActivity());
    setListAdapter(adapter);

    // get conference name and description from previous activity
    Intent intent = getActivity().getIntent();
    String confname = intent.getStringExtra("ConferenceName");
    String confdesc = intent.getStringExtra("ConferenceDescription");

    // we have to get the name of the conference
    // set activity title - which is the conference title
    title.setText(confname);

    // set activity description - which is the conference description
    description.setText(confdesc);
  }

  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
    // TODO Auto-generated method stub
    MyPresentation presentation = (MyPresentation) adapter.getItem(position);
    Toast.makeText(getActivity(),
        presentation.name + "\ndescription : " + presentation.description, Toast.LENGTH_SHORT)
        .show();

    // Open an activity with the presentation values

    Intent intent = new Intent(getActivity(), PresentationView.class);
    intent.putExtra("pres", presentation.name);
    startActivity(intent);
  }
}
