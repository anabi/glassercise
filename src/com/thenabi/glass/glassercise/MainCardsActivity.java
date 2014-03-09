package com.thenabi.glass.glassercise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.AdapterView;
import com.google.android.glass.app.Card;
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.view.MenuUtils;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainCardsActivity extends Activity {

    private static final int START_CARD_INDEX = 3;

    private List<Card> mCards;
    private CardScrollView mCardScrollView;

    Class[] menuActivies = {SettingsActivity.class };

    enum menu_item_id {
        SETTINGS,
        TIPS,
        HISTORY,
        TODAYS_WORKOUT,
        MY_WORKOUTS,
        WORKOUT_LIBRARY
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createCards();

        mCardScrollView = new CardScrollView(this);
        mCardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Long i = new Long(id);
               Log.d("SELECTED ID: ", i.toString());
            }
        });

        MainLevelCardScrollAdapter adapter = new MainLevelCardScrollAdapter();
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        mCardScrollView.setSelection(START_CARD_INDEX);
        setContentView(mCardScrollView);
    }

    private void createCards() {
        mCards = new ArrayList<Card>();

        Card card;

        card = new MenuCard(this, menu_item_id.SETTINGS);
        card.setText(R.string.main_card_title_settings);
        // card.setFootnote("");
        // card.addImage(R.drawable.ic_printer_ink_levels);
        mCards.add(card);

        card = new MenuCard(this, menu_item_id.TIPS);
        card.setText(R.string.main_card_title_tips);
        // card.setFootnote("");
        // card.addImage(R.drawable.ic_printer_ink_levels);
        mCards.add(card);

        card = new MenuCard(this, menu_item_id.HISTORY);
        card.setText(R.string.main_card_title_history);
        // card.setFootnote("");
        // card.addImage(R.drawable.ic_printer_ink_levels);
        mCards.add(card);


        card = new MenuCard(this, menu_item_id.TODAYS_WORKOUT);
        card.setText(R.string.main_card_title_todays_workout);
        // card.setFootnote("");
        // card.addImage(R.drawable.ic_printer_ink_levels);
        mCards.add(card);

        card = new MenuCard(this, menu_item_id.MY_WORKOUTS);
        card.setText(R.string.main_card_title_my_workouts);
        // card.setFootnote("");
        // card.addImage(R.drawable.ic_printer_ink_levels);
        mCards.add(card);

        card = new MenuCard(this, menu_item_id.WORKOUT_LIBRARY);
        card.setText(R.string.main_card_title_workout_library);
        // card.setFootnote("");
        // card.addImage(R.drawable.ic_printer_ink_levels);
        mCards.add(card);

    }

    private class MainLevelCardScrollAdapter extends CardScrollAdapter {
        @Override
        public int findIdPosition(Object id) {
            return -1;
        }

        @Override
        public int findItemPosition(Object item) {
            return mCards.indexOf(item);
        }

        @Override
        public int getCount() {
            return mCards.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return (View) mCards.get(position).toView();
        }

        @Override
        public Object getItem(int position) {
            return mCards.get(position);
        }

    }

}