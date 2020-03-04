package top.xiao.pojo;

import top.xiao.pojo.base.BasePageQuery;

public class AccountTypeCert extends BasePageQuery {
    private Integer id;

    private String accttype;

    private Integer certid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccttype() {
        return accttype;
    }

    public void setAccttype(String accttype) {
        this.accttype = accttype == null ? null : accttype.trim();
    }

    public Integer getCertid() {
        return certid;
    }

    public void setCertid(Integer certid) {
        this.certid = certid;
    }
}