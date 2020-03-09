node{
   stage('SCM Checkout'){
     git 'https://github.com/esafesoftwares/EcommerceApp.git'
   }
   stage('Compile-Package'){
      // Get maven home path
      def mvnHome =  tool name: 'm3', type: 'maven'   
      sh "${mvnHome}/bin/mvn package"
   }
   
   stage('SonarQube Analysis') {
        def mvnHome =  tool name: 'm3', type: 'maven'
        withSonarQubeEnv('sonar') { 
          sh "${mvnHome}/bin/mvn sonar:sonar"
        }
    }
   stage('Approval') {
        timeout(time:3, unit:'DAYS') {
            input 'Do I have your approval for deployment?'
        }
    }
   stage('Artifact Upload') {
        node {
            def pom = readMavenPom file: 'pom.xml'
            def file = "${pom.artifactId}-${pom.version}"
            def jar = "target/${file}.war"

            sh "cp pom.xml ${file}.pom"

            nexusArtifactUploader artifacts: [
                    [artifactId: "${pom.artifactId}", classifier: '', file: "target/${file}.war", type: 'war'],
                    [artifactId: "${pom.artifactId}", classifier: '', file: "${file}.pom", type: 'pom']
                ], 
                credentialsId: 'nexus', 
                groupId: "${pom.groupId}", 
                nexusUrl: 'nexus.local:8081', 
                nexusVersion: 'nexus3', 
                protocol: 'http', 
                repository: 'Ecommerce-App', 
                version: "${pom.version}"        
        }
    }
}
