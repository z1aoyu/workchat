# workchat
实现企业微信对接服务的搭建，根据DDD的设计理念，搭建一套对接企业微信第三方服务商应用的服务

## wechat-isv-spring-boot-starter 
这是针对企业微信提供的API进行封装，目前包含 （应用授权、通讯录管理、身份验证）。
（maven中央仓库只能发布稳定版 等所有接口补全后稳定版会推到中央仓库，可直接在中央仓库下载）
### 使用方式 
拉取starter代码后，在本地install打包，在需要引入项目的pom文件中添加以下依赖即可。
   ---
        <!--企业微信ISV服务 Starter-->
        <dependency>
            <groupId>com.github.b1aoyu</groupId>
            <artifactId>wechat-isv-spring-boot-starter</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
   ---
在正式接入之前，认真阅读以下内容能够帮你快速接入：
## 前置任务

注册应用，成为企业微信第三方应用开发企业。

创建应用，配置对应参数。

重点关注：使用配置，回调配置。

其中使用配置：主要前端配置，包含内容：

应用的主页：桌面端独立的主页

可信任域名：用于JS-SDK的调用，构造Oauth2构造的授权链接使用

安装成功之后回调的域名：直接跳转到该域名

业务设置的URL：企业管理员可以从应用后台直接授权通过该URL免登录直接跳转到该URL进行应用配置

回调配置：主要后端使用，包含内容：

数据回调URL：用于接收托管企业微信的应用信息

指令回调URL：用于接收应用的授权变更事件以及Ticket票据

Token：用于生成签名校验回调的合法性

Base64的AES密钥：其中Base64的密钥末尾不支持"="字符，需要手动配置该参数。  该参数是回调加解密参数，应用于回调请求体内的密文解密。

完成回调配置后就可以正常和接口进行通信了。

## 对接前弄明白几件事

[接口文档 - 企业微信开发者中心](https://work.weixin.qq.com/api/doc/90001/90143/91201)

**1 三种类型的Token分别用来干嘛的**

**2 什么数据是回调获得的，什么数据是主动请求获得的**

**3 那些事情是前端要做的，那些事情是后端要做的**

服务商Token，我们作为第三方应用的提供方就是服务商，这个Token主要是我们自己使用，登录授权，推广二维码等等，这个去看文档很好理解。 重点关注第三方应用Token和授权企业的Token

第三方应用Token指的是： 我们的应用即将被安装但还没有被安装的时候，我们可以获取这个凭证，以及相关的信息，来构建我们应用的一些授权链接，让用户进行授权，安装，以此获得对应的授权该应用的企业信息，该应用对应企业的管理员列表等。

授权企业的Token：此时企业已经安装好应用了，我们可以通过预授权码构建的授权链接之后获取的Code码获得企业永久授权码，此时永久授权码，获取企业AccessToken，可以用于操作企业相关的接口，通讯录管理，消息推送等操作。

### 带着上面的2 3 两个问题，回答以下企业应用授权和用户身份验证，以及授权完成后能做那些事情。

企业应用授权：https://work.weixin.qq.com/api/doc/90001/90143/90597

什么数据是回调获得的，什么数据是主动请求获得的。 我们要搞清楚一点，在我们主动获取数据之前，我们的应用首先需要被安装，安装完成后意味着用户已经接入了我们的应用，此时才允许你有主动请求获得的接口。在安装应用以及授权的时候，我们就要区分那些数据是回调的那些数据是主动授权的。

先说两种企业授权应用的方式：https://work.weixin.qq.com/api/doc/90001/90143/90597

1 企业在应用市场发起授权安装应用，会发生授权通知事件，此时会向指令回调URL推送授权成功，此时我们通过一系列解密操作可以获得AuthCOde-临时授权码，我们通过临时授权码主动调用获取企业永久授权码接口可以获得永久授权码，我们可以主动调用接口获得：企业授权信息 企业凭证 应用的管理员列表等信息。（纯后端的操作，回调是通过指令回调URL操作的）

在提到第二种之前，我们需要先知道一个点：

由于第三方服务商可能托管了大量的企业，其安全问题造成的影响会更加严重，故API中除了合法来源IP校验之外，还额外增加了suite_ticket作为安全凭证。获取suite_access_token时，需要suite_ticket参数。suite_ticket由企业微信后台定时推送给“指令回调URL”，每十分钟更新一次，见

[推送suite_ticket](https://work.weixin.qq.com/api/doc/90001/90143/90600#10982/%E6%8E%A8%E9%80%81suite_ticket)。

suite_ticket实际有效期为30分钟，可以容错连续两次获取suite_ticket失败的情况，但是请永远使用最新接收到的suite_ticket。通过本接口获取的suite_access_token有效期为2小时，开发者需要进行缓存，不可频繁获取。

2  由于需要获取第三方凭证，并且建议第三方服务商进行缓存的操作，获取预授权码的操作交由后端执行，后端给予前端预授权码，由前端构造授权链接让用户授权，前端得到用户授权后的临时授权码后，将临时授权码给予后端，后端获取永久授权码并存储落库。（前后端共同实现）

此时我们就完成了企业授权应用的操作 ---  说白了就是用来安装的，安装完了能给你推点信息，你能通过接口拿点信息。

主动调用的就上面那些信息，企业相关的，企业凭证，应用管理员等等，剩下的就是回调的信息了。

回调的内容包含：成员的增删改，部门的增删改，标签的增删改，共享应用事件的增删改，应用管理员变更的通知。  至此，企业应用授权完成。

---

---

用户身份验证：https://work.weixin.qq.com/api/doc/90001/90143/91118

还是那两个问题，什么数据是回调获得的，什么数据是主动请求的，在实现的过程中那些是后端做的，那些是前端做的。 当然最大的区别是，大前提：此时这个应用在这家企业下已经安装完成了。

还是两种方式：  网页授权登录，扫码授权登录。其中网页授权登录的Oauth2构造又分为构造第三方应用的Oauth2链接和构造企业的Oauth2链接，我们重点关注第一种即可。第二种忽略不看。

先说网页授权登录，首先如果做过微信公众平台的授权登录，那么可以告诉你的是基本一样，无非就是多了几个参数的事。

首先，前端构造Oatuh2授权链接，让用户点击确认授权，注意：前端传递的这个回调域名需要在企业微信后台中配置安全可信域名才能够在企业微信内被访问成功。用户授权成功之后，会往你构造的链接中指定的回调地址推送一个带有code参数的URL，前端将这个参数传给后端，后端根据第三方应用凭证和用户授权的code值可以主动调用获取访问用户身份接口和获取访问用户敏感信息接口，完成用户信息的获取。

扫码授权登录暂时忽略 至此，用户身份验证完成。

**划重点： 当这个应用已经对接成功了，意味着我们已经拥有了这个永久授权码，你会发现在这之后的通讯录管理也好，成员部门管理也罢，都是以这个授权码为主来获取的，就是说这个授权码，获取的AccessToken相当于别人第三方平台的正式密钥，可以拿着它带上各种业务Id调用别人的接口了。**

## 完成以上内容的阅读，代表着正式进入DDD模式下的企业微信ISV服务了。 在项目中的readme会有更加详细的架构图以及逻辑实现。
