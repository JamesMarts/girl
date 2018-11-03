package com.ljw.demo;

import com.ljw.demo.entity.Girl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlReponsitory extends JpaRepository<Girl,Integer> {
}
