package com.example.aio_converter;


import java.math.BigDecimal;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class Temperature extends Activity
{
	
	public float var1, var2;
	public String varStr1,varStr2;
	public boolean flag1=true,flag2=true;
	public static int precision =1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temperature);
	
		spinnerInit(R.array.Temp_array);
		
		ET1();
		ET2();
	
	}
	
		public static double round(double unrounded)
		{
		    BigDecimal bd = new BigDecimal(unrounded);
		    bd = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
		    return bd.doubleValue();
		}
		public void spinnerInit(int arr)
		{
					
			Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
			Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

			// Create an ArrayAdapter using the string array and a default spinner layout
			ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
			        arr,R.layout.spinner_layout);
			// Specify the layout to use when the list of choices appears
			adapter.setDropDownViewResource(R.layout.spinner_layout);
			// Apply the adapter to the spinner
			spinner1.setAdapter(adapter);
			spinner2.setAdapter(adapter);

			spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener1());
			spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener2());

			
		}
		public void ET1()
		{
			EditText eT1 = (EditText) findViewById(R.id.eT1);
			eT1.addTextChangedListener(new TextWatcher()
			{
				@Override
				public void afterTextChanged(Editable s) 
				{	
			EditText eT1 = (EditText) findViewById(R.id.eT1);  
			EditText eT2 = (EditText) findViewById(R.id.eT2);
			Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
			Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
			int spin1pos,spin2pos;
			spin1pos=spinner1.getSelectedItemPosition();
			spin2pos=spinner2.getSelectedItemPosition();
			final double result;
			if ((eT1.isFocused())&&flag1){
					try
					{
					var1 = Float.parseFloat(eT1.getText().toString());
					}
					catch (NumberFormatException e)
					{
						var1=0;
					}
					result=result(var1,spin1pos,spin2pos);
					varStr2 = String.valueOf(result);
					eT2.setText(varStr2);
				}
				flag1=true;
				}
				public void beforeTextChanged(CharSequence s, int start, int count, int after){}
				public void onTextChanged(CharSequence s, int start, int before, int count) {}
			});
		}
		public void ET2()
			{
			EditText eT2 = (EditText) findViewById(R.id.eT2);
			eT2.addTextChangedListener(new TextWatcher()
			{
				@Override
				public void afterTextChanged(Editable s) 
				{	
					EditText eT1 = (EditText) findViewById(R.id.eT1);  
					EditText eT2 = (EditText) findViewById(R.id.eT2);
					Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
					Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
					int spin1pos,spin2pos;
					spin1pos=spinner1.getSelectedItemPosition();
					spin2pos=spinner2.getSelectedItemPosition();
				final double result;
				if ((eT2.isFocused())&&flag2)
					{
						try
						{	
							var2 = Float.parseFloat(eT2.getText().toString());
						}
						catch (NumberFormatException e)
						{
							var2=0;
						}
						result=result(var2,spin2pos,spin1pos);
						varStr1 = String.valueOf(result);
						eT1.setText(varStr1);
					}
				flag2=true;
				}
				public void beforeTextChanged(CharSequence s, int start, int count, int after){}
				public void onTextChanged(CharSequence s, int start, int before, int count) {}
			});
		   }

		public void ET1_init()
		{
			EditText eT1 = (EditText) findViewById(R.id.eT1);  
			EditText eT2 = (EditText) findViewById(R.id.eT2);
			Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
			Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
			int spin1pos,spin2pos;
			spin1pos=spinner1.getSelectedItemPosition();
			spin2pos=spinner2.getSelectedItemPosition();
			final double result;
					try
					{
					var1 = Float.parseFloat(eT1.getText().toString());
					}
					catch (NumberFormatException e)
					{
						var1=0;
					}
					result=result(var1,spin1pos,spin2pos);
					varStr2 = String.valueOf(result);
					eT2.setText(varStr2);
		}
		public void ET2_init()
		{
				EditText eT1 = (EditText) findViewById(R.id.eT1);  
				EditText eT2 = (EditText) findViewById(R.id.eT2);
				Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
				Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
				int spin1pos,spin2pos;
				spin1pos=spinner1.getSelectedItemPosition();
				spin2pos=spinner2.getSelectedItemPosition();
			final double result;
					try
					{	
						var2 = Float.parseFloat(eT2.getText().toString());
					}
					catch (NumberFormatException e)
					{
						var2=0;
					}
					result=result(var2,spin2pos,spin1pos);
					varStr1 = String.valueOf(result);
					eT1.setText(varStr1);
	   }
		
		
		public class CustomOnItemSelectedListener1 implements OnItemSelectedListener
	{
			 
			  public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) 
			  {
				/*Toast.makeText(parent.getContext(), 
						"OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString()+spin1pos+spin2pos,
						Toast.LENGTH_SHORT).show();
				Toast.makeText(parent.getContext(),"Spinner1 is Enabled ",Toast.LENGTH_SHORT).show();*/
				
				ET2_init();
				flag1=false;
			  }
			  @Override
			  public void onNothingSelected(AdapterView<?> arg0) 
			  {
				// TODO Auto-generated method stub
			  }
			 
		}
		
		public class CustomOnItemSelectedListener2 implements OnItemSelectedListener
		{
				  public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) 
				  {
					/*Toast.makeText(parent.getContext(), 
							"OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString()+spin1pos+spin2pos,
							Toast.LENGTH_SHORT).show();
					Toast.makeText(parent.getContext(),"Spinner2 is Enabled ",Toast.LENGTH_SHORT).show();*/
					ET1_init();
					flag2=false;
				  }
				  @Override
				  public void onNothingSelected(AdapterView<?> arg0) 
				  {
					// TODO Auto-generated method stub
				  }
			}
		
		public double result (float var,int spin1pos,int spin2pos)
		{
			double res=0;
			switch (spin1pos) {
			case 0:							// CELSIUS
				switch (spin2pos) {
				case 0:								// CELSIUS
					res=round(var);
					break;
				case 1:								// FARENHEIT
					res=round((var*1.8f)+32);
					break;
				case 2:								// KELVIN
					res=round(var+273.15f);
					break;
				default:
					break;
				}
				break;
			case 1:							// FARENHEIT
				switch (spin2pos) {
				case 0:								// CELSIUS
					res=round((var-32)/1.8f);
					break;
				case 1:								// FARENHEIT
					res=round(var);
					break;
				case 2:								// KELVIN
					res=round(((var-32)/1.8f)+273.15f);
					break;
				default:
					break;
				}
				break;
			case 2:							// KELVIN
				switch (spin2pos) {
				case 0:								// CELSIUS
					res=round(var-273.15f);
					break;
				case 1:								// FARENHEIT
					res=round(((var-273.15f)*1.8f)+32);
					break;
				case 2:								// KELVIN
					res=round(var);
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
			return res;
		}
		
	/*	public double result2 (int spin1pos,int spin2pos)
		  {
			double res=0;
			switch (spin1pos) {
			case 0:							// CELSIUS
				switch (spin2pos) {
				case 0:								// CELSIUS
					res=round(var2);
					break;
				case 1:								// FARENHEIT
					res=round((var2-32)*0.5556f);
					break;
				case 2:								// KELVIN
					res=round(var2-273.15f);
					break;
				default:
					break;
				}
				break;
			case 1:							// FARENHEIT
				switch (spin2pos) {
				case 0:								// CELSIUS
					res=round((var2*1.8f)+32);
					break;
				case 1:								// FARENHEIT
					res=round(var2);
					break;
				case 2:								// KELVIN
					res=round(((var2-273.5f)*1.8f)+32);
					break;
				default:
					break;
				}
				break;
			case 2:							// KELVIN
				switch (spin2pos) {
				case 0:								// CELSIUS
					res=round(var2+273.15f);
					break;
				case 1:								// FARENHEIT
					res=round(((var2-32)/1.8f)+273.15f);
					break;
				case 2:								// KELVIN
					res=round(var2);
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
			return res;
		  }*/
	
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}
}
