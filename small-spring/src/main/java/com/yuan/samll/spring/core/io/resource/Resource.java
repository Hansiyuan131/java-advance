package com.yuan.samll.spring.core.io.resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:18
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
