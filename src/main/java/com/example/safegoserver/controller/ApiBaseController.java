package com.example.safegoserver.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class ApiBaseController {

  @Autowired
  ModelMapper mapper;

  protected <T , D> D toDto(T entity, Class<D> dtoClass) {
    return mapper.map(entity, dtoClass);
  }

  protected <D, T > T toEntity(D dto, Class<T> entityClass) {
    return this.mapper.map(dto, entityClass);
  }


}
