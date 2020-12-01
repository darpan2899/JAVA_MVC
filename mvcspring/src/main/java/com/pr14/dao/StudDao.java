package com.pr14.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import com.pr14.beans.Stud;    
    

public class StudDao {
	
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Stud p){    
	    String sql="insert into Student(Id,Name,Sem,CPI,Username,Password) values("+p.getId()+",'"+p.getName()+"',"+p.getSem()+","+p.getCPI()+",'"+p.getusername()+"','"+p.getpassword()+"')";    
	    return template.update(sql);    
	}    
	public int update(Stud p){    
	    String sql="update Student set Name='"+p.getName()+"', Sem='"+p.getSem()+"',CPI="+p.getCPI()+",username='"+p.getusername()+"',password='" +p.getpassword()+"' where Id="+p.getId();    
	    return template.update(sql);    
	}    
	public int delete(int Id){    
	    String sql="delete from Student where Id="+Id+"";    
	    return template.update(sql);    
	}    
	public Stud getStudById(int Id){    
	    String sql="select * from Student where Id=?";    
	    return template.queryForObject(sql, new Object[]{Id},new BeanPropertyRowMapper<Stud>(Stud.class));    
	}    
	public List<Stud> getStudents(){    
	    return template.query("select * from Student",new RowMapper<Stud>(){    
	        public Stud mapRow(ResultSet rs, int row) throws SQLException {    
	        	Stud e=new Stud();
	       
	            e.setId(rs.getDouble(1));   
	            e.setName(rs.getString(2));    
	            e.setCPI(rs.getFloat(4));    
	            e.setSem(rs.getInt(3)); 
	            e.setusername(rs.getString(5));
	            e.setpassword(rs.getString(6));
	            return e;    
	        }    
	    });    
	}    

}
