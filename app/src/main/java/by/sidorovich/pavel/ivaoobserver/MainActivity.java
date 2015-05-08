package by.sidorovich.pavel.ivaoobserver;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import by.sidorovich.pavel.ivaoobserver.state.NetworkState;
import by.sidorovich.pavel.ivaoobserver.status.IvaoStatusDownloader;
import by.sidorovich.pavel.ivaoobserver.status.NetworkStatus;

public class MainActivity extends Activity
{
    public ProgressDialog mProgressDialog;
    private NetworkStatus networkStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        prepareProgressDialog();

        networkStatus = (new IvaoStatusDownloader(this)).getNetworkStatus();
        showWarningMessage();

        if (networkStatus != null) {
            TextView warningMessageTv = (TextView) findViewById(R.id.warningMessage);
            warningMessageTv.setText(networkStatus.getWhazzupUrl());
        }

        (new NetworkState(this, networkStatus.getWhazzupUrl())).refresh();
    }

    private void prepareProgressDialog()
    {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Loading data from IVAO");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(true);
    }

    private void showWarningMessage()
    {
        String warningMessage = (networkStatus == null) ? getResources().getString(R.string.something_wrong)
                : networkStatus.getMessage();

        if (networkStatus != null) {
            String whazzupUrl = networkStatus.getWhazzupUrl();
            if (whazzupUrl.isEmpty() && warningMessage.isEmpty()) {
                warningMessage = getResources().getString(R.string.empty_whazzup_url);
            }
        }

        if (warningMessage.length() > 0) {
            TextView warningMessageTv = (TextView) findViewById(R.id.warningMessage);
            warningMessageTv.setText(warningMessage);
        }
    }
}
