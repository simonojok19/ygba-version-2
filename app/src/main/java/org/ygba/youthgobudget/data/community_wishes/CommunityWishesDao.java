package org.ygba.youthgobudget.data.community_wishes;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CommunityWishesDao {
    @Insert
    void insertCommunityWish(CommunityWish communityWish);

    @Query("SELECT * FROM " + CommunityWishConstants.TABLE_NAME)
    List<CommunityWish> getCommunityWishesForUploaded();
}
