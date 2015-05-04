package com.alejandrocelaya.localservice;

import android.os.Binder;

/**
 * Created by cta on 04/05/2015.
 */
public class MainBinder extends Binder {

    private MainService service;

    public MainBinder(MainService service) {
        this.service = service;
    }

    public MainService getService() {
        return service;
    }

    public void setService(MainService service) {
        this.service = service;
    }
}
