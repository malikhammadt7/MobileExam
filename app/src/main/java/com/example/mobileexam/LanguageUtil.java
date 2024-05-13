package com.example.mobileexam;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

public class LanguageUtil {
	
	public enum Language {
		ARABIC("ar"),
		ENGLISH("en"),
		URDU("ur");
		
		private final String languageCode;
		
		Language(String languageCode) {
			this.languageCode = languageCode;
		}
		
		public String getLanguageCode() {
			return languageCode;
		}
	}
	
	//region Methods
	
	private Language activeLang;
	
	public LanguageUtil(Context context) {
		activeLang = getCurrentLanguage(context);
	}
	
	public Language getActiveLang() {
		return activeLang;
	}
	
	public static Language getCurrentLanguage(Context context) {
		Configuration configuration = context.getResources().getConfiguration();
		Locale locale = configuration.locale;
		String languageCode = locale.getLanguage();
		
		for (Language lang : Language.values()) {
			if (lang.getLanguageCode().equals(languageCode)) {
				return lang;
			}
		}
		return Language.ENGLISH;
	}
	
	public void changeAppLanguage(Context context, Language language) {
		Resources resources = context.getResources();
		Configuration configuration = resources.getConfiguration();
		
		Locale locale = new Locale(language.getLanguageCode());
		Locale.setDefault(locale);
		configuration.locale = locale;
		
		DisplayMetrics displayMetrics = resources.getDisplayMetrics();
		resources.updateConfiguration(configuration, displayMetrics);
	}
	//endregion Methods
}
