package com.ffms.entity;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;


/**
 * ��Ϊ��ҳ��ѯ������ص���һ�� Page ���󣬶� Page ����̳���ArrayList��
 * �����������ֱ�ӷ���ArrayList�Ļ�����һЩ�����»��������⣬������JSON
 * ����Page���͵Ľ��ʱ���ᱻ����List��JSON��ʽ�����ᶪ�� Page �������
 * ����չ���ԣ�������������Ҫ����ҳ�Ľ�� Page ����ת���������Լ������ PageBean.
 *  �����Լ������PageBeanû�м̳�ArrayList�����ǰ���һ��List����������
 *  ��ҳ��������Ա���ǰ������⡣
 * @author ��ά��
 *
 * @param <T>
 */
public class PageBean<T> implements Serializable {
    private static final long serialVersionUID = 8656597559014685635L;
    private long total;        //�ܼ�¼��
    private List<T> list;    //�����
    private int pageNum;    // �ڼ�ҳ
    private int pageSize;    // ÿҳ��¼��
    private int pages;        // ��ҳ��
    private int size;        // ��ǰҳ������ <= pageSize������������ArrayList��size����
    
    /**
     * ��װPage������Ϊֱ�ӷ���Page������JSON�����Լ���������»ᱻ����List������
     * ������һЩ���⡣
     * @param list          page���
     * @param navigatePages ҳ������
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