# Preview
Preview moudule


1. The "src/com/module" has Main.java which handles the backend code for creating a renderable view for the file selected by the user.
After performing the processing it alerts the client of its successful status so that the client can now display 
the file selected by the user.

2. The Web Content folder has a folder called WEB-INF which has the configuration files for establishing a connection
between the server and client, also any communications there after.

3. The index.jsp inside Web Content folder is the initial file which is displayed when the client connects to the server.
It displays the option of selecting the file and performing preview.

4. The resources folder has myjs.js which is a javascript file used to perform the operations of displaying the preview.

5. The resources folder also contains some image resources and css sheets. The images include excel icon, word icon you see when you select a particular file. The style sheet .css is used to arrange the web elements style on the browser.

6. So to run the application one must have tomcat installed on the system and the configuration files help tomcat in doing some custom initialisation and serving client requets.


