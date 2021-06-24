package com.vdcompany.adminSmartbox.mapper;

import com.vdcompany.adminSmartbox.bean.lookup.LookupVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LookupMapper {

	List<LookupVO> getLookupAgency();
	List<LookupVO> getLookupStoreInfo();
	List<LookupVO> getLookupBrandInfo();

}
