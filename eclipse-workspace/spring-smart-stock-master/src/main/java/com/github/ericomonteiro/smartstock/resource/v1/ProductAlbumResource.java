package com.github.ericomonteiro.smartstock.resource.v1;

import com.github.ericomonteiro.smartstock.model.dto.photo.AlbumDto;
import com.github.ericomonteiro.smartstock.model.dto.photo.PhotoDto;
import com.github.ericomonteiro.smartstock.model.dto.product.FileResponseDto;
import com.github.ericomonteiro.smartstock.model.mapper.AlbumDtoMapper;
import com.github.ericomonteiro.smartstock.service.photo.PhotoService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/product/{productId}/album")
@Transactional
public class ProductAlbumResource {

    private final PhotoService photoService;
    private final ServletContext context;

    @PostMapping
    public ResponseEntity<FileResponseDto> insertPhoto(
            @PathVariable("productId") Long productId,
            @RequestParam("file")MultipartFile file,
            @RequestParam("main")Boolean main
    ) throws IOException {
        var fileResponse = photoService.addPhotoToProduct(productId, file, main);
        return ResponseEntity
                .created(
                    ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/" + file.getName())
                        .build()
                        .toUri())
                .body(fileResponse);
    }

    @GetMapping
    public ResponseEntity<List<AlbumDto>> getAlbum(
            @PathVariable("productId") Long productId
    ) {
        var photos = photoService.getAlbum(productId);
        if (photos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        var uriPrefix = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .build(false).toUriString();

        return ResponseEntity.ok(AlbumDtoMapper.fromListFileResponseDto(photos, uriPrefix));
    }

    @GetMapping("/{photoId}")
    public void showPhoto(
            @PathVariable("productId") Long productId,
            @PathVariable("photoId") UUID photoId,
            HttpServletResponse response
    ) throws IOException {
        setPhotoResponse(photoService.getPhoto(photoId), response);
    }

    @GetMapping("/main")
    public void showMainPhoto(
            @PathVariable("productId") Long productId,
            HttpServletResponse response
    ) throws IOException {
        setPhotoResponse(photoService.getMainPhoto(productId), response);
    }

    @GetMapping("/download/main")
    public ResponseEntity<Resource> downloadMainPhoto(@PathVariable("productId") Long productId) {
        PhotoDto photo = photoService.getMainPhoto(productId);

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + photo.getFileName() + "\"")
                .body(new ByteArrayResource(photo.getData()));
    }

    private void setPhotoResponse(PhotoDto photo, HttpServletResponse response) throws IOException {
        var file = new ByteArrayResource(photo.getData());
        InputStream in = file.getInputStream();
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

}
