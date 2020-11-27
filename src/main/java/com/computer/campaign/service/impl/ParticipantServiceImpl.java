package com.computer.campaign.service.impl;

import com.computer.campaign.exception.UserNotFoundException;
import com.computer.campaign.mapper.ParticipantMapper;
import com.computer.campaign.mapper.SuperUserMapper;
import com.computer.campaign.pojo.Participant;
import com.computer.campaign.service.ParticipantService;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author Mr.Huang
 * @create 2020-05-12 23:02
 */
@Service
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    ParticipantMapper participantMapper;
    @Override
    public Participant judge(String su_id) {
        /*检测是否参与过竞选*/
        String p_id="p"+su_id;//竞选id为p+账号
        Participant participant = participantMapper.judge(p_id);
        if(participant!=null){//不为空返回竞选信息
            return participant;
        }else {
            return null;
        }

    }

    @Override
    public boolean contend(Participant participant, String d_id) {
        if(participantMapper.contend(participant)>0){
            participantMapper.sumCpoll(participant.getS_id());//为该职位竞选人数+1
            return true;
        }
        return false;
    }

    @Override
    public Participant checkParticipantFile(Participant participant) throws Exception {
        /*上传文件并将访问路径存到participant中的imgSrc属性中*/
        MultipartFile imgFile = participant.getImgFile();
        String ext= "."+ FilenameUtils.getExtension(imgFile.getOriginalFilename());//获取拓展名
        String newFileName=participant.getP_id()+ UUID.randomUUID().toString().replace("-","")+ext;
        //System.out.println( ResourceUtils.getURL("classpath:").getPath());
        //String realPath = ResourceUtils.getURL("classpath:").getPath() + "static/partImgs";//获取工程的对应文件相对路径
        File path=new File(ResourceUtils.getURL("classpath:").getPath());//获取要上传文件的路径
        if(!path.exists()){
            path=new File("");
        }
        File upload=new File(path.getAbsolutePath(),"static/partImgs/");
        if(!upload.exists()) {
            if(upload.mkdirs()){
                System.out.println(upload.getAbsolutePath());
            }else {
                throw new MultipartException("异常");
            }
        }
        String DirPath=upload.getAbsolutePath()+"/"+participant.getD_id();//定义一个路径
        File Dir = new File(DirPath);
        if(!Dir.exists()){//如果不存在创建出来
            Dir.mkdirs();
        }
        imgFile.transferTo(new File(Dir,newFileName));   //文件上传
        String ImgPath="/partImgs/"+participant.getD_id()+"/"+newFileName;
        //将文件路径存到img中
        participant.setImgsrc(ImgPath);
        return participant;
    }


}
