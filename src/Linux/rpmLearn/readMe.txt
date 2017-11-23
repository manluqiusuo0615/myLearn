包管理系统:安装  查询  升级   卸载
软件包管理简介
    源码包(源代码直接开放给你的包,绝大多数源代码包都是C或C++写的)
        脚本安装包(绝大多数都是源码包再开发之后的源码包,不需要手工安装
        一般都是install.sh)
    二进制包(RPM包,系统默认包,目前实际使用,源代码经过编译后的机器语言)
RPM包管理-rpm命令管理
    rpm包的命名规则
        httpd-2.4.6-45.el7.centos.x86_64.rpm
        httpd           软件包名
        2.4.6           软件版本
        45              软件发布的次数
        e17.centos      适合的Linux平台(noarch任何Linux平台)
        x86_64          适合的硬件平台
        rpm             rpm包扩展名
        httpd-2.4.6-45.el7.centos.x86_64.rpm   包全名
    rpm包的依赖性
        树形依赖:a->b->c
        环形依赖:a->b->c->a(把a,b,c用一条命令同时安装)
        模块依赖:模块依赖查询网站(www.rpmfind.net)

        Linux下的所有光盘都需要挂载
        挂载命令 mount
        1.创建挂载点  mkdir /mnt/cdrom
        2.挂载    mount /dev/sr0 /mnt/cdrom
            （会出现:mount: /dev/sr0 is write-protected, mounting read-only）
        3.查看cdrom会看到光盘中的所有内容    cd /mnt/cdrom

        安装rpm包
        命令   -i是安装   -v是显示安装信息   -h是显示安装过程
        rpm   -ivh
        以   .so.数字   结尾的都是库依赖,这种库依赖包不是单独独立的包,它是某
      一个软件包当中的一个软件,即,只要安装这个软件所在的这个包,这个软件就会自动
      安装进去
RPM包管理-yum在线管理
    为了解决包依赖性的,一个包含所有rpm包的网站
    需要所有依赖性,自动从网站下载所依赖的包
    除了可以将yum网站作为文件服务源,还可以将本地光盘作为文件服务源
    yum可以很方便的替代rpm进行软件的安装和卸载,但是对于rpm包的查询,
    却只能使用rpm命令
源码包管理

脚本安装包与软件包选择

包全名:操作的包是没有安装的软件包时,使用包全名,而且要注意路径
    一般是安装和升级
包名：操作已经安装的软件包时,使用包名.是搜索/var/lib/rpm中的数据库
    次文件下的文件都是二进制文件,不能用vi打开,只能用相应的命令来操作

RPM安装:
rpm  -ivh  包全名
选项:
    -i(install)     安装
    -v(verbose)     显示详情信息
    -h(hash)        显示进度
    --nodeps        不检测依赖性

RPM包升级
rpm -Uvh 包全名
选项:
    -U(upgrade)    升级

RPM卸载
rpm -e  包名
选项:
    -e(erase)     卸载
    --nodeps      不检查依赖性

RPM查询
rpm  -q  包名
选项:
    -q //查询包是否安装
管道符 grep
rpm -qa | grep xxxx
查询出所有的xxxx的rpm包

rpm -qi 包名
选项:
    -i   查询软件信息(information)
    -p   查询未安装包信息(package)

rpm -ql 包名
选项:
    -l   列表(list)
    -p   查询未安装包信息(package)

很多服务的安装位置都是默认的安装位置,不建议更改默认安装位置

查询系统文件属于哪个RPM包
rpm -qf 系统文件名
选项:
    -f   查询系统文件属于哪个软件包(file)









yum管理=====也是rpm包
IP地址配置和网络yum源
网络yum源
/etc/sysconfig/network-scripts/yum.repos.d/CentOS-Base.repo
本地光盘yum源
/etc/sysconfig/network-scripts/yum.repos.d/CentOS-Media.repo

yum命令
查询:
#查询所有可用软件包列表
yum list
#搜索服务器上所有和关键字相关的包
yum search 关键字
#安装
yum -y install 包名
    install    安装
    -y         自动回答yes
#升级
yum -y update 包名
#卸载
yum -y remove 包名

提醒:尽量不要用yum卸载,服务器安装尽量最小化安装,安装后
尽量不要卸载

光盘yum源搭建

