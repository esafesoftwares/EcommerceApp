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
}
