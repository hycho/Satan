package com.satan.DevilDom.Baraddur.chapter01.introduce;

import java.io.File;
import java.io.FileFilter;

/**
 * 
 * Java8의 새로운 기능들...
 * 1. 스트림(Stream) 처리.
 * 2. 동작 파라미터화(behavior parameterization)로 메서드에 코드 전달하기.
 * 3. 병렬성과 공유 가변 데이터(Shared mutable data)
 * 4. 메서드 레퍼런스(method reference)
 */
public class Introduce {

	public static void main(String[] args) {
		hiddenFile();
		
	}
	
	/**
	 * 람다식을 통해 로직을 쉽게 사용하는 방법을 간략하게 소개하는 1번째 예제.
	 */
	public static void hiddenFile() {
		File[] firstHiddenFiles = new File("C:\\").listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isHidden();
			}
		});
		
		for(File f : firstHiddenFiles) {
			System.out.println(f.getName());
		}
		
		File[] secondHiddenFiles = new File("C:\\").listFiles(File::isHidden);
		
		for(File f : secondHiddenFiles) {
			System.out.println(f.getName());
		}
	}

}
