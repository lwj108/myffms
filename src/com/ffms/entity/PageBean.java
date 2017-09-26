package com.ffms.entity;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;


/**
 * 因为分页查询结果返回的是一个 Page 对象，而 Page 对象继承自ArrayList，
 * 但是如果我们直接返回ArrayList的话，在一些场景下回遇到问题，比如在JSON
 * 处理Page类型的结果时，会被当成List来JSON格式化，会丢弃 Page 对象的所
 * 有扩展属性，所以这里我们要将分页的结果 Page 类型转换成我们自己定义的 PageBean.
 *  我们自己定义的PageBean没有继承ArrayList，而是包含一个List属性来保存
 *  分页结果。所以避免前面的问题。
 * @author 李维俊
 *
 * @param <T>
 */
public class PageBean<T> implements Serializable {
    private static final long serialVersionUID = 8656597559014685635L;
    private long total;        //总记录数
    private List<T> list;    //结果集
    private int pageNum;    // 第几页
    private int pageSize;    // 每页记录数
    private int pages;        // 总页数
    private int size;        // 当前页的数量 <= pageSize，该属性来自ArrayList的size属性
    
    /**
     * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理，
     * 而出现一些问题。
     * @param list          page结果
     * @param navigatePages 页码数量
     */
    public PageBean(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.list = page;
            this.size = page.size();
        }
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}