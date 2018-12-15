package com.example.cn.contentpro.RxJava;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface NetBook {
//      GET ----------查找资源（查）
////    POST --------修改资源（改）
////    PUT ----------上传文件（增）
////    DELETE ----删除文件（删）
////    HEAD--------只请求页面的首部

    //    https://api.douban.com/v2/book/search?q=%E9%87%91%E7%93%B6%E6%A2%85&tag=&start=0&count=1
    @GET("book/search")
    Observable<BookInfo> Getsearch(@Query("q") String q,
                                   @Query("tag") String tag,
                                   @Query("start") String start,
                                   @Query("count") String count);

}
