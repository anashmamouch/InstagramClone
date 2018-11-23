package com.benzino.instagramclone;

import android.app.Application;

import com.parse.Parse;

/**
 * Created on 23/11/18.
 *
 * @author Anas
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("zdMPcnYfEcnAWDqeL0AyJKMmiWDhFnCCvuFtkx89")
                // if defined
                .clientKey("dhjwn3XFnEitUpyTEuswsCLOMXnkZtmFUZMHwNiH")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
