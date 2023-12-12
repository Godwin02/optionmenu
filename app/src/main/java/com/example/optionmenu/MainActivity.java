package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int SETTINGS_ID=R.id.settings;
    public static final int ABOUT_ID=R.id.about;
    public static final int MESSAGE_ID=R.id.message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attach the click listener to the button to show the PopupMenu
        View button = findViewById(R.id.anchorView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    // Method to show the PopupMenu
    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popupMenu.getMenu());

        // Set item click listener for the PopupMenu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle menu item click
                if (item.getItemId() == R.id.settings) {
                    Intent intent = new Intent(MainActivity.this, SettingsPage.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.about) {
                    Toast.makeText(MainActivity.this, "You clicked About Option", Toast.LENGTH_LONG).show();

                } else if (item.getItemId() == R.id.message) {
                    Toast.makeText(MainActivity.this, "You Clicked Starred Messages", Toast.LENGTH_LONG).show();

                }

                return false;
            }
        });
                // Show the PopupMenu
                popupMenu.show();
            }
        }


