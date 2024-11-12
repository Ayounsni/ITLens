package com.it.itlens.models.dtos.Results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterResultDTO {
    private String title;
    private List<SubChapterResultDTO> subChapters;
}

