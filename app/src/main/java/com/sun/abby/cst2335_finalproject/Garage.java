package com.sun.abby.cst2335_finalproject;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

/**
 * Class Garage to execute all the actives include: allow the user to open / close the door,
 * and turn on a light. Opening the garage door should also turn on the light automatically.
 * The user should be able to turn the light on and off afterwards.
 * @version 1.0.0
 * @author Yun Luo
 */
public class Garage extends AppCompatActivity {
    /**
     * ToggleButton object t1
     * ToggleButton object t2
     */
    ToggleButton t1, t2;

    @Override
    /**
     * This method to initilize the Garage activity
     * @param savedInstanceState Bundle object
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);

        t1 = (ToggleButton)findViewById(R.id.toggleButton_light);
        t2 =(ToggleButton)findViewById(R.id.toggleButton_door);
    }// end of onCreate

    /**
     * This method is to click to turn on/off garage light
     * @param view View object
     */
 public void lightClick(View view) {
     boolean on = ((ToggleButton) view).isChecked();
     ImageView iView = (ImageView) findViewById(R.id.lightOnOff);
     if (on) {
         on = false;
         iView.setImageResource(R.drawable.lighton);
     } else {
         on = true;
         iView.setImageResource(R.drawable.lightoff);
     }

 }// end of lightClick

    /**
     * This method is to click button and turn on/off the garage door
     * @param v View object
     */
    public void doorClick (View v){
        boolean on = ((ToggleButton) v).isChecked();
        ImageView iView = (ImageView) findViewById(R.id.doorOpenClosed);
        ImageView iViewLight = (ImageView) findViewById(R.id.lightOnOff);
        if (on) {
            on = false;
            iView.setImageResource(R.drawable.dooropen);
            iViewLight.setImageResource(R.drawable.lighton);

        } else {
            on = true;
            iView.setImageResource(R.drawable.doorclosed);
            iViewLight.setImageResource(R.drawable.lightoff);
        }

    }// end of doorClick

// menu bar

    /**
     * This method to initialize the toolbar item
     * @param m Menu object
     * @return true
     */
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.toolbar_garage, m);
        return true;

    }

    /**
     * This method to pass the menu item has been selected. In this function, when user click on toolbar icon
     * will be asked if go back to Main Menu.
     * @param mi MenuItem mi
     * @return true
     */
    public boolean onOptionsItemSelected(MenuItem mi) {
        int id = mi.getItemId();
        switch (id) {
            case R.id.garage_goback:
                Log.d("Toolbar", "Option 1 selected");
              //  Snackbar.make(getWindow().getDecorView(), "Go back menu has been selected", Snackbar.LENGTH_LONG)
                //       .setAction("Action", null).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(Garage.this);
                builder.setTitle("Do you want to go Main Menu?");
                // Add the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        finish();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.cancel();

                    }
                });
                // Create the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();

                break;

        }// end of switch
        return true;
    }//onOptionsItemSelected


}// end of Garage class
