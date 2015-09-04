package slidenerd.vivz.roboguicedemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private View square1;
    private View square2;
    private View square3;
    private Square square;
    private AlarmManager alarmManager;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            square = new Square();
            square.setSize(square1.getWidth());

            Toast.makeText(MainActivity.this, "Size of the square is " + square.size, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        square1 = findViewById(R.id.square1);
        square2 = findViewById(R.id.square2);
        square3 = findViewById(R.id.square3);

        Animation scale1 = AnimationUtils.loadAnimation(this, R.anim.scale);
        Animation scale2 = AnimationUtils.loadAnimation(this, R.anim.scale);
        Animation scale3 = AnimationUtils.loadAnimation(this, R.anim.scale);

        scale1.setStartOffset(100);
        scale2.setStartOffset(200);
        scale3.setStartOffset(300);

        square1.setAnimation(scale1);
        square2.setAnimation(scale2);
        square3.setAnimation(scale3);

        square1.post(runnable);

        runService();

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
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, DemoService.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, 1000, 5000, pendingIntent);
    }
}
