package com.example.dao.jasypt;

/**
 * @program: common-springboot-dao
 * @description: 自定义解密service类
 * @author: Hession
 * @create: 2019-05-12 15:16
 **/

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;
import com.ulisesbocchio.jasyptspringboot.exception.DecryptionException;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jasypt.util.text.BasicTextEncryptor;

import javax.annotation.PostConstruct;

/**
 * 若无此自定义类，默认执行 DefaultPropertyResolver
 */
public class CustomResolver implements EncryptablePropertyResolver {

    private BasicTextEncryptor encryptor = new BasicTextEncryptor();
    private CustomDetector detector = new CustomDetector();
   @PostConstruct
   public void init(){
       encryptor.setPassword("salt");
   }

    @Override
    public String resolvePropertyValue(String value) {
        String actualValue = value;
        if (this.detector.isEncrypted(value)) {
            try {
                //真正需要调用的自定义解密方法。可以是rsa\des等加解密方法。
                //此处依旧使用jasypt框架默认的加解密方法
                actualValue = this.encryptor.decrypt(this.detector.unwrapEncryptedValue(value.trim()));
            } catch (EncryptionOperationNotPossibleException var4) {
                throw new DecryptionException("Decryption of Properties failed,  make sure encryption/decryption passwords match", var4);
            }
        }

        return actualValue;
    }
}
