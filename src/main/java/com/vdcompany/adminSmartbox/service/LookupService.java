package com.vdcompany.adminSmartbox.service;

import java.util.List;
import com.vdcompany.adminSmartbox.bean.lookup.LookupVO;

public interface LookupService {


	List<LookupVO> getLookupAgency();
	List<LookupVO> getLookupStoreInfo();
	List<LookupVO> getLookupBrandInfo();

	
}
