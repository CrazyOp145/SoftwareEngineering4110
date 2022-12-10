# Installation guide for WSU INC. Wholesale Food Distribution
For more information on the application, read the README.md file or view the Wiki via this link: [https://github.com/CrazyOp145/SoftwareEngineering4110/wiki]

## How to install

### Install Intellij IDEA
WSU INC. Wholesale Food Distribution was designed using Intellij IDEA, but the application should be able to work with other Java IDEs. 
To get Intellij's IDE click on the link: [https://www.jetbrains.com/idea/download/#section=windows] to be redirected to the download page.
Then on the website, download the specified .exe installer for your system. 
Run the .exe installer and follow along through with all of the prompts until you have successfully installed the IDE.

### Obtain Source Files
To obtain the source files head over to the repository page of the application or click on this link: [https://github.com/CrazyOp145/SoftwareEngineering4110].
Then, click on the green "Code" button and in the "Local" tab you could either clones the repository or download it as a .zip file.

#### Download using .zip

To download the .zip, Click on the download .zip button, head to where you have specified for the download to save. Then unzip the .zip file by using Window's unzip function or by using a .zip file handler.

#### Clone Repository

To Clone the repo, copy the HTTPS url or copy this link: [https://github.com/CrazyOp145/SoftwareEngineering4110]. Then open up your command line to type or copy and paste the line into the command prompt and hit enter.

```
git clone https://github.com/CrazyOp145/SoftwareEngineering4110
```
### Download Java FX
The UI for the application utilizes Java FX 19. In order to install the Java FX head over to the link: [https://gluonhq.com/products/javafx/] and download the latest version for your specified system. 
Then unzip the downloaded file and head inside the IDEA open File and open Project Structure. 
Then select Libraries and select the "+" symbol and find the where you unzipped the JavaFX file and select the lib folder.
Then head over to the Run and press edit configurations and then select the LoginValidationGUI file then add VM options.
Within the VM options add 

``` 
--module-path "" --add-modules javafx.controls,javafx.fxml
```
Within the quotes add the absoulute file path to the lib folder of the JavaFX file.

### Run Application in Intellij IDEA

Firstly, open the file within Intellij IDEA. 

Then open the src folder, open the Profiles folder, then the Login folder.

Next, open up the LoginValidationGUI.java.

Then at the top of the IDE select Run and Run the LoginValidationGUI.java.

