def call(String credID,String imagename){
   withCredentials([usernamePassword(
                    credentialsId:"${credID}",
                    passwordVariable: "dockerHubPass",
                    usernameVariable: "dockerHubUser"
                )]){
                
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                sh "docker tag ${imagename} ${env.dockerHubUser}/${imagename}"
                sh "docker push ${env.dockerHubUser}/${imagename}:latest"
                }
}
