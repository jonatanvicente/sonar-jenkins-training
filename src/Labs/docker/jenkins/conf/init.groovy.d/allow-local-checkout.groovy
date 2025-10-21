import hudson.plugins.git.GitSCM

// enable local file:// checkouts
GitSCM.ALLOW_LOCAL_CHECKOUT = true
println "GitSCM.ALLOW_LOCAL_CHECKOUT = ${GitSCM.ALLOW_LOCAL_CHECKOUT}"
