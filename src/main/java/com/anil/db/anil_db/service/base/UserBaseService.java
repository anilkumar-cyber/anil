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
package com.anil.db.anil_db.service.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.anil.db.anil_db.mapper.User;
import com.anil.db.anil_db.service.UserService;

@Service
public class UserBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}


    //CRUD METHODS
    
    	
        
    //CRUD - CREATE
    	
	public User insert(User obj) {
		
		long id = jdbcTemplate.queryForObject("SELECT nvl(max(\"id\")+1, 1) FROM User", new MapSqlParameterSource(), Long.class);
		obj.set_id(id);
		
		String sql = "INSERT INTO User (\"id\", \"mail\",\"name\",\"password\",\"roles\",\"surname\",\"username\"  )	VALUES (:id, :mail,:name,:password,:roles,:surname,:username  )";

		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("mail", obj.getMail())
			.addValue("name", obj.getName())
			.addValue("password", obj.getPassword())
			.addValue("roles", obj.getRoles())
			.addValue("surname", obj.getSurname())
			.addValue("username", obj.getUsername());

		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
        	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM User WHERE \"id\"=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
        	
    //CRUD - GET ONE
    	
	public User get(Long id) {
	    
		String sql = "select * from User where \"id\" = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return jdbcTemplate.queryForObject(sql, parameters, new User());
	}

    	
        	
    //CRUD - GET LIST
    	
	public List<User> getList() {
	    
		String sql = "select * from User";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new User());
	}

    	
        
    //CRUD - EDIT
    	
	public User update(User obj, Long id) {

		String sql = "UPDATE User SET \"mail\" = :mail,\"name\" = :name,\"password\" = :password,\"roles\" = :roles,\"surname\" = :surname,\"username\" = :username  WHERE \"id\"=:id";

		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("mail", obj.getMail())
			.addValue("name", obj.getName())
			.addValue("password", obj.getPassword())
			.addValue("roles", obj.getRoles())
			.addValue("surname", obj.getSurname())
			.addValue("username", obj.getUsername());

		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    

    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in  Custom.js
     */
    
    
    /*
    Name: changePassword
    Description: Change password of user from admin
    Params: 
    */
    


}
