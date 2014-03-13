package com.example.mesconferences.conferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mesconferences.R;
import com.example.mesconferences.presentations.MyPresentationActivity;

public class MesConfFragment extends ListFragment {

  MesConferencesAdapter adapter;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.list_view_list_activity, container, false);
    return view;
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    adapter = new MesConferencesAdapter(getActivity());
    setListAdapter(adapter);
  }

  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
    showDetails(position);
  }

  private void showDetails(int position) {
    MyConferences conf = (MyConferences) adapter.getItem(position);

    Intent intent = new Intent();
    intent.putExtra("ConferenceName", conf.conferenceName);
    intent.putExtra("ConferenceDescription", conf.conferenceDescription);

    intent.setClass(getActivity(), MyPresentationActivity.class);
    startActivity(intent);
  }
}
