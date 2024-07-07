package ru.hogwarts.school.services;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.AvatarDto;

import java.io.IOException;

public interface AvatarService{

    AvatarDto getFromBd(Long id);

    Avatar getFromDisk(Long id);

    void save(Long studentId, MultipartFile multipartFile) throws IOException;

}
