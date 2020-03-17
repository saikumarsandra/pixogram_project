package com.pixogram.mediaservice.service;

import java.util.List;
import java.util.Optional;

import com.pixogram.mediaservice.entity.Media;
import com.pixogram.mediaservice.model.MediaData;
import com.pixogram.mediaservice.model.MediaDataModel;
import com.pixogram.mediaservice.model.MediaDataModelResponse;

public interface IMediaService {
	


	public List<Media> getall();
	public void save(MediaData action);
	public Optional<Media> getWithId(Integer id);
	public void updateuser(MediaData action);
	public List<MediaDataModelResponse> findAllMediaByUserId(Integer userId);
}