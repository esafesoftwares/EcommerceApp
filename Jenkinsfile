#!groovy​

// FULL_BUILD -> true/false build parameter to define if we need to run the entire stack for lab purpose only
//final FULL_BUILD = params.FULL_BUILD
// HOST_PROVISION -> server to run ansible based on provision/inventory.ini
//final HOST_PROVISION = params.HOST_PROVISION

final GIT_URL = 'https://github.com/esafesoftwares/EcommerceApp.git'
//final NEXUS_URL = 'nexus.local:8081'

stage('Build') {
    node {
        git GIT_URL
        withEnv(["PATH+MAVEN=${tool 'm3'}/bin"]) {
                def pom = readMavenPom file: 'pom.xml'
                sh "mvn -B versions:set -DnewVersion=${pom.version}-${BUILD_NUMBER}"
                sh "mvn -B -Dmaven.test.skip=true clean package"
                stash name: "artifact", includes: "target/ECommerceApp*.war"
            }
      }
}
stage('Static Analysis') {
        node {
            withEnv(["PATH+MAVEN=${tool 'm3'}/bin"]) {
                withSonarQubeEnv('sonar'){
                   // unstash 'it_tests'
                    //unstash 'unit_tests'
                    sh 'mvn sonar:sonar -DskipTests'
                }
            }
        }
    }
