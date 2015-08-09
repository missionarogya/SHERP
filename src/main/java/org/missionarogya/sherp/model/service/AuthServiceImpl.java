package org.missionarogya.sherp.model.service;

import java.util.List;

import org.missionarogya.sherp.controller.object.request.RequestType;
import org.missionarogya.sherp.model.dao.AuthDao;
import org.missionarogya.sherp.model.dao.object.Access;
import org.missionarogya.sherp.model.dao.object.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("AuthenticationService")
@Transactional
public class AuthServiceImpl implements AuthService {
	@Autowired
    private AuthDao dao;
	private String errorMessage = "";
	public int checkAuthorization(RequestType request, String action) {
		// TODO Auto-generated method stub
		List<Member> members = dao.findMember(request.getSessionId());
		if(members.size()==0){
			
			return 404;
		}
		List<Access> accesses = dao.getAccessProfile(action);
		if(accesses.size()==0){
			
			return 401;
		}
		for(Member member : members){
			for(Access access : accesses){
				if(member.getRole().equals(access.getRole())){
					return 200;
				}
			}
			
		}
		
		return 403;
		
	}
	

}
