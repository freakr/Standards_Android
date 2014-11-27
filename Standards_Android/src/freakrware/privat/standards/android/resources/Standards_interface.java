package freakrware.privat.standards.android.resources;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.telephony.SmsManager;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ToggleButton;

public interface Standards_interface {
	
	public Standards standard = new Standards();
    
	public class Standards{
		
		public Activity mActivity;
		public Context context;
		
		public void send_sms(String phoneNo, String sms)
		{
			
			try {
				SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(phoneNo, null, sms, null, null);
				Toast.makeText(context, "SMS Sent!",Toast.LENGTH_LONG).show();
			  } catch (Exception e) {
				Toast.makeText(context, "SMS faild, please try again later!",Toast.LENGTH_LONG).show();
				e.printStackTrace();
			  }
			
		}
		
		public void exception_catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		public boolean is_Wifi_active(){
			WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
			return wifiManager.isWifiEnabled();
		}
		public boolean Wifi_enable(){
			WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
			return wifiManager.setWifiEnabled(true);
		}
		public boolean Wifi_disable(){
			WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
			return wifiManager.setWifiEnabled(false);
		}
		
		public boolean is_Sound_active(){
			AudioManager myAudioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
			int ringermode = myAudioManager.getRingerMode();
			if(ringermode == AudioManager.RINGER_MODE_NORMAL || ringermode == AudioManager.RINGER_MODE_SILENT){
				return true;
			}else{
				return false;
			}
		}
		public void Sound_normal(){
			AudioManager myAudioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE); 
			myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		}
		public void Sound_silent(){
			AudioManager myAudioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE); 
			myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		}
		public void Sound_vibrate(){
			AudioManager myAudioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE); 
			myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
		}
		
		public void sleep(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		public void wait(Thread thread,int time){
			try {
				thread.wait(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		
		public Thread getThread( final String name ) {
		    if ( name == null )
		        throw new NullPointerException( "Null name" );
		    final Thread[] threads = getAllThreads( );
		    for ( Thread thread : threads )
		        if ( thread.getName( ).equals( name ) )
		            return thread;
		    return null;
		}
		
		public Thread[] getAllThreads( ) {
		    final ThreadGroup root = Thread.currentThread().getThreadGroup();
		    Thread[] threads = new Thread[ root.activeCount() ];
		    root.enumerate( threads, true);
		    
		    return threads;
		   
		}
		
		public void thread_rename(String name){
			Thread t = Thread.currentThread();
			t.setName(name + " - Thread");
	
		}
		public void set_Activity(Activity activity){
			this.mActivity = activity;
			this.context = this.mActivity.getBaseContext();
		}
		public LinearLayout newlinlayout(Activity activity, int orientation) {
			LinearLayout ll = new LinearLayout(activity);
			ll.setOrientation(orientation);
			return ll;
		}
		public LinearLayout newlinlayout(Activity activity, int orientation,int backcolor) {
			LinearLayout ll = new LinearLayout(activity);
			ll.setOrientation(orientation);
			ll.setBackgroundColor(backcolor);
			return ll;
		}
		public TextView newtextview(Activity activity, String text, int textsize, int color, int gravity) {
			TextView tv = new TextView(activity);
	        tv.setText(text);
	        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textsize);
	        tv.setTextColor(color);
	        tv.setGravity(gravity);
	        return tv;
		}
		public TextView newtextview(Activity activity, String text, int textsize, int gravity) {
			TextView tv = new TextView(activity);
	        tv.setText(text);
	        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textsize);
	        tv.setGravity(gravity);
	        return tv;
		}
		
		public View newdivider_hor(Activity activity, int size, int color) {
			View divider = new View(activity);
	        divider.setLayoutParams(new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, size));
	        divider.setBackgroundColor(color);
			return divider;
		}
		
		public View newdivider_vert(Activity activity, int size, int color) {
			View divider = new View(activity);
	        divider.setLayoutParams(new LayoutParams(size,LinearLayout.LayoutParams.MATCH_PARENT ));
	        divider.setBackgroundColor(color);
			return divider;
		}
		
		public ToggleButton newtoggbutt(Activity activity, String text,String texton, String textoff, int textsize, int gravity) {
			ToggleButton tb = new ToggleButton(activity);
	        tb.setText(text);
	        tb.setTextOn(texton);
	        tb.setTextOff(textoff);
	        tb.setPadding(10, 10, 10, 10);
	        tb.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textsize);
	        tb.setGravity(gravity);
			return tb;
		}
		public Button newbutton(Activity activity, String text, int textsize) {
			final Button b = new Button(activity);
			b.setText(text);
	    	b.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textsize);
	        return b;
		}
		public void set_Context(Context context) {
			this.context = context;
			
		}
		public void set_Color_ToggleButton(ToggleButton tb,int colortrue, int colorfalse) {
			if(tb.isChecked())
			{
				tb.setTextColor(Color.BLACK);
				tb.setBackgroundColor(colortrue);
			}
			else
			{
				tb.setTextColor(Color.WHITE);
				tb.setBackgroundColor(colorfalse);
			}
		}
		
		

}
}
