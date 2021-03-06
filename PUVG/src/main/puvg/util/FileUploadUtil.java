package main.puvg.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	static Logger logger = LogManager.getLogger(FileUploadUtil.class);
	
	// 파일 업로드 메서드
	public static String fileUpload(MultipartFile file, HttpServletRequest request) throws IOException {
		
		logger.info("fileUpload 호출 성공 >>> : ");
		String real_name = null;
		// MultipartFile 클래스의 getFile() 메서드로 클라이언트가 업로드한 파일명
		String org_name = file.getOriginalFilename();
		logger.info("org_name >>> : " + org_name);
		
		// 파일명 변경 (중복 방지)
		if(org_name != null && (!org_name.equals(""))) {
			real_name = "fileupload_" + System.currentTimeMillis() + "_" + org_name;
			String docRoot = request.getSession().getServletContext().getRealPath("/uploadImg");
			
			File fileDir = new File(docRoot);
			if(!fileDir.exists()) {
				fileDir.mkdir();
			}
			
			File fileAdd = new File(docRoot + "/" + real_name);
			logger.info("경로 >>> : " + fileAdd);
			
			file.transferTo(fileAdd);
		}
		
		return real_name;
	}
	
	// 파일 삭제 메서드
	public static void fileDelete(String fileName, HttpServletRequest request) throws IOException {
		logger.info("fileDelete 호출 성공 >>> : ");
		boolean result = false;
		String docRoot = request.getSession().getServletContext().getRealPath("/uploadStorage");
		
		File fileDelete = new File(docRoot + "/" + fileName);
		logger.info("fileDelete >>> : ");
		if(fileDelete.exists() && fileDelete.isFile()) {
			result = fileDelete.delete();
		}
		
		logger.info(result);;
	}
}
