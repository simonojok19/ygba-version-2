package org.ygba.youthgobudget.data.community_wishes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = CommunityWishConstants.TABLE_NAME)
public class CommunityWish {
    @ColumnInfo(name = CommunityWishConstants.PRIMARY_KEY)
    @PrimaryKey(autoGenerate = true)
    private  int primaryKey;

    @ColumnInfo(name = CommunityWishConstants.REGION)
    private String region;

    @ColumnInfo(name = CommunityWishConstants.DISTRICT)
    private String district;

    @ColumnInfo(name = CommunityWishConstants.SECTOR)
    private String sector;

    @ColumnInfo(name = CommunityWishConstants.SUB_COUNTY)
    private String sub_county;

    @ColumnInfo(name = CommunityWishConstants.FINANCIAL_YEAR)
    private String finacial_year;

    @ColumnInfo(name = CommunityWishConstants.SERVICE_POINT)
    private String service_point;

    @ColumnInfo(name = CommunityWishConstants.COMMUNITY_NEEDS)
    private String community_needs;

}
