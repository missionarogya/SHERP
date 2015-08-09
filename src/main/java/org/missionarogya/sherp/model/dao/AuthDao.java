package org.missionarogya.sherp.model.dao;

import java.util.List;

import org.missionarogya.sherp.model.dao.object.Access;
import org.missionarogya.sherp.model.dao.object.Member;

public interface AuthDao {
	public List<Member> findMember(int memberId);
	public List<Access> getAccessProfile(String action);
}
