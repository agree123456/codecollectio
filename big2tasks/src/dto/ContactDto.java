package dto;

public class ContactDto {// 저장공간
	   private int member_id; 
	   private String member_name; 
	   private String address; 
	   private String phonenumber;
	   private String groups_id;
	   
	   public ContactDto() {
	   			}
	  //private을 public으로 하여 사용할수 있게 하는곳
	   
	public int getMember_id() {
		return member_id;
	}

	public ContactDto(int member_id, String member_name, String address, String phonenumber, String groups_id) {
		this.member_id = member_id;
		this.member_name = member_name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.groups_id = groups_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getGroups_id() {
		return groups_id;
	}

	public void setGroups_id(String groups_id) {
		this.groups_id = groups_id;
	}

	
	@Override
	public String toString() {
		return "ContactDto [member_id=" + member_id + ", member_name=" + member_name + ", address=" + address
				+ ", phonenumber=" + phonenumber + ", groups_id=" + groups_id + "]";
	}
	   
}