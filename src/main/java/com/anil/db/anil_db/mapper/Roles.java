/* 
* Generated by
* 
*      _____ _          __  __      _     _
*     / ____| |        / _|/ _|    | |   | |
*    | (___ | | ____ _| |_| |_ ___ | | __| | ___ _ __
*     \___ \| |/ / _` |  _|  _/ _ \| |/ _` |/ _ \ '__|
*     ____) |   < (_| | | | || (_) | | (_| |  __/ |
*    |_____/|_|\_\__,_|_| |_| \___/|_|\__,_|\___|_|
*
* The code generator that works in many programming languages
*
*			https://www.skaffolder.com
*
*
* You can generate the code from the command-line
*       https://npmjs.com/package/skaffolder-cli
*
*       npm install -g skaffodler-cli
*
*   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
*
* To remove this comment please upgrade your plan here: 
*      https://app.skaffolder.com/#!/upgrade
*
* Or get up to 70% discount sharing your unique link:
*       https://app.skaffolder.com/#!/register?friend=5e3bb9e4cb6fd67ac004aa16
*
* You will get 10% discount for each one of your friends
* 
*/
package com.anil.db.anil_db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Roles implements RowMapper<Roles>{

    private Long _id;
    private Long _user;
	private String role;

	@Override
	public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Roles obj = new Roles();
		try {
			obj.set_id(rs.getLong("id"));
			obj.set_user(rs.getLong("_user"));
			obj.setRole(rs.getString("role"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	} 
    
	
	public Long get_id() {
		return _id;
	}
	public void set_id(Long id) {
		this._id = id;
	}

	public Long get_user() {
		return _user;
	}


	public void set_user(Long _user) {
		this._user = _user;
	}

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

}
