package by.sidorovich.pavel.ivaoobserver;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity
{
    IvaoStatus ivaoStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ivaoStatus = new IvaoStatus(getPreferences(MODE_PRIVATE));
    }
}
