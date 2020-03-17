package com.pixogram.mediaplumbing.feignproxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pixogram.mediaplumbing.model.Media;
import com.pixogram.mediaplumbing.model.MediaData;
import com.pixogram.mediaplumbing.model.MediaDataModel;
import com.pixogram.mediaplumbing.model.MediaDataModelResponse;
import com.pixogram.mediaplumbing.model.Medialist;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;


@FeignClient(name ="api-gateway")//,configuration = {MediaServiceProxy.MultipartSupportConfig.class})
@RibbonClient(name ="media-service")
public interface MediaServiceProxy {
	
	
	@GetMapping("/media-service/media/user/{userId}")
	public ResponseEntity<List<MediaDataModelResponse>> getmediaByUserId(@PathVariable Integer userId);



	@PostMapping(value = "/media-service/media", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public boolean save(MultipartFile file);// ,@RequestBody MediaDataModel media);
	
	@PostMapping(value = "/media-service/mediadata")
	public boolean saveData(@RequestBody MediaDataModel media);
	
	@GetMapping("/media-service/mediadetails/{mediaId}")
	public ResponseEntity<MediaData> getDetailsBymediaId(@PathVariable Integer mediaId);
	
}
