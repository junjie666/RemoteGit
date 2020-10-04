package bean;

import java.util.List;

/**
 * 分页模型
 * @author shenjunjie
 * @param <T>
 *
 */

public class Page<T>
{
	private int pageNum; //当前页数
	private int totalPageNum; //总页码
	private int totalCount; //总记录数
	private int perCount=2; //每页的记录数
	private int index; //数据库查询索引
	private List<T> pageData; //当前页的数据
	private boolean hasNext; //判断是否有下页
	private boolean hasPre; //判断是否有上页
	private String url;
	
	
	public int getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(int pageNum)
	{
		if(pageNum<1) pageNum=1;
		if(pageNum>getTotalPageNum()) pageNum=getTotalPageNum();
		this.pageNum = pageNum;
	}

	public int getTotalPageNum()
	{
		return getTotalCount()%getPerCount()==0?getTotalCount()/getPerCount():getTotalCount()/getPerCount()+1;
	}

	public void setTotalPageNum(int totalPageNum)
	{
		this.totalPageNum = totalPageNum;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public int getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	public int getPerCount()
	{
		return perCount;
	}

	public void setPerCount(int perCount)
	{
		this.perCount = perCount;
	}

	public int getIndex()
	{
		//0-1 1
		//2-3 2
		//4-5 3
		int index=(getPageNum()-1)*getPerCount();
		return index>0?index:0;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	public List<T> getPageData()
	{
		return pageData;
	}

	public void setPageData(List<T> pageData)
	{
		this.pageData = pageData;
	}

	public boolean isHasNext()
	{
		return getPageNum()<getTotalPageNum();
	}

	public void setHasNext(boolean hasNext)
	{
		this.hasNext = hasNext;
	}

	public boolean isHasPre()
	{
		return getPageNum()>1;
	}

	public void setHasPre(boolean hasPre)
	{
		this.hasPre = hasPre;
	}

	public Page()
	{
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public Page(int pageNum, int totalPageNum, int totalCount, int perCount, int index, List<T> pageData,
			boolean hasNext, boolean hasPre)
	{
		super();
		this.pageNum = pageNum;
		this.totalPageNum = totalPageNum;
		this.totalCount = totalCount;
		this.perCount = perCount;
		this.index = index;
		this.pageData = pageData;
		this.hasNext = hasNext;
		this.hasPre = hasPre;
	}

	@Override
	public String toString()
	{
		return "Page [pageNum=" + pageNum + ", totalPageNum=" + totalPageNum + ", totalCount=" + totalCount
				+ ", perCount=" + perCount + ", index=" + index + ", pageData=" + pageData + ", hasNext=" + hasNext
				+ ", hasPre=" + hasPre + "]";
	}
	

	
	
	
}
