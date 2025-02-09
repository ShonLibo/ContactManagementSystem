 pipeline{

     agent any



     stages {

         stage('Checkout') {        // this stage fetches the source code form github
             steps {
                 git branch: 'main', url: ''
             }
         }

         stage(sonarQube inspection){

            steps{
               withSonarQubeEnv( installationName:'sonarQ'){
                    sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
               }
            }

         }


       stage('Build') {         // compiles the source code
             steps {
                 sh 'mvn clean compile'
             }
         }



       stage('unit test') {    // runs unit test
             steps {
                 sh 'mvn test'
             }


       }


        stage('Integration Tests') { // runs integration test
                    steps {
                        sh 'mvn verify'
                    }


     }
 }