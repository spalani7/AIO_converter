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

public class Distance_length extends Activity
{
	
	public float var1, var2;
	public String varStr1,varStr2;
	public boolean flag1=true,flag2=true;
	public static int precision =1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temperature);
	
		spinnerInit(R.array.Distance_array);
		
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
		
		public double result (float var, int spin1pos,int spin2pos)
		{
			double res=0;
			switch (spin1pos) {
			case 0:							// KM
				switch (spin2pos) {
				case 0:								// KM
					res=round(var);
					break;
				case 1:								// MILE
					res=round(var/1.609f);
					break;
				case 2:								// YARD
					res=round(var*1093.6f);
					break;
				case 3:								// FOOT
					res=round(var*3280.84f);
					break;
				case 4:								// INCH
					res=round(var*39370.08f);
					break;
				default:
					break;
				}
				break;
			case 1:							// MILE
				switch (spin2pos) {
				case 0:								// KM
					res=round(var*1.609f);
					break;
				case 1:								// MILE
					res=round(var);
					break;
				case 2:								// YARD
					res=round(var*1760);
					break;
				case 3:								// FOOT
					res=round(var*5280);
					break;
				case 4:								// INCH
					res=round(var*63360);
					break;
				default:
					break;
				}
				break;
			case 2:							// YARD
				switch (spin2pos) {
				case 0:								// KM
					res=round(var/1093.6f);
					break;
				case 1:								// MILE
					res=round(var/1760);
					break;
				case 2:								// YARD
					res=round(var);
					break;
				case 3:								// FOOT
					res=round(var*3);
					break;
				case 4:								// INCH
					res=round(var*36);
					break;
				default:
					break;
				}
				break;
			case 3:							// FOOT
				switch (spin2pos) {
				case 0:								// KM
					res=round(var/3280.84f);
					break;
				case 1:								// MILE
					res=round(var/5280);
					break;
				case 2:								// YARD
					res=round(var/3);
					break;
				case 3:								// FOOT
					res=round(var);
					break;
				case 4:								// INCH
					res=round(var*12);
					break;
				default:
					break;
				}
				break;
			case 4:							// INCH
				switch (spin2pos) {
				case 0:								// KM
					res=round(var/39370.08f);
					break;
				case 1:								// MILE
					res=round(var/63360);
					break;
				case 2:								// YARD
					res=round(var/36);
					break;
				case 3:								// FOOT
					res=round(var/12);
					break;
				case 4:								// INCH
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
		
		/*public double result2 (int spin1pos,int spin2pos)
		  {
			double res=0;
			switch (spin1pos) {
			case 0:							// KM
				switch (spin2pos) {
				case 0:								// KM
					res=round(var2);
					break;
				case 1:								// MILE
					res=round(var2*1.609f);
					break;
				case 2:								// YARD
					res=round(var2-273.15f);
					break;
				case 3:								// FOOT
					res=round(var2-273.15f);
					break;
				case 4:								// INCH
					res=round(var2-273.15f);
					break;
				default:
					break;
				}
				break;
			case 1:							// MILE
				switch (spin2pos) {
				case 0:								// KM
					res=round(var2/1.609f);
					break;
				case 1:								// MILE
					res=round(var2);
					break;
				case 2:								// YARD
					res=round(var2/1760);
					break;
				case 3:								// FOOT
					res=round(var2/5280);
					break;
				case 4:								// INCH
					res=round(var2/63360);
					break;
				default:
					break;
				}
				break;
			case 2:							// YARD
				switch (spin2pos) {
				case 0:								// KM
					res=round(var2);
					break;
				case 1:								// MILE
					res=round(var2*3);
					break;
				case 2:								// YARD
					res=round(var2);
					break;
				case 3:								// FOOT
					res=round(var2-273.15f);
					break;
				case 4:								// INCH
					res=round(var2-273.15f);
					break;
				default:
					break;
				}
				break;
			case 3:							// FOOT
				switch (spin2pos) {
				case 0:								// KM
					res=round(var2);
					break;
				case 1:								// MILE
					res=round((var2-32)*0.5556f);
					break;
				case 2:								// YARD
					res=round(var2-273.15f);
					break;
				case 3:								// FOOT
					res=round(var2);
					break;
				case 4:								// INCH
					res=round(var2-273.15f);
					break;
				default:
					break;
				}
				break;
			case 4:							// INCH
				switch (spin2pos) {
				case 0:								// KM
					res=round(var2*39370.08f);
					break;
				case 1:								// MILE
					res=round((var2-32)*0.5556f);
					break;
				case 2:								// YARD
					res=round(var2-273.15f);
					break;
				case 3:								// FOOT
					res=round(var2-273.15f);
					break;
				case 4:								// INCH
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
