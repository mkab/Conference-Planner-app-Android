package com.example.mesconferences.conferences;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mesconferences.R;

public class MesConferencesAdapter extends BaseAdapter {

  List<MyConferences> list = MyConferences.getDataForListView();
  private final LayoutInflater inflater;

  public MesConferencesAdapter(Context context) {
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    // TODO Auto-generated method stub
    return list.size();
  }

  @Override
  public Object getItem(int arg0) {
    // TODO Auto-generated method stub
    return list.get(arg0);
  }

  @Override
  public long getItemId(int arg0) {
    // TODO Auto-generated method stub
    return arg0;
  }

  @Override
  public View getView(int arg0, View arg1, ViewGroup arg2) {
    // TODO Auto-generated method stub
    if (arg1 == null) {
      arg1 = inflater.inflate(R.layout.mesconf_fragment, arg2, false);
    }

    TextView title = (TextView) arg1.findViewById(R.id.tvTitle);
    TextView description = (TextView) arg1.findViewById(R.id.tvDescription);
    MyConferences chapter = list.get(arg0);

    title.setText(chapter.conferenceName);
    description.setText(chapter.conferenceDescription);

    return arg1;
  }

}
