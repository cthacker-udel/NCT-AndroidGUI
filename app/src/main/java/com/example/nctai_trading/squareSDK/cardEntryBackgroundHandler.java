package com.example.nctai_trading.squareSDK;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import sqip.CardDetails;
import sqip.CardEntryActivityCommand;
import sqip.CardNonceBackgroundHandler;

public class cardEntryBackgroundHandler implements CardNonceBackgroundHandler {
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
