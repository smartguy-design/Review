package sist.com.report;

public class CallCenter {
    private String name;
    private int id;
    private int pbx;
    private String team;
    private String ip;

    public CallCenter() {

    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getPbx() {
	return pbx;
    }

    public void setPbx(int pbx) {
	this.pbx = pbx;
    }

    public String getTeam() {
	return team;
    }

    public void setTeam(String team) {
	this.team = team;
    }

    public String getIp() {
	return ip;
    }

    public void setIp(String ip) {
	this.ip = ip;
    }

    @Override
    public String toString() {
	return "CallCenter [name=" + name + ", id=" + id + ", pbx=" + pbx + ", team=" + team + ", ip=" + ip + "]";
    }

}
