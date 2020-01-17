package com.gzeinnumer.scanba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gzeinnumer.scanba.model.ResponsePlat;
import com.gzeinnumer.scanba.network.RetroServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageActivity extends AppCompatActivity {

    public static final String DATA = "data";
    public String noBa;
    private TextView tvPlat, tvPesan;
    private Button btnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        btnScan = findViewById(R.id.btn_scan_again);
        tvPlat = findViewById(R.id.tv_plat);
        tvPesan = findViewById(R.id.tv_pesan);

        noBa = getIntent().getStringExtra(DATA);

        tvPlat.setText(noBa);
        RetroServer.getInstance().getIzin(noBa).enqueue(new Callback<ResponsePlat>() {
            @Override
            public void onResponse(Call<ResponsePlat> call, Response<ResponsePlat> response) {
                if (response.isSuccessful()){
                    if(response.body().getResult().size()>0){
                        if (response.body().getResult().get(0).getStatus().equals("1")){
                            tvPesan.setText("Diizinkan ");
                        } else {
                            tvPesan.setText("Tidak di izinkan");
                        }
                    } else{
                        tvPesan.setText("Tidak di izinkan");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponsePlat> call, Throwable t) {
                Toast.makeText(MessageActivity.this, "Error : "+ t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() { }
}
