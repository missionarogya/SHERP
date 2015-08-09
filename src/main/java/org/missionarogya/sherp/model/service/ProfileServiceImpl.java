package org.missionarogya.sherp.model.service;

import java.util.Random;

import org.missionarogya.sherp.controller.object.request.CreateProfileRequestType;
import org.missionarogya.sherp.model.dao.ProfileDao;
import org.missionarogya.sherp.model.dao.object.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("ProfileService")
@Transactional
public class ProfileServiceImpl implements ProfileService {
	@Autowired
    private ProfileDao dao;
	public int createProfile(CreateProfileRequestType request) {
		
		Member member = new Member();
		Random r = new Random();
		int Low = 100000;
		int High = 999999;
		int R = r.nextInt(High-Low) + Low;
		member.setMemberId(R);
		member.setEmailId(request.getEmailid());
		member.setRole("AdminRO");
		if(!dao.findMemberByEmailId(member))
		{
			dao.saveMember(member);
			return R;
		}
		else{
			return 0;
		}
		
	}
	public boolean checkProfileAvailability(String mailId){
		Member member = new Member();
		member.setEmailId(mailId);
		boolean balance = dao.findMemberByEmailId(member);
		return balance;
	}

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
