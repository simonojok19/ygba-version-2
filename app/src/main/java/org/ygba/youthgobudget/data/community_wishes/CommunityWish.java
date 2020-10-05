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

    public CommunityWish(String region, String district, String sector, String sub_county, String finacial_year, String service_point, String community_needs) {
        this.region = region;
        this.district = district;
        this.sector = sector;
        this.sub_county = sub_county;
        this.finacial_year = finacial_year;
        this.service_point = service_point;
        this.community_needs = community_needs;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSub_county() {
        return sub_county;
    }

    public void setSub_county(String sub_county) {
        this.sub_county = sub_county;
    }

    public String getFinacial_year() {
        return finacial_year;
    }

    public void setFinacial_year(String finacial_year) {
        this.finacial_year = finacial_year;
    }

    public String getService_point() {
        return service_point;
    }

    public void setService_point(String service_point) {
        this.service_point = service_point;
    }

    public String getCommunity_needs() {
        return community_needs;
    }

    public void setCommunity_needs(String community_needs) {
        this.community_needs = community_needs;
    }

    @Override
    public String toString() {
        return "CommunityWish{" +
                "primaryKey=" + primaryKey +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", sector='" + sector + '\'' +
                ", sub_county='" + sub_county + '\'' +
                ", finacial_year='" + finacial_year + '\'' +
                ", service_point='" + service_point + '\'' +
                ", community_needs='" + community_needs + '\'' +
                '}';
    }
}
