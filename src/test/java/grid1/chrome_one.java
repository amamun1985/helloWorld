package grid1;

public class chrome_one {

/*
1) We Should have drivers & browsers on Hub & Node machines.

2) Make local system as HUB server , then register all the VM's(nodes) with Hub
 Download Selenium Standalone Server jar from  https://goo.gl/4g538W
 * we should have same jar on all the Nodes
Step1: Create Hub in your local Windows system.
  java -jar selenium-server-standalone-3.9.1.jar -role hub

Step2: Register your remote node with Hub (Windows/Chrome)
  java -Dwebdriver.chrome.driver="C:\Drivers\chromedriver_win32\chromedriver.exe" -jar selenium-server-standalone-3.9.1.jar -role node -hub http://192.168.13.1:4444/grid/register/

Check Hub is running with One Node(i.e Windows) on browser
http://localhost:4444/grid/console

Step3: Register your remote node with Hub (Linux/Firefox)
  java -Dwebdriver.gecko.driver="/home/pavan/Drivers/geckodriver" -jar selenium-server-standalone-3.9.1.jar -role node -hub http://192.168.13.1:4444/grid/register/

Check Hub is running with Two Nodes(i.e Windows and Linux)
http://localhost:4444/grid/console
 */



}
