package com.github.ericomonteiro.smartstock.model.mapper;

import com.github.ericomonteiro.smartstock.model.dto.photo.AlbumDto;
import com.github.ericomonteiro.smartstock.model.dto.product.FileResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumDtoMapper {

    public static AlbumDto fromFileResponseDto(FileResponseDto file, String uriPrefix) {
        return new AlbumDto(
                uriPrefix + '/' + file.getName(),
                file.getMain()
        );
    }

    public static List<AlbumDto> fromListFileResponseDto(List<FileResponseDto> files, String uriPrefix) {
        return files
                .stream()
                .map((f) -> AlbumDtoMapper.fromFileResponseDto(f, uriPrefix))
                .collect(Collectors.toList());
    }

}
