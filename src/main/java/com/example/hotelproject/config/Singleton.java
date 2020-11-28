package com.example.hotelproject.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Value;

public class Singleton {
    @Value("${cloudinary.cloud_name}")
    private static String cloudName;
    @Value("${cloudinary.api_key}")
    private static String apiKey;

    @Value("${cloudinary.api_secret}")
    private static String apiSecret;

    private static Cloudinary cloudinary;

    public static void registerCloudinary(Cloudinary cloudinary) {
        Singleton.cloudinary = cloudinary;
    }

    public static void deregisterCloudinary() {
        cloudinary = null;
    }

    private static class DefaultCloudinaryHolder {
        public static final Cloudinary INSTANCE = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "ddpptb148",
            "api_key", "852523734917466",
            "api_secret", "GA4r2ccvr5YY909RGmROveUF_SQ"
        ));
    }

    public static Cloudinary getCloudinary() {
        if (cloudinary == null) {
            return DefaultCloudinaryHolder.INSTANCE;
        }
        return cloudinary;
    }
}
