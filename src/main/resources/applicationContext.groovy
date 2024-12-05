beans {
    singletonBean(com.example.groovyconfig.SingletonBean) { bean ->
        bean.scope = "singleton"
    }
    prototypeBean(com.example.groovyconfig.PrototypeBean) { bean ->
        bean.scope = "prototype"
    }
}