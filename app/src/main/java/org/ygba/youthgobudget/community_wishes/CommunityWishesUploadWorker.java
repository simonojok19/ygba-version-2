package org.ygba.youthgobudget.community_wishes;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;
import org.ygba.youthgobudget.YGBARepository;
import org.ygba.youthgobudget.data.YGBDatabase;
import org.ygba.youthgobudget.data.community_wishes.CommunityWish;
import org.ygba.youthgobudget.utils.Constants;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class CommunityWishesUploadWorker extends Worker {
    private YGBARepository ygbaRepository;
    public CommunityWishesUploadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        ygbaRepository = YGBARepository.getInstance(YGBDatabase.getInstance(context.getApplicationContext()));
    }

    @NonNull
    @Override
    public Result doWork() {
        private final String[] sectorList = {"Agriculture Sector", "Health Sector", "Education Sector"};
        try {
            List<CommunityWish> communityWishes = ygbaRepository.getCommunityWishes();
            for(CommunityWish communityWish: communityWishes) {
                String url = "";
                if (communityWish.getSector().equals(sectorList[0])) {
                    url = Constants.COMMUNITY_WISHES_AGRICULTURE_URL;
                } else if (communityWish.getSector().equals(sectorList[1])) {
                    url = Constants.COMMUNITY_WISHES_HEALTH_URL;
                } else if (communityWish.getSector().equals(sectorList[2])) {
                    url = Constants.COMMUNITY_WISHES_EDUCATION_URL;
                }
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST,
                        url,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d("Error", response.toString());
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("Error", error.toString());
                            }
                        }
                );
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return Result.retry();
    }
}
