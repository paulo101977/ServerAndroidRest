package com.android.rest.api.videocontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.android.rest.api.persistence.Video;
import com.android.rest.api.persistence.VideoPersistence;


@Controller
@RequestMapping("/videos")
public class VideoController {
	
	@Autowired(required = true)
	private VideoPersistence persistence;
	

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Video> videos(){
		
		return persistence.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Video post(Video video){
		//Video v = persistence.save(video);
		return null;
	}
}
