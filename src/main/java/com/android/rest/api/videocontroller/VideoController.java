package com.android.rest.api.videocontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.android.rest.api.persistence.Video;
import com.android.rest.api.persistence.VideoPersistence;
import com.fasterxml.jackson.annotation.JsonView;


@Controller
@RequestMapping("/videos")
@RestController
public class VideoController {
	
	@Autowired(required = true)
	private VideoPersistence persistence;
	

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Video> videos(){
		
		return persistence.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@JsonView(com.android.rest.api.persistence.Video.class)
	public @ResponseBody Video insert(@RequestBody Video video){
		//Video videoObj = wrapperObj.get
		return persistence.save(video);
	}
}
