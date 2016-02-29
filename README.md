# msp-db-installer
  A database installer for https://github.com/Abhijith-Nagaraja/monitor-stock-price/

###Prerequisites
1. Java version 1.8
2. Maven (Easy step by step guide: http://www.tutorialspoint.com/maven/maven_environment_setup.htm)
3. Tomcat or any other server capabale of host java web project
4. Git
5. MySql Server

###Steps
1. Clone the project

      git clone https://github.com/Abhijith-Nagaraja/msp-db-installer.git
  ![Setp 1](./images/step1.jpg)<br/>
2. Go inside the clone directory and execute maven install
 
      mvn clean install
      <table>
        <tbody>
          <tr>
            <td>![Step 2](./images/step2.jpg)</td>
            <td>![Step 2a](./images/step2a.jpg)</td>
          </tr>
        </tbody>
      </table><br/>
3. Copy the war folder from projects target directory into your Tomcat server webapp directory and renmae if required
      <table>
        <tbody>
          <tr>
            <td>![Step 3a](./images/step3a.jpg)</td>
            <td>![Step 3b](./images/step3b.jpg)</td>
            <td>![Step 3c](./images/step3c.jpg)</td>
          </tr>
        </tbody>
      </table><br/>
4. Start the Tomcat server<br/>
      ![Step 4](./images/step4.jpg)<br/><br/>
5. Open the browser, go to "[your server address with port]://[war-name]/"
      ![Step 5](./images/step5.jpg)<br/>
6. Enter all the input fields and click on execute
      ![Step 6](./images/step6.jpg)<br/>
