package com.example.nctai_trading;

import android.content.Intent;

import com.coinbase.android.sdk.OAuth;
import com.coinbase.api.entity.OAuthTokensResponse;

public class CompleteAuthorizationTask {//extends RoboAsyncTask<OAuthTokensResponse> {
    private Intent mIntent;

    //public CompleteAuthorizationTask(Intent intent) {
    //    super(MainActivity.this);
    //    mIntent = intent;
    //}

    //@Override
    //public OAuthTokensResponse call() throws Exception {
    //    return OAuth.completeAuthorization(MainActivity.this, CLIENT_ID, CLIENT_SECRET, mIntent.getData());
    //}

    //@Override
    //public void onSuccess(OAuthTokensResponse tokens) {
    //    // Do something with the tokens
    //}

    //@Override
    //public void onException(Exception ex) {
    //    // Authorization failed for whatever reason
    //}
}

// In the activity containing the redirect intent filter:

    //@Override
    //protected void onNewIntent(final Intent intent) {
    //    if (intent != null && intent.getAction() != null && intent.getAction().equals("android.intent.action.VIEW")) {
    //        new CompleteAuthorizationTask(intent).execute();
    //    }
    //}