package test.rs.com.recyclerviewapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    List<String> list ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        getList();
    }




    private void getList()
    {
        List<test.rs.com.recyclerviewapplication.Worldpopulation.WorldpopulationBean> listData = new ArrayList<>();

//        listData.add("A");
//        listData.add("B");
//        listData.add("C");
//        listData.add("D");
//        listData.add("E");
//        listData.add("F");
//        listData.add("G");
//        listData.add("H");
//        listData.add("I");
//        listData.add("J");
//        listData.add("K");
//        listData.add("L");
//        listData.add("M");
//        listData.add("N");
//        listData.add("O");
//        listData.add("P");
//        listData.add("Q");
//        listData.add("R");
//        listData.add("S");
//        listData.add("T");
//        listData.add("U");
//        listData.add("V");
//        listData.add("W");
//        listData.add("X");
//        listData.add("Y");
//        listData.add("Z");
//
//        return listData;


        new AsyncTask<Void,String,String>(){

            @Override
            protected String doInBackground(Void... params) {


                try {
                    URL url = new URL("http://www.androidbegin.com/tutorial/jsonparsetutorial.txt");
                    HttpURLConnection con = (HttpURLConnection)url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    int responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                        br.close();
                    }
                      return sb.toString();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return null;
                }

            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);


                Gson gson = new Gson();
                Worldpopulation Worldpopulation = gson.fromJson(s , Worldpopulation.class);

                List<test.rs.com.recyclerviewapplication.Worldpopulation.WorldpopulationBean> listWorldPopulation = Worldpopulation.getWorldpopulation();
                RecyclerView.Adapter adapter = new DataAdapter(listWorldPopulation,MainActivity.this);
                recyclerView.setAdapter(adapter);
            }
        }.execute();

    }
}
