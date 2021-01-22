package com.example.nctai_trading;

import java.io.IOException;

import sqip.CardDetails;
import sqip.CardEntryActivityCommand;
import sqip.CardNonceBackgroundHandler;

public class CardEntryBackgroundHandler implements CardNonceBackgroundHandler {

    @Override
    public CardEntryActivityCommand handleEnteredCardInBackground(CardDetails cardDetails) {
        try{
            // TODO: Call backend service
            throw new IOException("Thrown IOException");
            // MyBackendServiceResponse response = myBackendService(cardDetails.getNonce());
            /*
            if (response.isSuccessful()) {
         return new CardEntryActivityCommand.Finish();
            } else {
         return new CardEntryActivityCommand.ShowError(response.errorMessage)
      }
    } catch(IOException exception) {
       return new CardEntryActivityCommand.ShowError(
             resources.getString(R.string.network_failure));
    }
             */
        }
        catch(IOException exception){
            //return new CardEntryActivityCommand.ShowError(resources.getString(R.string.network_failure));
            System.out.println(exception.getStackTrace());
            return new CardEntryActivityCommand.Finish();
        }
    }
}
