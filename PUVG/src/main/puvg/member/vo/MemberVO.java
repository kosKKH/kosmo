package main.puvg.member.vo;

public class MemberVO {
	private String vnum;
	private String vname;
	private String vemall;
	private String vpw;
	private String vaddr;
	private String vph;
	private String vdept;
	private String vrank;
	private String vbirth;
	private String vhiredate;
	private String vdeleteyn;
	
	public MemberVO() {
	}

	public MemberVO(String vnum, String vname, String vemall, String vpw, String vaddr, String vph, String vdept,
			String vrank, String vbirth, String vhiredate, String vdeleteyn) {
		this.vnum = vnum;
		this.vname = vname;
		this.vemall = vemall;
		this.vpw = vpw;
		this.vaddr = vaddr;
		this.vph = vph;
		this.vdept = vdept;
		this.vrank = vrank;
		this.vbirth = vbirth;
		this.vhiredate = vhiredate;
		this.vdeleteyn = vdeleteyn;
	}

	public String getVnum() {
		return vnum;
	}

	public void setVnum(String vnum) {
		this.vnum = vnum;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVemall() {
		return vemall;
	}

	public void setVemall(String vemall) {
		this.vemall = vemall;
	}

	public String getVpw() {
		return vpw;
	}

	public void setVpw(String vpw) {
		this.vpw = vpw;
	}

	public String getVaddr() {
		return vaddr;
	}

	public void setVaddr(String vaddr) {
		this.vaddr = vaddr;
	}

	public String getVph() {
		return vph;
	}

	public void setVph(String vph) {
		this.vph = vph;
	}

	public String getVdept() {
		return vdept;
	}

	public void setVdept(String vdept) {
		this.vdept = vdept;
	}

	public String getVrank() {
		return vrank;
	}

	public void setVrank(String vrank) {
		this.vrank = vrank;
	}

	public String getVbirth() {
		return vbirth;
	}

	public void setVbirth(String vbirth) {
		this.vbirth = vbirth;
	}

	public String getVhiredate() {
		return vhiredate;
	}

	public void setVhiredate(String vhiredate) {
		this.vhiredate = vhiredate;
	}

	public String getVdeleteyn() {
		return vdeleteyn;
	}

	public void setVdeleteyn(String vdeleteyn) {
		this.vdeleteyn = vdeleteyn;
	}
	
	
}
