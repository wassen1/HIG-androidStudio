package com.wassemann.lecture81;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class MainActivity extends FragmentActivity
implements HeadlinesFragment.OnHeadlineSelectedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onArticleSelected(int position) {

        ArticleFragment af = (ArticleFragment)
                getFragmentManager().findFragmentById(R.id.article_fragment);
        af.updateArticleView(position);

        TranslateFragment tf = (TranslateFragment)
                getFragmentManager().findFragmentById(R.id.translate_fragment);
        tf.updateArticleView(position);







    }
}
