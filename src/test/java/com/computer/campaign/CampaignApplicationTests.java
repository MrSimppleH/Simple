package com.computer.campaign;

import com.computer.campaign.mapper.AdminMapper;
import com.computer.campaign.mapper.ParticipantMapper;
import com.computer.campaign.mapper.SimpleUserMapper;
import com.computer.campaign.pojo.Department;
import com.computer.campaign.pojo.Participant;
import com.computer.campaign.pojo.SimpleUser;
import com.computer.campaign.pojo.Sort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampaignApplicationTests {
    @Autowired
    SimpleUserMapper simpleUserMapper;

    @Test
    public void contextLoads() {
        System.out.println("我试试");
    }
    @Test
    public void insertSimpleUser(){
        SimpleUser simpleUser=new SimpleUser();
        simpleUser.setD_id("100000");
        simpleUser.setSu_id("2017010101");
        simpleUser.setSu_name("AAA");
        simpleUser.setSu_pwd("bbb");
        simpleUserMapper.insertSimpleUser(simpleUser);
    }
    @Autowired
    ParticipantMapper participantMapper;
    @Test
    public void uopdate(){
        String s_id="02";
        if(participantMapper.sumCpoll(s_id)>0){
            System.out.println("成功");
        }else
        {
            System.out.println("失败");
        }
    }
    @Autowired
    AdminMapper adminMapper;
    @Test
    public void department(){
        List<Department> departments = adminMapper.showAllDepartment();
        System.out.println(departments);
    }
    @Test
    public void showAllsort(){
        List<Sort> sortList = adminMapper.showAllSort();
        System.out.println(sortList);
    }
    @Test
    public void  INTuuid(){
    Integer d_id= UUID.randomUUID().toString().hashCode();
    d_id = d_id < 0 ? -d_id : d_id;
        System.out.println(d_id);
    }

    @Test
    public void checkContend(){
        String p_id="p001";
        Participant judge = participantMapper.judge(p_id);
        System.out.println(judge);
}
    @Test
    public void file() throws FileNotFoundException {
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "static/partImgs";//获取工程的对应文件相对路径
        System.out.println(realPath);
    }
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void redisTEST(){
//        stringRedisTemplate.opsForValue().set("k1","abc");
        List<Participant> participantList = simpleUserMapper.showAllPartByD_id("001");
        Participant participant = participantList.get(1);
        redisTemplate.opsForList().leftPop(participantList);
    }
    @Autowired
    RedisTemplate<Object,Object> jsonRedisTemplate;
    @Test
    public void jsonRedisTEST(){
//        stringRedisTemplate.opsForValue().set("k1","abc");
        List<Participant> participantList = simpleUserMapper.showAllPartByD_id("001");
        Participant participant = participantList.get(1);
        jsonRedisTemplate.opsForValue().set("k2",participant);
        //jsonRedisTemplate.opsForList().leftPop(participantList);
    }
    @Test
    public void participantList(){
        Participant participant=new Participant();
        participant.setD_id("001");
        participant.setS_id("06");
        List<Participant> participantList = simpleUserMapper.showPartByD_idS_id(participant);
        System.out.println(participantList);
    }
    @Test
    public void insertSimpple(){
        String d_id="001";
        int i=simpleUserMapper.sumd_sum(d_id);
        System.out.println(i);
    }
    @Test
    public void path() throws FileNotFoundException {

    }
}
