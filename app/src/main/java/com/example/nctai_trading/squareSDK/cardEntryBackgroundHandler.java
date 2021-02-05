package com.example.nctai_trading.squareSDK;

import android.content.res.Resources;

import org.jetbrains.annotations.NotNull;

import sqip.CardDetails;
import sqip.CardEntryActivityCommand;
import sqip.CardNonceBackgroundHandler;

public class cardEntryBackgroundHandler implements CardNonceBackgroundHandler {

    private final ChargeCall.Factory chargeCallFactory;
    private final Resources resources;


    public cardEntryBackgroundHandler(ChargeCall.Factory chargeCallFactory, Resources resources){
        this.chargeCallFactory = chargeCallFactory;
        this.resources = resources;
    }

    @NotNull
    @Override
    public CardEntryActivityCommand handleEnteredCardInBackground(@NotNull CardDetails cardDetails) {



        try{
            // TODO : Call your backend service
            // MyBackendServiceResponse response = // myBackendService(cardDetails.getNonce());....

            // if(response.isSuccessful()){
            //      return new CardEntryActivityCommand.Finish();
            // }
            //  else{
            //      return new CardEntryActivityCommand.ShowError(response.errorMessage);
            //  }
        }
        catch(Exception e){
            return new CardEntryActivityCommand.ShowError("NetWork Failure");
        }
        return new CardEntryActivityCommand.Finish();
    }
}
