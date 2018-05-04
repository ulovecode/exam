package com.ulovecode.common.utils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * Created by jackzhu on 2017/9/9.
 */
public class FileUtils {

    public byte[] getContent(String filePath) throws IOException {
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length
                && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file "
                    + file.getName());
        }
        fi.close();
        return buffer;
    }

    /**
     * the traditional io way
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(String filename) throws IOException {

        File f = new File(filename);
        if (!f.exists()) {
            throw new FileNotFoundException(filename);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }

    /**
     * NIO way
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray2(String filename) throws IOException {

        File f = new File(filename);
        if (!f.exists()) {
            throw new FileNotFoundException(filename);
        }

        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
                // do nothing
                // System.out.println("reading");
            }
            return byteBuffer.array();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Mapped File way MappedByteBuffer 可以在处理大文件时，提升性能
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray3(String filename) throws IOException {

        FileChannel fc = null;
        try {
            fc = new RandomAccessFile(filename, "r").getChannel();
            MappedByteBuffer byteBuffer = fc.map(MapMode.READ_ONLY, 0,
                    fc.size()).load();
            System.out.println(byteBuffer.isLoaded());
            byte[] result = new byte[(int) fc.size()];
            if (byteBuffer.remaining() > 0) {
                // System.out.println("remain");
                byteBuffer.get(result, 0, byteBuffer.remaining());
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                fc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static boolean forChannel(File f1,File f2){

        try{
            int length=2097152;
            FileInputStream in=new FileInputStream(f1);
            FileOutputStream out=new FileOutputStream(f2);
            FileChannel inC=in.getChannel();
            FileChannel outC=out.getChannel();
            ByteBuffer b=null;
            while(true){
                if(inC.position()==inC.size()){
                    inC.force(true);
                    inC.close();
                    outC.close();
                    return true;
                }
                if((inC.size()-inC.position())<length){
                    length=(int)(inC.size()-inC.position());
                }else
                    length=2097152;
                b=ByteBuffer.allocateDirect(length);
                inC.read(b);
                b.flip();
                outC.write(b);
                outC.force(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public static boolean forImage(File f1,File f2){
        try{
            int length=202097152;
            FileInputStream in=new FileInputStream(f1);
            RandomAccessFile out=new RandomAccessFile(f2,"rw");
            FileChannel inC=in.getChannel();
            MappedByteBuffer outC=null;
            MappedByteBuffer inbuffer=null;
            byte[] b=new byte[length];
            while(true){
                if(inC.position()==inC.size()){
                    inC.close();
                    outC.force();
                    out.close();
                    return true;
                }
                if((inC.size()-inC.position())<length){
                    length=(int)(inC.size()-inC.position());
                }else{
                    length=20971520;
                }
                b=new byte[length];
                inbuffer=inC.map(MapMode.READ_ONLY,inC.position(),length);
                inbuffer.load();
                inbuffer.get(b);
                outC=out.getChannel().map(MapMode.READ_WRITE,inC.position(),length);
                inC.position(b.length+inC.position());
                outC.put(b);
                outC.force();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean forceDelete(File f){
        boolean result = false;
        int tryCount = 0;
        while(!result && tryCount++ <10){
            System.gc();
            result = f.delete();
        }
        return result;
    }


    public static String getFileExt(String fileName){
        String types = fileName.substring(fileName.lastIndexOf(".") + 1);
        if(types.equals("mp4") || types.equals("avi")){
            return "video";
        }else if(types.equals("jpg") || types.equals("png")){
            return "image";
        }
        return null;
    }


}
