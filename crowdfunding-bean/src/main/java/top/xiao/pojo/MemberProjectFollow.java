package top.xiao.pojo;

import top.xiao.pojo.base.BasePageQuery;

public class MemberProjectFollow extends BasePageQuery {
    private Integer id;

    private Integer projectid;

    private Integer memberid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
}