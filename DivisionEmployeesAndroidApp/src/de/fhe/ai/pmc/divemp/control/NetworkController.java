package de.fhe.ai.pmc.divemp.control;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 *  A central controller for all network-related stuff
 *
 *  This class uses the AsyncHttpClient library for Android -
 *  have a look at http://loopj.com/android-async-http/
 *
 *  Notice: The static BASE_URL String should be alter to reflect your
 *  actual server location!
 */
public class NetworkController
{
    private static final String BASE_URL = "http://192.168.1.105:8080/api";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void getDivisions( RequestParams params, AsyncHttpResponseHandler responseHandler )
    {
        client.get( BASE_URL + "/divisions", params, responseHandler );
    }
}
