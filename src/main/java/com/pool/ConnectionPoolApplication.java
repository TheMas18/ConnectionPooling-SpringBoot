package com.pool;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(exclude = {
		JdbcTemplateAutoConfiguration.class,
		DataSourceAutoConfiguration.class
})
public class ConnectionPoolApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		
	
		
		SpringApplication.run(ConnectionPoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("App Started");
		
		jdbcTemplate.update("insert into demo(id,name,skill) values(2,'Goku','Web Developer')");
		System.out.println("Data Inserted");
		List<Map<String,Object>> queryForList = jdbcTemplate.queryForList("select * from demo");
		
		queryForList.forEach(item->{
			System.out.println("Id : "+item.get("id"));
			System.out.println("Name : "+item.get("name"));
			System.out.println("Skill : "+item.get("skill"));
		});
		
		
	}

}
