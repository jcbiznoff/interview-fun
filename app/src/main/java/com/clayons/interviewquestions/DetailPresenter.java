package com.clayons.interviewquestions;

/**
 * Created by pranavbhalla on 11/19/15.
 */
public class DetailPresenter {

    private final DetailModel mModel;
    private final DetailView mView;

    public DetailPresenter(DetailModel mModel, DetailView mView) {
        this.mModel = mModel;
        this.mView = mView;
    }

    public void onCreate(DetailActivity detailActivity) {
        mModel.onCreate(detailActivity);
        mView.onCreate(detailActivity);
    }

    public void onResume(DetailActivity detailActivity) {
        render();
    }

    private void render() {
        mView.drawPerson(mModel.getPerson());
    }
}
