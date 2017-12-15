package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/12 0012.
 */

public class HotelDetailRoomEntity extends BaseRemote {

    /**
     * info : {"policy":[{"key_name":"建筑面积","key_value":"10~15平方米"},{"key_name":"楼层","key_value":"1-6层"}],"facilities":[{"key_name":"入离时间","key_value":"入住时间：14:00以后        离店时间：12:00以前"},{"key_name":"早餐说明","key_value":"单早20元     双早35元"}]}
     */

    private InfoBean info;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        private List<PolicyBean> policy;
        private List<FacilitiesBean> facilities;

        public List<PolicyBean> getPolicy() {
            return policy;
        }

        public void setPolicy(List<PolicyBean> policy) {
            this.policy = policy;
        }

        public List<FacilitiesBean> getFacilities() {
            return facilities;
        }

        public void setFacilities(List<FacilitiesBean> facilities) {
            this.facilities = facilities;
        }

        public static class PolicyBean {
            /**
             * key_name : 建筑面积
             * key_value : 10~15平方米
             */

            private String key_name;
            private String key_value;

            public String getKey_name() {
                return key_name;
            }

            public void setKey_name(String key_name) {
                this.key_name = key_name;
            }

            public String getKey_value() {
                return key_value;
            }

            public void setKey_value(String key_value) {
                this.key_value = key_value;
            }
        }

        public static class FacilitiesBean {
            /**
             * key_name : 入离时间
             * key_value : 入住时间：14:00以后        离店时间：12:00以前
             */

            private String key_name;
            private String key_value;

            public String getKey_name() {
                return key_name;
            }

            public void setKey_name(String key_name) {
                this.key_name = key_name;
            }

            public String getKey_value() {
                return key_value;
            }

            public void setKey_value(String key_value) {
                this.key_value = key_value;
            }
        }
    }
}
