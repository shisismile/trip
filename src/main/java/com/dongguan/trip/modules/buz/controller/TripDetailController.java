package com.dongguan.trip.modules.buz.controller;

import com.dongguan.trip.common.utils.R;
import com.dongguan.trip.common.utils.SnowFlake;
import com.dongguan.trip.modules.buz.entity.NavEntity;
import com.dongguan.trip.modules.buz.entity.TripDetailEntity;
import com.dongguan.trip.modules.buz.entity.TripFirstTypeEntity;
import com.dongguan.trip.modules.buz.entity.TripSecondTypeEntity;
import com.dongguan.trip.modules.buz.service.NavService;
import com.dongguan.trip.modules.buz.service.TripDetailService;
import com.dongguan.trip.modules.buz.service.TripFirstTypeService;
import com.dongguan.trip.modules.buz.service.TripSecondTypeService;
import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("detail")
public class TripDetailController {
    @Resource
    private TripDetailService tripDetailService;

    @Value("${upload.filepath}")
    private String filePath;
    @Resource
    private TripSecondTypeService tripSecondTypeService;
    @Resource
    private TripFirstTypeService tripFirstTypeService;
    @Resource
    private NavService navService;
    @RequestMapping("one.html")
    public ModelAndView detail(HttpServletRequest request, @RequestParam("id") Long id, ModelAndView mav) {
        TripDetailEntity byId = tripDetailService.findById(id);
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        String fileDetail = byId.getFileDetail();
        if (!StringUtils.isEmpty(fileDetail)) {
            File fileDetail_ = new File(fileDetail);
            byId.setFileDetail(basePath + "/file/image.html?file_name=" + fileDetail_.getName());
        }

        String fileDetail0 = byId.getFileDetail0();
        if (!StringUtils.isEmpty(fileDetail0)) {
            File fileDetail0_ = new File(fileDetail0);
            byId.setFileDetail0(basePath + "/file/image.html?file_name=" + fileDetail0_.getName());
        }
        String fileDetail1 = byId.getFileDetail1();
        if (!StringUtils.isEmpty(fileDetail1)) {
            File fileDetail1_ = new File(fileDetail1);
            byId.setFileDetail1(basePath + "/file/image.html?file_name=" + fileDetail1_.getName());
        }
        String fileDetail2 = byId.getFileDetail2();
        if (!StringUtils.isEmpty(fileDetail2)) {
            File fileDetail2_ = new File(fileDetail2);
            byId.setFileDetail2(basePath + "/file/image.html?file_name=" + fileDetail2_.getName());
        }
        mav.setViewName("detail");
        List<NavEntity> navEntities = navService.queryAll();
        mav.addObject("navEntities", navEntities);
        mav.addObject("detail", byId);
        return mav;
    }

    @RequestMapping("save")
    @ResponseBody
    public R save(TripDetailEntity tripDetailEntity) {
        return tripDetailService.save(tripDetailEntity) == 0 ? R.ok() : R.error();
    }

