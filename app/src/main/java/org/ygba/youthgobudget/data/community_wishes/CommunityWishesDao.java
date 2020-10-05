package org.ygba.youthgobudget.data.community_wishes;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface CommunityWishesDao {
    @Insert
    void insertCommunityWish(CommunityWish communityWish);
}
