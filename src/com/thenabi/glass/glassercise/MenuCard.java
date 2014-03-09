package com.thenabi.glass.glassercise;

import android.content.Context;
import android.content.Intent;
import com.google.android.glass.app.Card;

/**
 * Created with IntelliJ IDEA.
 * User: abdul.nabi
 * Date: 12/26/13
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuCard extends Card {
    private Enum id;
    private Intent selectedIntent;


    public MenuCard(Context context) {
        super(context);
    }

    /**
     *
     * @param context
     * @param anID
     */
    public MenuCard(Context context, Enum anID) {
        this(context);
        id = anID;
    }

    public Enum getId() {
        return id;
    }

    public void setId(Enum id) {
        this.id = id;
    }

}
