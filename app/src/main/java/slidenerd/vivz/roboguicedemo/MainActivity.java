package slidenerd.vivz.roboguicedemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import com.google.inject.Inject;

import roboguice.activity.RoboActionBarActivity;
import roboguice.activity.event.OnResumeEvent;
import roboguice.event.Observes;
import roboguice.inject.ContentView;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActionBarActivity {
    @InjectView(R.id.square1)
    private View square1;
    @InjectView(R.id.square2)
    private View square2;
    @InjectView(R.id.square3)
    private View square3;
    @Inject
    private Shape square;
    @Inject
    private AlarmManager alarmManager;

    @InjectResource(R.anim.scale)
    private Animation scale1;
    @InjectResource(R.anim.scale)
    private Animation scale2;
    @InjectResource(R.anim.scale)
    private Animation scale3;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

//            square.setSize(square1.getWidth());
            Toast.makeText(MainActivity.this, "Area of the square is " + square.getArea(), Toast.LENGTH_LONG).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scale1.setStartOffset(100);
        scale2.setStartOffset(200);
        scale3.setStartOffset(300);
        square1.setAnimation(scale1);
        square2.setAnimation(scale2);
        square3.setAnimation(scale3);
        square1.post(runnable);
        runService();

    }

    public void runOnResume(@Observes OnResumeEvent event) {
        Toast.makeText(MainActivity.this, "onResume", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void runService() {
        Intent intent = new Intent(this, DemoService.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, 1000, 5000, pendingIntent);
    }
}
