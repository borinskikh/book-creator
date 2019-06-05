package com.xiaoniang.epub.innerfiles;

import com.xiaoniang.epub.api.EpubBook;
import com.xiaoniang.epub.api.InnerFile;

public class ContentOPF extends InnerFile {

    ContentOPF(EpubBook epubBook, int start, int end, int volume) {
	setInnerPath(epubBook.innerFolderPath(0) + "content.opf");
	setEpubBook(epubBook);
	addContent("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
	addContent("<package xmlns=\"http://www.idpf.org/2007/opf\" unique-identifier=\"BookId\" version=\"2.0\">\r\n");
	addContent("  <metadata xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:opf=\"http://www.idpf.org/2007/opf\">\r\n");
	addContent("    <dc:identifier id=\"BookId\" opf:scheme=\"XN\">"+epubBook.bookID()+epubBook.title()+epubBook.volumeTitle(volume)+"</dc:identifier>\r\n");
	addContent("    <dc:title>"+epubBook.title()+epubBook.volumeTitle(volume)+"</dc:title>\r\n");
	addContent("    <dc:creator opf:file-as=\""+epubBook.author()+"\" opf:role=\"aut\">"+epubBook.author()+"</dc:creator>\r\n");
	addContent("    <dc:language>en</dc:language>\r\n");
	addContent("    <dc:date opf:event=\"creation\">"+epubBook.dateOfCreation()+"</dc:date>\r\n");
	addContent("    <dc:publisher>WuxiaWorld.com</dc:publisher>\r\n");
	addContent("<dc:description>"+escapeHtml(epubBook.description())+"</dc:description>");
	addContent("<dc:contributor opf:file-as=\"Programmer\" opf:role=\"oth\">XiaoNiang [https://github.com/XiaoNiang]</dc:contributor>");
	addContent("<dc:contributor opf:file-as=\"Translator\" opf:role=\"trl\">"+epubBook.translator()+"</dc:contributor>");
	for (String genre : epubBook.genres(0)) {
	    addContent("<dc:subject>"+genre+"</dc:subject>");
	}
	addContent("<dc:source>http://WuxiaWorld.com</dc:source>");
	addContent("    <dc:rights>All materials' copyrights reserved by their respective authors and the associated publishers. Please respect their rights. Works will be deleted upon request by copyright holders.</dc:rights>\r\n");
	addContent("    <meta name=\"cover\" content=\"cover.jpg\" />\r\n");
	addContent("  </metadata>\r\n");
	addContent("  <manifest>\r\n");
	addContent("    <item href=\"toc.ncx\" id=\"ncx\" media-type=\"application/x-dtbncx+xml\" />\r\n");
	addContent("    <item href=\"Text/cover.xhtml\" id=\"cover.xhtml\" media-type=\"application/xhtml+xml\" />\r\n");
	addContent("    <item href=\"Text/description.xhtml\" id=\"description.xhtml\" media-type=\"application/xhtml+xml\" />\r\n");
	addContent("    <item href=\"Images/cover.jpg\" id=\"cover.jpg\" media-type=\"image/jpeg\"/>");
	addContent("    <item href=\"Styles/stylesheet.css\" id=\"stylesheet.css\" media-type=\"text/css\" />\r\n");
	for (int i = start; i <= end; i++) {
	    String chapterFileIndex = "" + i;
	    while (chapterFileIndex.length() < 4) {
		chapterFileIndex = "0" + chapterFileIndex;
	    }
	    addContent("    <item href=\"Text/chapter_" + chapterFileIndex + ".xhtml\" id=\"Chapter_" + chapterFileIndex
		    + ".xhtml\" media-type=\"application/xhtml+xml\" />\r\n");
	}
	addContent("  </manifest>\r\n");
	addContent("  <spine toc=\"ncx\">\r\n");
	addContent("    <itemref idref=\"cover.xhtml\" />\r\n");
	addContent("    <itemref idref=\"description.xhtml\" />\r\n");
	for (int i = start; i <= end; i++) {
	    String chapterFileIndex = "" + i;
	    while (chapterFileIndex.length() < 4) {
		chapterFileIndex = "0" + chapterFileIndex;
	    }
	    addContent("    <itemref idref=\"Chapter_" + chapterFileIndex + ".xhtml\" />\r\n");
	}
	addContent("  </spine>\r\n");
	addContent("  <guide>\r\n");
	addContent("    <reference href=\"Text/cover.xhtml\" title=\"Cover\" type=\"cover\" />\r\n");
	addContent("  </guide>\r\n");
	addContent("</package>");
    }

}