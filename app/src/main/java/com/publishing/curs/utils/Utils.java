package com.publishing.curs.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Completable;

public class Utils {
    public static String urlByIsbn(String isbn) {
        if (isbn == null) return "";
        String formattedIsbn = isbn.replaceAll("-", "");
        return "https://pictures.abebooks.com/isbn/" +
                formattedIsbn +
                "-us.jpg";
    }

    public static Completable randomDelayCompletable() {
        return Completable.complete()
                .delay(100 + new Random().nextInt(1000), TimeUnit.MILLISECONDS);
    }
}
