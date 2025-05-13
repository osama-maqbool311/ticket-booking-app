package com.daas.translator;


import com.daas.dto.request.ShowCreateRequest;
import com.daas.entity.Show;

public class ShowTranslator {
    public static Show toEntity(ShowCreateRequest request) {
        Show show = new Show();
        show.setTitle(request.getTitle());
        show.setLocation(request.getLocation());
        show.setStartTime(request.getStartTime());
        show.setEndTime(request.getEndTime());
        return show;
    }
}
