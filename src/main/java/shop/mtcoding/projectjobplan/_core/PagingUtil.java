package shop.mtcoding.projectjobplan._core;

import java.util.ArrayList;
import java.util.List;

public class PagingUtil {

    public static List<Integer> getPageList(int totalPageCount) {
        List<Integer> pageList = new ArrayList<>();
        for (int i = 0; i < totalPageCount; i++) {
            pageList.add(i);
        }
        return pageList;
    }

    public static int getTotalPageCount(int totalCount) {
        int remainCount = totalCount % Constant.PAGING_COUNT;
        int totalPageCount = totalCount / Constant.PAGING_COUNT;
        if (remainCount > 0) {
            totalPageCount += 1;
        }
        return totalPageCount;
    }
}
