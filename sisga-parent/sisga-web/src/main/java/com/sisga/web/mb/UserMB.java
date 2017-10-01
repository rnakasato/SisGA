package com.sisga.web.mb;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sisga.domain.user.User;


@ManagedBean(name="userMB")
@ViewScoped
public class UserMB extends BaseMB<User>{

	@Override
	public void clearFilter() {
		
	}

}
