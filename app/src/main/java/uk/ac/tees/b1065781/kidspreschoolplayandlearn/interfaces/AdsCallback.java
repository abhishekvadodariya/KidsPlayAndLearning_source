package uk.ac.tees.b1065781.kidspreschoolplayandlearn.interfaces;

public interface AdsCallback {

    void adLoadingFailed();

    void adClose();

    void startNextScreen();

    void onLoaded();
}