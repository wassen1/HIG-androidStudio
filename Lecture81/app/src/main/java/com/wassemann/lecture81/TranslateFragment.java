package com.wassemann.lecture81;

import android.widget.TextView;

/**
 * Created by wassen on 2017-12-06.
 */

public class TranslateFragment extends AnyTextFragment {
    @Override
    public void updateArticleView(int position) {
        TextView translate = (TextView) getActivity().findViewById(R.id.translate_view);
        translate.setText(Ipsum.Translates[position]);
        mCurrentPosition = position;
    }
}
