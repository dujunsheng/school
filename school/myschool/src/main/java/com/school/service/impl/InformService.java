package com.school.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.mapper.InformMapper;
import com.school.po.Inform;
import com.school.po.InformExample;

@Service
public class InformService {
    
    @Resource
    private InformMapper informMapper;
    
    /*
     * 发布通知，即向数据库中插入数据
     */
    public int releaseInform(Inform inform) {
	return informMapper.insertSelective(inform);
    }
    
    /*
     * 删除通知
     */
    public int deleteInform(int informId) {
	return informMapper.deleteByPrimaryKey(informId);
    }
    
    /*
     * 更新通知
     */
    public int updateInform(Inform inform) {
	return informMapper.updateByPrimaryKey(inform);
    }
    
    /*
     * 获取全部通知
     */
    public List<Inform> getAllInforms(InformExample example) {
	return informMapper.selectByExampleWithBLOBs(example);
    }
    
    public List<Inform> getAllInformByRank(InformExample example){
	return informMapper.selectByExampleWithBLOBs(example);
    }
    
    /*
     * 获取最新的通知,两天之内的
     */
    public List<Inform> getInformLastest(InformExample example) {
	return informMapper.selectByExampleWithBLOBs(example);
    }
    
    /*
     * 通过主键获取inform
     */
    public Inform selectInformByPrimaryKey(int id) {
	return informMapper.selectByPrimaryKey(id);
    }
    
    /*
     * 标题关键字搜索
     */
    public List<Inform> searchByTitle(InformExample example){
	return informMapper.selectByExampleWithBLOBs(example);
    }
    
}
