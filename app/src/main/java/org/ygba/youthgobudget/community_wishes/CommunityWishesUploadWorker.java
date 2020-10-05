package org.ygba.youthgobudget.community_wishes;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.ygba.youthgobudget.YGBARepository;
import org.ygba.youthgobudget.data.YGBDatabase;
import org.ygba.youthgobudget.data.community_wishes.CommunityWish;

import java.util.List;

public class CommunityWishesUploadWorker extends Worker {
    private YGBARepository ygbaRepository;
    public CommunityWishesUploadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        ygbaRepository = YGBARepository.getInstance(YGBDatabase.getInstance(context.getApplicationContext()));
    }

    @NonNull
    @Override
    public Result doWork() {
        List<CommunityWish> communityWishes = ygbaRepository.getCommunityWishes();
        return null;
    }
}
