def call() {
    // This block finds the Maven tool and adds its 'bin' directory to the PATH
    withEnv(["PATH+MAVEN=${tool 'Maven-3.9.11'}/bin"]) {
        script {
            currentBuild.description = "Commit: ${env.GIT_COMMIT}"
        }
        echo "Now building commit: ${env.GIT_COMMIT}"

        // Now the 'sh' step will be able to find 'mvn' in the PATH
        sh 'mvn clean install'
        
        archiveArtifacts artifacts: 'target/*.jar'
    }
}
