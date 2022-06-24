package bank.vo;

public class accountVO {

	private String account_number; //ACCOUNT_NUMBER
	private String account_name; //ACCOUNT_NAME
	private String branch_code; //BRANCH_CODE
	private String balance; //BALANCE	
	private String insert_date; //INSERT_DATE	
	private String update_date; //UPDATE_DATE	
	private String deleteyn; //DELETEYN
	private String cnumber; //CNUMBER
	
	public accountVO() {
	
	}

	public accountVO(String account_number
					,String account_name
					,String branch_code
					,String balance
					,String insert_date
					,String update_date
					,String deleteyn
					,String cnumber) {
		
		this.account_number = account_number;
		this.account_name = account_name;
		this.branch_code = branch_code;
		this.balance = balance;
		this.insert_date = insert_date;
		this.update_date = update_date;
		this.deleteyn = deleteyn;
		this.cnumber = cnumber;
	}

	public String getAccount_number() {
		return account_number;
	}

	public String getAccount_name() {
		return account_name;
	}

	public String getBranch_code() {
		return branch_code;
	}

	public String getBalance() {
		return balance;
	}

	public String getInsert_date() {
		return insert_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public String getDeleteyn() {
		return deleteyn;
	}

	public String getCnumber() {
		return cnumber;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}

	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	
	
}
