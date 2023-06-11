package com.rhode.app.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.rhode.app.Binding.CitizenApp;
import com.rhode.app.Entity.CitizenApplication;
import com.rhode.app.Repository.CitizenApplicationRepo;
import com.rhode.app.Service.CitizenAppRegService;


@Service
public class CitizenAppRegServiceImpl implements CitizenAppRegService {
	
	@Autowired
	CitizenApplicationRepo repo;
	
	// We should not hard code the URL, we need to write it in the yml
	private static final String REST_URL="http://ssawebapi-env.eba-k88sahp.ap-south-1.elasticbeanstalk.com/ssn/{ssn}";
	
	@Override
	public String registerCitizenApp(CitizenApp app) {
		Long ssn=app.getSSN();
		WebClient webclient= WebClient.create();
			String statename=webclient.get()
									.uri(REST_URL, ssn)
									.retrieve() //used to receive response from the client....,It will extract the response 
									.bodyToMono(String.class) //The received response want to store to string variable
									.block();// for synchrons communication
			
		if("Rhode Island".equals(statename)) {
			
			CitizenApplication entity=new CitizenApplication();
			BeanUtils.copyProperties(app, entity);
			repo.save(entity);
			return "Citizen App created, AppId :" + entity.getId();
		}
		return "Citizen Not Belongs to RI";
	}

}
