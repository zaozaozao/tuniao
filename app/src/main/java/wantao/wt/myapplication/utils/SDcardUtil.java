package wantao.wt.myapplication.utils;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;


/**
 * SD卡工具类
 *
 * @author:zhangnn
 * @createtime:2016/5/5 16:34
 */
public final class SDcardUtil
{
	/** 默认根目录名称 */
	private static String ROOT_DIR     = "myapplication";
	/** 默认图片目录名称 */
	public static final String IMAGE_DIR    = "images";
	/** 默认文件目录名称 */
	public static final String FILE_DIR     = "files";
	/** 默认缓存目录名称 */
	public static final String CACHE_DIR    = "cache";
	/** 默认APK目录名称 */
	public static final String APK_DIR      = "apk";
	/** 默认DB目录名称 */
	public static final String DB_DIR       = "db";
	/** 默认音频目录名称 */
	public static final String AUDIO_DIR    = "audio";
	/** 默认视频目录名称 */
	public static final String VIDEO_DIR    = "video";
	/** 默认书籍目录名称 */
	public static final String BOOK_DIR     = "books";
	/** 默认日志目录名称 */
	public static final String LOG_DIR      = "logs";
	
	/** 默认根目录文件夹 */
	private static File rootDirFile  = null;
	/** 默认图片目录 */
	private static File imageDirFile = null;
	/** 默认文件目录 */
	private static File fileDirFile  = null;
	/** 默认缓存目录 */
	private static File cacheDirFile = null;
	/** 默认apk文件的目录 */
	private static File apkDirFile   = null;
	/** 默认数据库文件的目录 */
	private static File dbDirFile    = null;
	/** 默认音频的目录 */
	private static File audioDirFile = null;
	/** 默认视频的目录 */
	private static File videoDirFile = null;
	/** 默认书籍的目录 */
	private static File bookDirFile  = null;
	/** 默认日志的目录 */
	private static File logDirFile   = null;

	/**
	 * 设置SD卡文件存放根目录名称
	 * @param dirName
	 */
	public static void setRootDirName(String dirName){
		ROOT_DIR = dirName;
	}
	
