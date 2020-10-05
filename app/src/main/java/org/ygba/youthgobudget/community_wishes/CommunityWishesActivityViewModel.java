package org.ygba.youthgobudget.community_wishes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.ygba.youthgobudget.YGBARepository;
import org.ygba.youthgobudget.data.YGBDatabase;
import org.ygba.youthgobudget.data.community_wishes.CommunityWish;

public class CommunityWishesActivityViewModel extends AndroidViewModel {
    private YGBARepository ygbaRepository;
    public CommunityWishesActivityViewModel(@NonNull Application application) {
        super(application);
        ygbaRepository = YGBARepository.getInstance(YGBDatabase.getInstance(application.getApplicationContext()));
    }

    public void saveCommunityWish(CommunityWish communityWish) {
        ygbaRepository.saveCommunityWish(communityWish);
    }
}
