package com.rol.zakat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;

public class home_page extends AppCompatActivity {
    private CardView personal, organization, rules, hadis, about, update, apps;
    Vibrator vibrator;

    AlertDialog.Builder alertdialog;
    AppUpdateManager appUpdateManager;

    private static final int MY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        checkAppUpdate();

        personal = findViewById(R.id.personal);
        organization = findViewById(R.id.organizartion);
        rules = findViewById(R.id.rules);
        hadis = findViewById(R.id.hadis);
        about = findViewById(R.id.about);
        apps = findViewById(R.id.apps);
        update = findViewById(R.id.update);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);
                Intent i = new Intent(home_page.this, personal_zakat.class);
                startActivity(i);
            }
        });

        organization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);
                Intent i = new Intent(home_page.this, organizational_zakat.class);
                startActivity(i);
            }
        });

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);
                Intent i = new Intent(home_page.this, rules.class);
                startActivity(i);
            }
        });

        hadis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(100);
                Intent h = new Intent(home_page.this, hadispage.class);
                startActivity(h);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);
                Intent i = new Intent(home_page.this, about.class);
                startActivity(i);
            }
        });

        apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);
                Uri uri = Uri.parse("https://republic-of-legends.netlify.app/appgallery");
                Intent u = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(u);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);
                alertdialog = new AlertDialog.Builder(home_page.this);
                alertdialog.setTitle("আপডেট");
                alertdialog.setMessage("আপনি কি অ্যাপটি আপডেট করতে চান?");
                alertdialog.setIcon(R.drawable.baseline_download_24);

                alertdialog.setPositiveButton("হ্যাঁ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Uri uri = Uri.parse("https://republic-of-legends.netlify.app/appgallery/amarzakat");
                        Intent u = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(u);

                        checkAppUpdate();
                    }
                });

                alertdialog.setNegativeButton("না", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = alertdialog.create();

                dialog.show();




            }
        });
    }


    private void checkAppUpdate (){
        appUpdateManager = AppUpdateManagerFactory.create(this);

        // Returns an intent object that you use to check for an update.
        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();

        // Checks that the platform will allow the specified type of update.
        appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    // This example applies an immediate update. To apply a flexible update
                    // instead, pass in AppUpdateType.FLEXIBLE
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {
                // Request the update.
                try {
                    appUpdateManager.startUpdateFlowForResult(
                            // Pass the intent that is returned by 'getAppUpdateInfo()'.
                            appUpdateInfo
                            // an activity result launcher registered via registerForActivityResult
                            ,AppUpdateType.FLEXIBLE, home_page.this,
                            // Or pass 'AppUpdateType.FLEXIBLE' to newBuilder() for
                            // flexible updates.
                            MY_REQUEST_CODE);
                } catch (IntentSender.SendIntentException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Before starting an update, register a listener for updates.
        appUpdateManager.registerListener(listener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == MY_REQUEST_CODE) {
            if (resultCode != RESULT_OK) {
                Log.d("msg","Update flow failed! Result code: " + resultCode);
                // If the update is cancelled or fails,
                // you can request to start the update again.
            }
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        // When status updates are no longer needed, unregister the listener.
        appUpdateManager.unregisterListener(listener);
    }

    InstallStateUpdatedListener listener = state -> {
        if (state.installStatus() == InstallStatus.DOWNLOADED) {
            // After the update is downloaded, show a notification
            // and request user confirmation to restart the app.
            popupSnackbarForCompleteUpdate();
        }
    };

    // Displays the snackbar notification and call to action.
    private void popupSnackbarForCompleteUpdate() {
        Snackbar snackbar =
                Snackbar.make(
                        findViewById(android.R.id.content),
                        "An update has just been downloaded.",
                        Snackbar.LENGTH_INDEFINITE);

        snackbar.setAction("RESTART", view -> appUpdateManager.completeUpdate());
        snackbar.setActionTextColor(
                getResources().getColor(android.R.color.holo_blue_bright));
        snackbar.show();
    }




}