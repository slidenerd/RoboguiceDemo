package slidenerd.vivz.roboguicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.inject.Inject;

import roboguice.service.RoboIntentService;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class DemoService extends RoboIntentService {

    @Inject
    private Square square;

    public DemoService() {
        super("Roboguice Demo Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        square.setSize(10.0F);
        Log.d("VIVZ", "Square size is " + square.size);
    }
}
