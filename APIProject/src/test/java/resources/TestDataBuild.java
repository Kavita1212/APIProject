package resources;

import pojo.LoginRegisterUpdate;
import pojo.UpdateInfo;

public class TestDataBuild {
	
	public LoginRegisterUpdate loginPayload(String emailaddress,String password) {
		
		LoginRegisterUpdate ad = new LoginRegisterUpdate();
		ad.setEmail(emailaddress);
		ad.setPassword(password);
		return ad;
		
	}
	
	public UpdateInfo updateInfoPayload(String name,String job) {
		
		UpdateInfo upinfo=new UpdateInfo();
		upinfo.setName(name);
		upinfo.setJob(job);
		return upinfo;
		
	}
	

}
