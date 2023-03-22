package com.mvitu.MvituBackend;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class MvituBackendApplication {

	public static void main(String[] args) throws IOException {
		//initializes firebase
		InputStream serviceAccount = MvituBackendApplication.class.getClassLoader().getResourceAsStream("serviceAccountKey.json");
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();
		FirebaseApp.initializeApp(options);
		SpringApplication.run(MvituBackendApplication.class, args);
	}

}
