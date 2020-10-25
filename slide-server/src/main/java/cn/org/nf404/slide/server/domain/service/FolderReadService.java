package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.api.request.folder.FolderQueryRequest;
import cn.org.nf404.slide.api.response.folder.FolderInfo;
import cn.org.nf404.slide.api.response.slide.SlideInfo;
import cn.org.nf404.slide.common.utils.AssertUtil;
import cn.org.nf404.slide.server.domain.converter.RequestConverter;
import cn.org.nf404.slide.server.domain.model.Folder;
import cn.org.nf404.slide.server.domain.model.Slide;
import cn.org.nf404.slide.server.repository.criteria.SlideQueryCriteria;
import cn.org.nf404.slide.server.repository.impl.FolderRepository;
import cn.org.nf404.slide.server.repository.impl.SlideRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ghy Arcry
 * @since 2020-10-12
 */
@Service
@AllArgsConstructor
public class FolderReadService {
    private final FolderRepository folderRepository;
    private final SlideRepository slideRepository;
    private final RequestConverter converter;

    public FolderInfo query(FolderQueryRequest request) {
        Folder byId = this.folderRepository.findById(request.getId());
        FolderInfo folderInfo = this.converter.convert(byId);

        AssertUtil.nonExist(folderInfo, "folder", request.getId());

        SlideQueryCriteria criteria = SlideQueryCriteria.builder()
                .folderId(byId.getId())
                .build();
        List<Slide> slideList = this.slideRepository.query(criteria);
        List<SlideInfo> slideInfoList = slideList.stream()
                .map(this.converter::convert)
                .collect(Collectors.toList());
        folderInfo.setSlides(slideInfoList);

        return folderInfo;
    }

}
