package de.fhe.ai.pmc.divemp.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.loopj.android.http.JsonHttpResponseHandler;
import de.fhe.ai.pmc.divemp.R;
import de.fhe.ai.pmc.divemp.control.NetworkController;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DivisionList extends Activity
{
    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        NetworkController.getDivisions( null, new JsonHttpResponseHandler(  ) {

            @Override
            public void onSuccess( JSONArray response )
            {
                List<String> divisionNames = new ArrayList<String>();

                try
                {
                    for( int i = 0; i < response.length(); i++ )
                    {
                        JSONObject division = response.getJSONObject( i );

                        divisionNames.add( division.getString( "name" ) );
                    }
                }
                catch ( JSONException e )
                {
                    e.printStackTrace();
                }

                updateListAdapter( divisionNames );

            }
        });

    }

    /**
     * Internal method which exchanges the list views adapter to
     * reflect a changed data source, e.g. a new list of division names
     *
     * @param divisionNames the new data source for our list view
     */
    private void updateListAdapter( List<String> divisionNames )
    {
        ListView divisionListView = (ListView)findViewById( R.id.list );

        ArrayAdapter<String> divisionAdapter =
                new ArrayAdapter<String>( getApplicationContext(),
                        R.layout.list_item, divisionNames );

        divisionListView.setAdapter( divisionAdapter );
    }
}
