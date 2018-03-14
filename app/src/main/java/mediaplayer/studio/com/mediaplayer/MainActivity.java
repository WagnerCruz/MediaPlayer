package mediaplayer.studio.com.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = findViewById(R.id.botaoPlayID);
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.ozone);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer.isPlaying()){
                    pausar();
                }else{
                    tocar();
                }

            }
        });

    }

    private void tocar(){

        if (mediaPlayer != null){
            mediaPlayer.start();
            botao.setText("Pausar");
        }

    }

    private void pausar(){

        if(mediaPlayer != null){
            mediaPlayer.pause();
            botao.setText("Tocar");
        }
    }

    protected void onDestroy() {

        if(mediaPlayer != null & mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;

        }

        super.onDestroy();
    }
}
