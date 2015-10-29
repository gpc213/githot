package com.knight.arch.api;

import com.knight.arch.model.AccessTokenResponse;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * @author andyiac
 * @date 15/10/23
 * @web http://blog.andyiac.com
 * @github https://github.com/andyiac
 */
public interface OAuthApiService {
    //POST https://github.com/login/oauth/access_token

    @Headers({
            "Accept: application/json"
    })
    @FormUrlEncoded
    @POST("/login/oauth/access_token")
    Observable<AccessTokenResponse> getOAuthToken(@Field("client_id") String client_id,
                                                  @Field("client_secret") String client_secret, @Field("code") String code);

    @Headers({
            "Content-Length: 0"
    })
    @PUT("/user/starred/{user}/{repo}")
    Observable<Object> starRepos(@Path("user") String user, @Path("repo") String repo,
                                 @Query(value = "access_token", encodeValue = true) String accessToken);

}