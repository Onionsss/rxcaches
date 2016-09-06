package onionsss.it.retrofitrxjava;

import com.cpoopc.retrofitrxcache.RxCacheResult;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 作者：张琦 on 2016/9/6 21:02
 */
public interface Api {

    /**
     * 返回的observable
     * @return
     */
    @GET("/api/v1.0/news/refresh")
    Observable<RxCacheResult<NewsList>> refreshNews();
}
