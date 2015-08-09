package org.missionarogya.sherp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.missionarogya.sherp.model.dao.object.Member;
import org.missionarogya.sherp.model.dao.object.MyObject;
import org.springframework.stereotype.Repository;
@Repository("ProfileDao")
public class ProfileDaoImpl extends AbstractDao implements ProfileDao {

	public void saveMember(Member member) {
		// TODO Auto-generated method stub
		persist(member);
	}

	public boolean findMemberByEmailId(Member member) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Member.class);
        criteria.add(Restrictions.eq("emailId",member.getEmailId()));
        List<Member> members = criteria.list();
        if(members.size()>0){
        	return true;
        }
        else{
        	return false;
        }
	}
}
