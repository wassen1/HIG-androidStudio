package com.wassemann.lecture81;

import android.widget.TextView;


public class ArticleFragment extends AnyTextFragment {

    @Override
    public void updateArticleView(int position) {
        TextView article = (TextView) getActivity().findViewById(R.id.article);
        article.setText(Ipsum.Articles[position]);

        //TextView translate = (TextView) getActivity().findViewById(R.id.textView_translation);
       // translate.setText(Ipsum.Translates[position]);
        mCurrentPosition = position;
    }


}
