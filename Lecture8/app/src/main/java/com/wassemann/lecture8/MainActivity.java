package com.wassemann.lecture8;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class  MainActivity extends FragmentActivity
    implements HeadlinesFragment.OnHeadlineSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Kolla vilken layout används; om det är den med tom FrameLayout
        då måste vi lägga till ett fragment
        */


        if(findViewById(R.id.fragment_container) !=null) {

        /*
        Vi ska dock först kolla om activity återställts från
        ett tidigare läge; i så fall ska vi inte lägga till
        ett fragment - det finns redan ett i activity
        */

        if (savedInstanceState != null) {
            return;
        }

        // Annars, om inget fragment är inläst, skapa en
        HeadlinesFragment firstFragment = new HeadlinesFragment();
        firstFragment.setArguments(getIntent().getExtras());

        // Lägg till fragment i FrameLayout med id 'fragment_container'
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }

    }
    public void onArticleSelected(int position) {

        // Ta fram article fragment från activity layout
        ArticleFragment articleFrag = (ArticleFragment)
                getSupportFragmentManager().findFragmentById(R.id.article_fragment);
        articleFrag.updateArticleView(position);

        if (articleFrag != null) {

            // Om det finns ett article fragment tillgängligt
            // då är vi i två-panel layout...
            // ArticleFragment uppdaterar sitt innehåll
            articleFrag.updateArticleView(position);
        }else {

            // Vi är i en-panel layout och måste swap-a fragments
            // Skapa fragment och skicka ett argument med id för vald artikel
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction =
                    getSupportFragmentManager().beginTransaction();

            // Läs in detta fragment i fragment_container view
            // och lägg transaktionen på stack (för att kunna gå tillbaka)
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Utför transaction
            transaction.commit();
        }
    }

}
