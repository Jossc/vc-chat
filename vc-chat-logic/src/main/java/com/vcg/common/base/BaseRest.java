package com.vcg.common.base;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


public interface BaseRest<T, Q, P> {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    T selectByPrimaryKey(@PathVariable("id") P id);

    @RequestMapping(value = "/ids/{ids}", method = RequestMethod.GET)
    List<T> selectByPrimaryKeys(@PathVariable("ids") List<P> ids);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    Integer deleteByPrimaryKey(@PathVariable("id") P id);

    @RequestMapping(value = "/ids/{ids}", method = RequestMethod.DELETE)
    Integer deleteByPrimaryKeys(@PathVariable("ids") List<P> ids);

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Object insert(@RequestBody T t);

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Object insertSelective(@RequestBody T t);

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Object insertBatch(@RequestBody List<T> ts);

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Object updateByPrimaryKeySelective(@RequestBody T t);

}
