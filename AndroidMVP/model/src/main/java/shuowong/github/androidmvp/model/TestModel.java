package shuowong.github.androidmvp.model;

import java.util.List;

/**
 * Created by WANGSHUO on 11/25/15.
 */
public class TestModel implements IModel{


    /**
     * orgId : orgId
     * orgName : orgName
     */

    private OrgEntity org;
    /**
     * appcode : 55
     * subscode : subscode0
     */

    private List<BizEntity> biz;

    public void setOrg(OrgEntity org) {
        this.org = org;
    }

    public void setBiz(List<BizEntity> biz) {
        this.biz = biz;
    }

    public OrgEntity getOrg() {
        return org;
    }

    public List<BizEntity> getBiz() {
        return biz;
    }

    public static class OrgEntity {
        private String orgId;
        private String orgName;

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public String getOrgId() {
            return orgId;
        }

        public String getOrgName() {
            return orgName;
        }
    }

    public static class BizEntity {
        private int appcode;
        private String subscode;

        public void setAppcode(int appcode) {
            this.appcode = appcode;
        }

        public void setSubscode(String subscode) {
            this.subscode = subscode;
        }

        public int getAppcode() {
            return appcode;
        }

        public String getSubscode() {
            return subscode;
        }
    }
}
