package com.example.stegnography;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
public class InputData  extends Activity 
{
	Button button;
	Button button1;
	 EditText  add_rollno=null;
	 String a_rollno=null;
	//DBip dbip;
	String item ="";
	int temp =0;
     private SQLiteDatabase dataBase=null;
 	//private Spinner spinner1, spinner2,spinner3;
     private SQLiteDatabase newDB;
     ArrayList arrayList=new ArrayList();
     String data="";
	   String data1="";
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input);
		add_rollno = (EditText)findViewById(R.id.add_rollno);
		//retreveSpeed();
		addListenerOnButton();
		//dbip = new DBip(this);	
	}
	public void addListenerOnButton() {
		button = (Button) findViewById(R.id.add_save_btn);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				a_rollno=add_rollno.getText().toString().trim();
				//saveData();
				Toast.makeText(getApplicationContext(), "Insert Sucessfully", 
    	    		      Toast.LENGTH_SHORT).show();
				add_rollno.setText("");			
			}	});	}}
