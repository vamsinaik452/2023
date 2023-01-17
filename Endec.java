package com.example.stegnography;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.app.Activity;
import android.app.ProgressDialog;
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
public class Endec  extends Activity 
{
	Button button;
	Button button1;
	 EditText  add_rollno=null;
	 String a_rollno=null;
	 private ProgressDialog progress;
	 EditText  add_rollno1=null;
	 String a_rollno1=null;
	DBip dbip;
	String item ="";
	int temp =0;
     private SQLiteDatabase dataBase=null;
 	//private Spinner spinner1, spinner2,spinner3;
     private SQLiteDatabase newDB;
     ArrayList arrayList=new ArrayList();
     String data="";
	   String data1="";
	   String name="";
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.endec);
		add_rollno = (EditText)findViewById(R.id.add_rollno);
		add_rollno1 = (EditText)findViewById(R.id.add_rollno1);
		//retreveSpeed();
		 Bundle b = getIntent().getExtras();
		 name = b.getString("Data");
		 add_rollno.setText(name);
		 progress = new ProgressDialog(this);
		addListenerOnButton();
		dbip = new DBip(this);
	}
	public void addListenerOnButton() {
		button = (Button) findViewById(R.id.add_save_btn);
 
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				a_rollno=add_rollno.getText().toString().trim();
				a_rollno1=add_rollno1.getText().toString().trim();
				saveData();
				 progress.setMessage("Encoding the File ");
			      progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			      progress.setIndeterminate(true);
			      progress.show();
			   final int totalProgressTime = 100;
			   final Thread t = new Thread(){
			   @Override
			   public void run(){
			      int jumpTime = 0;
			      while(jumpTime < totalProgressTime){
			         try {
			            sleep(200);
			            jumpTime += 5;
			            progress.setProgress(jumpTime);
			         } catch (InterruptedException e) {
			           // TODO Auto-generated catch block
			           e.printStackTrace();
			         }
			      }   }   };   t.start();
		Toast.makeText(getApplicationContext(), "File Encode Sucessfully", 
    	    		      Toast.LENGTH_SHORT).show();
				add_rollno.setText("");
				add_rollno1.setText("");
			}
		});
		button1 = (Button) findViewById(R.id.add_save_btn1);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				a_rollno=add_rollno.getText().toString().trim();
				a_rollno1=add_rollno1.getText().toString().trim();
				retrieveData(a_rollno);
				 progress.setMessage("Encoding the File ");
			      progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			      progress.setIndeterminate(true);
			      progress.show();
			   final int totalProgressTime = 100;
			   final Thread t = new Thread(){
			   @Override
			   public void run(){
			      int jumpTime = 0;
			      while(jumpTime < totalProgressTime){
			         try {
			            sleep(200);
			            jumpTime += 5;
			            progress.setProgress(jumpTime);
			         } catch (InterruptedException e) {
			           // TODO Auto-generated catch block
			           e.printStackTrace();
			         }     }}   };
			   t.start();
				Toast.makeText(getApplicationContext(), "Succesfully Decode", 
    	    		      Toast.LENGTH_SHORT).show();
			}
		});
	}
    private void saveData(){
        dataBase=dbip.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(dbip.KEY_PNAME,a_rollno);
        values.put(dbip.KEY_SNAME,a_rollno1);
        System.out.println("");
        dataBase.delete(dbip.TABLE_NAME, null, null);
            dataBase.insert(dbip.TABLE_NAME, null, values);
        dataBase.close();
       // finish();
    }

    
    private void retrieveData(String inputdata)
    {
    	  dataBase=dbip.getWritableDatabase();
          ContentValues values=new ContentValues();
          Cursor cursor = dataBase.rawQuery("SELECT * FROM Encode WHERE filename = ?", new String[]{ inputdata });
          if (cursor != null && cursor.moveToFirst()) {
              String title = cursor.getString(cursor.getColumnIndex(dbip.KEY_SNAME));
              add_rollno1.setText(title);
              // Dumps "Title: Test Title Content: Test Content"
             // Log.d(TAG, "Title: " + title + " Content: " + content);
              cursor.close();
          }
    }    
}
