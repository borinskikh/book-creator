package com.xiaoniang.epub.api;

import java.io.File;
import java.io.IOException;
import com.xiaoniang.epub.resources.Log;

public class CreateEpubBook {

	public static void main(String[] args) {
		String path = "output" + File.separator;
		new File(path).mkdir();
		try {
			Log.println("[Start]");
			new EpubBook(path, "https://www.novelupdates.com/series/pure-love-✕-insult-complex/").create();;
		} catch (IOException e) {
			Log.println("[!] Couldn't create the Epub book");
			e.printStackTrace(Log.stream());
		} finally {
			Log.close();
		}
	}
}