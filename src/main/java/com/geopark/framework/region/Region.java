package com.geopark.framework.region;

import java.io.File;
import java.lang.reflect.Method;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;

public class Region {
	
	private static String getRootPath() {

        return System.getProperty("user.dir");
    }
	
	private static String getResourcePath() {
        String resourcePath = getRootPath() + "/src/main/resources";
        return resourcePath;
    }

	public static String getCityInfo(String ip){
		 
        //db
//        String dbPath = IPUtil.class.getResource("/ip2region.db").getPath();
		String dbPath = getResourcePath() + File.separator +  "ip2region.db";
        File file = new File(dbPath);
        if ( file.exists() == false ) {
            System.out.println("Error: Invalid ip2region.db file");
        }
 
        //查询算法
        int algorithm = DbSearcher.BTREE_ALGORITHM; //B-tree
                        //DbSearcher.BINARY_ALGORITHM //Binary
                        //DbSearcher.MEMORY_ALGORITYM //Memory
        try {
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config, dbPath);
 
            //define the method
            Method method = null;
            switch ( algorithm )
            {
            case DbSearcher.BTREE_ALGORITHM:
                method = searcher.getClass().getMethod("btreeSearch", String.class);
                break;
            case DbSearcher.BINARY_ALGORITHM:
                method = searcher.getClass().getMethod("binarySearch", String.class);
                break;
            case DbSearcher.MEMORY_ALGORITYM:
                method = searcher.getClass().getMethod("memorySearch", String.class);
                break;
            }
 
            DataBlock dataBlock = null;
            if ( Util.isIpAddress(ip) == false ) {
                System.out.println("Error: Invalid ip address");
            }
 
            dataBlock  = (DataBlock) method.invoke(searcher, ip);
 
            return dataBlock.getRegion();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
 
    public static void main(String[] args)  throws Exception{
        System.err.println(getCityInfo("221.237.119.174"));
    }

}
