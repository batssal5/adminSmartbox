package com.vdcompany.adminSmartbox.bean.web.paging;

<<<<<<< HEAD

=======
>>>>>>> origin/0.1.1
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> origin/0.1.1
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagingVO {

    private String type;
    private int skip = -1;
    private int take = -1;
    private String requireTotalCount;
    private String totalSummary;
    private String filter;
    private String box_id;
    private String idx;
    private String store_idx;

}