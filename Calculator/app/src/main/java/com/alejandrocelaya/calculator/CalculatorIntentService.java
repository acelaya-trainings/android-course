package com.alejandrocelaya.calculator;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by cta on 29/04/2015.
 */
public class CalculatorIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public CalculatorIntentService() {
        super(CalculatorIntentService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
