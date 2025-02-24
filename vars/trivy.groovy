def call(){
  sh "trivy fs . -o results.jason"
}
