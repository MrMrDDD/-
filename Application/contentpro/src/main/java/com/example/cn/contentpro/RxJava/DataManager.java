package com.example.cn.contentpro.RxJava;

import rx.Observable;

public class DataManager {
    private NetBook mNetBook;

    public DataManager() {
        this.mNetBook = RetrofitHelper.getInstance().getNetBook();
    }

    /**
     * 获取数据结果
     * @param q
     * @param tag
     * @param start
     * @param count
     * @return
     */
    public Observable<BookInfo> Getsearch(String q,
                                          String tag,
                                          String start,
                                          String count) {

        return mNetBook.Getsearch(q, tag, start, count);
    }
}
