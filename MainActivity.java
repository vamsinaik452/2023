package com.example.stegnography;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText  username=null;
	   private EditText  password=null;
	   private TextView attempts;
	   private Button login;
	   int counter = 3;
	   private SQLiteDatabase newDB;
	   private SQLiteDatabase newDB1;
	   private SQLiteDatabase newDB2;
	   String data="";
	   String data1="";
	   String data2="";
	   String data3="";
	   String data4="";
	   String data5="";
	   ArrayList arrayList=new ArrayList();
	   ArrayList staffarray=new ArrayList();
	   ArrayList studentaray=new ArrayList();
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_main);
	      username = (EditText)findViewById(R.id.editText1);
	      password = (EditText)findViewById(R.id.editText2);
	   
	      login = (Button)findViewById(R.id.button1);
	   }
	   public void login(View view){
	      if(username.getText().toString().equals("Admin") && 
	      password.getText().toString().equals("Admin"))
	      {
	      Intent nextScreen = new Intent(getApplicationContext(), Selection.class);
	    startActivity(nextScreen);
	   }	
	    	  Toast.makeText(getApplicationContext(), "go...", 
	    		      Toast.LENGTH_SHORT).show();
	}
	}
