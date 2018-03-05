package com.vcg.common.base;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public abstract class BaseRestImpl<T, Q, P> extends BaseServiceImpl<T, Q, P> implements BaseRest<T, Q, P> {

	@Transactional
	public Integer deleteByPrimaryKeys(@PathVariable("ids") List<P> ids) {
		return super.deleteByPrimaryKeys(ids);
	}

	@Transactional(readOnly=true)
	public T selectByPrimaryKey(@PathVariable("id") P id) {
		return super.selectByPrimaryKey(id);
	}

	@Transactional(readOnly=true)
	public List<T> selectByPrimaryKeys(@PathVariable("ids") List<P> ids) {
		return super.selectByPrimaryKeys(ids);
	}

	@Transactional
	public Integer deleteByPrimaryKey(@PathVariable("id") P id) {
		return super.deleteByPrimaryKey(id);
	}

	@Transactional
	public Object insert(@RequestBody T t) {
		return super.insert(t);
	}

	@Transactional
	public Object insertSelective(@RequestBody T t) {
		return super.insertSelective(t);
	}

	@Transactional
	public Object insertBatch(@RequestBody List<T> ts) {
		return super.insertBatch(ts);
	}

	@Transactional
	public Object updateByPrimaryKeySelective(@RequestBody T t) {
		return super.updateByPrimaryKeySelective(t);
	}


}
