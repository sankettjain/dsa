package com.pratice.dsa.interview;

import org.apache.http.HttpResponse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class ImageDownloader {

    private String webPage;
    private static Set<String> downloadedImages = new HashSet<>();
    private static Set<String> visitedUrls = new HashSet<>();

    public Set<String> getDownloadedImages() {
        return downloadedImages;
    }

    public Set<String> getURLS() {
        return visitedUrls;
    }

    private void downloadImagesFromPage(String path) throws IOException {

        for(String url: visitedUrls) {
            Document doc = Jsoup.connect(url).get();
            Elements imgElements = doc.getElementsByTag("img");
            for (Element imgElement : imgElements) {
                String imgSrc = imgElement.attr("src");
                // Ensure that the image source URL is absolute
                if (!imgSrc.startsWith("http")) {
                    imgSrc = url + imgSrc;
                }
                // Extract the image file name from the URL
                String fileName = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);

                if(downloadedImages.contains(fileName)){
                    continue;
                } else{
                    downloadedImages.add(fileName);
                }

                // Open a connection to the image URL and download the image
                try (BufferedInputStream in = new BufferedInputStream(new URL(imgSrc).openStream());
                     FileOutputStream out = new FileOutputStream(path + fileName)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                    System.out.println("Downloaded: " + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        String path = "/Users/sanketjain/projects/files/";
        String startingUrl = "https://www.instahyre.com/candidate/opportunities/?matching=true"; // Replace with the URL of the web page you want to start from
        ImageDownloader imageDownloader = new ImageDownloader();

        imageDownloader.downloadImagesRecursively(startingUrl);

        imageDownloader.downloadImagesFromPage(path);

        System.out.println(imageDownloader.getDownloadedImages());
        System.out.println(imageDownloader.getURLS());


    }

    private void downloadImagesRecursively(String url) throws IOException {
        if (!visitedUrls.contains(url)) {
            visitedUrls.add(url); // Mark URL as visited
            Document doc = Jsoup.connect(url).get();
            // Find links to nested pages and recursively download images from them
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                String nestedUrl = link.absUrl("href");
                if (!nestedUrl.isEmpty()) {
                    downloadImagesRecursively(nestedUrl);
                }
            }
        }
    }
}

