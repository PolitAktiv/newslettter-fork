package net.zylk.liferay.portal.model.util;

import com.liferay.portal.kernel.json.JSON;


public class SubscriptionExtraInfo {
	
	private long groupId;
	private String email;
	private String name;
	private String surname;
	private String languageId;
	private long[] categories;
	
	
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLanguageId() {
		return languageId;
	}
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	@JSON
	public long[] getCategories() {
		return categories;
	}
	@JSON 
	public void setCategories(long[] categories) {
		this.categories = categories;
	}
	
}