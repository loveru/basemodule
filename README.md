# basemodule

[！[]（https://jitpack.io/v/loveru/basemodule.svg）（https://jitpack.io/#loveru/basemodule）

implementation 'com.github.loveru:basemodule:v1.0.0'

一,如果导入后报如下错误，

Error: Invoke-customs are only supported starting with Android O (--min-api 26)

请在主项目中添加如下配置：



android {
    ....

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}
