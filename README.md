# microservices-springboot-1
Web application example of Microservices using Spring Boot

#Setup NodeJS

##Install NodeJS

Firstly, checking whether or not you have ‘Node.js‘ installed, by command: node -v & npm -v. If the command goes unrecognized, we must install ‘NodeJS‘.
Go to: nodejs.org. Download NodeJS installer, the tutorial uses version: 10.4.0 Current. We got a ‘node-v10.4.0-x64.msi‘ file, double click on it and follow the guides to setup NodeJS.

##Checking NodeJS version
Open cmd, checking NodeJS by commandline: node -v & npm -v

#Setup Angular 6 CLI

##Install Angular CLI
Using commandline npm install -g @angular/cli

##Check Angular CLI version
Check Angular-CLI after setup by commandline ng -version

#Implement SpringBoot RestAPI project

#Setup Angular 6 project

Run below command to generate initial Angular 6 client project:

ng new Angular6-client

##Run Angular 6 project

Start angular6-client project by cmd npm start

##Check angular application on http://localhost:4200

#Integrate SpringBoot RestAPI & Angular 6
Angular client calls SpringBoot RestAPIs
Angular6-Client and SpringBoot server work independently on ports 4200 and 8080.
The client at 4200 will proxy any /api requests to the SpringBoot server at port 8080.

#Step to do:
– Create a file proxy.conf.json under project angular6-client folder with content:

{
	"/test-account": {
		"target": "http://localhost:8080",
		"secure": false
	}
}

– Edit package.json file for start script:


"scripts": {
    "ng": "ng",
    "start": "ng serve --proxy-config proxy.conf.json",
    "build": "ng build",
    "test": "ng test",
    "lint": "ng lint",
    "e2e": "ng e2e"
},

– Build and run the SpringBoot project at port 8080. And restart angular6-client at port 4200
- Make a request http://localhost:4200/test-account