package com.example.option_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();
        clickListner();

    }

    private void clickListner() {

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu menu = new PopupMenu(MainActivity.this, btnClick);

                menu.getMenuInflater().inflate(R.menu.menu_bar, menu.getMenu());

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.itm1) {
                            Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                menu.show();
            }

        });
    }

    private void binding() {
        btnClick = findViewById(R.id.btnClick);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // MenuInflater inflater =;
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.itm1) {
            Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.itm2) {
            Toast.makeText(MainActivity.this, "Delet", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.itm3) {
            Toast.makeText(MainActivity.this, "Block", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}