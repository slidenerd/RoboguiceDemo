package slidenerd.vivz.roboguicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class DemoService extends IntentService {

    private Square square;

    public DemoService() {
        super("Roboguice Demo Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        square = new Square();
        square.setSize(10.0F);
        Log.d("VIVZ", "Square size is " + square.size);
    }
}
