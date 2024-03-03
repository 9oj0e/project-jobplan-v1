package shop.mtcoding.projectjobplan._core;

import java.util.ArrayList;
import java.util.List;

public class PagingUtil {
    public static boolean isFirst(int currentPage) {
        return currentPage == 0 ? true : false;
    }

    public static boolean isLast(int currentPage, int totalCount) {
        int totalPageCount = getTotalPageCount(totalCount);
        return currentPage == totalPageCount - 1 ? true : false;
    }

    public static List<Integer> getPageList(int totalPageCount) {
        List<Integer> pageList = new ArrayList<>();
        for (int i = 0; i < totalPageCount; i++) {
            pageList.add(i);
        }
        /* RJS
        List<Integer> numberList = new ArrayList<>();
        int allPage;
        if (totalPage % 10 == 0) {
            allPage = totalCount - 1;
            for (int i = 1; i <= allPage; i++) {
                numberList.add(i);
                request.setAttribute("numberList", numberList);
            }
        } else if (totalPage % 10 != 0) {
            allPage = totalCount;
            for (int i = 1; i <= allPage; i++) {
                numberList.add(i);
                request.setAttribute("numberList", numberList);
            }
        }
        */
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
