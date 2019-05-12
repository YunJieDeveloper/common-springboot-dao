package com.example.dao.jasypt;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyDetector;
import org.springframework.util.Assert;

/**
 * @program: common-springboot-dao
 * @description: 自定义加密串前后包装格式
 * @author: Hession
 * @create: 2019-05-12 15:10
 **/

/**
 * 若无此类，默认是DefaultPropertyDetector类
 */
public class CustomDetector implements EncryptablePropertyDetector {

    private String prefix = "RSA(";
    private String suffix = ")";

    public CustomDetector() {
    }

    public CustomDetector(String prefix, String suffix) {
        Assert.notNull(prefix, "Prefix can't be null");
        Assert.notNull(suffix, "Suffix can't be null");
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public boolean isEncrypted(String property) {
        if (property == null) {
            return false;
        } else {
            String trimmedValue = property.trim();
            return trimmedValue.startsWith(this.prefix) && trimmedValue.endsWith(this.suffix);
        }
    }

    @Override
    public String unwrapEncryptedValue(String property) {
        return property.substring(this.prefix.length(), property.length() - this.suffix.length());
    }
}
