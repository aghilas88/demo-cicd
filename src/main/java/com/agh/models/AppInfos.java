package com.agh.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AppInfos {
    private String appName;
    private String appDescription;
}
