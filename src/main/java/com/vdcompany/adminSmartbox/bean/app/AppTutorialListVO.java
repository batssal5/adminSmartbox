package com.vdcompany.adminSmartbox.bean.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppTutorialListVO {
    private List<AppTutorialVO> list;

}
