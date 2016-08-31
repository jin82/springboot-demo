package jin.study.movie.model;

public class Admin {
    private Integer aId;

    private String aUser;

    private String aPassword;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaUser() {
        return aUser;
    }

    public void setaUser(String aUser) {
        this.aUser = aUser == null ? null : aUser.trim();
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword == null ? null : aPassword.trim();
    }
}