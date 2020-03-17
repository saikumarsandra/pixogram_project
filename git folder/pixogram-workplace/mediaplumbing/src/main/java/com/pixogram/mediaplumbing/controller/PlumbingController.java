package com.pixogram.mediaplumbing.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.pixogram.mediaplumbing.feignproxy.MediaServiceProxy;
import com.pixogram.mediaplumbing.feignproxy.NewsFeedServiceProxy;
import com.pixogram.mediaplumbing.model.Media;
import com.pixogram.mediaplumbing.model.MediaData;
import com.pixogram.mediaplumbing.model.MediaDataModel;
import com.pixogram.mediaplumbing.model.MediaDataModelResponse;
import com.pixogram.mediaplumbing.model.MediaDetails;
import com.pixogram.mediaplumbing.model.Medialist;
import com.pixogram.mediaplumbing.model.NewsFeedModel;



@RestController
public class PlumbingController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MediaServiceProxy mediaProxy;
	 @Autowired
	 private NewsFeedServiceProxy newsFeedServiceProxy;
	
	private final String MEDIA_URL = "http://localhost:7004/media-service/media";
	
	@PostMapping("/media")
	public void post(@RequestParam("file") MultipartFile file,@RequestParam("url") String url,@RequestParam("title") String title,
			@RequestParam("description") String description,@RequestParam("tags") String tags,@RequestParam("userid") String userid,
			@RequestParam("type") String type) {
		logger.info("title : "+title);
		logger.info("userid: "+userid);
		logger.info("url : "+url);
		logger.info("desc : "+description);
		logger.info("tags : "+tags );
		logger.info("type : "+type);
		
		logger.info(file.getOriginalFilename() + " : "  +file.getSize());
		
		// create a model using other info
		MediaDataModel model = new MediaDataModel(Integer.parseInt(userid),url,title,description,tags,type);
		
		//this.restTemplate.getForObject(MEDIA_URL, MediaDataModel.class);
		// 1. call media microservice to save data in db
		this.mediaProxy.saveData(model);
		
		// 2. call media microservice to upload file
		this.mediaProxy.save(file);//,model);
		
		
		NewsFeedModel feed = new NewsFeedModel();
		feed.setFeed(" Media Uploaded");
		feed.setUserId(Integer.parseInt(userid));
		this.newsFeedServiceProxy.addNewsFeed(feed);
	}
		
	@GetMapping("/media/{userId}")
	public ResponseEntity<List<MediaDataModelResponse>> userMedia(@PathVariable Integer userId)
	{
		ResponseEntity<List<MediaDataModelResponse>> response=this.mediaProxy.getmediaByUserId(userId);
		return response;
		
	}
	@GetMapping("/mediadetails/{mediaId}")
	public ResponseEntity<MediaDetails> getMedialDetailsById(@PathVariable Integer mediaId){
		MediaData media = this.mediaProxy.getDetailsBymediaId(mediaId).getBody();
			MediaDetails data = new MediaDetails(media.getId(), media.getUserid(), media.getUrl(), media.getTitle(),media.getDescription(),media.getTags(),media.getType());
		ResponseEntity<MediaDetails> result = new ResponseEntity<MediaDetails>(data,HttpStatus.OK);	
		
		return result;
	}
		
	}	



	
