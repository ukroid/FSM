import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import com.example.android.fsm.BuildConfig;
import com.example.android.fsm.MainActivity;
import com.example.android.fsm.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by artem on 25.04.2017.
 */

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void validateTextView() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        TextView currentState = (TextView) activity.findViewById(R.id.current_status);

        assertNotNull("TextView could not be found", currentState);

    }





}
