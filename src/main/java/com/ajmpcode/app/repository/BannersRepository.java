package com.ajmpcode.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajmpcode.app.model.Banner;

@Repository
public interface BannersRepository extends JpaRepository<Banner, Integer> {
	
			// select * from Banners where estatus = ? order by id desc 
			public List<Banner> findByEstatusOrderByIdDesc(String estatus);

}
