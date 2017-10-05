package ui.StepDefinitions;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow.CredentialCreatedListener;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import static io.restassured.RestAssured.*;
import com.google.api.services.tasks.TasksScopes;
import com.google.api.services.tasks.model.*;
import com.google.api.services.tasks.Tasks;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Quickstart {
    /** Application name. */
    private static final String APPLICATION_NAME =
        "Asad Google Task API Test";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), ".credentials/tasks-java-quickstart");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/tasks-java-quickstart
     */
    private static final List<String> SCOPES =
        Arrays.asList(TasksScopes.TASKS_READONLY);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in =
            Quickstart.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets =
            GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = null;
		try {
			credential = new AuthorizationCodeInstalledApp(
			    flow, new LocalServerReceiver()).authorize("user");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Tasks client service.
     * @return an authorized Tasks client service
     * @throws IOException
     */
    public static Tasks getTasksService() throws IOException {
        Credential credential = authorize();
        return new Tasks.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
    
    public static void CreateTask()
    {
    	given().baseUri("https://www.googleapis.com/tasks/v1/users/@me/lists/MDA0NDUwODAxMjkzNDk5Mzk3NjA6MDow?key={YOUR_API_KEY}").
    	//https://www.googleapis.com/tasks/v1/users/@me/lists?key={335119480348-0s415532dvfq27bk7a9q7sn01klpda3b.apps.googleusercontent.com
    	when().body("\"kind\": \"tasks#taskList\"," +
 "\"id\": \"MDA0NDUwODAxMjkzNDk5Mzk3NjA6MDow\"," +
 "\"etag\": \"\"ZPF2pw17LedTHeJNTnTTe4cmlp4/h6HfWCHp2C1DxXYaNtHRa0rYkeA\"\"," +
 "\"title\": \"Raza Ahmed's list\"," +
 "\"updated\": \"2017-10-04T23:46:21.000Z\"," +
 "\"selfLink\": \"https://www.googleapis.com/tasks/v1/users/@me/lists/MDA0NDUwODAxMjkzNDk5Mzk3NjA6MDow\"").post();
    }
    
//    public static void main(String[] args) throws IOException {
//        // Build a new authorized API client service.
//        Tasks service = getTasksService();
//
//        // Print the first 10 task lists.
//        TaskLists result = service.tasklists().list()
//             .setMaxResults(Long.valueOf(10))
//             .execute();
//       CreateTask();
//        List<TaskList> tasklists = result.getItems();
//        if (tasklists == null || tasklists.size() == 0) {
//            System.out.println("No task lists found.");
//        } else {
//            System.out.println("Task lists:");
//            for (TaskList tasklist : tasklists) {
//                System.out.printf("%s (%s)\n",
//                        tasklist.getTitle(),
//                        tasklist.getId());
//            }
//        }
//    }

}