    @RequestMapping("saveAll.html")
    @ResponseBody
    public R saveAll(TripDetailEntity tripDetailEntity, @RequestParam("firstType") Long firstType,
                     @RequestParam("fileDetail_file") MultipartFile fileDetail_file,
                     @RequestParam("fileDetail0_file") MultipartFile fileDetail0_file,
                     @RequestParam("fileDetail1_file") MultipartFile fileDetail1_file,
                     @RequestParam("fileDetail2_file") MultipartFile fileDetail2_file,
                     HttpServletRequest request) {
        try {
            SysUserEntity userEntity = (SysUserEntity) request.getSession().getAttribute("CURRENT_USER");
            String contextPath = request.getContextPath();
            if (tripDetailEntity.getId() == null) {
                tripDetailEntity.setId(new SnowFlake().nextId());
                tripDetailEntity.setUrl(contextPath + "/detail/one.html?id=" + tripDetailEntity.getId());
                if (tripDetailEntity.getMaxMinus() > 0) {
                    tripDetailEntity.setIsOnCount(1);
                } else {
                    tripDetailEntity.setIsOnCount(0);
                }
            } else {
                tripDetailEntity = tripDetailService.findById(tripDetailEntity.getId());
            }
            tripDetailEntity.setSysUserEntity(userEntity);
            String filename = fileDetail_file.getOriginalFilename();
            String subfix = filename.substring(filename.lastIndexOf(".") + 1);
            String path = filePath + File.separator + "fileDetail_file" + UUID.randomUUID().toString() + "." + subfix;
            tripDetailEntity.setFileDetail(path);
            fileDetail_file.transferTo(new File(path));

            String filename0 = fileDetail0_file.getOriginalFilename();
            String subfix0 = filename0.substring(filename0.lastIndexOf(".") + 1);
            String path0 = filePath + File.separator + "fileDetail_file0" + UUID.randomUUID().toString() + "." + subfix0;
            tripDetailEntity.setFileDetail0(path0);
            fileDetail0_file.transferTo(new File(path0));

            String filename1 = fileDetail1_file.getOriginalFilename();
            String subfix1 = filename1.substring(filename1.lastIndexOf(".") + 1);
            String path1 = filePath + File.separator + "fileDetail_file1" + UUID.randomUUID().toString() + "." + subfix1;
            tripDetailEntity.setFileDetail1(path1);
            fileDetail1_file.transferTo(new File(path1));

            String filename2 = fileDetail2_file.getOriginalFilename();
            String subfix2 = filename2.substring(filename2.lastIndexOf(".") + 1);
            String path2 = filePath + File.separator + "fileDetail_file2" + UUID.randomUUID().toString() + "." + subfix2;
            tripDetailEntity.setFileDetail2(path2);
            fileDetail2_file.transferTo(new File(path2));

            tripDetailService.save(tripDetailEntity);
            TripSecondTypeEntity tripSecondTypeEntity=new TripSecondTypeEntity();
            tripSecondTypeEntity.setId(new SnowFlake().nextId());
            tripSecondTypeEntity.setHref("/trip/detail/one.html?id="+tripDetailEntity.getId());
            tripSecondTypeEntity.setTypeName(tripDetailEntity.getShortName());
            TripFirstTypeEntity firstTypeServiceById = tripFirstTypeService.findById(firstType);
            tripSecondTypeEntity.setTripFirstTypeEntity(firstTypeServiceById);

            tripSecondTypeService.save(tripSecondTypeEntity);

            TripSecondTypeEntity tripSecondTypeEntity0=new TripSecondTypeEntity();
            tripSecondTypeEntity0.setId(new SnowFlake().nextId());
            tripSecondTypeEntity0.setHref("/trip/detail/one.html?id="+tripDetailEntity.getId());
            tripSecondTypeEntity0.setTypeName(tripDetailEntity.getShortName());
            TripFirstTypeEntity firstTypeServiceById0=null;
            if(tripDetailEntity.getTripDays()==1){
                firstTypeServiceById0= tripFirstTypeService.findById(4L);
            }else if(tripDetailEntity.getTripDays()==2){
                firstTypeServiceById0= tripFirstTypeService.findById(5L);
            }else if(tripDetailEntity.getTripDays()>2){
                firstTypeServiceById0= tripFirstTypeService.findById(6L);
            }
            tripSecondTypeEntity0.setTripFirstTypeEntity(firstTypeServiceById0);
            tripSecondTypeService.save(tripSecondTypeEntity0);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }

    }

    @RequestMapping("delete.html")
    public ModelAndView remove(@RequestParam("id") Long id, ModelAndView mav, HttpServletRequest request) {
        TripDetailEntity byId = tripDetailService.findById(id);
        byId.setStatus(-1);
        tripDetailService.save(byId);
        mav.setViewName("redirect:" +  "/user/userDetail.html");
        return mav;
    }
    @RequestMapping("getWithPage.html")
    public @ResponseBody R getWithPage(TripDetailEntity tripDetailEntity,Integer page,Integer rows){
        Page<TripDetailEntity> entityPage = tripDetailService.findWithPage(tripDetailEntity, page, rows, Sort.Direction.ASC, "id");
        R result = R.ok().put("total", entityPage.getTotalElements()).put("rows", entityPage.getContent());
        return result;
    }
}