	/**
	 * SD卡是否可用
	 * 
	 * @return true:可用,false:不可用
	 */
	public static boolean isCanUseSD() {
		try
		{
			return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 初始化目录
	 */
	public static void initDir() {
		
		//默认根目录
		String downloadRootPath = File.separator + ROOT_DIR + File.separator;
		//默认缓存目录
		String cacheDownloadPath = downloadRootPath + CACHE_DIR + File.separator;
		//默认图片目录
		String imageDownloadPath = cacheDownloadPath + IMAGE_DIR + File.separator;
		//默认音频目录
		String audioDownloadPath = cacheDownloadPath + AUDIO_DIR + File.separator;
		//默认视频目录
		String videoDownloadPath = cacheDownloadPath + VIDEO_DIR + File.separator;
		//默认书籍目录
		String bookDownloadPath = cacheDownloadPath + BOOK_DIR + File.separator;
		//默认文件目录
		String fileDownloadPath = downloadRootPath + FILE_DIR + File.separator;
		//默认apk目录
		String apkDownloadPath = downloadRootPath + APK_DIR + File.separator;
		//默认DB目录
		String dbDownloadPath = downloadRootPath + DB_DIR + File.separator;
		//默认日志目录
		String logDownloadPath = downloadRootPath + LOG_DIR + File.separator;
		
		try
		{
			File root;
			if (isCanUseSD())
			{
				root = Environment.getExternalStorageDirectory();
			}
			else
			{
				root = Environment.getRootDirectory();
			}
			rootDirFile = makeDir(root.getAbsolutePath() + downloadRootPath);
			cacheDirFile = makeDir(root.getAbsolutePath() + cacheDownloadPath);
			imageDirFile = makeDir(root.getAbsolutePath() + imageDownloadPath);
			fileDirFile = makeDir(root.getAbsolutePath() + fileDownloadPath);
			apkDirFile = makeDir(root.getAbsolutePath() + apkDownloadPath);
			dbDirFile = makeDir(root.getAbsolutePath() + dbDownloadPath);
			audioDirFile = makeDir(root.getAbsolutePath() + audioDownloadPath);
			videoDirFile = makeDir(root.getAbsolutePath() + videoDownloadPath);
			bookDirFile = makeDir(root.getAbsolutePath() + bookDownloadPath);
			logDirFile = makeDir(root.getAbsolutePath() + logDownloadPath);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建文件夹
	 * 
	 * @param path
	 *            文件夹路径
	 * @return File
	 */
	private static File makeDir(String path) {
		File file = new File(path);
		if (!file.exists())
		{
			file.mkdirs();
		}
		return file;
	}
	
	/**
	 * 计算sdcard上的剩余空间.
	 *
	 * @return the int
	 */
	public static int freeSpaceOnSD() {
		StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
		double sdFreeMB = ((double) stat.getAvailableBlocks() * (double) stat.getBlockSize()) / 1024 * 1024;
		return (int) sdFreeMB;
	}
	
	/**
	 * 获取下载根目录文件夹
	 * 
	 * @return file
	 */
	public static File getRootDirFile() {
		if (rootDirFile == null)
		{
			initDir();
		}
		return rootDirFile;
	}
	
	/**
	 * 获取下载根目录
	 */
	public static String getRootDir() {
		if (rootDirFile == null)
		{
			initDir();
		}
		return rootDirFile.getPath();
	}
	
	/**
	 * 获取下载图片文件夹
	 * 
	 * @return file
	 */
	public static File getImageDirFile() {
		if (imageDirFile == null)
		{
			initDir();
		}
		return imageDirFile;
	}
	
	/**
	 * 获取下载图片文件夹的目录
	 */
	public static String getImageDir() {
		if (imageDirFile == null)
		{
			initDir();
		}
		return imageDirFile.getPath();
	}
	
	/**
	 * 获取下载文件夹
	 * 
	 * @return file
	 */
	public static File getFileDirFile() {
		if (fileDirFile == null)
		{
			initDir();
		}
		return fileDirFile;
	}
	
	/**
	 * 获取下载文件夹的目录
	 */
	public static String getFileDir() {
		if (fileDirFile == null)
		{
			initDir();
		}
		return fileDirFile.getPath();
	}
	
	/**
	 * 获取缓存目录文件夹
	 * 
	 * @return file
	 */
	public static File getCacheDirFile() {
		if (cacheDirFile == null)
		{
			initDir();
		}
		return cacheDirFile;
	}
	
	/**
	 * 获取缓存文件夹的目录
	 */
	public static String getCacheDir() {
		if (cacheDirFile == null)
		{
			initDir();
		}
		return cacheDirFile.getPath();
	}
	
	/**
	 * 获取apk文件夹
	 * 
	 * @return file
	 */
	public static File getApkDirFile() {
		if (apkDirFile == null)
		{
			initDir();
		}
		return apkDirFile;
	}
	
	/**
	 * 获取apk文件夹的目录
	 */
	public static String getApkDir() {
		if (apkDirFile == null)
		{
			initDir();
		}
		return apkDirFile.getPath();
	}
	
	/**
	 * 获取数据库文件夹
	 * 
	 * @return file
	 */
	public static File getDbDirFile() {
		if (dbDirFile == null)
		{
			initDir();
		}
		return dbDirFile;
	}
	
	/**
	 * 获取数据库文件夹的目录
	 */
	public static String getDbDir() {
		if (dbDirFile == null)
		{
			initDir();
		}
		return dbDirFile.getPath();
	}
	
	/**
	 * 获取音频文件夹
	 * 
	 * @return file
	 */
	public static File getAudioDirFile() {
		if (audioDirFile == null)
		{
			initDir();
		}
		return audioDirFile;
	}
	
	/**
	 * 获取音频文件夹的目录
	 * 
	 * @return string filePath
	 */
	public static String getAudioDir() {
		if (audioDirFile == null)
		{
			initDir();
		}
		return audioDirFile.getPath();
	}
	
	/**
	 * 获取视频文件夹
	 */
	public static File getVideoDirFile() {
		if (videoDirFile == null)
		{
			initDir();
		}
		return videoDirFile;
	}
	
	/**
	 * 获取视频文件夹的目录
	 */
	public static String getVideoDir() {
		if (videoDirFile == null)
		{
			initDir();
		}
		return videoDirFile.getPath();
	}
	
	/**
	 * 获取书籍文件夹
	 */
	public static File getBookDirFile() {
		if (bookDirFile == null)
		{
			initDir();
		}
		return bookDirFile;
	}
	
	/**
	 * 获取书籍文件夹的目录
	 */
	public static String getBookDir() {
		if (bookDirFile == null)
		{
			initDir();
		}
		return bookDirFile.getPath();
	}
	
	/**
	 * 获取日志文件夹
	 */
	public static File getLogDirFile() {
		if (logDirFile == null)
		{
			initDir();
		}
		return logDirFile;
	}
	
	/**
	 * 获取日志文件夹的目录
	 */
	public static String getLogDir() {
		if (logDirFile == null)
		{
			initDir();
		}
		return logDirFile.getPath();
	}
}
