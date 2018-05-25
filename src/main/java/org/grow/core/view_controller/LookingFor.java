package org.grow.core.view_controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.grow.core.domain.TrainingMember;
import org.grow.core.head_tobody.TrainingMemberManager;

import org.grow.core.infrasturcture.JpaRepo;
import org.grow.core.infrasturcture.dto.TrainingMemberAssistant;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Api
@RestController
public class LookingFor {
    @Resource
    private TrainingMemberManager trainingMemberManager;

    @Resource
    private JpaRepo jpaRepo;
    @ApiOperation(value="member Get", notes = "query")
    @GetMapping("/trainingMember/get/{memberCode}")
    public TrainingMember findOne(@PathVariable(value = "memberCode") String memberCode){
        return jpaRepo.findByMemberCode(memberCode);

    }
    @ApiOperation(value="member Put", notes = "store")
    @PutMapping("/trainingMember/put")
    public TrainingMember save(@RequestBody TrainingMemberAssistant a){
        return  this.trainingMemberManager.saveNew(a);

    }
    @ApiOperation(value="member post", notes = "modify")
    @PostMapping("/trainingMember/post")
    public TrainingMember modify(@RequestBody TrainingMemberAssistant a){
        return  this.trainingMemberManager.saveNew(a);
    }
    @ApiOperation(value="member delete", notes = "delete")
    @DeleteMapping("/trainingMember/delete/{memberCode}")
    @Transactional
    public HttpEntity<TrainingMember> delete(@PathVariable(value = "memberCode") String memberCode){
        this.jpaRepo.deleteByMemberCode(memberCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ApiOperation(value = "member Get All",notes = "all")
    @GetMapping(("/trainingMember/getAll"))
    public List<TrainingMember> findAll(){
        return jpaRepo.findAll();
    }

}
