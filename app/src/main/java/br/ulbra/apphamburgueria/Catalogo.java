package br.ulbra.apphamburgueria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Catalogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogo);

        TextView catalogTitle = findViewById(R.id.textView2);
        TextView appTitle = findViewById(R.id.textView6);
        TextView burgerSection = findViewById(R.id.textView7);
        TextView cheeseburgerDesc = findViewById(R.id.textView12);
        TextView baconBurgerDesc = findViewById(R.id.textView14);
        TextView bbqBurgerDesc = findViewById(R.id.textView16);
        TextView veggieBurgerDesc = findViewById(R.id.textView15);
        TextView drinksSection = findViewById(R.id.textView18);
        TextView cocaColaDesc = findViewById(R.id.textView19);
        TextView waterDesc = findViewById(R.id.textView21);
        TextView coffeeDesc = findViewById(R.id.textView23);
        TextView juiceDesc = findViewById(R.id.textView24);

        ImageView cheeseburgerImage = findViewById(R.id.imageView);
        ImageView baconImage = findViewById(R.id.imageView2);
        ImageView veggieImage = findViewById(R.id.imageView3);
        ImageView bbqImage = findViewById(R.id.imageView5);
        ImageView cocaColaImage = findViewById(R.id.imageView6);
        ImageView waterImage = findViewById(R.id.imageView7);
        ImageView coffeeImage = findViewById(R.id.imageView8);
        ImageView juiceImage = findViewById(R.id.imageView9);

        Button btWhatsapp = findViewById(R.id.btwhatsapp);
        btWhatsapp.setOnClickListener(view -> {
            String numeroWhatsapp = "5511999999999";
            String mensagem = "Olá, gostaria de fazer um pedido!";
            String url = "https://wa.me/" + numeroWhatsapp + "?text=" + Uri.encode(mensagem);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });
    }
}
