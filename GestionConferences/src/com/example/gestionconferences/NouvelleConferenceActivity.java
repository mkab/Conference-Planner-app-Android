package com.example.gestionconferences;

import java.util.Date;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class NouvelleConferenceActivity extends Activity {
  static Dialog myDialog, dialogPresentation, dialogHeure;
  static LinearLayout presentations;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_ecran_nouvelle_conference);

    creationBoitesDialogue();
    ajouterListeners();
    presentations = (LinearLayout) findViewById(R.id.linearLayoutPresentations);
  }

  public void creationBoitesDialogue() {
    myDialog = new Dialog(this, R.style.AlertDialogCustom);

    LayoutInflater inflater = this.getLayoutInflater();
    View v = inflater.inflate(R.layout.layout_choix_date, null);
    myDialog.setContentView(v);

    dialogPresentation = new Dialog(this, R.style.AlertDialogCustom);

    LayoutInflater inflater2 = this.getLayoutInflater();
    View v2 = inflater2.inflate(R.layout.layout_nouvelle_presentation, null);
    dialogPresentation.setContentView(v2);

    dialogHeure = new Dialog(this, R.style.AlertDialogCustom);
    LayoutInflater inflater3 = this.getLayoutInflater();
    View v3 = inflater3.inflate(R.layout.layout_nouvelle_presentation, null);
    dialogHeure.setContentView(v3);
  }

  public void ajouterListeners() {
    Button boutonDateDebut = (Button) findViewById(R.id.boutonDebutConference);
    boutonDateDebut.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {

        NouvelleConferenceActivity.myDialog.setTitle("Date de début de la conférence");
        NouvelleConferenceActivity.myDialog.show();
      }
    });

    Button boutonDateFin = (Button) findViewById(R.id.boutonFinConference);
    boutonDateFin.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {

        NouvelleConferenceActivity.myDialog.setTitle("Date de fin de la conférence");
        NouvelleConferenceActivity.myDialog.show();
      }
    });

    Button boutonAjouterPresentation = (Button) findViewById(R.id.boutonAjouterPresentation);
    boutonAjouterPresentation.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {

        NouvelleConferenceActivity.dialogPresentation.setTitle("Nouvelle Presentation");
        NouvelleConferenceActivity.dialogPresentation.show();

        Button boutonValiderPresentation =
            (Button) NouvelleConferenceActivity.dialogPresentation
                .findViewById(R.id.boutonValiderPresentation);

        boutonValiderPresentation.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View v) {
            EditText editText =
                (EditText) NouvelleConferenceActivity.dialogPresentation
                    .findViewById(R.id.editTextProgramme);
            String textProgramme = editText.getText().toString();
            Toast.makeText(NouvelleConferenceActivity.this, "programme = " + textProgramme,
                Toast.LENGTH_SHORT).show();

            editText =
                (EditText) NouvelleConferenceActivity.dialogPresentation
                    .findViewById(R.id.editTextAuteur);
            String textAuteur = editText.getText().toString();
            Toast.makeText(NouvelleConferenceActivity.this, "auteur = " + textAuteur,
                Toast.LENGTH_SHORT).show();

            editText =
                (EditText) NouvelleConferenceActivity.dialogPresentation
                    .findViewById(R.id.editTextLieu);
            String textLieu = editText.getText().toString();
            Toast.makeText(NouvelleConferenceActivity.this, "lieu = " + textLieu,
                Toast.LENGTH_SHORT).show();

            DatePicker datePicker =
                (DatePicker) NouvelleConferenceActivity.dialogPresentation
                    .findViewById(R.id.datePickerPresentation);
            int jour = datePicker.getDayOfMonth();
            int mois = datePicker.getMonth();
            int annee = datePicker.getYear();

            TimePicker timePicker =
                (TimePicker) NouvelleConferenceActivity.dialogPresentation
                    .findViewById(R.id.timePickerDebutPresentation);
            int heure = timePicker.getCurrentHour();
            int minute = timePicker.getCurrentMinute();
            Date dateDebut = new Date(annee, mois, jour, heure, minute);
            Toast.makeText(NouvelleConferenceActivity.this, "date  Debut= " + dateDebut.toString(),
                Toast.LENGTH_SHORT).show();

            timePicker =
                (TimePicker) NouvelleConferenceActivity.dialogPresentation
                    .findViewById(R.id.timePickerFinPresentation);
            heure = timePicker.getCurrentHour();
            minute = timePicker.getCurrentMinute();
            Date dateFin = new Date(annee, mois, jour, heure, minute);
            Toast.makeText(NouvelleConferenceActivity.this, "date Fin = " + dateDebut.toString(),
                Toast.LENGTH_SHORT).show();

            // Ajout d'un textView
            LinearLayout layout = new LinearLayout(NouvelleConferenceActivity.this);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT));

            TextView titleView = new TextView(NouvelleConferenceActivity.this);
            LayoutParams lparams =
                new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            titleView.setLayoutParams(lparams);
            // titleView.setTextAppearance(this, android.R.attr.textAppearanceLarge);
            titleView.setText(textProgramme + " par : " + textAuteur);
            layout.addView(titleView);

            // LayoutParams ll = new
            // LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,getWindowManager().getDefaultDisplay().getHeight()-100);
            NouvelleConferenceActivity.presentations.addView(layout);

            NouvelleConferenceActivity.dialogPresentation.dismiss();
          }
        });

      }

    });

  }

}
