package com.github.ericomonteiro.smartstock.model.mapper;

import com.github.ericomonteiro.smartstock.model.Photo;
import com.github.ericomonteiro.smartstock.model.Product;
import com.github.ericomonteiro.smartstock.model.dto.photo.PhotoDto;
import com.github.ericomonteiro.smartstock.model.dto.product.FileResponseDto;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PhotoMapper {

    public static Photo of(Product product, MultipartFile file, Boolean main) throws IOException {
        return new Photo(
                product,
                main,
                FilenameUtils.getExtension(file.getOriginalFilename()),
                file.getBytes()
        );
    }

    public static FileResponseDto toFileResponseDto(Photo photo) {
        return new FileResponseDto(
                photo.getId().toString(),
                photo.getFileType(),
                photo.getMain()
        );
    }

    public static List<FileResponseDto> toListFileResponseDto(List<Photo> photos) {
        return photos.stream().map(PhotoMapper::toFileResponseDto).collect(Collectors.toList());
    }

    public static PhotoDto toPhotoDto(Photo photo) {
        return new PhotoDto(
                photo.getId().toString(),
                photo.getMain(),
                photo.getFileType(),
                photo.getData()
        );
    }

}
